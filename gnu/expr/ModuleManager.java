package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import gnu.text.URLPath;
import java.io.File;
import java.net.URL;

public class ModuleManager
{
  public static final long LAST_MODIFIED_CACHE_TIME = 1000L;
  static ModuleManager instance = new ModuleManager();
  private String compilationDirectory = "";
  public long lastModifiedCacheTime = 1000L;
  ModuleInfo[] modules;
  int numModules;
  ModuleSet packageInfoChain;
  
  /* Error */
  private void add(ModuleInfo paramModuleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   6: ifnonnull +41 -> 47
    //   9: aload_0
    //   10: bipush 10
    //   12: anewarray 39	gnu/expr/ModuleInfo
    //   15: putfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   18: aload_0
    //   19: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   22: astore 4
    //   24: aload_0
    //   25: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   28: istore 5
    //   30: aload_0
    //   31: iload 5
    //   33: iconst_1
    //   34: iadd
    //   35: putfield 41	gnu/expr/ModuleManager:numModules	I
    //   38: aload 4
    //   40: iload 5
    //   42: aload_1
    //   43: aastore
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   51: aload_0
    //   52: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   55: arraylength
    //   56: if_icmpne -38 -> 18
    //   59: iconst_2
    //   60: aload_0
    //   61: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   64: imul
    //   65: anewarray 39	gnu/expr/ModuleInfo
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   73: iconst_0
    //   74: aload_3
    //   75: iconst_0
    //   76: aload_0
    //   77: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   80: invokestatic 47	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   83: aload_0
    //   84: aload_3
    //   85: putfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   88: goto -70 -> 18
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	ModuleManager
    //   0	96	1	paramModuleInfo	ModuleInfo
    //   91	4	2	localObject	Object
    //   68	17	3	arrayOfModuleInfo1	ModuleInfo[]
    //   22	17	4	arrayOfModuleInfo2	ModuleInfo[]
    //   28	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   2	18	91	finally
    //   18	44	91	finally
    //   47	88	91	finally
  }
  
  public static ModuleInfo findWithClass(Class paramClass)
  {
    try
    {
      ModuleInfo localModuleInfo = (ModuleInfo)ModuleInfo.mapClassToInfo.get(paramClass);
      if (localModuleInfo == null)
      {
        localModuleInfo = new ModuleInfo();
        localModuleInfo.setModuleClass(paramClass);
      }
      return localModuleInfo;
    }
    finally {}
  }
  
  public static ModuleManager getInstance()
  {
    return instance;
  }
  
  /* Error */
  private ModuleInfo searchWithAbsSourcePath(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   6: istore_3
    //   7: iinc 3 255
    //   10: iload_3
    //   11: iflt +32 -> 43
    //   14: aload_0
    //   15: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   18: iload_3
    //   19: aaload
    //   20: astore 4
    //   22: aload_1
    //   23: aload 4
    //   25: invokevirtual 72	gnu/expr/ModuleInfo:getSourceAbsPathname	()Ljava/lang/String;
    //   28: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: istore 5
    //   33: iload 5
    //   35: ifeq -28 -> 7
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: areturn
    //   43: aconst_null
    //   44: astore 4
    //   46: goto -8 -> 38
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ModuleManager
    //   0	54	1	paramString	String
    //   49	4	2	localObject	Object
    //   6	13	3	i	int
    //   20	25	4	localModuleInfo	ModuleInfo
    //   31	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   14	33	49	finally
  }
  
  public void clear()
  {
    try
    {
      ModuleSet localModuleSet;
      for (Object localObject2 = this.packageInfoChain; localObject2 != null; localObject2 = localModuleSet)
      {
        localModuleSet = ((ModuleSet)localObject2).next;
        ((ModuleSet)localObject2).next = null;
      }
      this.packageInfoChain = null;
      this.modules = null;
      this.numModules = 0;
      return;
    }
    finally {}
  }
  
  public ModuleInfo find(Compilation paramCompilation)
  {
    try
    {
      ModuleExp localModuleExp = paramCompilation.getModule();
      ClassType localClassType = localModuleExp.classFor(paramCompilation);
      String str = localModuleExp.getFileName();
      ModuleInfo localModuleInfo = findWithSourcePath(ModuleInfo.absPath(str), str);
      localModuleInfo.setClassName(localClassType.getName());
      localModuleInfo.exp = localModuleExp;
      paramCompilation.minfo = localModuleInfo;
      localModuleInfo.comp = paramCompilation;
      return localModuleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ModuleInfo findWithClassName(String paramString)
  {
    ModuleInfo localModuleInfo1 = searchWithClassName(paramString);
    if (localModuleInfo1 != null) {
      return localModuleInfo1;
    }
    try
    {
      ModuleInfo localModuleInfo2 = findWithClass(ClassType.getContextClass(paramString));
      return localModuleInfo2;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }
  
  public ModuleInfo findWithSourcePath(Path paramPath, String paramString)
  {
    try
    {
      String str = paramPath.toString();
      ModuleInfo localModuleInfo = searchWithAbsSourcePath(str);
      if (localModuleInfo == null)
      {
        localModuleInfo = new ModuleInfo();
        localModuleInfo.sourcePath = paramString;
        localModuleInfo.sourceAbsPath = paramPath;
        localModuleInfo.sourceAbsPathname = str;
        add(localModuleInfo);
      }
      return localModuleInfo;
    }
    finally {}
  }
  
  public ModuleInfo findWithSourcePath(String paramString)
  {
    try
    {
      ModuleInfo localModuleInfo = findWithSourcePath(ModuleInfo.absPath(paramString), paramString);
      return localModuleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ModuleInfo findWithURL(URL paramURL)
  {
    try
    {
      ModuleInfo localModuleInfo = findWithSourcePath(URLPath.valueOf(paramURL), paramURL.toExternalForm());
      return localModuleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getCompilationDirectory()
  {
    return this.compilationDirectory;
  }
  
  /* Error */
  public ModuleInfo getModule(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   6: istore_3
    //   7: iload_1
    //   8: iload_3
    //   9: if_icmplt +11 -> 20
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 4
    //   19: areturn
    //   20: aload_0
    //   21: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   24: iload_1
    //   25: aaload
    //   26: astore 4
    //   28: goto -13 -> 15
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	ModuleManager
    //   0	36	1	paramInt	int
    //   31	4	2	localObject	Object
    //   6	4	3	i	int
    //   13	14	4	localModuleInfo	ModuleInfo
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   20	28	31	finally
  }
  
  public void loadPackageInfo(String paramString)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    try
    {
      String str = paramString + "." + "$ModulesMap$";
      for (ModuleSet localModuleSet1 = this.packageInfoChain; localModuleSet1 != null; localModuleSet1 = localModuleSet1.next) {
        if (!localModuleSet1.getClass().getName().equals(str)) {}
      }
      ModuleSet localModuleSet2 = (ModuleSet)Class.forName(str).newInstance();
      localModuleSet2.next = this.packageInfoChain;
      this.packageInfoChain = localModuleSet2;
      localModuleSet2.register(this);
      return;
    }
    finally {}
  }
  
  public void register(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        ModuleInfo localModuleInfo1 = searchWithClassName(paramString1);
        if (localModuleInfo1 != null) {
          return;
        }
        Path localPath1 = Path.valueOf(paramString2);
        String str1 = localPath1.getCanonical().toString();
        if (searchWithAbsSourcePath(str1) == null)
        {
          ModuleInfo localModuleInfo2 = new ModuleInfo();
          if (localPath1.isAbsolute())
          {
            localModuleInfo2.sourceAbsPath = localPath1;
            localModuleInfo2.sourceAbsPathname = str1;
            localModuleInfo2.setClassName(paramString1);
            localModuleInfo2.sourcePath = paramString2;
            localModuleInfo2.uri = paramString3;
            add(localModuleInfo2);
          }
          else
          {
            try
            {
              Class localClass = this.packageInfoChain.getClass();
              String str2 = localClass.getName().replace('.', '/') + ".class";
              Path localPath2 = URLPath.valueOf(localClass.getClassLoader().getResource(str2)).resolve(paramString2);
              localModuleInfo2.sourceAbsPath = localPath2;
              localModuleInfo2.sourceAbsPathname = localPath2.toString();
            }
            catch (Throwable localThrowable) {}
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public ModuleInfo searchWithClassName(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	gnu/expr/ModuleManager:numModules	I
    //   6: istore_3
    //   7: iinc 3 255
    //   10: iload_3
    //   11: iflt +32 -> 43
    //   14: aload_0
    //   15: getfield 37	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   18: iload_3
    //   19: aaload
    //   20: astore 4
    //   22: aload_1
    //   23: aload 4
    //   25: invokevirtual 258	gnu/expr/ModuleInfo:getClassName	()Ljava/lang/String;
    //   28: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: istore 5
    //   33: iload 5
    //   35: ifeq -28 -> 7
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: areturn
    //   43: aconst_null
    //   44: astore 4
    //   46: goto -8 -> 38
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ModuleManager
    //   0	54	1	paramString	String
    //   49	4	2	localObject	Object
    //   6	13	3	i	int
    //   20	25	4	localModuleInfo	ModuleInfo
    //   31	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   14	33	49	finally
  }
  
  public void setCompilationDirectory(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    int i = paramString.length();
    if (i > 0)
    {
      char c = File.separatorChar;
      if (paramString.charAt(i - 1) != c) {
        paramString = paramString + c;
      }
    }
    this.compilationDirectory = paramString;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleManager
 * JD-Core Version:    0.7.0.1
 */