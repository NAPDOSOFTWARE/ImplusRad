package gnu.kawa.lispexpr;

import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderVector
  extends ReadTableEntry
{
  char close;
  
  public ReaderVector(char paramChar)
  {
    this.close = paramChar;
  }
  
  /* Error */
  public static gnu.lists.FVector readVector(LispReader paramLispReader, gnu.text.LineBufferedReader paramLineBufferedReader, int paramInt, char paramChar)
    throws IOException, SyntaxException
  {
    // Byte code:
    //   0: bipush 32
    //   2: istore 4
    //   4: aload_1
    //   5: instanceof 21
    //   8: ifeq +35 -> 43
    //   11: aload_1
    //   12: checkcast 21	gnu/mapping/InPort
    //   15: getfield 24	gnu/mapping/InPort:readState	C
    //   18: istore 4
    //   20: aload_1
    //   21: checkcast 21	gnu/mapping/InPort
    //   24: astore 15
    //   26: iload_3
    //   27: bipush 93
    //   29: if_icmpne +98 -> 127
    //   32: bipush 91
    //   34: istore 16
    //   36: aload 15
    //   38: iload 16
    //   40: putfield 24	gnu/mapping/InPort:readState	C
    //   43: new 26	java/util/Vector
    //   46: dup
    //   47: invokespecial 27	java/util/Vector:<init>	()V
    //   50: astore 5
    //   52: invokestatic 33	gnu/kawa/lispexpr/ReadTable:getCurrent	()Lgnu/kawa/lispexpr/ReadTable;
    //   55: astore 7
    //   57: aload_0
    //   58: invokevirtual 39	gnu/kawa/lispexpr/LispReader:read	()I
    //   61: istore 8
    //   63: iload 8
    //   65: ifge +9 -> 74
    //   68: aload_0
    //   69: ldc 41
    //   71: invokevirtual 45	gnu/kawa/lispexpr/LispReader:eofError	(Ljava/lang/String;)V
    //   74: iload 8
    //   76: iload_3
    //   77: if_icmpne +57 -> 134
    //   80: aload 5
    //   82: invokevirtual 48	java/util/Vector:size	()I
    //   85: anewarray 50	java/lang/Object
    //   88: astore 9
    //   90: aload 5
    //   92: aload 9
    //   94: invokevirtual 54	java/util/Vector:copyInto	([Ljava/lang/Object;)V
    //   97: new 56	gnu/lists/FVector
    //   100: dup
    //   101: aload 9
    //   103: invokespecial 58	gnu/lists/FVector:<init>	([Ljava/lang/Object;)V
    //   106: astore 10
    //   108: aload_1
    //   109: instanceof 21
    //   112: ifeq +12 -> 124
    //   115: aload_1
    //   116: checkcast 21	gnu/mapping/InPort
    //   119: iload 4
    //   121: putfield 24	gnu/mapping/InPort:readState	C
    //   124: aload 10
    //   126: areturn
    //   127: bipush 40
    //   129: istore 16
    //   131: goto -95 -> 36
    //   134: aload_0
    //   135: iload 8
    //   137: aload 7
    //   139: invokevirtual 62	gnu/kawa/lispexpr/LispReader:readValues	(ILgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
    //   142: astore 11
    //   144: aload 11
    //   146: instanceof 64
    //   149: ifeq +44 -> 193
    //   152: aload 11
    //   154: checkcast 64	gnu/mapping/Values
    //   157: invokevirtual 68	gnu/mapping/Values:getValues	()[Ljava/lang/Object;
    //   160: astore 12
    //   162: aload 12
    //   164: arraylength
    //   165: istore 13
    //   167: iconst_0
    //   168: istore 14
    //   170: iload 14
    //   172: iload 13
    //   174: if_icmpge -117 -> 57
    //   177: aload 5
    //   179: aload 12
    //   181: iload 14
    //   183: aaload
    //   184: invokevirtual 72	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   187: iinc 14 1
    //   190: goto -20 -> 170
    //   193: aload 11
    //   195: getstatic 78	gnu/expr/QuoteExp:voidExp	Lgnu/expr/QuoteExp;
    //   198: if_acmpne +8 -> 206
    //   201: getstatic 82	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   204: astore 11
    //   206: aload 5
    //   208: aload 11
    //   210: invokevirtual 72	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   213: goto -156 -> 57
    //   216: astore 6
    //   218: aload_1
    //   219: instanceof 21
    //   222: ifeq +12 -> 234
    //   225: aload_1
    //   226: checkcast 21	gnu/mapping/InPort
    //   229: iload 4
    //   231: putfield 24	gnu/mapping/InPort:readState	C
    //   234: aload 6
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramLispReader	LispReader
    //   0	237	1	paramLineBufferedReader	gnu.text.LineBufferedReader
    //   0	237	2	paramInt	int
    //   0	237	3	paramChar	char
    //   2	228	4	c1	char
    //   50	157	5	localVector	java.util.Vector
    //   216	19	6	localObject1	Object
    //   55	83	7	localReadTable	ReadTable
    //   61	75	8	c2	char
    //   88	14	9	arrayOfObject1	Object[]
    //   106	19	10	localFVector	gnu.lists.FVector
    //   142	67	11	localObject2	Object
    //   160	20	12	arrayOfObject2	Object[]
    //   165	10	13	i	int
    //   168	20	14	j	int
    //   24	13	15	localInPort	gnu.mapping.InPort
    //   34	96	16	c3	char
    // Exception table:
    //   from	to	target	type
    //   43	57	216	finally
    //   57	63	216	finally
    //   68	74	216	finally
    //   80	108	216	finally
    //   134	167	216	finally
    //   177	187	216	finally
    //   193	206	216	finally
    //   206	213	216	finally
  }
  
  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    return readVector((LispReader)paramLexer, paramLexer.getPort(), paramInt2, this.close);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderVector
 * JD-Core Version:    0.7.0.1
 */