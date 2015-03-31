package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.Location;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ModuleInfo
{
  static ClassToInfoMap mapClassToInfo = new ClassToInfoMap();
  private String className;
  Compilation comp;
  ModuleInfo[] dependencies;
  ModuleExp exp;
  public long lastCheckedTime;
  public long lastModifiedTime;
  Class moduleClass;
  int numDependencies;
  Path sourceAbsPath;
  String sourceAbsPathname;
  public String sourcePath;
  String uri;
  
  public static Path absPath(String paramString)
  {
    return Path.valueOf(paramString).getCanonical();
  }
  
  public static ModuleInfo find(ClassType paramClassType)
  {
    if (paramClassType.isExisting()) {
      try
      {
        ModuleInfo localModuleInfo = ModuleManager.findWithClass(paramClassType.getReflectClass());
        return localModuleInfo;
      }
      catch (Exception localException) {}
    }
    return ModuleManager.getInstance().findWithClassName(paramClassType.getName());
  }
  
  public static ModuleInfo findFromInstance(Object paramObject)
  {
    return ModuleContext.getContext().findFromInstance(paramObject);
  }
  
  static void makeDeclInModule2(ModuleExp paramModuleExp, Declaration paramDeclaration)
  {
    Object localObject = paramDeclaration.getConstantValue();
    ReferenceExp localReferenceExp;
    String str;
    if ((localObject instanceof FieldLocation))
    {
      FieldLocation localFieldLocation = (FieldLocation)localObject;
      Declaration localDeclaration1 = localFieldLocation.getDeclaration();
      localReferenceExp = new ReferenceExp(localDeclaration1);
      paramDeclaration.setAlias(true);
      localReferenceExp.setDontDereference(true);
      paramDeclaration.setValue(localReferenceExp);
      if (localDeclaration1.isProcedureDecl()) {
        paramDeclaration.setProcedureDecl(true);
      }
      if (localDeclaration1.getFlag(32768L)) {
        paramDeclaration.setSyntax();
      }
      if (!paramDeclaration.getFlag(2048L)) {
        str = localFieldLocation.getDeclaringClass().getName();
      }
    }
    for (Declaration localDeclaration2 = paramModuleExp.firstDecl();; localDeclaration2 = localDeclaration2.nextDecl()) {
      if (localDeclaration2 != null)
      {
        if ((str.equals(localDeclaration2.getType().getName())) && (localDeclaration2.getFlag(1073741824L))) {
          localReferenceExp.setContextDecl(localDeclaration2);
        }
      }
      else {
        return;
      }
    }
  }
  
  public static void register(Object paramObject)
  {
    ModuleContext.getContext().setInstance(paramObject);
  }
  
  /* Error */
  public void addDependency(ModuleInfo paramModuleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   6: ifnonnull +41 -> 47
    //   9: aload_0
    //   10: bipush 8
    //   12: anewarray 2	gnu/expr/ModuleInfo
    //   15: putfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   18: aload_0
    //   19: getfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   22: astore 4
    //   24: aload_0
    //   25: getfield 178	gnu/expr/ModuleInfo:numDependencies	I
    //   28: istore 5
    //   30: aload_0
    //   31: iload 5
    //   33: iconst_1
    //   34: iadd
    //   35: putfield 178	gnu/expr/ModuleInfo:numDependencies	I
    //   38: aload 4
    //   40: iload 5
    //   42: aload_1
    //   43: aastore
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 178	gnu/expr/ModuleInfo:numDependencies	I
    //   51: aload_0
    //   52: getfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   55: arraylength
    //   56: if_icmpne -38 -> 18
    //   59: iconst_2
    //   60: aload_0
    //   61: getfield 178	gnu/expr/ModuleInfo:numDependencies	I
    //   64: imul
    //   65: anewarray 2	gnu/expr/ModuleInfo
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   73: iconst_0
    //   74: aload_3
    //   75: iconst_0
    //   76: aload_0
    //   77: getfield 178	gnu/expr/ModuleInfo:numDependencies	I
    //   80: invokestatic 184	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   83: aload_0
    //   84: aload_3
    //   85: putfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   88: goto -70 -> 18
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	ModuleInfo
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
  
  public boolean checkCurrent(ModuleManager paramModuleManager, long paramLong)
  {
    if (this.sourceAbsPath == null) {
      return true;
    }
    if (this.lastCheckedTime + paramModuleManager.lastModifiedCacheTime >= paramLong) {
      return this.moduleClass != null;
    }
    long l1 = this.sourceAbsPath.getLastModified();
    long l2 = this.lastModifiedTime;
    this.lastModifiedTime = l1;
    this.lastCheckedTime = paramLong;
    if (this.className == null) {
      return false;
    }
    if (this.moduleClass == null) {}
    URL localURL;
    try
    {
      this.moduleClass = ClassType.getContextClass(this.className);
      if ((l2 != 0L) || (this.moduleClass == null)) {
        break label203;
      }
      String str1 = this.className;
      int j = str1.lastIndexOf('.');
      if (j >= 0) {
        str1 = str1.substring(j + 1);
      }
      String str2 = str1 + ".class";
      localURL = this.moduleClass.getResource(str2);
      if (localURL == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      long l3;
      label184:
      return false;
    }
    try
    {
      l3 = localURL.openConnection().getLastModified();
      l2 = l3;
    }
    catch (IOException localIOException)
    {
      localURL = null;
      break label184;
    }
    if (localURL == null) {
      return true;
    }
    label203:
    if (l1 > l2)
    {
      this.moduleClass = null;
      return false;
    }
    int i = this.numDependencies;
    ModuleInfo localModuleInfo;
    do
    {
      i--;
      if (i < 0) {
        break;
      }
      localModuleInfo = this.dependencies[i];
    } while ((localModuleInfo.comp != null) || (localModuleInfo.checkCurrent(paramModuleManager, paramLong)));
    this.moduleClass = null;
    return false;
    return true;
  }
  
  public void cleanupAfterCompilation()
  {
    if (this.comp != null) {
      this.comp.cleanupAfterCompilation();
    }
  }
  
  public void clearClass()
  {
    this.moduleClass = null;
    this.numDependencies = 0;
    this.dependencies = null;
  }
  
  /* Error */
  public String getClassName()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   6: ifnonnull +21 -> 27
    //   9: aload_0
    //   10: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   13: ifnull +23 -> 36
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   21: invokevirtual 258	java/lang/Class:getName	()Ljava/lang/String;
    //   24: putfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   27: aload_0
    //   28: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   40: ifnull -13 -> 27
    //   43: aload_0
    //   44: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   47: getfield 262	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   50: ifnull -23 -> 27
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   58: getfield 262	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   61: invokevirtual 76	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   64: putfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   67: goto -40 -> 27
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ModuleInfo
    //   70	4	1	localObject	Object
    //   31	4	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	27	70	finally
    //   27	32	70	finally
    //   36	67	70	finally
  }
  
  /* Error */
  public ClassType getClassType()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   13: invokestatic 267	gnu/bytecode/Type:make	(Ljava/lang/Class;)Lgnu/bytecode/Type;
    //   16: checkcast 54	gnu/bytecode/ClassType
    //   19: astore_3
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_3
    //   23: areturn
    //   24: aload_0
    //   25: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   28: ifnull +24 -> 52
    //   31: aload_0
    //   32: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   35: getfield 262	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   38: ifnull +14 -> 52
    //   41: aload_0
    //   42: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   45: getfield 262	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   48: astore_3
    //   49: goto -29 -> 20
    //   52: aload_0
    //   53: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   56: invokestatic 270	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   59: astore_2
    //   60: aload_2
    //   61: astore_3
    //   62: goto -42 -> 20
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ModuleInfo
    //   65	4	1	localObject1	Object
    //   59	2	2	localClassType	ClassType
    //   19	43	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	65	finally
    //   24	49	65	finally
    //   52	60	65	finally
  }
  
  public Compilation getCompilation()
  {
    return this.comp;
  }
  
  public Object getInstance()
  {
    return ModuleContext.getContext().findInstance(this);
  }
  
  /* Error */
  public Class getModuleClass()
    throws ClassNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +11 -> 19
    //   11: aload_2
    //   12: astore 4
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 4
    //   18: areturn
    //   19: aload_0
    //   20: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   23: invokestatic 211	gnu/bytecode/ClassType:getContextClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: putfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   32: aload_3
    //   33: astore 4
    //   35: goto -21 -> 14
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ModuleInfo
    //   38	4	1	localObject1	Object
    //   6	6	2	localClass1	Class
    //   26	7	3	localClass2	Class
    //   12	22	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   19	32	38	finally
  }
  
  public Class getModuleClassRaw()
  {
    return this.moduleClass;
  }
  
  /* Error */
  public ModuleExp getModuleExp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 282	gnu/expr/ModuleInfo:exp	Lgnu/expr/ModuleExp;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +75 -> 83
    //   11: aload_0
    //   12: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   22: getfield 285	gnu/expr/Compilation:mainLambda	Lgnu/expr/ModuleExp;
    //   25: astore 4
    //   27: aload_0
    //   28: monitorexit
    //   29: aload 4
    //   31: areturn
    //   32: aload_0
    //   33: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   36: invokestatic 270	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   39: astore_3
    //   40: new 143	gnu/expr/ModuleExp
    //   43: dup
    //   44: invokespecial 286	gnu/expr/ModuleExp:<init>	()V
    //   47: astore_2
    //   48: aload_2
    //   49: aload_3
    //   50: putfield 289	gnu/expr/ModuleExp:type	Lgnu/bytecode/ClassType;
    //   53: aload_2
    //   54: aload_3
    //   55: invokevirtual 76	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   58: invokevirtual 293	gnu/expr/ModuleExp:setName	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: ldc_w 294
    //   65: aload_2
    //   66: getfield 297	gnu/expr/ModuleExp:flags	I
    //   69: ior
    //   70: putfield 297	gnu/expr/ModuleExp:flags	I
    //   73: aload_2
    //   74: aload_0
    //   75: putfield 301	gnu/expr/ModuleExp:info	Lgnu/expr/ModuleInfo;
    //   78: aload_0
    //   79: aload_2
    //   80: putfield 282	gnu/expr/ModuleInfo:exp	Lgnu/expr/ModuleExp;
    //   83: aload_2
    //   84: astore 4
    //   86: goto -59 -> 27
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	ModuleInfo
    //   89	4	1	localObject	Object
    //   6	78	2	localModuleExp1	ModuleExp
    //   39	16	3	localClassType	ClassType
    //   25	60	4	localModuleExp2	ModuleExp
    // Exception table:
    //   from	to	target	type
    //   2	7	89	finally
    //   11	27	89	finally
    //   32	83	89	finally
  }
  
  public String getNamespaceUri()
  {
    return this.uri;
  }
  
  public Object getRunInstance()
  {
    Object localObject = getInstance();
    if ((localObject instanceof Runnable)) {
      ((Runnable)localObject).run();
    }
    return localObject;
  }
  
  public Path getSourceAbsPath()
  {
    return this.sourceAbsPath;
  }
  
  public String getSourceAbsPathname()
  {
    String str = this.sourceAbsPathname;
    if ((str == null) && (this.sourceAbsPath != null))
    {
      str = this.sourceAbsPath.toString();
      this.sourceAbsPathname = str;
    }
    return str;
  }
  
  public int getState()
  {
    if (this.comp == null) {
      return 14;
    }
    return this.comp.getState();
  }
  
  public void loadByStages(int paramInt)
  {
    if (1 + getState() >= paramInt) {}
    int m;
    do
    {
      int i;
      do
      {
        return;
        loadByStages(paramInt - 2);
        i = getState();
      } while (i >= paramInt);
      this.comp.setState(i + 1);
      int j = this.numDependencies;
      for (int k = 0; k < j; k++) {
        this.dependencies[k].loadByStages(paramInt);
      }
      m = getState();
    } while (m >= paramInt);
    this.comp.setState(m & 0xFFFFFFFE);
    this.comp.process(paramInt);
  }
  
  public boolean loadEager(int paramInt)
  {
    boolean bool = true;
    if ((this.comp == null) && (this.className != null)) {}
    int i;
    do
    {
      return false;
      i = getState();
      if (i >= paramInt) {
        return bool;
      }
    } while ((i & 0x1) != 0);
    this.comp.setState(i + 1);
    int j = this.numDependencies;
    for (int k = 0;; k++)
    {
      if (k >= j) {
        break label102;
      }
      if (!this.dependencies[k].loadEager(paramInt))
      {
        if (getState() != i + 1) {
          break;
        }
        this.comp.setState(i);
        return false;
      }
    }
    label102:
    if (getState() == i + 1) {
      this.comp.setState(i);
    }
    this.comp.process(paramInt);
    if (getState() == paramInt) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void setClassName(String paramString)
  {
    this.className = paramString;
  }
  
  public void setCompilation(Compilation paramCompilation)
  {
    paramCompilation.minfo = this;
    this.comp = paramCompilation;
    ModuleExp localModuleExp = paramCompilation.mainLambda;
    this.exp = localModuleExp;
    if (localModuleExp != null)
    {
      String str = localModuleExp.getFileName();
      this.sourcePath = str;
      this.sourceAbsPath = absPath(str);
    }
  }
  
  public void setModuleClass(Class paramClass)
  {
    this.moduleClass = paramClass;
    this.className = paramClass.getName();
    mapClassToInfo.put(paramClass, this);
  }
  
  public void setNamespaceUri(String paramString)
  {
    this.uri = paramString;
  }
  
  public void setSourceAbsPath(Path paramPath)
  {
    this.sourceAbsPath = paramPath;
    this.sourceAbsPathname = null;
  }
  
  public ModuleExp setupModuleExp()
  {
    for (;;)
    {
      ModuleExp localModuleExp;
      try
      {
        localModuleExp = getModuleExp();
        int i = localModuleExp.flags;
        if ((i & 0x80000) == 0) {
          return localModuleExp;
        }
        localModuleExp.setFlag(false, 524288);
        Object localObject2;
        ClassType localClassType;
        Object localObject3;
        Language localLanguage;
        gnu.bytecode.Field localField;
        int j;
        if (this.moduleClass != null)
        {
          localObject2 = this.moduleClass;
          localClassType = (ClassType)Type.make((Class)localObject2);
          localObject3 = null;
          localLanguage = Language.getDefaultLanguage();
          localField = localClassType.getFields();
          if (localField == null) {
            break label237;
          }
          j = localField.getFlags();
          if ((j & 0x1) == 0)
          {
            localField = localField.getNext();
            continue;
          }
        }
        else
        {
          localClassType = ClassType.make(this.className);
          Class localClass = localClassType.getReflectClass();
          localObject2 = localClass;
          continue;
        }
        if (((j & 0x8) == 0) && (localObject3 == null)) {}
        Declaration localDeclaration1;
        try
        {
          localObject3 = getInstance();
          Object localObject4 = ((Class)localObject2).getField(localField.getName()).get(localObject3);
          localDeclaration1 = localLanguage.declFromField(localModuleExp, localObject4, localField);
          if (((j & 0x10) != 0) && ((!(localObject4 instanceof Location)) || ((localObject4 instanceof FieldLocation)))) {
            localDeclaration1.noteValue(new QuoteExp(localObject4));
          }
        }
        catch (Exception localException)
        {
          throw new WrappedException(localException);
        }
        localDeclaration1.noteValue(null);
      }
      finally {}
      continue;
      label237:
      Declaration localDeclaration2;
      for (Object localObject5 = localModuleExp.firstDecl(); localObject5 != null; localObject5 = localDeclaration2)
      {
        makeDeclInModule2(localModuleExp, (Declaration)localObject5);
        localDeclaration2 = ((Declaration)localObject5).nextDecl();
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ModuleInfo[");
    if (this.moduleClass != null)
    {
      localStringBuffer.append("class: ");
      localStringBuffer.append(this.moduleClass);
    }
    for (;;)
    {
      localStringBuffer.append(']');
      return localStringBuffer.toString();
      if (this.className != null)
      {
        localStringBuffer.append("class-name: ");
        localStringBuffer.append(this.className);
      }
    }
  }
  
  static class ClassToInfoMap
    extends AbstractWeakHashTable<Class, ModuleInfo>
  {
    protected Class getKeyFromValue(ModuleInfo paramModuleInfo)
    {
      return paramModuleInfo.moduleClass;
    }
    
    protected boolean matches(Class paramClass1, Class paramClass2)
    {
      return paramClass1 == paramClass2;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleInfo
 * JD-Core Version:    0.7.0.1
 */