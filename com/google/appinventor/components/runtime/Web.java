package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.HtmlEntities;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.FileUtil.FileException;
import com.google.appinventor.components.runtime.util.GingerbreadUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

@DesignerComponent(category=ComponentCategory.CONNECTIVITY, description="Non-visible component that provides functions for HTTP GET, POST, PUT, and DELETE requests.", iconName="images/web.png", nonVisible=true, version=4)
@SimpleObject
@UsesLibraries(libraries="json.jar")
@UsesPermissions(permissionNames="android.permission.INTERNET")
public class Web
  extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "Web";
  private static final Map<String, String> mimeTypeToExtension = ;
  private final Activity activity;
  private boolean allowCookies;
  private final CookieHandler cookieHandler;
  private YailList requestHeaders = new YailList();
  private String responseFileName = "";
  private boolean saveResponse;
  private String urlString = "";
  
  static
  {
    mimeTypeToExtension.put("application/pdf", "pdf");
    mimeTypeToExtension.put("application/zip", "zip");
    mimeTypeToExtension.put("audio/mpeg", "mpeg");
    mimeTypeToExtension.put("audio/mp3", "mp3");
    mimeTypeToExtension.put("audio/mp4", "mp4");
    mimeTypeToExtension.put("image/gif", "gif");
    mimeTypeToExtension.put("image/jpeg", "jpg");
    mimeTypeToExtension.put("image/png", "png");
    mimeTypeToExtension.put("image/tiff", "tiff");
    mimeTypeToExtension.put("text/plain", "txt");
    mimeTypeToExtension.put("text/html", "html");
    mimeTypeToExtension.put("text/xml", "xml");
  }
  
  protected Web()
  {
    super(null);
    this.activity = null;
    this.cookieHandler = null;
  }
  
  public Web(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.activity = paramComponentContainer.$context();
    if (SdkLevel.getLevel() >= 9) {}
    for (CookieHandler localCookieHandler = GingerbreadUtil.newCookieManager();; localCookieHandler = null)
    {
      this.cookieHandler = localCookieHandler;
      return;
    }
  }
  
  private CapturedProperties capturePropertyValues(String paramString)
  {
    try
    {
      CapturedProperties localCapturedProperties = new CapturedProperties(this);
      return localCapturedProperties;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Form localForm2 = this.form;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.urlString;
      localForm2.dispatchErrorOccurredEvent(this, paramString, 1109, arrayOfObject2);
      return null;
    }
    catch (InvalidRequestHeadersException localInvalidRequestHeadersException)
    {
      for (;;)
      {
        Form localForm1 = this.form;
        int i = localInvalidRequestHeadersException.errorNumber;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(localInvalidRequestHeadersException.index);
        localForm1.dispatchErrorOccurredEvent(this, paramString, i, arrayOfObject1);
      }
    }
  }
  
  private static File createFile(String paramString1, String paramString2)
    throws IOException, FileUtil.FileException
  {
    if (!TextUtils.isEmpty(paramString1)) {
      return FileUtil.getExternalFile(paramString1);
    }
    int i = paramString2.indexOf(';');
    if (i != -1) {
      paramString2 = paramString2.substring(0, i);
    }
    String str = (String)mimeTypeToExtension.get(paramString2);
    if (str == null) {
      str = "tmp";
    }
    return FileUtil.getDownloadFile(str);
  }
  
  static Object decodeJsonText(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      Object localObject = JsonUtil.getObjectFromJson(paramString);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalArgumentException("jsonText is not a legal JSON value");
    }
  }
  
  private static InputStream getConnectionStream(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException) {}
    return paramHttpURLConnection.getErrorStream();
  }
  
  private static String getResponseContent(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    String str1 = paramHttpURLConnection.getContentEncoding();
    if (str1 == null) {
      str1 = "UTF-8";
    }
    InputStreamReader localInputStreamReader = new InputStreamReader(getConnectionStream(paramHttpURLConnection), str1);
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        int i = paramHttpURLConnection.getContentLength();
        if (i != -1)
        {
          localStringBuilder = new StringBuilder(i);
          char[] arrayOfChar = new char[1024];
          int j = localInputStreamReader.read(arrayOfChar);
          if (j == -1) {
            break;
          }
          localStringBuilder.append(arrayOfChar, 0, j);
          continue;
        }
        localStringBuilder = new StringBuilder();
      }
      finally
      {
        localInputStreamReader.close();
      }
    }
    String str2 = localStringBuilder.toString();
    localInputStreamReader.close();
    return str2;
  }
  
  private static String getResponseType(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getContentType();
    if (str != null) {
      return str;
    }
    return "";
  }
  
  private static HttpURLConnection openConnection(CapturedProperties paramCapturedProperties, String paramString)
    throws IOException, ClassCastException, ProtocolException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramCapturedProperties.url.openConnection();
    if ((paramString.equals("PUT")) || (paramString.equals("DELETE"))) {
      localHttpURLConnection.setRequestMethod(paramString);
    }
    Iterator localIterator1 = paramCapturedProperties.requestHeaders.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      String str2 = (String)localEntry2.getKey();
      Iterator localIterator4 = ((List)localEntry2.getValue()).iterator();
      while (localIterator4.hasNext()) {
        localHttpURLConnection.addRequestProperty(str2, (String)localIterator4.next());
      }
    }
    if (paramCapturedProperties.cookies != null)
    {
      Iterator localIterator2 = paramCapturedProperties.cookies.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
        String str1 = (String)localEntry1.getKey();
        Iterator localIterator3 = ((List)localEntry1.getValue()).iterator();
        while (localIterator3.hasNext()) {
          localHttpURLConnection.addRequestProperty(str1, (String)localIterator3.next());
        }
      }
    }
    return localHttpURLConnection;
  }
  
  private void performRequest(final CapturedProperties paramCapturedProperties, byte[] paramArrayOfByte, String paramString1, String paramString2)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = openConnection(paramCapturedProperties, paramString2);
    if ((localHttpURLConnection == null) || (paramArrayOfByte != null)) {}
    for (;;)
    {
      final int i;
      final String str1;
      try
      {
        writeRequestData(localHttpURLConnection, paramArrayOfByte);
        i = localHttpURLConnection.getResponseCode();
        str1 = getResponseType(localHttpURLConnection);
        processResponseCookies(localHttpURLConnection);
        if (!this.saveResponse) {
          break label115;
        }
        final String str3 = saveResponseContent(localHttpURLConnection, paramCapturedProperties.responseFileName, str1);
        this.activity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Web.this.GotFile(paramCapturedProperties.urlString, i, str1, str3);
          }
        });
        return;
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
      if (paramString1 != null)
      {
        writeRequestFile(localHttpURLConnection, paramString1);
        continue;
        label115:
        final String str2 = getResponseContent(localHttpURLConnection);
        this.activity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Web.this.GotText(paramCapturedProperties.urlString, i, str1, str2);
          }
        });
      }
    }
  }
  
  private static Map<String, List<String>> processRequestHeaders(YailList paramYailList)
    throws Web.InvalidRequestHeadersException
  {
    HashMap localHashMap = Maps.newHashMap();
    int i = 0;
    while (i < paramYailList.size())
    {
      Object localObject1 = paramYailList.getObject(i);
      if ((localObject1 instanceof YailList))
      {
        YailList localYailList1 = (YailList)localObject1;
        if (localYailList1.size() == 2)
        {
          String str = localYailList1.getObject(0).toString();
          Object localObject2 = localYailList1.getObject(1);
          ArrayList localArrayList = Lists.newArrayList();
          if ((localObject2 instanceof YailList))
          {
            YailList localYailList2 = (YailList)localObject2;
            for (int j = 0; j < localYailList2.size(); j++) {
              localArrayList.add(localYailList2.getObject(j).toString());
            }
          }
          localArrayList.add(localObject2.toString());
          localHashMap.put(str, localArrayList);
          i++;
        }
        else
        {
          throw new InvalidRequestHeadersException(1111, i + 1);
        }
      }
      else
      {
        throw new InvalidRequestHeadersException(1110, i + 1);
      }
    }
    return localHashMap;
  }
  
  private void processResponseCookies(HttpURLConnection paramHttpURLConnection)
  {
    if ((this.allowCookies) && (this.cookieHandler != null)) {}
    try
    {
      Map localMap = paramHttpURLConnection.getHeaderFields();
      this.cookieHandler.put(paramHttpURLConnection.getURL().toURI(), localMap);
      return;
    }
    catch (IOException localIOException) {}catch (URISyntaxException localURISyntaxException) {}
  }
  
  private void requestTextImpl(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues(paramString3);
    if (localCapturedProperties == null) {
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          try
          {
            if ((paramString2 == null) || (paramString2.length() == 0))
            {
              byte[] arrayOfByte1 = paramString1.getBytes("UTF-8");
              localObject = arrayOfByte1;
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            Object localObject;
            byte[] arrayOfByte2;
            Form localForm1 = Web.this.form;
            Web localWeb1 = Web.this;
            String str1 = paramString3;
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = paramString2;
            localForm1.dispatchErrorOccurredEvent(localWeb1, str1, 1102, arrayOfObject1);
            return;
          }
          try
          {
            Web.this.performRequest(localCapturedProperties, (byte[])localObject, null, paramString4);
            return;
          }
          catch (FileUtil.FileException localFileException)
          {
            Web.this.form.dispatchErrorOccurredEvent(Web.this, paramString3, localFileException.getErrorMessageNumber(), new Object[0]);
            return;
          }
          catch (Exception localException)
          {
            Form localForm2 = Web.this.form;
            Web localWeb2 = Web.this;
            String str2 = paramString3;
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = paramString1;
            arrayOfObject2[1] = localCapturedProperties.urlString;
            localForm2.dispatchErrorOccurredEvent(localWeb2, str2, 1103, arrayOfObject2);
          }
          arrayOfByte2 = paramString1.getBytes(paramString2);
          localObject = arrayOfByte2;
        }
      }
    });
  }
  
  /* Error */
  private static String saveResponseContent(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokestatic 481	com/google/appinventor/components/runtime/Web:createFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   5: astore_3
    //   6: new 483	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 287	com/google/appinventor/components/runtime/Web:getConnectionStream	(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   14: sipush 4096
    //   17: invokespecial 486	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   20: astore 4
    //   22: new 488	java/io/BufferedOutputStream
    //   25: dup
    //   26: new 490	java/io/FileOutputStream
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 493	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: sipush 4096
    //   37: invokespecial 496	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   40: astore 5
    //   42: aload 4
    //   44: invokevirtual 498	java/io/BufferedInputStream:read	()I
    //   47: istore 8
    //   49: iload 8
    //   51: iconst_m1
    //   52: if_icmpne +23 -> 75
    //   55: aload 5
    //   57: invokevirtual 501	java/io/BufferedOutputStream:flush	()V
    //   60: aload 5
    //   62: invokevirtual 502	java/io/BufferedOutputStream:close	()V
    //   65: aload 4
    //   67: invokevirtual 503	java/io/BufferedInputStream:close	()V
    //   70: aload_3
    //   71: invokevirtual 508	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: areturn
    //   75: aload 5
    //   77: iload 8
    //   79: invokevirtual 511	java/io/BufferedOutputStream:write	(I)V
    //   82: goto -40 -> 42
    //   85: astore 6
    //   87: aload 5
    //   89: invokevirtual 502	java/io/BufferedOutputStream:close	()V
    //   92: aload 6
    //   94: athrow
    //   95: astore 7
    //   97: aload 4
    //   99: invokevirtual 503	java/io/BufferedInputStream:close	()V
    //   102: aload 7
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramHttpURLConnection	HttpURLConnection
    //   0	105	1	paramString1	String
    //   0	105	2	paramString2	String
    //   5	66	3	localFile	File
    //   20	78	4	localBufferedInputStream	java.io.BufferedInputStream
    //   40	48	5	localBufferedOutputStream	BufferedOutputStream
    //   85	8	6	localObject1	Object
    //   95	8	7	localObject2	Object
    //   47	31	8	i	int
    // Exception table:
    //   from	to	target	type
    //   42	49	85	finally
    //   55	60	85	finally
    //   75	82	85	finally
    //   22	42	95	finally
    //   60	65	95	finally
    //   87	95	95	finally
  }
  
  private static void writeRequestData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
    throws IOException
  {
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
    try
    {
      localBufferedOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localBufferedOutputStream.flush();
      return;
    }
    finally
    {
      localBufferedOutputStream.close();
    }
  }
  
  /* Error */
  private void writeRequestFile(HttpURLConnection paramHttpURLConnection, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 483	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 192	com/google/appinventor/components/runtime/Web:form	Lcom/google/appinventor/components/runtime/Form;
    //   8: aload_2
    //   9: invokestatic 534	com/google/appinventor/components/runtime/util/MediaUtil:openMedia	(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)Ljava/io/InputStream;
    //   12: invokespecial 537	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_3
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 515	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   21: aload_1
    //   22: iconst_0
    //   23: invokevirtual 540	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   26: new 488	java/io/BufferedOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokevirtual 522	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   34: invokespecial 525	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   37: astore 5
    //   39: aload_3
    //   40: invokevirtual 498	java/io/BufferedInputStream:read	()I
    //   43: istore 7
    //   45: iload 7
    //   47: iconst_m1
    //   48: if_icmpne +18 -> 66
    //   51: aload 5
    //   53: invokevirtual 501	java/io/BufferedOutputStream:flush	()V
    //   56: aload 5
    //   58: invokevirtual 502	java/io/BufferedOutputStream:close	()V
    //   61: aload_3
    //   62: invokevirtual 503	java/io/BufferedInputStream:close	()V
    //   65: return
    //   66: aload 5
    //   68: iload 7
    //   70: invokevirtual 511	java/io/BufferedOutputStream:write	(I)V
    //   73: goto -34 -> 39
    //   76: astore 6
    //   78: aload 5
    //   80: invokevirtual 502	java/io/BufferedOutputStream:close	()V
    //   83: aload 6
    //   85: athrow
    //   86: astore 4
    //   88: aload_3
    //   89: invokevirtual 503	java/io/BufferedInputStream:close	()V
    //   92: aload 4
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	Web
    //   0	95	1	paramHttpURLConnection	HttpURLConnection
    //   0	95	2	paramString	String
    //   15	74	3	localBufferedInputStream	java.io.BufferedInputStream
    //   86	7	4	localObject1	Object
    //   37	42	5	localBufferedOutputStream	BufferedOutputStream
    //   76	8	6	localObject2	Object
    //   43	26	7	i	int
    // Exception table:
    //   from	to	target	type
    //   39	45	76	finally
    //   51	56	76	finally
    //   66	73	76	finally
    //   16	39	86	finally
    //   56	61	86	finally
    //   78	86	86	finally
  }
  
  @DesignerProperty(defaultValue="false", editorType="boolean")
  @SimpleProperty
  public void AllowCookies(boolean paramBoolean)
  {
    this.allowCookies = paramBoolean;
    if ((paramBoolean) && (this.cookieHandler == null)) {
      this.form.dispatchErrorOccurredEvent(this, "AllowCookies", 4, new Object[0]);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the cookies from a response should be saved and used in subsequent requests. Cookies are only supported on Android version 2.3 or greater.")
  public boolean AllowCookies()
  {
    return this.allowCookies;
  }
  
  @SimpleFunction
  public String BuildRequestData(YailList paramYailList)
  {
    try
    {
      String str = buildRequestData(paramYailList);
      return str;
    }
    catch (BuildRequestDataException localBuildRequestDataException)
    {
      Form localForm = this.form;
      int i = localBuildRequestDataException.errorNumber;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localBuildRequestDataException.index);
      localForm.dispatchErrorOccurredEvent(this, "BuildRequestData", i, arrayOfObject);
    }
    return "";
  }
  
  @SimpleFunction(description="Clears all cookies for this Web component.")
  public void ClearCookies()
  {
    if (this.cookieHandler != null)
    {
      GingerbreadUtil.clearCookies(this.cookieHandler);
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "ClearCookies", 4, new Object[0]);
  }
  
  @SimpleFunction
  public void Delete()
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues("Delete");
    if (localCapturedProperties == null) {
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        try
        {
          Web.this.performRequest(localCapturedProperties, null, null, "DELETE");
          return;
        }
        catch (FileUtil.FileException localFileException)
        {
          Web.this.form.dispatchErrorOccurredEvent(Web.this, "Delete", localFileException.getErrorMessageNumber(), new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Form localForm = Web.this.form;
          Web localWeb = Web.this;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localCapturedProperties.urlString;
          localForm.dispatchErrorOccurredEvent(localWeb, "Delete", 1114, arrayOfObject);
        }
      }
    });
  }
  
  @SimpleFunction
  public void Get()
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues("Get");
    if (localCapturedProperties == null) {
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        try
        {
          Web.this.performRequest(localCapturedProperties, null, null, "GET");
          return;
        }
        catch (FileUtil.FileException localFileException)
        {
          Web.this.form.dispatchErrorOccurredEvent(Web.this, "Get", localFileException.getErrorMessageNumber(), new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Form localForm = Web.this.form;
          Web localWeb = Web.this;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localCapturedProperties.urlString;
          localForm.dispatchErrorOccurredEvent(localWeb, "Get", 1101, arrayOfObject);
        }
      }
    });
  }
  
  @SimpleEvent
  public void GotFile(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = paramString3;
    EventDispatcher.dispatchEvent(this, "GotFile", arrayOfObject);
  }
  
  @SimpleEvent
  public void GotText(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = paramString3;
    EventDispatcher.dispatchEvent(this, "GotText", arrayOfObject);
  }
  
  @SimpleFunction(description="Decodes the given HTML text value. HTML character entities such as &amp;amp;, &amp;lt;, &amp;gt;, &amp;apos;, and &amp;quot; are changed to &amp;, &lt;, &gt;, &#39;, and &quot;. Entities such as &amp;#xhhhh, and &amp;#nnnn are changed to the appropriate characters.")
  public String HtmlTextDecode(String paramString)
  {
    try
    {
      String str = HtmlEntities.decodeHtmlText(paramString);
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "HtmlTextDecode", 1106, new Object[] { paramString });
    }
    return "";
  }
  
  @SimpleFunction
  public Object JsonTextDecode(String paramString)
  {
    try
    {
      Object localObject = decodeJsonText(paramString);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "JsonTextDecode", 1105, new Object[] { paramString });
    }
    return "";
  }
  
  @SimpleFunction(description="Performs an HTTP POST request using the Url property and data from the specified file.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The ResponseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PostFile(final String paramString)
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues("PostFile");
    if (localCapturedProperties == null) {
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        try
        {
          Web.this.performRequest(localCapturedProperties, null, paramString, "POST");
          return;
        }
        catch (FileUtil.FileException localFileException)
        {
          Web.this.form.dispatchErrorOccurredEvent(Web.this, "PostFile", localFileException.getErrorMessageNumber(), new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Form localForm = Web.this.form;
          Web localWeb = Web.this;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = localCapturedProperties.urlString;
          localForm.dispatchErrorOccurredEvent(localWeb, "PostFile", 1104, arrayOfObject);
        }
      }
    });
  }
  
  @SimpleFunction(description="Performs an HTTP POST request using the Url property and the specified text.<br>The characters of the text are encoded using UTF-8 encoding.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The responseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PostText(String paramString)
  {
    requestTextImpl(paramString, "UTF-8", "PostText", "POST");
  }
  
  @SimpleFunction(description="Performs an HTTP POST request using the Url property and the specified text.<br>The characters of the text are encoded using the given encoding.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The ResponseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PostTextWithEncoding(String paramString1, String paramString2)
  {
    requestTextImpl(paramString1, paramString2, "PostTextWithEncoding", "POST");
  }
  
  @SimpleFunction(description="Performs an HTTP PUT request using the Url property and data from the specified file.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The ResponseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PutFile(final String paramString)
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues("PutFile");
    if (localCapturedProperties == null) {
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        try
        {
          Web.this.performRequest(localCapturedProperties, null, paramString, "PUT");
          return;
        }
        catch (FileUtil.FileException localFileException)
        {
          Web.this.form.dispatchErrorOccurredEvent(Web.this, "PutFile", localFileException.getErrorMessageNumber(), new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Form localForm = Web.this.form;
          Web localWeb = Web.this;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = localCapturedProperties.urlString;
          localForm.dispatchErrorOccurredEvent(localWeb, "PutFile", 1104, arrayOfObject);
        }
      }
    });
  }
  
  @SimpleFunction(description="Performs an HTTP PUT request using the Url property and the specified text.<br>The characters of the text are encoded using UTF-8 encoding.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The responseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PutText(String paramString)
  {
    requestTextImpl(paramString, "UTF-8", "PutText", "PUT");
  }
  
  @SimpleFunction(description="Performs an HTTP PUT request using the Url property and the specified text.<br>The characters of the text are encoded using the given encoding.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The ResponseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PutTextWithEncoding(String paramString1, String paramString2)
  {
    requestTextImpl(paramString1, paramString2, "PutTextWithEncoding", "PUT");
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The request headers, as a list of two-element sublists. The first element of each sublist represents the request header field name. The second element of each sublist represents the request header field values, either a single value or a list containing multiple values.")
  public YailList RequestHeaders()
  {
    return this.requestHeaders;
  }
  
  @SimpleProperty
  public void RequestHeaders(YailList paramYailList)
  {
    try
    {
      processRequestHeaders(paramYailList);
      this.requestHeaders = paramYailList;
      return;
    }
    catch (InvalidRequestHeadersException localInvalidRequestHeadersException)
    {
      Form localForm = this.form;
      int i = localInvalidRequestHeadersException.errorNumber;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localInvalidRequestHeadersException.index);
      localForm.dispatchErrorOccurredEvent(this, "RequestHeaders", i, arrayOfObject);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The name of the file where the response should be saved. If SaveResponse is true and ResponseFileName is empty, then a new file name will be generated.")
  public String ResponseFileName()
  {
    return this.responseFileName;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ResponseFileName(String paramString)
  {
    this.responseFileName = paramString;
  }
  
  @DesignerProperty(defaultValue="false", editorType="boolean")
  @SimpleProperty
  public void SaveResponse(boolean paramBoolean)
  {
    this.saveResponse = paramBoolean;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the response should be saved in a file.")
  public boolean SaveResponse()
  {
    return this.saveResponse;
  }
  
  @SimpleFunction
  public String UriEncode(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("Web", "UTF-8 is unsupported?", localUnsupportedEncodingException);
    }
    return "";
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The URL for the web request.")
  public String Url()
  {
    return this.urlString;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void Url(String paramString)
  {
    this.urlString = paramString;
  }
  
  @SimpleFunction(description="Decodes the given XML string to produce a list structure.  See the App Inventor documentation on \"Other topics, notes, and details\" for information.")
  public Object XMLTextDecode(String paramString)
  {
    try
    {
      Object localObject = JsonTextDecode(XML.toJSONObject(paramString).toString());
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e("Exception in XMLTextDecode", localJSONException.getMessage());
      Form localForm = this.form;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONException.getMessage();
      localForm.dispatchErrorOccurredEvent(this, "XMLTextDecode", 1105, arrayOfObject);
    }
    return YailList.makeEmptyList();
  }
  
  String buildRequestData(YailList paramYailList)
    throws Web.BuildRequestDataException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = "";
    int i = 0;
    while (i < paramYailList.size())
    {
      Object localObject = paramYailList.getObject(i);
      if ((localObject instanceof YailList))
      {
        YailList localYailList = (YailList)localObject;
        if (localYailList.size() == 2)
        {
          String str2 = localYailList.getObject(0).toString();
          String str3 = localYailList.getObject(1).toString();
          localStringBuilder.append(str1).append(UriEncode(str2)).append('=').append(UriEncode(str3));
          str1 = "&";
          i++;
        }
        else
        {
          throw new BuildRequestDataException(1113, i + 1);
        }
      }
      else
      {
        throw new BuildRequestDataException(1112, i + 1);
      }
    }
    return localStringBuilder.toString();
  }
  
  static class BuildRequestDataException
    extends Exception
  {
    final int errorNumber;
    final int index;
    
    BuildRequestDataException(int paramInt1, int paramInt2)
    {
      this.errorNumber = paramInt1;
      this.index = paramInt2;
    }
  }
  
  private static class CapturedProperties
  {
    final boolean allowCookies;
    final Map<String, List<String>> cookies;
    final Map<String, List<String>> requestHeaders;
    final String responseFileName;
    final boolean saveResponse;
    final URL url;
    final String urlString;
    
    CapturedProperties(Web paramWeb)
      throws MalformedURLException, Web.InvalidRequestHeadersException
    {
      this.urlString = paramWeb.urlString;
      this.url = new URL(this.urlString);
      this.allowCookies = paramWeb.allowCookies;
      this.saveResponse = paramWeb.saveResponse;
      this.responseFileName = paramWeb.responseFileName;
      this.requestHeaders = Web.processRequestHeaders(paramWeb.requestHeaders);
      boolean bool = this.allowCookies;
      localObject = null;
      if (bool)
      {
        CookieHandler localCookieHandler = paramWeb.cookieHandler;
        localObject = null;
        if (localCookieHandler == null) {}
      }
      try
      {
        Map localMap = paramWeb.cookieHandler.get(this.url.toURI(), this.requestHeaders);
        localObject = localMap;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject = null;
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          localObject = null;
        }
      }
      this.cookies = localObject;
    }
  }
  
  private static class InvalidRequestHeadersException
    extends Exception
  {
    final int errorNumber;
    final int index;
    
    InvalidRequestHeadersException(int paramInt1, int paramInt2)
    {
      this.errorNumber = paramInt1;
      this.index = paramInt2;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Web
 * JD-Core Version:    0.7.0.1
 */