package gnu.kawa.servlet;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;

public class KawaAutoHandler
{
  static final String MODULE_MAP_ATTRIBUTE = "gnu.kawa.module-map";
  
  public static Object getModule(HttpRequestContext paramHttpRequestContext, CallContext paramCallContext, boolean paramBoolean)
    throws Exception
  {
    String str1 = paramHttpRequestContext.getRequestPath().substring(-1 + paramHttpRequestContext.getContextPath().length());
    Hashtable localHashtable = (Hashtable)paramHttpRequestContext.getAttribute("gnu.kawa.module-map");
    if (localHashtable == null)
    {
      localHashtable = new Hashtable();
      paramHttpRequestContext.setAttribute("gnu.kawa.module-map", localHashtable);
    }
    ModuleContext localModuleContext = (ModuleContext)paramHttpRequestContext.getAttribute("gnu.kawa.module-context");
    if (localModuleContext == null) {
      localModuleContext = ModuleContext.getContext();
    }
    localModuleContext.addFlags(ModuleContext.IN_HTTP_SERVER);
    if (paramHttpRequestContext.getClass().getName().endsWith("KawaServlet$Context")) {
      localModuleContext.addFlags(ModuleContext.IN_SERVLET);
    }
    ModuleInfo localModuleInfo = (ModuleInfo)localHashtable.get(str1);
    long l = System.currentTimeMillis();
    ModuleManager localModuleManager = localModuleContext.getManager();
    if ((localModuleInfo != null) && (l - localModuleInfo.lastCheckedTime < localModuleManager.lastModifiedCacheTime)) {
      return localModuleContext.findInstance(localModuleInfo);
    }
    int i = str1.length();
    URL localURL;
    String str2;
    String str5;
    label193:
    int k;
    if ((i == 0) || (str1.charAt(i - 1) == '/'))
    {
      localURL = null;
      str2 = str1;
      if (localURL != null) {
        break label366;
      }
      str5 = str1;
      k = str5.lastIndexOf('/');
      if (k >= 0) {
        break label297;
      }
    }
    for (;;)
    {
      if (localURL != null) {
        break label392;
      }
      byte[] arrayOfByte3 = ("The requested URL " + str1 + " was not found on this server." + " res/:" + paramHttpRequestContext.getResourceURL("/") + "\r\n").getBytes();
      paramHttpRequestContext.sendResponseHeaders(404, null, arrayOfByte3.length);
      OutputStream localOutputStream3 = paramHttpRequestContext.getResponseStream();
      try
      {
        localOutputStream3.write(arrayOfByte3);
        return null;
      }
      catch (IOException localIOException2)
      {
        RuntimeException localRuntimeException2 = new RuntimeException(localIOException2);
        throw localRuntimeException2;
      }
      localURL = paramHttpRequestContext.getResourceURL(str1);
      break;
      label297:
      str5 = str5.substring(0, k);
      str2 = str5 + "/+default+";
      localURL = paramHttpRequestContext.getResourceURL(str2);
      if (localURL == null) {
        break label193;
      }
      paramHttpRequestContext.setScriptAndLocalPath(str1.substring(1, k + 1), str1.substring(k + 1));
      continue;
      label366:
      paramHttpRequestContext.setScriptAndLocalPath(str1, "");
    }
    label392:
    String str3 = localURL.toExternalForm();
    if ((localModuleInfo == null) || (!str3.equals(localModuleInfo.getSourceAbsPathname()))) {
      localModuleInfo = localModuleManager.findWithURL(localURL);
    }
    if (localModuleInfo.checkCurrent(localModuleManager, l)) {
      return localModuleContext.findInstance(localModuleInfo);
    }
    localHashtable.put(str1, localModuleInfo);
    Path localPath = localModuleInfo.getSourceAbsPath();
    Object localObject = localPath.openInputStream();
    if (!(localObject instanceof BufferedInputStream))
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject);
      localObject = localBufferedInputStream;
    }
    Language localLanguage = Language.getInstanceFromFilenameExtension(str1);
    if (localLanguage != null) {
      paramHttpRequestContext.log("Compile " + str1 + " - a " + localLanguage.getName() + " source file (based on extension)");
    }
    SourceMessages localSourceMessages;
    for (;;)
    {
      InPort localInPort = new InPort((InputStream)localObject, localPath);
      Language.setCurrentLanguage(localLanguage);
      localSourceMessages = new SourceMessages();
      try
      {
        Compilation localCompilation2 = localLanguage.parse(localInPort, localSourceMessages, 9, localModuleInfo);
        localCompilation1 = localCompilation2;
      }
      catch (SyntaxException localSyntaxException)
      {
        Class localClass;
        for (;;)
        {
          boolean bool;
          String str4;
          byte[] arrayOfByte2;
          OutputStream localOutputStream2;
          RuntimeException localRuntimeException1;
          OutputStream localOutputStream1;
          byte[] arrayOfByte1;
          if (localSyntaxException.getMessages() != localSourceMessages) {
            throw localSyntaxException;
          }
          Compilation localCompilation1 = null;
        }
        localModuleInfo.setModuleClass(localClass);
      }
      bool = localSourceMessages.seenErrors();
      localClass = null;
      if (!bool)
      {
        localCompilation1.getModule();
        localClass = (Class)ModuleExp.evalModule1(Environment.getCurrent(), localCompilation1, localURL, null);
      }
      if (!localSourceMessages.seenErrors()) {
        break label948;
      }
      str4 = "script syntax error:\n" + localSourceMessages.toString(20);
      ((ServletPrinter)paramCallContext.consumer).addHeader("Content-type", "text/plain");
      paramHttpRequestContext.sendResponseHeaders(500, "Syntax errors", -1L);
      paramCallContext.consumer.write(str4);
      localModuleInfo.cleanupAfterCompilation();
      return null;
      localLanguage = Language.detect((InputStream)localObject);
      if (localLanguage == null) {
        break;
      }
      paramHttpRequestContext.log("Compile " + str1 + " - a " + localLanguage.getName() + " source file (detected from content)");
    }
    if (str1 != str2)
    {
      arrayOfByte2 = ("The requested URL " + str1 + " was not found on this server." + " upath=" + str2 + ".\r\n").getBytes();
      paramHttpRequestContext.sendResponseHeaders(404, null, arrayOfByte2.length);
      localOutputStream2 = paramHttpRequestContext.getResponseStream();
      try
      {
        localOutputStream2.write(arrayOfByte2);
        return null;
      }
      catch (IOException localIOException1)
      {
        localRuntimeException1 = new RuntimeException(localIOException1);
        throw localRuntimeException1;
      }
    }
    paramHttpRequestContext.sendResponseHeaders(200, null, localPath.getContentLength());
    localOutputStream1 = paramHttpRequestContext.getResponseStream();
    arrayOfByte1 = new byte[4096];
    for (;;)
    {
      int j = ((InputStream)localObject).read(arrayOfByte1);
      if (j < 0)
      {
        ((InputStream)localObject).close();
        localOutputStream1.close();
        return null;
      }
      localOutputStream1.write(arrayOfByte1, 0, j);
    }
    label948:
    return localModuleContext.findInstance(localModuleInfo);
  }
  
  public static void run(HttpRequestContext paramHttpRequestContext, CallContext paramCallContext)
    throws Throwable
  {
    if (paramHttpRequestContext.getRequestParameter("qexo-save-class") != null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = getModule(paramHttpRequestContext, paramCallContext, bool);
      if ((localObject instanceof ModuleBody)) {
        ((ModuleBody)localObject).run(paramCallContext);
      }
      return;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.servlet.KawaAutoHandler
 * JD-Core Version:    0.7.0.1
 */