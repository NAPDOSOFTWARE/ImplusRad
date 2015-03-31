package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.FileUtils;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.IsEqual;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.FilePath;
import gnu.text.Path;
import gnu.text.URIPath;
import java.io.File;
import java.io.IOException;
import kawa.standard.readchar;

public class files
  extends ModuleBody
{
  public static final ModuleMethod $Mn$Grpathname;
  public static final ModuleMethod $Pcfile$Mnseparator;
  public static final files $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29 = (SimpleSymbol)new SimpleSymbol("make-temporary-file").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod URI$Qu;
  public static final ModuleMethod absolute$Mnpath$Qu;
  public static final ModuleMethod copy$Mnfile;
  public static final ModuleMethod create$Mndirectory;
  public static final ModuleMethod delete$Mnfile;
  public static final ModuleMethod directory$Mnfiles;
  public static final ModuleMethod file$Mndirectory$Qu;
  public static final ModuleMethod file$Mnexists$Qu;
  public static final ModuleMethod file$Mnreadable$Qu;
  public static final ModuleMethod file$Mnwritable$Qu;
  public static final ModuleMethod filepath$Qu;
  public static final ModuleMethod make$Mntemporary$Mnfile;
  public static final ModuleMethod path$Mnauthority;
  public static final ModuleMethod path$Mndirectory;
  public static final ModuleMethod path$Mnextension;
  public static final ModuleMethod path$Mnfile;
  public static final ModuleMethod path$Mnfragment;
  public static final ModuleMethod path$Mnhost;
  public static final ModuleMethod path$Mnlast;
  public static final ModuleMethod path$Mnparent;
  public static final ModuleMethod path$Mnport;
  public static final ModuleMethod path$Mnquery;
  public static final ModuleMethod path$Mnscheme;
  public static final ModuleMethod path$Mnuser$Mninfo;
  public static final ModuleMethod path$Qu;
  public static final ModuleMethod rename$Mnfile;
  public static final ModuleMethod resolve$Mnuri;
  public static final ModuleMethod system$Mntmpdir;
  
  public static String $PcFileSeparator()
  {
    return System.getProperty("file.separator");
  }
  
  public static Path $To$Pathname(Object paramObject)
  {
    return Path.valueOf(paramObject);
  }
  
  static
  {
    Lit28 = (SimpleSymbol)new SimpleSymbol("resolve-uri").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("system-tmpdir").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("%file-separator").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("->pathname").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("directory-files").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("create-directory").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("copy-file").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("rename-file").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("delete-file").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("file-writable?").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("file-readable?").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("file-directory?").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("file-exists?").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("path-fragment").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("path-query").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("path-port").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("path-extension").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("path-last").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("path-parent").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("path-directory").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("path-file").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("path-host").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("path-user-info").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("path-authority").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("path-scheme").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("absolute-path?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("URI?").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("filepath?").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("path?").readResolve();
    $instance = new files();
    files localfiles = $instance;
    path$Qu = new ModuleMethod(localfiles, 1, Lit0, 4097);
    filepath$Qu = new ModuleMethod(localfiles, 2, Lit1, 4097);
    URI$Qu = new ModuleMethod(localfiles, 3, Lit2, 4097);
    absolute$Mnpath$Qu = new ModuleMethod(localfiles, 4, Lit3, 4097);
    path$Mnscheme = new ModuleMethod(localfiles, 5, Lit4, 4097);
    path$Mnauthority = new ModuleMethod(localfiles, 6, Lit5, 4097);
    path$Mnuser$Mninfo = new ModuleMethod(localfiles, 7, Lit6, 4097);
    path$Mnhost = new ModuleMethod(localfiles, 8, Lit7, 4097);
    path$Mnfile = new ModuleMethod(localfiles, 9, Lit8, 4097);
    path$Mndirectory = new ModuleMethod(localfiles, 10, Lit9, 4097);
    path$Mnparent = new ModuleMethod(localfiles, 11, Lit10, 4097);
    path$Mnlast = new ModuleMethod(localfiles, 12, Lit11, 4097);
    path$Mnextension = new ModuleMethod(localfiles, 13, Lit12, 4097);
    path$Mnport = new ModuleMethod(localfiles, 14, Lit13, 4097);
    path$Mnquery = new ModuleMethod(localfiles, 15, Lit14, 4097);
    path$Mnfragment = new ModuleMethod(localfiles, 16, Lit15, 4097);
    file$Mnexists$Qu = new ModuleMethod(localfiles, 17, Lit16, 4097);
    file$Mndirectory$Qu = new ModuleMethod(localfiles, 18, Lit17, 4097);
    file$Mnreadable$Qu = new ModuleMethod(localfiles, 19, Lit18, 4097);
    file$Mnwritable$Qu = new ModuleMethod(localfiles, 20, Lit19, 4097);
    delete$Mnfile = new ModuleMethod(localfiles, 21, Lit20, 4097);
    rename$Mnfile = new ModuleMethod(localfiles, 22, Lit21, 8194);
    copy$Mnfile = new ModuleMethod(localfiles, 23, Lit22, 8194);
    create$Mndirectory = new ModuleMethod(localfiles, 24, Lit23, 4097);
    directory$Mnfiles = new ModuleMethod(localfiles, 25, Lit24, 4097);
    $Mn$Grpathname = new ModuleMethod(localfiles, 26, Lit25, 4097);
    $Pcfile$Mnseparator = new ModuleMethod(localfiles, 27, Lit26, 0);
    system$Mntmpdir = new ModuleMethod(localfiles, 28, Lit27, 0);
    resolve$Mnuri = new ModuleMethod(localfiles, 29, Lit28, 8194);
    make$Mntemporary$Mnfile = new ModuleMethod(localfiles, 30, Lit29, 4096);
    $instance.run();
  }
  
  public files()
  {
    ModuleInfo.register(this);
  }
  
  public static boolean URI$Qu(Object paramObject)
  {
    return paramObject instanceof URIPath;
  }
  
  public static void copyFile(Path paramPath1, Path paramPath2)
  {
    InPort localInPort = ports.openInputFile(paramPath1);
    OutPort localOutPort = ports.openOutputFile(paramPath2);
    for (Object localObject = readchar.readChar.apply1(localInPort); !ports.isEofObject(localObject); localObject = readchar.readChar.apply1(localInPort)) {
      ports.writeChar(localObject, localOutPort);
    }
    ports.closeOutputPort(localOutPort);
    ports.closeInputPort(localInPort);
  }
  
  public static boolean createDirectory(FilePath paramFilePath)
  {
    return paramFilePath.toFile().mkdir();
  }
  
  public static void deleteFile(FilePath paramFilePath)
  {
    if (!paramFilePath.delete()) {
      throw ((Throwable)new IOException(Format.formatToString(0, new Object[] { "cannot delete ~a", paramFilePath }).toString()));
    }
  }
  
  public static Object directoryFiles(FilePath paramFilePath)
  {
    File localFile = paramFilePath.toFile();
    if (localFile == null) {}
    String[] arrayOfString;
    for (String str = null;; str = localFile.toString())
    {
      arrayOfString = new File(str).list();
      if (arrayOfString != null) {
        break;
      }
      return Boolean.FALSE;
    }
    return LList.makeList(arrayOfString, 0);
  }
  
  public static boolean isAbsolutePath(Path paramPath)
  {
    return paramPath.isAbsolute();
  }
  
  public static boolean isFileDirectory(Path paramPath)
  {
    return paramPath.isDirectory();
  }
  
  public static boolean isFileExists(Path paramPath)
  {
    return paramPath.exists();
  }
  
  public static boolean isFileReadable(FilePath paramFilePath)
  {
    return paramFilePath.toFile().canRead();
  }
  
  public static boolean isFileWritable(FilePath paramFilePath)
  {
    return paramFilePath.toFile().canWrite();
  }
  
  public static boolean isFilepath(Object paramObject)
  {
    return paramObject instanceof FilePath;
  }
  
  public static boolean isPath(Object paramObject)
  {
    return paramObject instanceof Path;
  }
  
  public static FilePath makeTemporaryFile()
  {
    return makeTemporaryFile("kawa~d.tmp");
  }
  
  public static FilePath makeTemporaryFile(CharSequence paramCharSequence)
  {
    return FilePath.makeFilePath(FileUtils.createTempFile(paramCharSequence.toString()));
  }
  
  public static Object pathAuthority(Path paramPath)
  {
    Object localObject = paramPath.getAuthority();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static Object pathDirectory(Path paramPath)
  {
    Path localPath = paramPath.getDirectory();
    if (localPath == null) {
      return Boolean.FALSE;
    }
    return localPath.toString();
  }
  
  public static Object pathExtension(Path paramPath)
  {
    Object localObject = paramPath.getExtension();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static Object pathFile(Path paramPath)
  {
    Object localObject = paramPath.getPath();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static Object pathFragment(Path paramPath)
  {
    Object localObject = paramPath.getFragment();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static String pathHost(Path paramPath)
  {
    return paramPath.getHost();
  }
  
  public static Object pathLast(Path paramPath)
  {
    Object localObject = paramPath.getLast();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static Object pathParent(Path paramPath)
  {
    Path localPath = paramPath.getParent();
    if (localPath == null) {
      return Boolean.FALSE;
    }
    return localPath.toString();
  }
  
  public static int pathPort(Path paramPath)
  {
    return paramPath.getPort();
  }
  
  public static Object pathQuery(Path paramPath)
  {
    Object localObject = paramPath.getQuery();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static Object pathScheme(Path paramPath)
  {
    Object localObject = paramPath.getScheme();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static Object pathUserInfo(Path paramPath)
  {
    Object localObject = paramPath.getUserInfo();
    if (localObject == null) {
      localObject = Boolean.FALSE;
    }
    return localObject;
  }
  
  public static boolean renameFile(FilePath paramFilePath1, FilePath paramFilePath2)
  {
    return paramFilePath1.toFile().renameTo(paramFilePath2.toFile());
  }
  
  public static Path resolveUri(Path paramPath1, Path paramPath2)
  {
    return paramPath2.resolve(paramPath1);
  }
  
  public static String systemTmpdir()
  {
    String str = System.getProperty("java.io.tmpdir");
    if (str != null) {
      return str;
    }
    if (IsEqual.apply($PcFileSeparator(), "\\")) {
      return "C:\\temp";
    }
    return "/tmp";
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 29: 
    default: 
      return super.apply0(paramModuleMethod);
    case 27: 
      return $PcFileSeparator();
    case 28: 
      return systemTmpdir();
    }
    return makeTemporaryFile();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 22: 
    case 23: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      if (isPath(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 2: 
      if (isFilepath(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 3: 
      if (URI$Qu(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      Path localPath15 = Path.valueOf(paramObject);
      if (isAbsolutePath(localPath15)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException21)
    {
      try
      {
        Path localPath14;
        Path localPath13;
        Path localPath12;
        Path localPath11;
        Path localPath10;
        Path localPath9;
        Path localPath8;
        Path localPath7;
        Path localPath6;
        Path localPath5;
        Path localPath4;
        Path localPath3;
        Path localPath2;
        Path localPath1;
        FilePath localFilePath5;
        FilePath localFilePath4;
        FilePath localFilePath3;
        FilePath localFilePath2;
        FilePath localFilePath1;
        CharSequence localCharSequence = (CharSequence)paramObject;
        return makeTemporaryFile(localCharSequence);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "make-temporary-file", 1, paramObject);
      }
      localClassCastException21 = localClassCastException21;
      throw new WrongType(localClassCastException21, "absolute-path?", 1, paramObject);
    }
    try
    {
      localPath14 = Path.valueOf(paramObject);
      return pathScheme(localPath14);
    }
    catch (ClassCastException localClassCastException20)
    {
      throw new WrongType(localClassCastException20, "path-scheme", 1, paramObject);
    }
    try
    {
      localPath13 = Path.valueOf(paramObject);
      return pathAuthority(localPath13);
    }
    catch (ClassCastException localClassCastException19)
    {
      throw new WrongType(localClassCastException19, "path-authority", 1, paramObject);
    }
    try
    {
      localPath12 = Path.valueOf(paramObject);
      return pathUserInfo(localPath12);
    }
    catch (ClassCastException localClassCastException18)
    {
      throw new WrongType(localClassCastException18, "path-user-info", 1, paramObject);
    }
    try
    {
      localPath11 = Path.valueOf(paramObject);
      return pathHost(localPath11);
    }
    catch (ClassCastException localClassCastException17)
    {
      throw new WrongType(localClassCastException17, "path-host", 1, paramObject);
    }
    try
    {
      localPath10 = Path.valueOf(paramObject);
      return pathFile(localPath10);
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "path-file", 1, paramObject);
    }
    try
    {
      localPath9 = Path.valueOf(paramObject);
      return pathDirectory(localPath9);
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "path-directory", 1, paramObject);
    }
    try
    {
      localPath8 = Path.valueOf(paramObject);
      return pathParent(localPath8);
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "path-parent", 1, paramObject);
    }
    try
    {
      localPath7 = Path.valueOf(paramObject);
      return pathLast(localPath7);
    }
    catch (ClassCastException localClassCastException13)
    {
      throw new WrongType(localClassCastException13, "path-last", 1, paramObject);
    }
    try
    {
      localPath6 = Path.valueOf(paramObject);
      return pathExtension(localPath6);
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "path-extension", 1, paramObject);
    }
    try
    {
      localPath5 = Path.valueOf(paramObject);
      return Integer.valueOf(pathPort(localPath5));
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "path-port", 1, paramObject);
    }
    try
    {
      localPath4 = Path.valueOf(paramObject);
      return pathQuery(localPath4);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "path-query", 1, paramObject);
    }
    try
    {
      localPath3 = Path.valueOf(paramObject);
      return pathFragment(localPath3);
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "path-fragment", 1, paramObject);
    }
    try
    {
      localPath2 = Path.valueOf(paramObject);
      if (isFileExists(localPath2)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "file-exists?", 1, paramObject);
    }
    try
    {
      localPath1 = Path.valueOf(paramObject);
      if (isFileDirectory(localPath1)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "file-directory?", 1, paramObject);
    }
    try
    {
      localFilePath5 = FilePath.makeFilePath(paramObject);
      if (isFileReadable(localFilePath5)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "file-readable?", 1, paramObject);
    }
    try
    {
      localFilePath4 = FilePath.makeFilePath(paramObject);
      if (isFileWritable(localFilePath4)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "file-writable?", 1, paramObject);
    }
    try
    {
      localFilePath3 = FilePath.makeFilePath(paramObject);
      deleteFile(localFilePath3);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "delete-file", 1, paramObject);
    }
    try
    {
      localFilePath2 = FilePath.makeFilePath(paramObject);
      if (createDirectory(localFilePath2)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "create-directory", 1, paramObject);
    }
    try
    {
      localFilePath1 = FilePath.makeFilePath(paramObject);
      return directoryFiles(localFilePath1);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "directory-files", 1, paramObject);
    }
    return $To$Pathname(paramObject);
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 529	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 22:+44->48, 23:+74->78, 29:+97->101
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 611	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_2
    //   49: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   52: astore 13
    //   54: aload_3
    //   55: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   58: astore 15
    //   60: aload 13
    //   62: aload 15
    //   64: invokestatic 613	kawa/lib/files:renameFile	(Lgnu/text/FilePath;Lgnu/text/FilePath;)Z
    //   67: ifeq +7 -> 74
    //   70: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   73: areturn
    //   74: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: areturn
    //   78: aload_2
    //   79: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   82: astore 9
    //   84: aload_3
    //   85: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   88: astore 11
    //   90: aload 9
    //   92: aload 11
    //   94: invokestatic 615	kawa/lib/files:copyFile	(Lgnu/text/Path;Lgnu/text/Path;)V
    //   97: getstatic 596	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   100: areturn
    //   101: aload_2
    //   102: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   105: astore 5
    //   107: aload_3
    //   108: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   111: astore 7
    //   113: aload 5
    //   115: aload 7
    //   117: invokestatic 617	kawa/lib/files:resolveUri	(Lgnu/text/Path;Lgnu/text/Path;)Lgnu/text/Path;
    //   120: areturn
    //   121: astore 12
    //   123: new 604	gnu/mapping/WrongType
    //   126: dup
    //   127: aload 12
    //   129: ldc 131
    //   131: iconst_1
    //   132: aload_2
    //   133: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   136: athrow
    //   137: astore 14
    //   139: new 604	gnu/mapping/WrongType
    //   142: dup
    //   143: aload 14
    //   145: ldc 131
    //   147: iconst_2
    //   148: aload_3
    //   149: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    //   153: astore 8
    //   155: new 604	gnu/mapping/WrongType
    //   158: dup
    //   159: aload 8
    //   161: ldc 127
    //   163: iconst_1
    //   164: aload_2
    //   165: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: astore 10
    //   171: new 604	gnu/mapping/WrongType
    //   174: dup
    //   175: aload 10
    //   177: ldc 127
    //   179: iconst_2
    //   180: aload_3
    //   181: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   184: athrow
    //   185: astore 4
    //   187: new 604	gnu/mapping/WrongType
    //   190: dup
    //   191: aload 4
    //   193: ldc 103
    //   195: iconst_1
    //   196: aload_2
    //   197: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore 6
    //   203: new 604	gnu/mapping/WrongType
    //   206: dup
    //   207: aload 6
    //   209: ldc 103
    //   211: iconst_2
    //   212: aload_3
    //   213: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	files
    //   0	217	1	paramModuleMethod	ModuleMethod
    //   0	217	2	paramObject1	Object
    //   0	217	3	paramObject2	Object
    //   185	7	4	localClassCastException1	ClassCastException
    //   105	9	5	localPath1	Path
    //   201	7	6	localClassCastException2	ClassCastException
    //   111	5	7	localPath2	Path
    //   153	7	8	localClassCastException3	ClassCastException
    //   82	9	9	localPath3	Path
    //   169	7	10	localClassCastException4	ClassCastException
    //   88	5	11	localPath4	Path
    //   121	7	12	localClassCastException5	ClassCastException
    //   52	9	13	localFilePath1	FilePath
    //   137	7	14	localClassCastException6	ClassCastException
    //   58	5	15	localFilePath2	FilePath
    // Exception table:
    //   from	to	target	type
    //   48	54	121	java/lang/ClassCastException
    //   54	60	137	java/lang/ClassCastException
    //   78	84	153	java/lang/ClassCastException
    //   84	90	169	java/lang/ClassCastException
    //   101	107	185	java/lang/ClassCastException
    //   107	113	201	java/lang/ClassCastException
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 29: 
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 30: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 28: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 22: 
    case 23: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 30: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 26: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25: 
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 24: 
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 21: 
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20: 
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 19: 
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 18: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 17: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 16: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 15: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 14: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 13: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 12: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 11: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 10: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 9: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 8: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 7: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 6: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 5: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 4: 
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 3: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 29: 
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Path.coerceToPathOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 23: 
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Path.coerceToPathOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    }
    if (FilePath.coerceToFilePathOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (FilePath.coerceToFilePathOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786430;
  }
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.files
 * JD-Core Version:    0.7.0.1
 */