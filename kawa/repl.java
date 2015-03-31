package kawa;

import gnu.bytecode.ClassType;
import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.lists.FString;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0or1;
import gnu.mapping.Values;
import gnu.text.Options;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.text.WriterManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class repl
  extends Procedure0or1
{
  public static String compilationTopname = null;
  static int defaultParseOptions = 72;
  public static String homeDirectory;
  public static boolean noConsole;
  static Language previousLanguage;
  static boolean shutdownRegistered = WriterManager.instance.registerShutdownHook();
  Language language;
  
  public repl(Language paramLanguage)
  {
    this.language = paramLanguage;
  }
  
  static void bad_option(String paramString)
  {
    System.err.println("kawa: bad option '" + paramString + "'");
    printOptions(System.err);
    System.exit(-1);
  }
  
  static void checkInitFile()
  {
    Object localObject;
    String str;
    if (homeDirectory == null)
    {
      homeDirectory = System.getProperty("user.home");
      if (homeDirectory == null) {
        break label103;
      }
      localObject = new FString(homeDirectory);
      if (!"/".equals(System.getProperty("file.separator"))) {
        break label97;
      }
      str = ".kawarc.scm";
    }
    for (File localFile = new File(homeDirectory, str);; localFile = null)
    {
      Environment.getCurrent().put("home-directory", localObject);
      if ((localFile != null) && (localFile.exists()) && (!Shell.runFileOrClass(localFile.getPath(), true, 0))) {
        System.exit(-1);
      }
      return;
      label97:
      str = "kawarc.scm";
      break;
      label103:
      localObject = Boolean.FALSE;
    }
  }
  
  public static void compileFiles(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    ModuleManager localModuleManager = ModuleManager.getInstance();
    Compilation[] arrayOfCompilation = new Compilation[paramInt2 - paramInt1];
    ModuleInfo[] arrayOfModuleInfo = new ModuleInfo[paramInt2 - paramInt1];
    SourceMessages localSourceMessages = new SourceMessages();
    String str2;
    Compilation localCompilation2;
    for (int i = paramInt1; i < paramInt2; i++)
    {
      str2 = paramArrayOfString[i];
      getLanguageFromFilenameExtension(str2);
      Language localLanguage = Language.getDefaultLanguage();
      localCompilation2 = null;
      try
      {
        InPort localInPort = InPort.openFile(str2);
        localCompilation2 = localLanguage.parse(localInPort, localSourceMessages, defaultParseOptions);
        if (compilationTopname != null)
        {
          ClassType localClassType = new ClassType(Compilation.mangleNameIfNeeded(compilationTopname));
          ModuleExp localModuleExp = localCompilation2.getModule();
          localModuleExp.setType(localClassType);
          localModuleExp.setName(compilationTopname);
          localCompilation2.mainClass = localClassType;
        }
        arrayOfModuleInfo[(i - paramInt1)] = localModuleManager.find(localCompilation2);
        arrayOfCompilation[(i - paramInt1)] = localCompilation2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        System.err.println(localFileNotFoundException);
        System.exit(-1);
        int j = paramInt1;
        for (;;)
        {
          if (j >= paramInt2) {
            return;
          }
          String str1 = paramArrayOfString[j];
          Compilation localCompilation1 = arrayOfCompilation[(j - paramInt1)];
          try
          {
            System.err.println("(compiling " + str1 + " to " + localCompilation1.mainClass.getName() + ')');
            arrayOfModuleInfo[(j - paramInt1)].loadByStages(14);
            boolean bool1 = localSourceMessages.seenErrors();
            localSourceMessages.checkErrors(System.err, 50);
            if (bool1) {
              System.exit(-1);
            }
            arrayOfCompilation[(j - paramInt1)] = localCompilation1;
            boolean bool2 = localSourceMessages.seenErrors();
            localSourceMessages.checkErrors(System.err, 50);
            if (bool2) {
              System.exit(-1);
            }
            j++;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              internalError(localThrowable1, localCompilation1, str1);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if ((!(localThrowable2 instanceof SyntaxException)) || (((SyntaxException)localThrowable2).getMessages() != localSourceMessages)) {
            internalError(localThrowable2, localCompilation2, str2);
          }
        }
      }
      if (localSourceMessages.seenErrorsOrWarnings())
      {
        System.err.println("(compiling " + str2 + ')');
        if (localSourceMessages.checkErrors(System.err, 20)) {
          System.exit(1);
        }
      }
    }
  }
  
  public static void getLanguage()
  {
    if (previousLanguage == null)
    {
      previousLanguage = Language.getInstance(null);
      Language.setDefaults(previousLanguage);
    }
  }
  
  public static void getLanguageFromFilenameExtension(String paramString)
  {
    if (previousLanguage == null)
    {
      previousLanguage = Language.getInstanceFromFilenameExtension(paramString);
      if (previousLanguage != null)
      {
        Language.setDefaults(previousLanguage);
        return;
      }
    }
    getLanguage();
  }
  
  static void internalError(Throwable paramThrowable, Compilation paramCompilation, Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramCompilation != null)
    {
      String str = paramCompilation.getFileName();
      int i = paramCompilation.getLineNumber();
      if ((str != null) && (i > 0))
      {
        localStringBuffer.append(str);
        localStringBuffer.append(':');
        localStringBuffer.append(i);
        localStringBuffer.append(": ");
      }
    }
    localStringBuffer.append("internal error while compiling ");
    localStringBuffer.append(paramObject);
    System.err.println(localStringBuffer.toString());
    paramThrowable.printStackTrace(System.err);
    System.exit(-1);
  }
  
  public static void main(String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        int i = processArgs(paramArrayOfString, 0, paramArrayOfString.length);
        if (i < 0) {
          return;
        }
        if (i < paramArrayOfString.length)
        {
          String str = paramArrayOfString[i];
          getLanguageFromFilenameExtension(str);
          setArgs(paramArrayOfString, i + 1);
          checkInitFile();
          Shell.runFileOrClass(str, false, 0);
          return;
        }
        getLanguage();
        setArgs(paramArrayOfString, i);
        checkInitFile();
        if (shouldUseGuiConsole())
        {
          startGuiConsole();
          continue;
        }
        if (Shell.run(Language.getDefaultLanguage(), Environment.getCurrent())) {
          continue;
        }
      }
      finally
      {
        if (!shutdownRegistered) {
          OutPort.runCleanups();
        }
        ModuleBody.exitDecrement();
      }
      System.exit(-1);
    }
  }
  
  public static void printOption(PrintStream paramPrintStream, String paramString1, String paramString2)
  {
    paramPrintStream.print(" ");
    paramPrintStream.print(paramString1);
    int i = 1 + paramString1.length();
    for (int j = 0; j < 30 - i; j++) {
      paramPrintStream.print(" ");
    }
    paramPrintStream.print(" ");
    paramPrintStream.println(paramString2);
  }
  
  public static void printOptions(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Usage: [java kawa.repl | kawa] [options ...]");
    paramPrintStream.println();
    paramPrintStream.println(" Generic options:");
    printOption(paramPrintStream, "--help", "Show help about options");
    printOption(paramPrintStream, "--author", "Show author information");
    printOption(paramPrintStream, "--version", "Show version information");
    paramPrintStream.println();
    paramPrintStream.println(" Options");
    printOption(paramPrintStream, "-e <expr>", "Evaluate expression <expr>");
    printOption(paramPrintStream, "-c <expr>", "Same as -e, but make sure ~/.kawarc.scm is run first");
    printOption(paramPrintStream, "-f <filename>", "File to interpret");
    printOption(paramPrintStream, "-s| --", "Start reading commands interactively from console");
    printOption(paramPrintStream, "-w", "Launch the interpreter in a GUI window");
    printOption(paramPrintStream, "--server <port>", "Start a server accepting telnet connections on <port>");
    printOption(paramPrintStream, "--debug-dump-zip", "Compiled interactive expressions to a zip archive");
    printOption(paramPrintStream, "--debug-print-expr", "Print generated internal expressions");
    printOption(paramPrintStream, "--debug-print-final-expr", "Print expression after any optimizations");
    printOption(paramPrintStream, "--debug-error-prints-stack-trace", "Print stack trace with errors");
    printOption(paramPrintStream, "--debug-warning-prints-stack-trace", "Print stack trace with warnings");
    printOption(paramPrintStream, "--[no-]full-tailcalls", "(Don't) use full tail-calls");
    printOption(paramPrintStream, "-C <filename> ...", "Compile named files to Java class files");
    printOption(paramPrintStream, "--output-format <format>", "Use <format> when printing top-level output");
    printOption(paramPrintStream, "--<language>", "Select source language, one of:");
    String[][] arrayOfString = Language.getLanguages();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      paramPrintStream.print("   ");
      String[] arrayOfString1 = arrayOfString[i];
      int k = -1 + arrayOfString1.length;
      for (int m = 0; m < k; m++) {
        paramPrintStream.print(arrayOfString1[m] + " ");
      }
      if (i == 0) {
        paramPrintStream.print("[default]");
      }
      paramPrintStream.println();
    }
    paramPrintStream.println(" Compilation options, must be specified before -C");
    printOption(paramPrintStream, "-d <dirname>", "Directory to place .class files in");
    printOption(paramPrintStream, "-P <prefix>", "Prefix to prepand to class names");
    printOption(paramPrintStream, "-T <topname>", "name to give to top-level class");
    printOption(paramPrintStream, "--main", "Generate an application, with a main method");
    printOption(paramPrintStream, "--applet", "Generate an applet");
    printOption(paramPrintStream, "--servlet", "Generate a servlet");
    printOption(paramPrintStream, "--module-static", "Top-level definitions are by default static");
    ArrayList localArrayList = Compilation.options.keys();
    for (int j = 0; j < localArrayList.size(); j++)
    {
      String str = (String)localArrayList.get(j);
      printOption(paramPrintStream, "--" + str, Compilation.options.getDoc(str));
    }
    paramPrintStream.println();
    paramPrintStream.println("For more information go to:  http://www.gnu.org/software/kawa/");
  }
  
  public static int processArgs(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    int i = 0;
    String str1;
    label201:
    StringBuffer localStringBuffer;
    int i11;
    label447:
    int i12;
    if (paramInt1 < paramInt2)
    {
      str1 = paramArrayOfString[paramInt1];
      if ((str1.equals("-c")) || (str1.equals("-e")))
      {
        paramInt1++;
        if (paramInt1 == paramInt2) {
          bad_option(str1);
        }
        getLanguage();
        setArgs(paramArrayOfString, paramInt1 + 1);
        if (str1.equals("-c")) {
          checkInitFile();
        }
        Language localLanguage1 = Language.getDefaultLanguage();
        SourceMessages localSourceMessages1 = new SourceMessages();
        Throwable localThrowable1 = Shell.run(localLanguage1, Environment.getCurrent(), new CharArrayInPort(paramArrayOfString[paramInt1]), OutPort.outDefault(), null, localSourceMessages1);
        if (localThrowable1 != null)
        {
          Shell.printError(localThrowable1, localSourceMessages1, OutPort.errDefault());
          System.exit(-1);
        }
      }
      for (i = 1;; i = 1)
      {
        paramInt1++;
        break;
        if (!str1.equals("-f")) {
          break label201;
        }
        paramInt1++;
        if (paramInt1 == paramInt2) {
          bad_option(str1);
        }
        String str9 = paramArrayOfString[paramInt1];
        getLanguageFromFilenameExtension(str9);
        setArgs(paramArrayOfString, paramInt1 + 1);
        checkInitFile();
        if (!Shell.runFileOrClass(str9, true, 0)) {
          System.exit(-1);
        }
      }
      int i15;
      int i17;
      if (str1.startsWith("--script"))
      {
        String str7 = str1.substring(8);
        i15 = paramInt1 + 1;
        int i16 = str7.length();
        i17 = 0;
        if (i16 > 0) {}
        try
        {
          int i18 = Integer.parseInt(str7);
          i17 = i18;
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            String str8;
            i15 = paramInt2;
            i17 = 0;
          }
        }
        if (i15 == paramInt2) {
          bad_option(str1);
        }
        str8 = paramArrayOfString[i15];
        getLanguageFromFilenameExtension(str8);
        setArgs(paramArrayOfString, i15 + 1);
        checkInitFile();
        if (!Shell.runFileOrClass(str8, true, i17)) {
          System.exit(-1);
        }
        return -1;
      }
      if (str1.equals("\\"))
      {
        int i9 = paramInt1 + 1;
        if (i9 == paramInt2) {
          bad_option(str1);
        }
        String str6 = paramArrayOfString[i9];
        SourceMessages localSourceMessages2 = new SourceMessages();
        for (;;)
        {
          Vector localVector;
          try
          {
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(str6));
            int i10 = localBufferedInputStream.read();
            if (i10 == 35)
            {
              localStringBuffer = new StringBuffer(100);
              localVector = new Vector(10);
              i11 = 0;
              if (i10 != 10)
              {
                i11 = 0;
                if (i10 != 13)
                {
                  i11 = 0;
                  if (i10 >= 0)
                  {
                    i10 = localBufferedInputStream.read();
                    continue;
                  }
                }
              }
              i12 = localBufferedInputStream.read();
              if (i12 >= 0) {
                break label2510;
              }
              System.err.println("unexpected end-of-file processing argument line for: '" + str6 + '\'');
              System.exit(-1);
              break label2510;
              label498:
              if (localStringBuffer.length() > 0) {
                localVector.addElement(localStringBuffer.toString());
              }
              int i13 = localVector.size();
              if (i13 > 0)
              {
                String[] arrayOfString = new String[i13];
                localVector.copyInto(arrayOfString);
                int i14 = processArgs(arrayOfString, 0, i13);
                if ((i14 >= 0) && (i14 < i13)) {
                  System.err.println("" + (i13 - i14) + " unused meta args");
                }
              }
            }
            getLanguageFromFilenameExtension(str6);
            InPort localInPort = InPort.openFile(localBufferedInputStream, str6);
            setArgs(paramArrayOfString, i9 + 1);
            checkInitFile();
            OutPort localOutPort = OutPort.errDefault();
            Throwable localThrowable3 = Shell.run(Language.getDefaultLanguage(), Environment.getCurrent(), localInPort, OutPort.outDefault(), null, localSourceMessages2);
            localSourceMessages2.printAll(localOutPort, 20);
            if (localThrowable3 != null)
            {
              if (((localThrowable3 instanceof SyntaxException)) && (((SyntaxException)localThrowable3).getMessages() == localSourceMessages2)) {
                System.exit(1);
              }
              throw localThrowable3;
            }
          }
          catch (Throwable localThrowable2)
          {
            Shell.printError(localThrowable2, localSourceMessages2, OutPort.errDefault());
            System.exit(1);
          }
          return -1;
          label709:
          if ((i12 == 32) || (i12 == 9))
          {
            if (localStringBuffer.length() <= 0) {
              continue;
            }
            localVector.addElement(localStringBuffer.toString());
            localStringBuffer.setLength(0);
            continue;
            label749:
            break label762;
          }
        }
      }
    }
    label2223:
    label2269:
    label2277:
    label2295:
    for (;;)
    {
      localStringBuffer.append((char)i12);
      break label447;
      label762:
      if (i12 == i11)
      {
        i11 = 0;
        break label447;
        if ((str1.equals("-s")) || (str1.equals("--")))
        {
          int j = paramInt1 + 1;
          getLanguage();
          setArgs(paramArrayOfString, j);
          checkInitFile();
          Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
          return -1;
        }
        if (str1.equals("-w"))
        {
          paramInt1++;
          getLanguage();
          setArgs(paramArrayOfString, paramInt1);
          checkInitFile();
          startGuiConsole();
          i = 1;
          break;
        }
        if (str1.equals("-d"))
        {
          paramInt1++;
          if (paramInt1 == paramInt2) {
            bad_option(str1);
          }
          ModuleManager.getInstance().setCompilationDirectory(paramArrayOfString[paramInt1]);
          break;
        }
        if ((str1.equals("--target")) || (str1.equals("target")))
        {
          paramInt1++;
          if (paramInt1 == paramInt2) {
            bad_option(str1);
          }
          String str2 = paramArrayOfString[paramInt1];
          if (str2.equals("7")) {
            Compilation.defaultClassFileVersion = 3342336;
          }
          if ((str2.equals("6")) || (str2.equals("1.6")))
          {
            Compilation.defaultClassFileVersion = 3276800;
            break;
          }
          if ((str2.equals("5")) || (str2.equals("1.5")))
          {
            Compilation.defaultClassFileVersion = 3211264;
            break;
          }
          if (str2.equals("1.4"))
          {
            Compilation.defaultClassFileVersion = 3145728;
            break;
          }
          if (str2.equals("1.3"))
          {
            Compilation.defaultClassFileVersion = 3080192;
            break;
          }
          if (str2.equals("1.2"))
          {
            Compilation.defaultClassFileVersion = 3014656;
            break;
          }
          if (str2.equals("1.1"))
          {
            Compilation.defaultClassFileVersion = 2949123;
            break;
          }
          bad_option(str2);
          break;
        }
        if (str1.equals("-P"))
        {
          paramInt1++;
          if (paramInt1 == paramInt2) {
            bad_option(str1);
          }
          Compilation.classPrefixDefault = paramArrayOfString[paramInt1];
          break;
        }
        if (str1.equals("-T"))
        {
          paramInt1++;
          if (paramInt1 == paramInt2) {
            bad_option(str1);
          }
          compilationTopname = paramArrayOfString[paramInt1];
          break;
        }
        if (str1.equals("-C"))
        {
          int i8 = paramInt1 + 1;
          if (i8 == paramInt2) {
            bad_option(str1);
          }
          compileFiles(paramArrayOfString, i8, paramInt2);
          return -1;
        }
        if ((str1.equals("--output-format")) || (str1.equals("--format")))
        {
          paramInt1++;
          if (paramInt1 == paramInt2) {
            bad_option(str1);
          }
          Shell.setDefaultFormat(paramArrayOfString[paramInt1]);
          break;
        }
        if (str1.equals("--connect"))
        {
          paramInt1++;
          if (paramInt1 == paramInt2) {
            bad_option(str1);
          }
          int i6;
          if (paramArrayOfString[paramInt1].equals("-")) {
            i6 = 0;
          }
          for (;;)
          {
            try
            {
              Socket localSocket2 = new Socket(InetAddress.getByName(null), i6);
              Telnet localTelnet = new Telnet(localSocket2, true);
              TelnetInputStream localTelnetInputStream = localTelnet.getInputStream();
              TelnetOutputStream localTelnetOutputStream = localTelnet.getOutputStream();
              PrintStream localPrintStream = new PrintStream(localTelnetOutputStream, true);
              System.setIn(localTelnetInputStream);
              System.setOut(localPrintStream);
              System.setErr(localPrintStream);
            }
            catch (IOException localIOException2)
            {
              localIOException2.printStackTrace(System.err);
              throw new Error(localIOException2.toString());
            }
            try
            {
              int i7 = Integer.parseInt(paramArrayOfString[paramInt1]);
              i6 = i7;
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              bad_option("--connect port#");
              i6 = -1;
            }
          }
        }
        if (str1.equals("--server"))
        {
          getLanguage();
          int i2 = paramInt1 + 1;
          if (i2 == paramInt2) {
            bad_option(str1);
          }
          int i3;
          if (paramArrayOfString[i2].equals("-")) {
            i3 = 0;
          }
          for (;;)
          {
            try
            {
              ServerSocket localServerSocket = new ServerSocket(i3);
              int i4 = localServerSocket.getLocalPort();
              System.err.println("Listening on port " + i4);
              System.err.print("waiting ... ");
              System.err.flush();
              Socket localSocket1 = localServerSocket.accept();
              System.err.println("got connection from " + localSocket1.getInetAddress() + " port:" + localSocket1.getPort());
              TelnetRepl.serve(Language.getDefaultLanguage(), localSocket1);
              continue;
              try
              {
                int i5 = Integer.parseInt(paramArrayOfString[i2]);
                i3 = i5;
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                bad_option("--server port#");
                i3 = -1;
              }
            }
            catch (IOException localIOException1)
            {
              throw new Error(localIOException1.toString());
            }
          }
        }
        if (str1.equals("--http-auto-handler"))
        {
          paramInt1 += 2;
          if (paramInt1 >= paramInt2) {
            bad_option(str1);
          }
          System.err.println("kawa: HttpServer classes not found");
          System.exit(-1);
          break;
        }
        if (str1.equals("--http-start"))
        {
          paramInt1++;
          if (paramInt1 >= paramInt2) {
            bad_option("missing httpd port argument");
          }
          System.err.println("kawa: HttpServer classes not found");
          System.exit(-1);
          break;
        }
        if (str1.equals("--main"))
        {
          Compilation.generateMainDefault = true;
          break;
        }
        if (str1.equals("--applet"))
        {
          defaultParseOptions = 0x10 | defaultParseOptions;
          break;
        }
        if (str1.equals("--servlet"))
        {
          defaultParseOptions = 0x20 | defaultParseOptions;
          gnu.kawa.servlet.HttpRequestContext.importServletDefinitions = 2;
          break;
        }
        if (str1.equals("--debug-dump-zip"))
        {
          ModuleExp.dumpZipPrefix = "kawa-zip-dump-";
          break;
        }
        if (str1.equals("--debug-print-expr"))
        {
          Compilation.debugPrintExpr = true;
          break;
        }
        if (str1.equals("--debug-print-final-expr"))
        {
          Compilation.debugPrintFinalExpr = true;
          break;
        }
        if (str1.equals("--debug-error-prints-stack-trace"))
        {
          SourceMessages.debugStackTraceOnError = true;
          break;
        }
        if (str1.equals("--debug-warning-prints-stack-trace"))
        {
          SourceMessages.debugStackTraceOnWarning = true;
          break;
        }
        if ((str1.equals("--module-nonstatic")) || (str1.equals("--no-module-static")))
        {
          Compilation.moduleStatic = -1;
          break;
        }
        if (str1.equals("--module-static"))
        {
          Compilation.moduleStatic = 1;
          break;
        }
        if (str1.equals("--module-static-run"))
        {
          Compilation.moduleStatic = 2;
          break;
        }
        if ((str1.equals("--no-inline")) || (str1.equals("--inline=none")))
        {
          Compilation.inlineOk = false;
          break;
        }
        if (str1.equals("--no-console"))
        {
          noConsole = true;
          break;
        }
        if (str1.equals("--inline"))
        {
          Compilation.inlineOk = true;
          break;
        }
        if (str1.equals("--cps"))
        {
          Compilation.defaultCallConvention = 4;
          break;
        }
        if (str1.equals("--full-tailcalls"))
        {
          Compilation.defaultCallConvention = 3;
          break;
        }
        if (str1.equals("--no-full-tailcalls"))
        {
          Compilation.defaultCallConvention = 1;
          break;
        }
        if (str1.equals("--pedantic"))
        {
          Language.requirePedantic = true;
          break;
        }
        if (str1.equals("--help"))
        {
          printOptions(System.out);
          System.exit(0);
          break;
        }
        if (str1.equals("--author"))
        {
          System.out.println("Per Bothner <per@bothner.com>");
          System.exit(0);
          break;
        }
        if (str1.equals("--version"))
        {
          System.out.print("Kawa ");
          System.out.print(Version.getVersion());
          System.out.println();
          System.out.println("Copyright (C) 2009 Per Bothner");
          i = 1;
          break;
        }
        if ((str1.length() > 0) && (str1.charAt(0) == '-'))
        {
          String str3 = str1;
          int i1;
          Language localLanguage2;
          if ((str3.length() > 2) && (str3.charAt(0) == '-'))
          {
            if (str3.charAt(1) == '-')
            {
              i1 = 2;
              str3 = str3.substring(i1);
            }
          }
          else
          {
            localLanguage2 = Language.getInstance(str3);
            if (localLanguage2 == null) {
              break label2277;
            }
            if (previousLanguage != null) {
              break label2269;
            }
            Language.setDefaults(localLanguage2);
          }
          for (;;)
          {
            previousLanguage = localLanguage2;
            break;
            i1 = 1;
            break label2223;
            Language.setCurrentLanguage(localLanguage2);
          }
          int k = str3.indexOf("=");
          String str4;
          if (k < 0)
          {
            str4 = null;
            if ((!str3.startsWith("no-")) || (str3.length() <= 3)) {
              break label2444;
            }
          }
          String str5;
          for (int n = 1;; n = 0)
          {
            if ((str4 == null) && (n != 0))
            {
              str4 = "no";
              str3 = str3.substring(3);
            }
            str5 = Compilation.options.set(str3, str4);
            if (str5 == null) {
              break;
            }
            if ((n != 0) && (str5 == "unknown option name")) {
              str5 = "both '--no-' prefix and '=" + str4 + "' specified";
            }
            if (str5 != "unknown option name") {
              break label2450;
            }
            bad_option(str1);
            break;
            int m = k + 1;
            str4 = str3.substring(m);
            str3 = str3.substring(0, k);
            break label2295;
          }
          System.err.println("kawa: bad option '" + str1 + "': " + str5);
          System.exit(-1);
          break;
        }
        if (ApplicationMainSupport.processSetProperty(str1)) {
          break;
        }
        if (i != 0) {
          return -1;
        }
        return paramInt1;
        if (i11 == 0)
        {
          if ((i12 == 92) || (i12 == 39) || (i12 == 34))
          {
            i11 = i12;
            break label447;
          }
          if (i12 == 10) {
            break label498;
          }
          if (i12 != 13) {
            break label709;
          }
          break label498;
        }
        if (i11 != 92) {
          break label749;
        }
        i11 = 0;
      }
    }
  }
  
  public static void setArgs(String[] paramArrayOfString, int paramInt)
  {
    ApplicationMainSupport.setArgs(paramArrayOfString, paramInt);
  }
  
  public static boolean shouldUseGuiConsole()
  {
    if (noConsole) {}
    for (;;)
    {
      return true;
      try
      {
        Object localObject = Class.forName("java.lang.System").getMethod("console", new Class[0]).invoke(new Object[0], new Object[0]);
        if (localObject == null) {}
      }
      catch (Throwable localThrowable)
      {
        label40:
        break label40;
      }
    }
    return false;
  }
  
  private static void startGuiConsole()
  {
    try
    {
      Class.forName("kawa.GuiConsole").newInstance();
      return;
    }
    catch (Exception localException)
    {
      System.err.println("failed to create Kawa window: " + localException);
      System.exit(-1);
    }
  }
  
  public Object apply0()
  {
    Shell.run(this.language, Environment.getCurrent());
    return Values.empty;
  }
  
  public Object apply1(Object paramObject)
  {
    Shell.run(this.language, (Environment)paramObject);
    return Values.empty;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.repl
 * JD-Core Version:    0.7.0.1
 */