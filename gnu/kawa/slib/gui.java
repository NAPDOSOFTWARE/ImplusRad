package gnu.kawa.slib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.Format;
import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Column;
import gnu.kawa.models.Display;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Row;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.xml.KAttr;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class gui
  extends ModuleBody
{
  public static final gui $instance;
  public static final ModuleMethod Button;
  public static final ModuleMethod Column;
  public static final Macro Image;
  public static final ModuleMethod Label;
  static final Class Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SyntaxRules Lit11;
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
  static final SyntaxRules Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final IntNum Lit42 = IntNum.make(1);
  static final SimpleSymbol Lit5;
  static final SyntaxRules Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod Row;
  public static final ModuleMethod Text;
  public static final ModuleMethod Window;
  public static final ModuleMethod as$Mncolor;
  public static final ModuleMethod button;
  public static final ModuleMethod image$Mnheight;
  public static final ModuleMethod image$Mnread;
  public static final ModuleMethod image$Mnwidth;
  static final Location loc$$St$DtgetHeight;
  static final Location loc$$St$DtgetWidth;
  public static final Macro process$Mnkeywords;
  public static final Macro run$Mnapplication;
  public static final ModuleMethod set$Mncontent;
  
  static
  {
    Lit41 = (SimpleSymbol)new SimpleSymbol("value").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("name").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("invoke").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("getName").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("attr").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.xml.KAttr>").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("instance?").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("+").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("loop").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("<object>").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("primitive-array-get").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("arg").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("num-args").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("i").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("<int>").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("run-application").readResolve();
    Lit21 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = PairWithPosition.make(Lit28, Pair.make((SimpleSymbol)new SimpleSymbol("gnu.kawa.models.Window").readResolve(), Pair.make(Pair.make(Lit29, Pair.make((SimpleSymbol)new SimpleSymbol("open").readResolve(), LList.Empty)), LList.Empty)), "gui.scm", 749575);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001", "\021\030\004\b\003", arrayOfObject2, 0);
    Lit22 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 1);
    Lit20 = (SimpleSymbol)new SimpleSymbol("Window").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("set-content").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("Column").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("Row").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("Text").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("Label").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("image-height").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("image-width").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("image-read").readResolve();
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = ((SimpleSymbol)new SimpleSymbol("text-field").readResolve());
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\003", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = ((SimpleSymbol)new SimpleSymbol("make").readResolve());
    arrayOfObject4[1] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.DrawImage>").readResolve());
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "", "\021\030\004\021\030\f\002", arrayOfObject4, 0);
    Lit11 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Lit10 = (SimpleSymbol)new SimpleSymbol("Image").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("Button").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("button").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("as-color").readResolve();
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("process-keywords").readResolve();
    Lit5 = localSimpleSymbol2;
    arrayOfObject5[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject6 = new Object[27];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("let").readResolve());
    arrayOfObject6[1] = Lit26;
    arrayOfObject6[2] = Lit23;
    arrayOfObject6[3] = Lit24;
    arrayOfObject6[4] = ((SimpleSymbol)new SimpleSymbol("field").readResolve());
    arrayOfObject6[5] = PairWithPosition.make(PairWithPosition.make(Lit37, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("length").readResolve(), LList.Empty, "gui.scm", 16426), "gui.scm", 16426), LList.Empty, "gui.scm", 16425);
    arrayOfObject6[6] = Lit32;
    arrayOfObject6[7] = PairWithPosition.make(PairWithPosition.make(Lit25, PairWithPosition.make(Lit23, PairWithPosition.make(Lit24, PairWithPosition.make(IntNum.make(0), LList.Empty, "gui.scm", 20509), "gui.scm", 20503), "gui.scm", 20500), "gui.scm", 20497), LList.Empty, "gui.scm", 20496);
    arrayOfObject6[8] = ((SimpleSymbol)new SimpleSymbol("if").readResolve());
    arrayOfObject6[9] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<").readResolve(), PairWithPosition.make(Lit25, PairWithPosition.make(Lit26, LList.Empty, "gui.scm", 24593), "gui.scm", 24591), "gui.scm", 24588);
    arrayOfObject6[10] = Lit27;
    arrayOfObject6[11] = PairWithPosition.make(Lit30, PairWithPosition.make(Lit31, LList.Empty, "gui.scm", 28710), "gui.scm", 28689);
    arrayOfObject6[12] = PairWithPosition.make(Lit25, LList.Empty, "gui.scm", 28725);
    arrayOfObject6[13] = ((SimpleSymbol)new SimpleSymbol("cond").readResolve());
    arrayOfObject6[14] = PairWithPosition.make(Lit34, PairWithPosition.make(Lit27, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<gnu.expr.Keyword>").readResolve(), LList.Empty, "gui.scm", 32797), "gui.scm", 32793), "gui.scm", 32782);
    arrayOfObject6[15] = PairWithPosition.make(PairWithPosition.make(Lit28, Pair.make((SimpleSymbol)new SimpleSymbol("gnu.expr.Keyword").readResolve(), Pair.make(Pair.make(Lit29, Pair.make(Lit38, LList.Empty)), LList.Empty)), "gui.scm", 40970), PairWithPosition.make(Lit27, LList.Empty, "gui.scm", 40995), "gui.scm", 40969);
    arrayOfObject6[16] = PairWithPosition.make(Lit30, PairWithPosition.make(Lit31, LList.Empty, "gui.scm", 45087), "gui.scm", 45066);
    arrayOfObject6[17] = PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(Lit42, LList.Empty, "gui.scm", 45107), "gui.scm", 45105), "gui.scm", 45102), LList.Empty, "gui.scm", 45102);
    arrayOfObject6[18] = PairWithPosition.make(PairWithPosition.make(Lit32, PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(IntNum.make(2), LList.Empty, "gui.scm", 49170), "gui.scm", 49168), "gui.scm", 49165), LList.Empty, "gui.scm", 49165), "gui.scm", 49159), LList.Empty, "gui.scm", 49159);
    arrayOfObject6[19] = PairWithPosition.make(Lit34, PairWithPosition.make(Lit27, PairWithPosition.make(Lit35, LList.Empty, "gui.scm", 53270), "gui.scm", 53266), "gui.scm", 53255);
    arrayOfObject6[20] = ((SimpleSymbol)new SimpleSymbol("let*").readResolve());
    arrayOfObject6[21] = PairWithPosition.make(PairWithPosition.make(Lit36, PairWithPosition.make(Lit23, PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, LList.Empty, "gui.scm", 57388), "gui.scm", 57367), "gui.scm", 57364), "gui.scm", 57358), PairWithPosition.make(PairWithPosition.make(Lit40, PairWithPosition.make(Lit23, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<java.lang.String>").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make(Lit36, PairWithPosition.make(PairWithPosition.make(Lit37, PairWithPosition.make(Lit38, LList.Empty, "gui.scm", 61489), "gui.scm", 61489), LList.Empty, "gui.scm", 61488), "gui.scm", 61483), "gui.scm", 61475), LList.Empty, "gui.scm", 61475), "gui.scm", 61456), "gui.scm", 61453), "gui.scm", 61447), PairWithPosition.make(PairWithPosition.make(Lit41, PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make(Lit36, PairWithPosition.make(PairWithPosition.make(Lit37, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("getObjectValue").readResolve(), LList.Empty, "gui.scm", 65564), "gui.scm", 65564), LList.Empty, "gui.scm", 65563), "gui.scm", 65558), "gui.scm", 65550), LList.Empty, "gui.scm", 65550), "gui.scm", 65543), LList.Empty, "gui.scm", 65543), "gui.scm", 61447), "gui.scm", 57357);
    arrayOfObject6[22] = PairWithPosition.make(Lit40, PairWithPosition.make(Lit41, LList.Empty, "gui.scm", 69666), "gui.scm", 69661);
    arrayOfObject6[23] = PairWithPosition.make(PairWithPosition.make(Lit32, PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(Lit42, LList.Empty, "gui.scm", 73746), "gui.scm", 73744), "gui.scm", 73741), LList.Empty, "gui.scm", 73741), "gui.scm", 73735), LList.Empty, "gui.scm", 73735);
    arrayOfObject6[24] = ((SimpleSymbol)new SimpleSymbol("else").readResolve());
    arrayOfObject6[25] = PairWithPosition.make(Lit27, LList.Empty, "gui.scm", 81951);
    arrayOfObject6[26] = PairWithPosition.make(PairWithPosition.make(Lit32, PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(Lit42, LList.Empty, "gui.scm", 86034), "gui.scm", 86032), "gui.scm", 86029), LList.Empty, "gui.scm", 86029), "gui.scm", 86023), LList.Empty, "gui.scm", 86023);
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\001", "\021\030\004\b\021\030\f\021\030\024\021\030\034\b\021\030$\t\013\030,\b\021\030\004\021\0304\021\030<\b\021\030D\021\030L\b\021\030\004a\b\021\030T\b\021\030\\\t\013\030d\b\021\030l©\021\030ty\t\023\t\003\021\030|\b\021\030\t\013\030\030\021\030i\021\030¤\021\030¬\b\t\023\t\003\030´\030¼\b\021\030Ä1\t\033\t\003\030Ì\030Ô", arrayOfObject6, 0);
    Lit6 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 4);
    Lit4 = (SimpleSymbol)new SimpleSymbol("*.getHeight").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("*.getWidth").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("cell-spacing").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("text").readResolve();
    Lit0 = Color.class;
    $instance = new gui();
    loc$$St$DtgetWidth = ThreadLocation.getInstance(Lit3, null);
    loc$$St$DtgetHeight = ThreadLocation.getInstance(Lit4, null);
    process$Mnkeywords = Macro.make(Lit5, Lit6, $instance);
    gui localgui = $instance;
    as$Mncolor = new ModuleMethod(localgui, 1, Lit7, 4097);
    button = new ModuleMethod(localgui, 2, Lit8, -4096);
    Button = new ModuleMethod(localgui, 3, Lit9, -4096);
    Image = Macro.make(Lit10, Lit11, $instance);
    image$Mnread = new ModuleMethod(localgui, 4, Lit12, 4097);
    image$Mnwidth = new ModuleMethod(localgui, 5, Lit13, 4097);
    image$Mnheight = new ModuleMethod(localgui, 6, Lit14, 4097);
    Label = new ModuleMethod(localgui, 7, Lit15, -4096);
    Text = new ModuleMethod(localgui, 8, Lit16, -4096);
    Row = new ModuleMethod(localgui, 9, Lit17, -4096);
    Column = new ModuleMethod(localgui, 10, Lit18, -4096);
    set$Mncontent = new ModuleMethod(localgui, 11, Lit19, 8194);
    Window = new ModuleMethod(localgui, 12, Lit20, -4096);
    run$Mnapplication = Macro.make(Lit21, Lit22, $instance);
    $instance.run();
  }
  
  public gui()
  {
    ModuleInfo.register(this);
  }
  
  public static Button Button(Object... paramVarArgs)
  {
    Button localButton = new Button();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            buttonKeyword(localButton, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          buttonKeyword(localButton, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      buttonNonKeyword(localButton, localObject);
    }
    return localButton;
  }
  
  public static Column Column(Object... paramVarArgs)
  {
    Column localColumn = new Column();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            boxKeyword(localColumn, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          boxKeyword(localColumn, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      boxNonKeyword(localColumn, localObject);
    }
    return localColumn;
  }
  
  public static Label Label(Object... paramVarArgs)
  {
    Label localLabel = new Label();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            labelKeyword(localLabel, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          labelKeyword(localLabel, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      labelNonKeyword(localLabel, localObject);
    }
    return localLabel;
  }
  
  public static Row Row(Object... paramVarArgs)
  {
    Row localRow = new Row();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            boxKeyword(localRow, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          boxKeyword(localRow, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      boxNonKeyword(localRow, localObject);
    }
    return localRow;
  }
  
  public static Text Text(Object... paramVarArgs)
  {
    Text localText = new Text();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            textKeyword(localText, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          textKeyword(localText, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      textNonKeyword(localText, localObject);
    }
    return localText;
  }
  
  public static Window Window(Object... paramVarArgs)
  {
    Window localWindow = Display.getInstance().makeWindow();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            windowKeyword(localWindow, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          windowKeyword(localWindow, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      windowNonKeyword(localWindow, localObject);
    }
    return localWindow;
  }
  
  public static Color asColor(Object paramObject)
  {
    if ((paramObject instanceof Color)) {
      return (Color)paramObject;
    }
    if ((paramObject instanceof Integer)) {}
    try
    {
      Integer localInteger = (Integer)paramObject;
      return new Color(localInteger.intValue());
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "java.lang.Integer.intValue()", 1, paramObject);
    }
    if ((paramObject instanceof IntNum)) {
      return new Color(IntNum.intValue(paramObject));
    }
    return (Color)SlotGet.staticField.apply2(Lit0, paramObject.toString());
  }
  
  static Model asModel(Object paramObject)
  {
    return Display.getInstance().coerceToModel(paramObject);
  }
  
  static Object boxKeyword(Box paramBox, String paramString, Object paramObject)
  {
    if (paramString == Lit2)
    {
      paramBox.setCellSpacing(paramObject);
      return Values.empty;
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown box attribute ~s", paramString }), new Object[0]);
  }
  
  static void boxNonKeyword(Box paramBox, Object paramObject)
  {
    paramBox.add(asModel(paramObject));
  }
  
  public static Button button(Object... paramVarArgs)
  {
    Button localButton = new Button();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          localObject = paramVarArgs[j];
          if ((localObject instanceof Keyword)) {}
          try
          {
            Keyword localKeyword = (Keyword)localObject;
            buttonKeyword(localButton, localKeyword.getName(), paramVarArgs[(j + 1)]);
            j += 2;
          }
          catch (ClassCastException localClassCastException2)
          {
            KAttr localKAttr;
            throw new WrongType(localClassCastException2, "gnu.expr.Keyword.getName()", 1, localObject);
          }
        }
        if ((localObject instanceof KAttr)) {}
        try
        {
          localKAttr = (KAttr)localObject;
          buttonKeyword(localButton, localKAttr.getName(), localKAttr.getObjectValue());
          j++;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "attr", -2, localObject);
        }
      }
      buttonNonKeyword(localButton, localObject);
    }
    return localButton;
  }
  
  static Object buttonKeyword(Button paramButton, String paramString, Object paramObject)
  {
    boolean bool = true;
    if (paramString == "foreground")
    {
      paramButton.setForeground(asColor(paramObject));
      return Values.empty;
    }
    if (paramString == "background")
    {
      paramButton.setBackground(asColor(paramObject));
      return Values.empty;
    }
    if (paramString == "action")
    {
      paramButton.setAction(paramObject);
      return Values.empty;
    }
    if (paramString == "text")
    {
      if (paramObject == null) {}
      for (String str = null;; str = paramObject.toString())
      {
        paramButton.setText(str);
        return Values.empty;
      }
    }
    if (paramString == "disabled") {}
    try
    {
      Boolean localBoolean = Boolean.FALSE;
      if (paramObject != localBoolean) {}
      for (;;)
      {
        paramButton.setDisabled(bool);
        return Values.empty;
        bool = false;
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "unknown button attribute ~s";
      arrayOfObject[bool] = paramString;
      return misc.error$V(Format.formatToString(0, arrayOfObject), new Object[0]);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.kawa.models.Button.setDisabled(boolean)", 2, paramObject);
    }
  }
  
  static Boolean buttonNonKeyword(Button paramButton, Object paramObject)
  {
    return Boolean.TRUE;
  }
  
  public static int imageHeight(BufferedImage paramBufferedImage)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$$St$DtgetHeight;
    try
    {
      Object localObject = localLocation.get();
      return ((Number)localApplyToArgs.apply2(localObject, paramBufferedImage)).intValue();
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("gui.scm", 77, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static BufferedImage imageRead(Path paramPath)
  {
    return ImageIO.read(paramPath.openInputStream());
  }
  
  public static int imageWidth(BufferedImage paramBufferedImage)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$$St$DtgetWidth;
    try
    {
      Object localObject = localLocation.get();
      return ((Number)localApplyToArgs.apply2(localObject, paramBufferedImage)).intValue();
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("gui.scm", 74, 3);
      throw localUnboundLocationException;
    }
  }
  
  static Object labelKeyword(Label paramLabel, String paramString, Object paramObject)
  {
    if (paramString == Lit1)
    {
      if (paramObject == null) {}
      for (String str = null;; str = paramObject.toString())
      {
        paramLabel.setText(str);
        return Values.empty;
      }
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown label attribute ~s", paramString }), new Object[0]);
  }
  
  static void labelNonKeyword(Label paramLabel, Object paramObject)
  {
    if (paramObject == null) {}
    for (String str = null;; str = paramObject.toString())
    {
      paramLabel.setText(str);
      return;
    }
  }
  
  public static void setContent(Window paramWindow, Object paramObject)
  {
    paramWindow.setContent(paramObject);
  }
  
  static Object textKeyword(Text paramText, String paramString, Object paramObject)
  {
    if (paramString == Lit1)
    {
      if (paramObject == null) {}
      for (String str = null;; str = paramObject.toString())
      {
        paramText.setText(str);
        return Values.empty;
      }
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown text attribute ~s", paramString }), new Object[0]);
  }
  
  static void textNonKeyword(Text paramText, Object paramObject)
  {
    if (paramObject == null) {}
    for (String str = null;; str = paramObject.toString())
    {
      paramText.setText(str);
      return;
    }
  }
  
  static Object windowKeyword(Window paramWindow, String paramString, Object paramObject)
  {
    if (paramString == "title")
    {
      if (paramObject == null) {}
      for (String str = null;; str = paramObject.toString())
      {
        paramWindow.setTitle(str);
        return Values.empty;
      }
    }
    if (paramString == "content")
    {
      paramWindow.setContent(paramObject);
      return Values.empty;
    }
    if (paramString == "menubar")
    {
      paramWindow.setMenuBar(paramObject);
      return Values.empty;
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown window attribute ~s", paramString }), new Object[0]);
  }
  
  static void windowNonKeyword(Window paramWindow, Object paramObject)
  {
    paramWindow.setContent(paramObject);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 3: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      return asColor(paramObject);
    }
    try
    {
      Path localPath = Path.valueOf(paramObject);
      return imageRead(localPath);
    }
    catch (ClassCastException localClassCastException3)
    {
      try
      {
        BufferedImage localBufferedImage2 = (BufferedImage)paramObject;
        return Integer.valueOf(imageWidth(localBufferedImage2));
      }
      catch (ClassCastException localClassCastException2)
      {
        BufferedImage localBufferedImage1;
        throw new WrongType(localClassCastException2, "image-width", 1, paramObject);
      }
      try
      {
        localBufferedImage1 = (BufferedImage)paramObject;
        return Integer.valueOf(imageHeight(localBufferedImage1));
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "image-height", 1, paramObject);
      }
      localClassCastException3 = localClassCastException3;
      throw new WrongType(localClassCastException3, "image-read", 1, paramObject);
    }
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 11) {}
    try
    {
      Window localWindow = (Window)paramObject1;
      setContent(localWindow, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-content", 1, paramObject1);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 2: 
      return button(paramArrayOfObject);
    case 3: 
      return Button(paramArrayOfObject);
    case 7: 
      return Label(paramArrayOfObject);
    case 8: 
      return Text(paramArrayOfObject);
    case 9: 
      return Row(paramArrayOfObject);
    case 10: 
      return Column(paramArrayOfObject);
    }
    return Window(paramArrayOfObject);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 3: 
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6: 
    case 5: 
    case 4: 
      do
      {
        do
        {
          do
          {
            return i;
          } while (!(paramObject instanceof BufferedImage));
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
        } while (!(paramObject instanceof BufferedImage));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (Path.coerceToPathOrNull(paramObject) == null);
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
    if (paramModuleMethod.selector == 11)
    {
      if (!(paramObject1 instanceof Window)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 12: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 10: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 9: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 8: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 7: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 3: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.gui
 * JD-Core Version:    0.7.0.1
 */