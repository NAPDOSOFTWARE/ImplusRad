package appinventor.ai_djxraizwellx.Implusx;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Player;
import com.google.appinventor.components.runtime.Slider;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.youngandroid.runtime;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class Screen1
  extends Form
  implements Runnable
{
  static final SimpleSymbol Lit0 = (SimpleSymbol)new SimpleSymbol("Screen1").readResolve();
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final IntNum Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final FString Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final IntNum Lit21;
  static final SimpleSymbol Lit22;
  static final IntNum Lit23;
  static final FString Lit24;
  static final FString Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final IntNum Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final DFloNum Lit30;
  static final SimpleSymbol Lit31;
  static final DFloNum Lit32;
  static final SimpleSymbol Lit33;
  static final DFloNum Lit34;
  static final FString Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final FString Lit40;
  static final SimpleSymbol Lit41;
  static final FString Lit42;
  static final FString Lit43;
  static final SimpleSymbol Lit44;
  static final FString Lit45;
  static final FString Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final FString Lit49;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final FString Lit54;
  static final SimpleSymbol Lit55;
  static final FString Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final FString Lit59;
  static final IntNum Lit6;
  static final IntNum Lit60;
  static final FString Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73 = (SimpleSymbol)new SimpleSymbol("lookup-handler").readResolve();
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static Screen1 Screen1;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn10;
  static final ModuleMethod lambda$Fn11;
  static final ModuleMethod lambda$Fn12;
  static final ModuleMethod lambda$Fn13;
  static final ModuleMethod lambda$Fn14;
  static final ModuleMethod lambda$Fn15;
  static final ModuleMethod lambda$Fn16;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  static final ModuleMethod lambda$Fn4;
  static final ModuleMethod lambda$Fn5;
  static final ModuleMethod lambda$Fn6;
  static final ModuleMethod lambda$Fn7;
  static final ModuleMethod lambda$Fn8;
  static final ModuleMethod lambda$Fn9;
  public Boolean $Stdebug$Mnform$St;
  public final ModuleMethod $define;
  public Button Button1;
  public final ModuleMethod Button1$Click;
  public Button Button2;
  public final ModuleMethod Button2$Click;
  public HorizontalArrangement HorizontalArrangement1;
  public Image Image1;
  public Image Image2;
  public Player Player1;
  public Slider Slider1;
  public final ModuleMethod Slider1$PositionChanged;
  public final ModuleMethod add$Mnto$Mncomponents;
  public final ModuleMethod add$Mnto$Mnevents;
  public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
  public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
  public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
  public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
  public final ModuleMethod android$Mnlog$Mnform;
  public LList components$Mnto$Mncreate;
  public final ModuleMethod dispatchEvent;
  public LList events$Mnto$Mnregister;
  public LList form$Mndo$Mnafter$Mncreation;
  public Environment form$Mnenvironment;
  public Symbol form$Mnname$Mnsymbol;
  public Environment global$Mnvar$Mnenvironment;
  public LList global$Mnvars$Mnto$Mncreate;
  public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
  public final ModuleMethod lookup$Mnhandler;
  public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
  public final ModuleMethod process$Mnexception;
  public final ModuleMethod send$Mnerror;
  
  static
  {
    Lit72 = (SimpleSymbol)new SimpleSymbol("dispatchEvent").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("send-error").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("add-to-global-vars").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("add-to-components").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("add-to-events").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("add-to-global-var-environment").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("is-bound-in-form-environment").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("lookup-in-form-environment").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("add-to-form-environment").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("android-log-form").readResolve();
    Lit61 = new FString("com.google.appinventor.components.runtime.Player");
    Lit60 = IntNum.make(70);
    Lit59 = new FString("com.google.appinventor.components.runtime.Player");
    Lit58 = (SimpleSymbol)new SimpleSymbol("Button2$Click").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("Stop").readResolve();
    Lit56 = new FString("com.google.appinventor.components.runtime.Button");
    Lit55 = (SimpleSymbol)new SimpleSymbol("Button2").readResolve();
    Lit54 = new FString("com.google.appinventor.components.runtime.Button");
    Lit53 = (SimpleSymbol)new SimpleSymbol("Click").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("Button1$Click").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("Start").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("Source").readResolve();
    Lit49 = new FString("com.google.appinventor.components.runtime.Button");
    Lit48 = (SimpleSymbol)new SimpleSymbol("Image").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("Button1").readResolve();
    Lit46 = new FString("com.google.appinventor.components.runtime.Button");
    Lit45 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    Lit44 = (SimpleSymbol)new SimpleSymbol("HorizontalArrangement1").readResolve();
    Lit43 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    Lit42 = new FString("com.google.appinventor.components.runtime.Image");
    Lit41 = (SimpleSymbol)new SimpleSymbol("Image2").readResolve();
    Lit40 = new FString("com.google.appinventor.components.runtime.Image");
    Lit39 = (SimpleSymbol)new SimpleSymbol("PositionChanged").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("Slider1$PositionChanged").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("Volume").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("Player1").readResolve();
    Lit35 = new FString("com.google.appinventor.components.runtime.Slider");
    Lit34 = DFloNum.make(70);
    Lit33 = (SimpleSymbol)new SimpleSymbol("ThumbPosition").readResolve();
    Lit32 = DFloNum.make(1.0D);
    Lit31 = (SimpleSymbol)new SimpleSymbol("MinValue").readResolve();
    Lit30 = DFloNum.make(100);
    Lit29 = (SimpleSymbol)new SimpleSymbol("MaxValue").readResolve();
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = -16777216;
    Lit28 = IntNum.make(arrayOfInt1);
    Lit27 = (SimpleSymbol)new SimpleSymbol("ColorLeft").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("Slider1").readResolve();
    Lit25 = new FString("com.google.appinventor.components.runtime.Slider");
    Lit24 = new FString("com.google.appinventor.components.runtime.Image");
    Lit23 = IntNum.make(330);
    Lit22 = (SimpleSymbol)new SimpleSymbol("Height").readResolve();
    Lit21 = IntNum.make(-2);
    Lit20 = (SimpleSymbol)new SimpleSymbol("Width").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("Picture").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("Image1").readResolve();
    Lit17 = new FString("com.google.appinventor.components.runtime.Image");
    Lit16 = (SimpleSymbol)new SimpleSymbol("Title").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("boolean").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("Scrollable").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("Icon").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("CloseScreenAnimation").readResolve();
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = -3355444;
    Lit11 = IntNum.make(arrayOfInt2);
    Lit10 = (SimpleSymbol)new SimpleSymbol("BackgroundColor").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("AppName").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("AlignVertical").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("number").readResolve();
    Lit6 = IntNum.make(3);
    Lit5 = (SimpleSymbol)new SimpleSymbol("AlignHorizontal").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("text").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("AboutScreen").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("*the-null-value*").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("getMessage").readResolve();
  }
  
  public Screen1()
  {
    ModuleInfo.register(this);
    Screen1.frame localframe = new Screen1.frame();
    localframe.$main = this;
    this.android$Mnlog$Mnform = new ModuleMethod(localframe, 1, Lit62, 4097);
    this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(localframe, 2, Lit63, 8194);
    this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(localframe, 3, Lit64, 8193);
    this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(localframe, 5, Lit65, 4097);
    this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(localframe, 6, Lit66, 8194);
    this.add$Mnto$Mnevents = new ModuleMethod(localframe, 7, Lit67, 8194);
    this.add$Mnto$Mncomponents = new ModuleMethod(localframe, 8, Lit68, 16388);
    this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(localframe, 9, Lit69, 8194);
    this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(localframe, 10, Lit70, 4097);
    this.send$Mnerror = new ModuleMethod(localframe, 11, Lit71, 4097);
    this.process$Mnexception = new ModuleMethod(localframe, 12, "process-exception", 4097);
    this.dispatchEvent = new ModuleMethod(localframe, 13, Lit72, 16388);
    this.lookup$Mnhandler = new ModuleMethod(localframe, 14, Lit73, 8194);
    ModuleMethod localModuleMethod = new ModuleMethod(localframe, 15, null, 0);
    localModuleMethod.setProperty("source-location", "/tmp/runtime6361510694210396753.scm:541");
    lambda$Fn1 = localModuleMethod;
    this.$define = new ModuleMethod(localframe, 16, "$define", 0);
    lambda$Fn2 = new ModuleMethod(localframe, 17, null, 0);
    lambda$Fn3 = new ModuleMethod(localframe, 18, null, 0);
    lambda$Fn4 = new ModuleMethod(localframe, 19, null, 0);
    lambda$Fn5 = new ModuleMethod(localframe, 20, null, 0);
    lambda$Fn6 = new ModuleMethod(localframe, 21, null, 0);
    this.Slider1$PositionChanged = new ModuleMethod(localframe, 22, Lit38, 4097);
    lambda$Fn7 = new ModuleMethod(localframe, 23, null, 0);
    lambda$Fn8 = new ModuleMethod(localframe, 24, null, 0);
    lambda$Fn9 = new ModuleMethod(localframe, 25, null, 0);
    lambda$Fn10 = new ModuleMethod(localframe, 26, null, 0);
    lambda$Fn11 = new ModuleMethod(localframe, 27, null, 0);
    lambda$Fn12 = new ModuleMethod(localframe, 28, null, 0);
    this.Button1$Click = new ModuleMethod(localframe, 29, Lit52, 0);
    lambda$Fn13 = new ModuleMethod(localframe, 30, null, 0);
    lambda$Fn14 = new ModuleMethod(localframe, 31, null, 0);
    this.Button2$Click = new ModuleMethod(localframe, 32, Lit58, 0);
    lambda$Fn15 = new ModuleMethod(localframe, 33, null, 0);
    lambda$Fn16 = new ModuleMethod(localframe, 34, null, 0);
  }
  
  static Object lambda10()
  {
    runtime.setAndCoerceProperty$Ex(Lit44, Lit5, Lit6, Lit7);
    return runtime.setAndCoerceProperty$Ex(Lit44, Lit20, Lit21, Lit7);
  }
  
  static Object lambda11()
  {
    runtime.setAndCoerceProperty$Ex(Lit44, Lit5, Lit6, Lit7);
    return runtime.setAndCoerceProperty$Ex(Lit44, Lit20, Lit21, Lit7);
  }
  
  static Object lambda12()
  {
    return runtime.setAndCoerceProperty$Ex(Lit47, Lit48, "play.png", Lit4);
  }
  
  static Object lambda13()
  {
    return runtime.setAndCoerceProperty$Ex(Lit47, Lit48, "play.png", Lit4);
  }
  
  static Object lambda14()
  {
    return runtime.setAndCoerceProperty$Ex(Lit55, Lit48, "pause2.png", Lit4);
  }
  
  static Object lambda15()
  {
    return runtime.setAndCoerceProperty$Ex(Lit55, Lit48, "pause2.png", Lit4);
  }
  
  static Object lambda16()
  {
    return runtime.setAndCoerceProperty$Ex(Lit36, Lit37, Lit60, Lit7);
  }
  
  static Object lambda17()
  {
    return runtime.setAndCoerceProperty$Ex(Lit36, Lit37, Lit60, Lit7);
  }
  
  /* Error */
  public static SimpleSymbol lambda1symbolAppend$V(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 549	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: astore_1
    //   6: getstatic 555	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   9: astore_2
    //   10: getstatic 560	kawa/lib/strings:string$Mnappend	Lgnu/expr/ModuleMethod;
    //   13: astore_3
    //   14: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   17: astore 4
    //   19: aload_1
    //   20: astore 5
    //   22: aload 5
    //   24: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   27: if_acmpne +28 -> 55
    //   30: aload_2
    //   31: aload_3
    //   32: aload 4
    //   34: invokestatic 567	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   37: invokevirtual 573	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 12
    //   42: aload 12
    //   44: checkcast 575	java/lang/CharSequence
    //   47: astore 14
    //   49: aload 14
    //   51: invokestatic 581	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   54: areturn
    //   55: aload 5
    //   57: checkcast 583	gnu/lists/Pair
    //   60: astore 7
    //   62: aload 7
    //   64: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   67: astore 8
    //   69: aload 7
    //   71: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   74: astore 9
    //   76: aload 9
    //   78: checkcast 591	gnu/mapping/Symbol
    //   81: astore 11
    //   83: aload 11
    //   85: invokestatic 595	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   88: aload 4
    //   90: invokestatic 598	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   93: astore 4
    //   95: aload 8
    //   97: astore 5
    //   99: goto -77 -> 22
    //   102: astore 6
    //   104: new 600	gnu/mapping/WrongType
    //   107: dup
    //   108: aload 6
    //   110: ldc_w 602
    //   113: bipush 254
    //   115: aload 5
    //   117: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    //   121: astore 10
    //   123: new 600	gnu/mapping/WrongType
    //   126: dup
    //   127: aload 10
    //   129: ldc_w 607
    //   132: iconst_1
    //   133: aload 9
    //   135: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   138: athrow
    //   139: astore 13
    //   141: new 600	gnu/mapping/WrongType
    //   144: dup
    //   145: aload 13
    //   147: ldc_w 609
    //   150: iconst_1
    //   151: aload 12
    //   153: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramArrayOfObject	Object[]
    //   5	15	1	localLList	LList
    //   9	22	2	localApply	gnu.kawa.functions.Apply
    //   13	19	3	localModuleMethod	ModuleMethod
    //   17	77	4	localObject1	Object
    //   20	96	5	localObject2	Object
    //   102	7	6	localClassCastException1	java.lang.ClassCastException
    //   60	10	7	localPair	gnu.lists.Pair
    //   67	29	8	localObject3	Object
    //   74	60	9	localObject4	Object
    //   121	7	10	localClassCastException2	java.lang.ClassCastException
    //   81	3	11	localSymbol	Symbol
    //   40	112	12	localObject5	Object
    //   139	7	13	localClassCastException3	java.lang.ClassCastException
    //   47	3	14	localCharSequence	java.lang.CharSequence
    // Exception table:
    //   from	to	target	type
    //   55	62	102	java/lang/ClassCastException
    //   76	83	121	java/lang/ClassCastException
    //   42	49	139	java/lang/ClassCastException
  }
  
  static Object lambda2()
  {
    return null;
  }
  
  static Object lambda3()
  {
    runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "IMPLUS RADIO - The best web radio !", Lit4);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit6, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit9, "IMPLUS RADIO", Lit4);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "zoom", Lit4);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "profile.png", Lit4);
    runtime.setAndCoerceProperty$Ex(Lit0, Lit14, Boolean.TRUE, Lit15);
    return runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "IMPLUS RADIO - THE NUMBER #1 IN #HITS MUSIC", Lit4);
  }
  
  static Object lambda4()
  {
    runtime.setAndCoerceProperty$Ex(Lit18, Lit19, "11043235_1559200447668890_2199368419064157750_n.jpg", Lit4);
    runtime.setAndCoerceProperty$Ex(Lit18, Lit20, Lit21, Lit7);
    return runtime.setAndCoerceProperty$Ex(Lit18, Lit22, Lit23, Lit7);
  }
  
  static Object lambda5()
  {
    runtime.setAndCoerceProperty$Ex(Lit18, Lit19, "11043235_1559200447668890_2199368419064157750_n.jpg", Lit4);
    runtime.setAndCoerceProperty$Ex(Lit18, Lit20, Lit21, Lit7);
    return runtime.setAndCoerceProperty$Ex(Lit18, Lit22, Lit23, Lit7);
  }
  
  static Object lambda6()
  {
    runtime.setAndCoerceProperty$Ex(Lit26, Lit27, Lit28, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit26, Lit29, Lit30, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit26, Lit31, Lit32, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit26, Lit33, Lit34, Lit7);
    return runtime.setAndCoerceProperty$Ex(Lit26, Lit20, Lit21, Lit7);
  }
  
  static Object lambda7()
  {
    runtime.setAndCoerceProperty$Ex(Lit26, Lit27, Lit28, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit26, Lit29, Lit30, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit26, Lit31, Lit32, Lit7);
    runtime.setAndCoerceProperty$Ex(Lit26, Lit33, Lit34, Lit7);
    return runtime.setAndCoerceProperty$Ex(Lit26, Lit20, Lit21, Lit7);
  }
  
  static Object lambda8()
  {
    runtime.setAndCoerceProperty$Ex(Lit41, Lit19, "Divider-1.png", Lit4);
    return runtime.setAndCoerceProperty$Ex(Lit41, Lit20, Lit21, Lit7);
  }
  
  static Object lambda9()
  {
    runtime.setAndCoerceProperty$Ex(Lit41, Lit19, "Divider-1.png", Lit4);
    return runtime.setAndCoerceProperty$Ex(Lit41, Lit20, Lit21, Lit7);
  }
  
  /* Error */
  public void $define()
  {
    // Byte code:
    //   0: invokestatic 644	kawa/standard/Scheme:getInstance	()Lkawa/standard/Scheme;
    //   3: invokestatic 650	gnu/expr/Language:setDefaults	(Lgnu/expr/Language;)V
    //   6: aload_0
    //   7: invokevirtual 653	appinventor/ai_djxraizwellx/Implusx/Screen1:run	()V
    //   10: aload_0
    //   11: putstatic 655	appinventor/ai_djxraizwellx/Implusx/Screen1:Screen1	Lappinventor/ai_djxraizwellx/Implusx/Screen1;
    //   14: aload_0
    //   15: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   18: aload_0
    //   19: invokevirtual 659	appinventor/ai_djxraizwellx/Implusx/Screen1:addToFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   22: aload_0
    //   23: getfield 661	appinventor/ai_djxraizwellx/Implusx/Screen1:events$Mnto$Mnregister	Lgnu/lists/LList;
    //   26: astore_2
    //   27: aload_2
    //   28: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   31: if_acmpne +114 -> 145
    //   34: aload_0
    //   35: getstatic 416	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit2	Lgnu/mapping/SimpleSymbol;
    //   38: getstatic 482	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   41: invokevirtual 664	appinventor/ai_djxraizwellx/Implusx/Screen1:addToGlobalVars	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   44: aload_0
    //   45: getfield 666	appinventor/ai_djxraizwellx/Implusx/Screen1:global$Mnvars$Mnto$Mncreate	Lgnu/lists/LList;
    //   48: invokestatic 672	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   51: astore 12
    //   53: aload 12
    //   55: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   58: if_acmpne +173 -> 231
    //   61: aload_0
    //   62: getfield 674	appinventor/ai_djxraizwellx/Implusx/Screen1:form$Mndo$Mnafter$Mncreation	Lgnu/lists/LList;
    //   65: invokestatic 672	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   68: astore 22
    //   70: aload 22
    //   72: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   75: if_acmpne +274 -> 349
    //   78: aload_0
    //   79: getfield 676	appinventor/ai_djxraizwellx/Implusx/Screen1:components$Mnto$Mncreate	Lgnu/lists/LList;
    //   82: invokestatic 672	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   85: astore 27
    //   87: aload 27
    //   89: astore 28
    //   91: aload 28
    //   93: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   96: if_acmpne +302 -> 398
    //   99: aload 27
    //   101: astore 29
    //   103: aload 29
    //   105: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   108: if_acmpne +472 -> 580
    //   111: aload 27
    //   113: astore 30
    //   115: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   118: astore 31
    //   120: aload 30
    //   122: aload 31
    //   124: if_acmpne +539 -> 663
    //   127: return
    //   128: astore_1
    //   129: aload_0
    //   130: aload_1
    //   131: invokevirtual 679	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 682	appinventor/ai_djxraizwellx/Implusx/Screen1:androidLogForm	(Ljava/lang/Object;)V
    //   137: aload_0
    //   138: aload_1
    //   139: invokevirtual 685	appinventor/ai_djxraizwellx/Implusx/Screen1:processException	(Ljava/lang/Object;)V
    //   142: goto -132 -> 10
    //   145: aload_2
    //   146: checkcast 583	gnu/lists/Pair
    //   149: astore 5
    //   151: aload 5
    //   153: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   156: astore 6
    //   158: getstatic 689	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   161: aload 6
    //   163: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   166: astore 7
    //   168: aload 7
    //   170: ifnonnull +41 -> 211
    //   173: aconst_null
    //   174: astore 8
    //   176: getstatic 696	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   179: aload 6
    //   181: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnonnull +33 -> 221
    //   191: aconst_null
    //   192: astore 10
    //   194: aload_0
    //   195: aload 8
    //   197: aload 10
    //   199: invokestatic 702	com/google/appinventor/components/runtime/EventDispatcher:registerEventForDelegation	(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 5
    //   204: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   207: astore_2
    //   208: goto -181 -> 27
    //   211: aload 7
    //   213: invokevirtual 707	java/lang/Object:toString	()Ljava/lang/String;
    //   216: astore 8
    //   218: goto -42 -> 176
    //   221: aload 9
    //   223: invokevirtual 707	java/lang/Object:toString	()Ljava/lang/String;
    //   226: astore 10
    //   228: goto -34 -> 194
    //   231: aload 12
    //   233: checkcast 583	gnu/lists/Pair
    //   236: astore 15
    //   238: aload 15
    //   240: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   243: astore 16
    //   245: getstatic 689	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   248: aload 16
    //   250: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: astore 17
    //   255: getstatic 710	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   258: aload 16
    //   260: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: astore 18
    //   265: aload 17
    //   267: checkcast 591	gnu/mapping/Symbol
    //   270: astore 21
    //   272: aload_0
    //   273: aload 21
    //   275: getstatic 714	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   278: aload 18
    //   280: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: invokevirtual 717	appinventor/ai_djxraizwellx/Implusx/Screen1:addToGlobalVarEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   286: aload 15
    //   288: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   291: astore 12
    //   293: goto -240 -> 53
    //   296: astore 13
    //   298: new 600	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 13
    //   304: ldc_w 602
    //   307: bipush 254
    //   309: aload 12
    //   311: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   314: astore 14
    //   316: aload 14
    //   318: athrow
    //   319: astore 11
    //   321: aload_0
    //   322: aload 11
    //   324: invokevirtual 685	appinventor/ai_djxraizwellx/Implusx/Screen1:processException	(Ljava/lang/Object;)V
    //   327: return
    //   328: astore 19
    //   330: new 600	gnu/mapping/WrongType
    //   333: dup
    //   334: aload 19
    //   336: ldc 185
    //   338: iconst_0
    //   339: aload 17
    //   341: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   344: astore 20
    //   346: aload 20
    //   348: athrow
    //   349: aload 22
    //   351: checkcast 583	gnu/lists/Pair
    //   354: astore 25
    //   356: aload 25
    //   358: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   361: invokestatic 720	kawa/lib/misc:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: aload 25
    //   367: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   370: astore 22
    //   372: goto -302 -> 70
    //   375: astore 23
    //   377: new 600	gnu/mapping/WrongType
    //   380: dup
    //   381: aload 23
    //   383: ldc_w 602
    //   386: bipush 254
    //   388: aload 22
    //   390: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   393: astore 24
    //   395: aload 24
    //   397: athrow
    //   398: aload 28
    //   400: checkcast 583	gnu/lists/Pair
    //   403: astore 47
    //   405: aload 47
    //   407: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   410: astore 48
    //   412: getstatic 723	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
    //   415: aload 48
    //   417: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   420: astore 49
    //   422: getstatic 726	kawa/lib/lists:cadddr	Lgnu/expr/GenericProc;
    //   425: aload 48
    //   427: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: getstatic 710	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   434: aload 48
    //   436: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   439: astore 51
    //   441: getstatic 689	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   444: aload 48
    //   446: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   449: astore 52
    //   451: aload 52
    //   453: checkcast 591	gnu/mapping/Symbol
    //   456: astore 55
    //   458: aload_0
    //   459: aload 55
    //   461: invokevirtual 730	appinventor/ai_djxraizwellx/Implusx/Screen1:lookupInFormEnvironment	(Lgnu/mapping/Symbol;)Ljava/lang/Object;
    //   464: astore 56
    //   466: getstatic 735	gnu/kawa/reflect/Invoke:make	Lgnu/kawa/reflect/Invoke;
    //   469: aload 51
    //   471: aload 56
    //   473: invokevirtual 573	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: astore 57
    //   478: getstatic 741	gnu/kawa/reflect/SlotSet:set$Mnfield$Ex	Lgnu/kawa/reflect/SlotSet;
    //   481: aload_0
    //   482: aload 49
    //   484: aload 57
    //   486: invokevirtual 745	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   489: pop
    //   490: aload 49
    //   492: checkcast 591	gnu/mapping/Symbol
    //   495: astore 61
    //   497: aload_0
    //   498: aload 61
    //   500: aload 57
    //   502: invokevirtual 659	appinventor/ai_djxraizwellx/Implusx/Screen1:addToFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   505: aload 47
    //   507: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   510: astore 28
    //   512: goto -421 -> 91
    //   515: astore 45
    //   517: new 600	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 45
    //   523: ldc_w 602
    //   526: bipush 254
    //   528: aload 28
    //   530: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   533: astore 46
    //   535: aload 46
    //   537: athrow
    //   538: astore 53
    //   540: new 600	gnu/mapping/WrongType
    //   543: dup
    //   544: aload 53
    //   546: ldc 193
    //   548: iconst_0
    //   549: aload 52
    //   551: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   554: astore 54
    //   556: aload 54
    //   558: athrow
    //   559: astore 59
    //   561: new 600	gnu/mapping/WrongType
    //   564: dup
    //   565: aload 59
    //   567: ldc 197
    //   569: iconst_0
    //   570: aload 49
    //   572: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   575: astore 60
    //   577: aload 60
    //   579: athrow
    //   580: aload 29
    //   582: checkcast 583	gnu/lists/Pair
    //   585: astore 40
    //   587: aload 40
    //   589: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   592: astore 41
    //   594: getstatic 723	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
    //   597: aload 41
    //   599: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   602: pop
    //   603: getstatic 726	kawa/lib/lists:cadddr	Lgnu/expr/GenericProc;
    //   606: aload 41
    //   608: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   611: astore 43
    //   613: aload 43
    //   615: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   618: if_acmpeq +12 -> 630
    //   621: getstatic 714	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   624: aload 43
    //   626: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   629: pop
    //   630: aload 40
    //   632: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   635: astore 29
    //   637: goto -534 -> 103
    //   640: astore 38
    //   642: new 600	gnu/mapping/WrongType
    //   645: dup
    //   646: aload 38
    //   648: ldc_w 602
    //   651: bipush 254
    //   653: aload 29
    //   655: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   658: astore 39
    //   660: aload 39
    //   662: athrow
    //   663: aload 30
    //   665: checkcast 583	gnu/lists/Pair
    //   668: astore 34
    //   670: aload 34
    //   672: invokevirtual 589	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   675: astore 35
    //   677: getstatic 723	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
    //   680: aload 35
    //   682: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   685: astore 36
    //   687: getstatic 726	kawa/lib/lists:cadddr	Lgnu/expr/GenericProc;
    //   690: aload 35
    //   692: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   695: pop
    //   696: aload_0
    //   697: getstatic 754	gnu/kawa/reflect/SlotGet:field	Lgnu/kawa/reflect/SlotGet;
    //   700: aload_0
    //   701: aload 36
    //   703: invokevirtual 573	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   706: invokevirtual 757	appinventor/ai_djxraizwellx/Implusx/Screen1:callInitialize	(Ljava/lang/Object;)V
    //   709: aload 34
    //   711: invokevirtual 586	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   714: astore 30
    //   716: goto -601 -> 115
    //   719: astore 32
    //   721: new 600	gnu/mapping/WrongType
    //   724: dup
    //   725: aload 32
    //   727: ldc_w 602
    //   730: bipush 254
    //   732: aload 30
    //   734: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   737: astore 33
    //   739: aload 33
    //   741: athrow
    //   742: astore_3
    //   743: new 600	gnu/mapping/WrongType
    //   746: dup
    //   747: aload_3
    //   748: ldc_w 602
    //   751: bipush 254
    //   753: aload_2
    //   754: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   757: astore 4
    //   759: aload 4
    //   761: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	Screen1
    //   128	11	1	localException	java.lang.Exception
    //   26	728	2	localObject1	Object
    //   742	6	3	localClassCastException1	java.lang.ClassCastException
    //   757	3	4	localWrongType1	gnu.mapping.WrongType
    //   149	54	5	localPair1	gnu.lists.Pair
    //   156	24	6	localObject2	Object
    //   166	46	7	localObject3	Object
    //   174	43	8	str1	String
    //   184	38	9	localObject4	Object
    //   192	35	10	str2	String
    //   319	4	11	localYailRuntimeError	com.google.appinventor.components.runtime.errors.YailRuntimeError
    //   51	259	12	localObject5	Object
    //   296	7	13	localClassCastException2	java.lang.ClassCastException
    //   314	3	14	localWrongType2	gnu.mapping.WrongType
    //   236	51	15	localPair2	gnu.lists.Pair
    //   243	16	16	localObject6	Object
    //   253	87	17	localObject7	Object
    //   263	16	18	localObject8	Object
    //   328	7	19	localClassCastException3	java.lang.ClassCastException
    //   344	3	20	localWrongType3	gnu.mapping.WrongType
    //   270	4	21	localSymbol1	Symbol
    //   68	321	22	localObject9	Object
    //   375	7	23	localClassCastException4	java.lang.ClassCastException
    //   393	3	24	localWrongType4	gnu.mapping.WrongType
    //   354	12	25	localPair3	gnu.lists.Pair
    //   85	27	27	localLList1	LList
    //   89	440	28	localObject10	Object
    //   101	553	29	localObject11	Object
    //   113	620	30	localObject12	Object
    //   118	5	31	localLList2	LList
    //   719	7	32	localClassCastException5	java.lang.ClassCastException
    //   737	3	33	localWrongType5	gnu.mapping.WrongType
    //   668	42	34	localPair4	gnu.lists.Pair
    //   675	16	35	localObject13	Object
    //   685	17	36	localObject14	Object
    //   640	7	38	localClassCastException6	java.lang.ClassCastException
    //   658	3	39	localWrongType6	gnu.mapping.WrongType
    //   585	46	40	localPair5	gnu.lists.Pair
    //   592	15	41	localObject15	Object
    //   611	14	43	localObject16	Object
    //   515	7	45	localClassCastException7	java.lang.ClassCastException
    //   533	3	46	localWrongType7	gnu.mapping.WrongType
    //   403	103	47	localPair6	gnu.lists.Pair
    //   410	35	48	localObject17	Object
    //   420	151	49	localObject18	Object
    //   439	31	51	localObject19	Object
    //   449	101	52	localObject20	Object
    //   538	7	53	localClassCastException8	java.lang.ClassCastException
    //   554	3	54	localWrongType8	gnu.mapping.WrongType
    //   456	4	55	localSymbol2	Symbol
    //   464	8	56	localObject21	Object
    //   476	25	57	localObject22	Object
    //   559	7	59	localClassCastException9	java.lang.ClassCastException
    //   575	3	60	localWrongType9	gnu.mapping.WrongType
    //   495	4	61	localSymbol3	Symbol
    // Exception table:
    //   from	to	target	type
    //   6	10	128	java/lang/Exception
    //   231	238	296	java/lang/ClassCastException
    //   34	53	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   53	70	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   70	87	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   91	99	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   103	111	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   115	120	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   231	238	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   238	265	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   265	272	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   272	293	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   298	319	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   330	349	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   349	356	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   356	372	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   377	398	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   398	405	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   405	451	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   451	458	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   458	490	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   490	497	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   497	512	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   517	538	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   540	559	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   561	580	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   580	587	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   587	630	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   630	637	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   642	663	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   663	670	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   670	716	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   721	742	319	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   265	272	328	java/lang/ClassCastException
    //   349	356	375	java/lang/ClassCastException
    //   398	405	515	java/lang/ClassCastException
    //   451	458	538	java/lang/ClassCastException
    //   490	497	559	java/lang/ClassCastException
    //   580	587	640	java/lang/ClassCastException
    //   663	670	719	java/lang/ClassCastException
    //   145	151	742	java/lang/ClassCastException
  }
  
  public Object Button1$Click()
  {
    runtime.setThisForm();
    runtime.setAndCoerceProperty$Ex(Lit36, Lit50, "http://69.4.225.77:8000/;", Lit4);
    return runtime.callComponentMethod(Lit36, Lit51, LList.Empty, LList.Empty);
  }
  
  public Object Button2$Click()
  {
    runtime.setThisForm();
    return runtime.callComponentMethod(Lit36, Lit57, LList.Empty, LList.Empty);
  }
  
  public Object Slider1$PositionChanged(Object paramObject)
  {
    runtime.sanitizeComponentData(paramObject);
    runtime.setThisForm();
    return runtime.setAndCoerceProperty$Ex(Lit36, Lit37, runtime.getProperty$1(Lit26, Lit33), Lit7);
  }
  
  public void addToComponents(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    this.components$Mnto$Mncreate = lists.cons(LList.list4(paramObject1, paramObject2, paramObject3, paramObject4), this.components$Mnto$Mncreate);
  }
  
  public void addToEvents(Object paramObject1, Object paramObject2)
  {
    this.events$Mnto$Mnregister = lists.cons(lists.cons(paramObject1, paramObject2), this.events$Mnto$Mnregister);
  }
  
  public void addToFormDoAfterCreation(Object paramObject)
  {
    this.form$Mndo$Mnafter$Mncreation = lists.cons(paramObject, this.form$Mndo$Mnafter$Mncreation);
  }
  
  public void addToFormEnvironment(Symbol paramSymbol, Object paramObject)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "Adding ~A to env ~A with value ~A";
    arrayOfObject[1] = paramSymbol;
    arrayOfObject[2] = this.form$Mnenvironment;
    arrayOfObject[3] = paramObject;
    androidLogForm(Format.formatToString(0, arrayOfObject));
    this.form$Mnenvironment.put(paramSymbol, paramObject);
  }
  
  public void addToGlobalVarEnvironment(Symbol paramSymbol, Object paramObject)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "Adding ~A to env ~A with value ~A";
    arrayOfObject[1] = paramSymbol;
    arrayOfObject[2] = this.global$Mnvar$Mnenvironment;
    arrayOfObject[3] = paramObject;
    androidLogForm(Format.formatToString(0, arrayOfObject));
    this.global$Mnvar$Mnenvironment.put(paramSymbol, paramObject);
  }
  
  public void addToGlobalVars(Object paramObject1, Object paramObject2)
  {
    this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(paramObject1, paramObject2), this.global$Mnvars$Mnto$Mncreate);
  }
  
  public void androidLogForm(Object paramObject) {}
  
  public boolean dispatchEvent(Component paramComponent, String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    SimpleSymbol localSimpleSymbol = misc.string$To$Symbol(paramString1);
    if (isBoundInFormEnvironment(localSimpleSymbol))
    {
      Object localObject1 = lookupInFormEnvironment(localSimpleSymbol);
      boolean bool = false;
      Object localObject2;
      if (localObject1 == paramComponent) {
        localObject2 = lookupHandler(paramString1, paramString2);
      }
      try
      {
        Scheme.apply.apply2(localObject2, LList.makeList(paramArrayOfObject, 0));
        bool = true;
        return bool;
      }
      catch (Throwable localThrowable)
      {
        androidLogForm(localThrowable.getMessage());
        localThrowable.printStackTrace();
        processException(localThrowable);
        return false;
      }
    }
    EventDispatcher.unregisterEventForDelegation(this, paramString1, paramString2);
    return false;
  }
  
  public boolean isBoundInFormEnvironment(Symbol paramSymbol)
  {
    return this.form$Mnenvironment.isBound(paramSymbol);
  }
  
  public Object lookupHandler(Object paramObject1, Object paramObject2)
  {
    String str1;
    String str2;
    if (paramObject1 == null)
    {
      str1 = null;
      str2 = null;
      if (paramObject2 != null) {
        break label35;
      }
    }
    for (;;)
    {
      return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(str1, str2)));
      str1 = paramObject1.toString();
      break;
      label35:
      str2 = paramObject2.toString();
    }
  }
  
  public Object lookupInFormEnvironment(Symbol paramSymbol)
  {
    return lookupInFormEnvironment(paramSymbol, Boolean.FALSE);
  }
  
  public Object lookupInFormEnvironment(Symbol paramSymbol, Object paramObject)
  {
    int i;
    int j;
    if (this.form$Mnenvironment == null)
    {
      i = 1;
      j = 0x1 & i + 1;
      if (j == 0) {
        break label48;
      }
      if (!this.form$Mnenvironment.isBound(paramSymbol)) {}
    }
    for (;;)
    {
      paramObject = this.form$Mnenvironment.get(paramSymbol);
      label48:
      do
      {
        return paramObject;
        i = 0;
        break;
      } while (j == 0);
    }
  }
  
  /* Error */
  public void processException(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 805	java/lang/Throwable
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 838	com/google/appinventor/components/runtime/ReplApplication:reportError	(Ljava/lang/Throwable;)V
    //   9: getstatic 714	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   12: getstatic 844	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   15: aload_1
    //   16: getstatic 420	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit1	Lgnu/mapping/SimpleSymbol;
    //   19: invokevirtual 573	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   22: invokevirtual 693	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnonnull +34 -> 63
    //   32: aconst_null
    //   33: astore 5
    //   35: aload_1
    //   36: instanceof 640
    //   39: ifeq +34 -> 73
    //   42: aload_1
    //   43: checkcast 640	com/google/appinventor/components/runtime/errors/YailRuntimeError
    //   46: invokevirtual 847	com/google/appinventor/components/runtime/errors/YailRuntimeError:getErrorType	()Ljava/lang/String;
    //   49: astore 6
    //   51: aload_0
    //   52: aload 5
    //   54: aload 6
    //   56: ldc_w 849
    //   59: invokestatic 855	com/google/appinventor/components/runtime/util/RuntimeErrorAlert:alert	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   62: return
    //   63: aload 4
    //   65: invokevirtual 707	java/lang/Object:toString	()Ljava/lang/String;
    //   68: astore 5
    //   70: goto -35 -> 35
    //   73: ldc_w 857
    //   76: astore 6
    //   78: goto -27 -> 51
    //   81: astore_2
    //   82: new 600	gnu/mapping/WrongType
    //   85: dup
    //   86: aload_2
    //   87: ldc_w 859
    //   90: iconst_1
    //   91: aload_1
    //   92: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	Screen1
    //   0	96	1	paramObject	Object
    //   81	6	2	localClassCastException	java.lang.ClassCastException
    //   4	2	3	localThrowable	Throwable
    //   25	39	4	localObject	Object
    //   33	36	5	str1	String
    //   49	28	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	5	81	java/lang/ClassCastException
  }
  
  public void run()
  {
    CallContext localCallContext = CallContext.getInstance();
    Consumer localConsumer = localCallContext.consumer;
    localCallContext.consumer = VoidConsumer.instance;
    try
    {
      run(localCallContext);
      localThrowable1 = null;
    }
    catch (Throwable localThrowable2)
    {
      Throwable localThrowable1;
      label23:
      break label23;
    }
    ModuleBody.runCleanup(localCallContext, localThrowable1, localConsumer);
  }
  
  /* Error */
  public final void run(CallContext paramCallContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 868	gnu/mapping/CallContext:consumer	Lgnu/lists/Consumer;
    //   4: astore_2
    //   5: ldc_w 885
    //   8: invokestatic 891	kawa/standard/require:find	(Ljava/lang/String;)Ljava/lang/Object;
    //   11: astore_3
    //   12: aload_3
    //   13: checkcast 6	java/lang/Runnable
    //   16: astore 5
    //   18: aload 5
    //   20: invokeinterface 892 1 0
    //   25: aload_0
    //   26: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   29: putfield 894	appinventor/ai_djxraizwellx/Implusx/Screen1:$Stdebug$Mnform$St	Ljava/lang/Boolean;
    //   32: aload_0
    //   33: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   36: invokestatic 595	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   39: invokestatic 897	gnu/mapping/Environment:make	(Ljava/lang/String;)Lgnu/mapping/SimpleEnvironment;
    //   42: putfield 786	appinventor/ai_djxraizwellx/Implusx/Screen1:form$Mnenvironment	Lgnu/mapping/Environment;
    //   45: iconst_2
    //   46: anewarray 704	java/lang/Object
    //   49: astore 6
    //   51: aload 6
    //   53: iconst_0
    //   54: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   57: invokestatic 595	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   60: aastore
    //   61: aload 6
    //   63: iconst_1
    //   64: ldc_w 899
    //   67: aastore
    //   68: aload 6
    //   70: invokestatic 903	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   73: astore 7
    //   75: aload 7
    //   77: ifnonnull +596 -> 673
    //   80: aconst_null
    //   81: astore 8
    //   83: aload_0
    //   84: aload 8
    //   86: invokestatic 897	gnu/mapping/Environment:make	(Ljava/lang/String;)Lgnu/mapping/SimpleEnvironment;
    //   89: putfield 799	appinventor/ai_djxraizwellx/Implusx/Screen1:global$Mnvar$Mnenvironment	Lgnu/mapping/Environment;
    //   92: aconst_null
    //   93: putstatic 655	appinventor/ai_djxraizwellx/Implusx/Screen1:Screen1	Lappinventor/ai_djxraizwellx/Implusx/Screen1;
    //   96: aload_0
    //   97: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   100: putfield 905	appinventor/ai_djxraizwellx/Implusx/Screen1:form$Mnname$Mnsymbol	Lgnu/mapping/Symbol;
    //   103: aload_0
    //   104: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   107: putfield 661	appinventor/ai_djxraizwellx/Implusx/Screen1:events$Mnto$Mnregister	Lgnu/lists/LList;
    //   110: aload_0
    //   111: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   114: putfield 676	appinventor/ai_djxraizwellx/Implusx/Screen1:components$Mnto$Mncreate	Lgnu/lists/LList;
    //   117: aload_0
    //   118: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   121: putfield 666	appinventor/ai_djxraizwellx/Implusx/Screen1:global$Mnvars$Mnto$Mncreate	Lgnu/lists/LList;
    //   124: aload_0
    //   125: getstatic 563	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   128: putfield 674	appinventor/ai_djxraizwellx/Implusx/Screen1:form$Mndo$Mnafter$Mncreation	Lgnu/lists/LList;
    //   131: ldc_w 885
    //   134: invokestatic 891	kawa/standard/require:find	(Ljava/lang/String;)Ljava/lang/Object;
    //   137: astore 9
    //   139: aload 9
    //   141: checkcast 6	java/lang/Runnable
    //   144: astore 11
    //   146: aload 11
    //   148: invokeinterface 892 1 0
    //   153: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   156: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   159: if_acmpeq +524 -> 683
    //   162: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   165: getstatic 412	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit3	Lgnu/mapping/SimpleSymbol;
    //   168: ldc_w 613
    //   171: getstatic 408	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit4	Lgnu/mapping/SimpleSymbol;
    //   174: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   181: getstatic 404	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit5	Lgnu/mapping/SimpleSymbol;
    //   184: getstatic 400	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit6	Lgnu/math/IntNum;
    //   187: getstatic 398	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit7	Lgnu/mapping/SimpleSymbol;
    //   190: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   197: getstatic 394	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit8	Lgnu/mapping/SimpleSymbol;
    //   200: getstatic 400	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit6	Lgnu/math/IntNum;
    //   203: getstatic 398	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit7	Lgnu/mapping/SimpleSymbol;
    //   206: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   213: getstatic 390	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit9	Lgnu/mapping/SimpleSymbol;
    //   216: ldc_w 615
    //   219: getstatic 408	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit4	Lgnu/mapping/SimpleSymbol;
    //   222: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: pop
    //   226: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   229: getstatic 386	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit10	Lgnu/mapping/SimpleSymbol;
    //   232: getstatic 382	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit11	Lgnu/math/IntNum;
    //   235: getstatic 398	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit7	Lgnu/mapping/SimpleSymbol;
    //   238: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   245: getstatic 379	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit12	Lgnu/mapping/SimpleSymbol;
    //   248: ldc_w 617
    //   251: getstatic 408	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit4	Lgnu/mapping/SimpleSymbol;
    //   254: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   261: getstatic 375	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit13	Lgnu/mapping/SimpleSymbol;
    //   264: ldc_w 619
    //   267: getstatic 408	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit4	Lgnu/mapping/SimpleSymbol;
    //   270: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   277: getstatic 371	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit14	Lgnu/mapping/SimpleSymbol;
    //   280: getstatic 624	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   283: getstatic 367	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit15	Lgnu/mapping/SimpleSymbol;
    //   286: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   293: getstatic 363	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit16	Lgnu/mapping/SimpleSymbol;
    //   296: ldc_w 626
    //   299: getstatic 408	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit4	Lgnu/mapping/SimpleSymbol;
    //   302: invokestatic 528	com/google/youngandroid/runtime:setAndCoerceProperty$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: aload_2
    //   306: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   309: aload_0
    //   310: aconst_null
    //   311: putfield 917	appinventor/ai_djxraizwellx/Implusx/Screen1:Image1	Lcom/google/appinventor/components/runtime/Image;
    //   314: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   317: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   320: if_acmpeq +380 -> 700
    //   323: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   326: getstatic 359	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit17	Lgnu/lists/FString;
    //   329: getstatic 357	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit18	Lgnu/mapping/SimpleSymbol;
    //   332: getstatic 489	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn3	Lgnu/expr/ModuleMethod;
    //   335: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aload_2
    //   339: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   342: aload_0
    //   343: aconst_null
    //   344: putfield 922	appinventor/ai_djxraizwellx/Implusx/Screen1:Slider1	Lcom/google/appinventor/components/runtime/Slider;
    //   347: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   350: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   353: if_acmpeq +366 -> 719
    //   356: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   359: getstatic 336	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit25	Lgnu/lists/FString;
    //   362: getstatic 334	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit26	Lgnu/mapping/SimpleSymbol;
    //   365: getstatic 493	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn5	Lgnu/expr/ModuleMethod;
    //   368: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: aload_2
    //   372: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   375: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   378: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   381: if_acmpeq +357 -> 738
    //   384: getstatic 287	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit38	Lgnu/mapping/SimpleSymbol;
    //   387: aload_0
    //   388: getfield 497	appinventor/ai_djxraizwellx/Implusx/Screen1:Slider1$PositionChanged	Lgnu/expr/ModuleMethod;
    //   391: invokestatic 925	com/google/youngandroid/runtime:addToCurrentFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   398: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   401: if_acmpeq +351 -> 752
    //   404: getstatic 928	com/google/youngandroid/runtime:$Stthis$Mnform$St	Ljava/lang/Object;
    //   407: checkcast 930	com/google/appinventor/components/runtime/HandlesEventDispatching
    //   410: ldc_w 332
    //   413: ldc_w 282
    //   416: invokestatic 702	com/google/appinventor/components/runtime/EventDispatcher:registerEventForDelegation	(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload_0
    //   420: aconst_null
    //   421: putfield 932	appinventor/ai_djxraizwellx/Implusx/Screen1:Image2	Lcom/google/appinventor/components/runtime/Image;
    //   424: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   427: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   430: if_acmpeq +335 -> 765
    //   433: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   436: getstatic 280	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit40	Lgnu/lists/FString;
    //   439: getstatic 278	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit41	Lgnu/mapping/SimpleSymbol;
    //   442: getstatic 499	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn7	Lgnu/expr/ModuleMethod;
    //   445: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   448: aload_2
    //   449: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   452: aload_0
    //   453: aconst_null
    //   454: putfield 934	appinventor/ai_djxraizwellx/Implusx/Screen1:HorizontalArrangement1	Lcom/google/appinventor/components/runtime/HorizontalArrangement;
    //   457: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   460: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   463: if_acmpeq +321 -> 784
    //   466: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   469: getstatic 271	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit43	Lgnu/lists/FString;
    //   472: getstatic 269	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit44	Lgnu/mapping/SimpleSymbol;
    //   475: getstatic 503	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn9	Lgnu/expr/ModuleMethod;
    //   478: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   481: aload_2
    //   482: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   485: aload_0
    //   486: aconst_null
    //   487: putfield 936	appinventor/ai_djxraizwellx/Implusx/Screen1:Button1	Lcom/google/appinventor/components/runtime/Button;
    //   490: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   493: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   496: if_acmpeq +307 -> 803
    //   499: getstatic 269	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit44	Lgnu/mapping/SimpleSymbol;
    //   502: getstatic 262	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit46	Lgnu/lists/FString;
    //   505: getstatic 260	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit47	Lgnu/mapping/SimpleSymbol;
    //   508: getstatic 507	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn11	Lgnu/expr/ModuleMethod;
    //   511: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: aload_2
    //   515: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   518: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   521: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   524: if_acmpeq +298 -> 822
    //   527: getstatic 243	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit52	Lgnu/mapping/SimpleSymbol;
    //   530: aload_0
    //   531: getfield 511	appinventor/ai_djxraizwellx/Implusx/Screen1:Button1$Click	Lgnu/expr/ModuleMethod;
    //   534: invokestatic 925	com/google/youngandroid/runtime:addToCurrentFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   537: pop
    //   538: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   541: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   544: if_acmpeq +292 -> 836
    //   547: getstatic 928	com/google/youngandroid/runtime:$Stthis$Mnform$St	Ljava/lang/Object;
    //   550: checkcast 930	com/google/appinventor/components/runtime/HandlesEventDispatching
    //   553: ldc_w 258
    //   556: ldc 238
    //   558: invokestatic 702	com/google/appinventor/components/runtime/EventDispatcher:registerEventForDelegation	(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload_0
    //   562: aconst_null
    //   563: putfield 938	appinventor/ai_djxraizwellx/Implusx/Screen1:Button2	Lcom/google/appinventor/components/runtime/Button;
    //   566: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   569: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   572: if_acmpeq +277 -> 849
    //   575: getstatic 269	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit44	Lgnu/mapping/SimpleSymbol;
    //   578: getstatic 236	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit54	Lgnu/lists/FString;
    //   581: getstatic 234	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit55	Lgnu/mapping/SimpleSymbol;
    //   584: getstatic 513	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn13	Lgnu/expr/ModuleMethod;
    //   587: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   590: aload_2
    //   591: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   594: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   597: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   600: if_acmpeq +268 -> 868
    //   603: getstatic 223	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit58	Lgnu/mapping/SimpleSymbol;
    //   606: aload_0
    //   607: getfield 517	appinventor/ai_djxraizwellx/Implusx/Screen1:Button2$Click	Lgnu/expr/ModuleMethod;
    //   610: invokestatic 925	com/google/youngandroid/runtime:addToCurrentFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   613: pop
    //   614: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   617: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   620: if_acmpeq +262 -> 882
    //   623: getstatic 928	com/google/youngandroid/runtime:$Stthis$Mnform$St	Ljava/lang/Object;
    //   626: checkcast 930	com/google/appinventor/components/runtime/HandlesEventDispatching
    //   629: ldc 232
    //   631: ldc 238
    //   633: invokestatic 702	com/google/appinventor/components/runtime/EventDispatcher:registerEventForDelegation	(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload_0
    //   637: aconst_null
    //   638: putfield 940	appinventor/ai_djxraizwellx/Implusx/Screen1:Player1	Lcom/google/appinventor/components/runtime/Player;
    //   641: getstatic 909	com/google/youngandroid/runtime:$Stthis$Mnis$Mnthe$Mnrepl$St	Ljava/lang/Object;
    //   644: getstatic 748	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   647: if_acmpeq +248 -> 895
    //   650: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   653: getstatic 220	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit59	Lgnu/lists/FString;
    //   656: getstatic 294	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit36	Lgnu/mapping/SimpleSymbol;
    //   659: getstatic 519	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn15	Lgnu/expr/ModuleMethod;
    //   662: invokestatic 920	com/google/youngandroid/runtime:addComponentWithinRepl	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   665: aload_2
    //   666: invokestatic 915	gnu/mapping/Values:writeValues	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   669: invokestatic 943	com/google/youngandroid/runtime:initRuntime	()V
    //   672: return
    //   673: aload 7
    //   675: invokevirtual 707	java/lang/Object:toString	()Ljava/lang/String;
    //   678: astore 8
    //   680: goto -597 -> 83
    //   683: aload_0
    //   684: new 945	kawa/lang/Promise
    //   687: dup
    //   688: getstatic 487	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn2	Lgnu/expr/ModuleMethod;
    //   691: invokespecial 948	kawa/lang/Promise:<init>	(Lgnu/mapping/Procedure;)V
    //   694: invokevirtual 950	appinventor/ai_djxraizwellx/Implusx/Screen1:addToFormDoAfterCreation	(Ljava/lang/Object;)V
    //   697: goto -388 -> 309
    //   700: aload_0
    //   701: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   704: getstatic 338	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit24	Lgnu/lists/FString;
    //   707: getstatic 357	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit18	Lgnu/mapping/SimpleSymbol;
    //   710: getstatic 491	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn4	Lgnu/expr/ModuleMethod;
    //   713: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   716: goto -374 -> 342
    //   719: aload_0
    //   720: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   723: getstatic 298	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit35	Lgnu/lists/FString;
    //   726: getstatic 334	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit26	Lgnu/mapping/SimpleSymbol;
    //   729: getstatic 495	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn6	Lgnu/expr/ModuleMethod;
    //   732: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   735: goto -360 -> 375
    //   738: aload_0
    //   739: getstatic 287	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit38	Lgnu/mapping/SimpleSymbol;
    //   742: aload_0
    //   743: getfield 497	appinventor/ai_djxraizwellx/Implusx/Screen1:Slider1$PositionChanged	Lgnu/expr/ModuleMethod;
    //   746: invokevirtual 659	appinventor/ai_djxraizwellx/Implusx/Screen1:addToFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   749: goto -354 -> 395
    //   752: aload_0
    //   753: getstatic 334	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit26	Lgnu/mapping/SimpleSymbol;
    //   756: getstatic 284	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit39	Lgnu/mapping/SimpleSymbol;
    //   759: invokevirtual 954	appinventor/ai_djxraizwellx/Implusx/Screen1:addToEvents	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   762: goto -343 -> 419
    //   765: aload_0
    //   766: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   769: getstatic 275	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit42	Lgnu/lists/FString;
    //   772: getstatic 278	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit41	Lgnu/mapping/SimpleSymbol;
    //   775: getstatic 501	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn8	Lgnu/expr/ModuleMethod;
    //   778: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   781: goto -329 -> 452
    //   784: aload_0
    //   785: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   788: getstatic 266	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit45	Lgnu/lists/FString;
    //   791: getstatic 269	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit44	Lgnu/mapping/SimpleSymbol;
    //   794: getstatic 505	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn10	Lgnu/expr/ModuleMethod;
    //   797: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   800: goto -315 -> 485
    //   803: aload_0
    //   804: getstatic 269	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit44	Lgnu/mapping/SimpleSymbol;
    //   807: getstatic 253	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit49	Lgnu/lists/FString;
    //   810: getstatic 260	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit47	Lgnu/mapping/SimpleSymbol;
    //   813: getstatic 509	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn12	Lgnu/expr/ModuleMethod;
    //   816: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   819: goto -301 -> 518
    //   822: aload_0
    //   823: getstatic 243	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit52	Lgnu/mapping/SimpleSymbol;
    //   826: aload_0
    //   827: getfield 511	appinventor/ai_djxraizwellx/Implusx/Screen1:Button1$Click	Lgnu/expr/ModuleMethod;
    //   830: invokevirtual 659	appinventor/ai_djxraizwellx/Implusx/Screen1:addToFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   833: goto -295 -> 538
    //   836: aload_0
    //   837: getstatic 260	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit47	Lgnu/mapping/SimpleSymbol;
    //   840: getstatic 240	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit53	Lgnu/mapping/SimpleSymbol;
    //   843: invokevirtual 954	appinventor/ai_djxraizwellx/Implusx/Screen1:addToEvents	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   846: goto -285 -> 561
    //   849: aload_0
    //   850: getstatic 269	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit44	Lgnu/mapping/SimpleSymbol;
    //   853: getstatic 231	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit56	Lgnu/lists/FString;
    //   856: getstatic 234	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit55	Lgnu/mapping/SimpleSymbol;
    //   859: getstatic 515	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn14	Lgnu/expr/ModuleMethod;
    //   862: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   865: goto -271 -> 594
    //   868: aload_0
    //   869: getstatic 223	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit58	Lgnu/mapping/SimpleSymbol;
    //   872: aload_0
    //   873: getfield 517	appinventor/ai_djxraizwellx/Implusx/Screen1:Button2$Click	Lgnu/expr/ModuleMethod;
    //   876: invokevirtual 659	appinventor/ai_djxraizwellx/Implusx/Screen1:addToFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   879: goto -265 -> 614
    //   882: aload_0
    //   883: getstatic 234	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit55	Lgnu/mapping/SimpleSymbol;
    //   886: getstatic 240	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit53	Lgnu/mapping/SimpleSymbol;
    //   889: invokevirtual 954	appinventor/ai_djxraizwellx/Implusx/Screen1:addToEvents	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   892: goto -256 -> 636
    //   895: aload_0
    //   896: getstatic 423	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit0	Lgnu/mapping/SimpleSymbol;
    //   899: getstatic 210	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit61	Lgnu/lists/FString;
    //   902: getstatic 294	appinventor/ai_djxraizwellx/Implusx/Screen1:Lit36	Lgnu/mapping/SimpleSymbol;
    //   905: getstatic 521	appinventor/ai_djxraizwellx/Implusx/Screen1:lambda$Fn16	Lgnu/expr/ModuleMethod;
    //   908: invokevirtual 952	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   911: goto -242 -> 669
    //   914: astore 4
    //   916: new 600	gnu/mapping/WrongType
    //   919: dup
    //   920: aload 4
    //   922: ldc_w 956
    //   925: iconst_1
    //   926: aload_3
    //   927: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   930: athrow
    //   931: astore 10
    //   933: new 600	gnu/mapping/WrongType
    //   936: dup
    //   937: aload 10
    //   939: ldc_w 956
    //   942: iconst_1
    //   943: aload 9
    //   945: invokespecial 605	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   948: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	Screen1
    //   0	949	1	paramCallContext	CallContext
    //   4	662	2	localConsumer	Consumer
    //   11	916	3	localObject1	Object
    //   914	7	4	localClassCastException1	java.lang.ClassCastException
    //   16	3	5	localRunnable1	Runnable
    //   49	20	6	arrayOfObject	Object[]
    //   73	601	7	localFString	FString
    //   81	598	8	str	String
    //   137	807	9	localObject2	Object
    //   931	7	10	localClassCastException2	java.lang.ClassCastException
    //   144	3	11	localRunnable2	Runnable
    // Exception table:
    //   from	to	target	type
    //   12	18	914	java/lang/ClassCastException
    //   139	146	931	java/lang/ClassCastException
  }
  
  public void sendError(Object paramObject)
  {
    if (paramObject == null) {}
    for (String str = null;; str = paramObject.toString())
    {
      RetValManager.sendError(str);
      return;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     appinventor.ai_djxraizwellx.Implusx.Screen1
 * JD-Core Version:    0.7.0.1
 */