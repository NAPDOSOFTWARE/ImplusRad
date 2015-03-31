package gnu.kawa.xml;

import gnu.mapping.MethodProc;

public class MakeCDATA
  extends MethodProc
{
  public static final MakeCDATA makeCDATA = new MakeCDATA();
  
  /* Error */
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 22	gnu/mapping/CallContext:consumer	Lgnu/lists/Consumer;
    //   4: astore_2
    //   5: aload_1
    //   6: invokestatic 28	gnu/kawa/xml/NodeConstructor:pushNodeContext	(Lgnu/mapping/CallContext;)Lgnu/xml/XMLFilter;
    //   9: astore_3
    //   10: new 30	java/lang/StringBuffer
    //   13: dup
    //   14: invokespecial 31	java/lang/StringBuffer:<init>	()V
    //   17: astore 4
    //   19: getstatic 37	gnu/mapping/Location:UNBOUND	Ljava/lang/String;
    //   22: astore 6
    //   24: aload_1
    //   25: aload 6
    //   27: invokevirtual 41	gnu/mapping/CallContext:getNextArg	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: astore 7
    //   32: aload 7
    //   34: aload 6
    //   36: if_acmpne +44 -> 80
    //   39: aload 4
    //   41: invokevirtual 45	java/lang/StringBuffer:length	()I
    //   44: istore 8
    //   46: iload 8
    //   48: newarray char
    //   50: astore 9
    //   52: aload 4
    //   54: iconst_0
    //   55: iload 8
    //   57: aload 9
    //   59: iconst_0
    //   60: invokevirtual 49	java/lang/StringBuffer:getChars	(II[CI)V
    //   63: aload_3
    //   64: aload 9
    //   66: iconst_0
    //   67: iload 8
    //   69: invokeinterface 55 4 0
    //   74: aload_2
    //   75: aload_1
    //   76: invokestatic 59	gnu/kawa/xml/NodeConstructor:popNodeContext	(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V
    //   79: return
    //   80: aload 7
    //   82: aload 4
    //   84: invokestatic 65	gnu/xml/TextUtils:stringValue	(Ljava/lang/Object;Ljava/lang/StringBuffer;)V
    //   87: goto -63 -> 24
    //   90: astore 5
    //   92: aload_2
    //   93: aload_1
    //   94: invokestatic 59	gnu/kawa/xml/NodeConstructor:popNodeContext	(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V
    //   97: aload 5
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	MakeCDATA
    //   0	100	1	paramCallContext	gnu.mapping.CallContext
    //   4	89	2	localConsumer	gnu.lists.Consumer
    //   9	55	3	localXMLFilter	gnu.xml.XMLFilter
    //   17	66	4	localStringBuffer	java.lang.StringBuffer
    //   90	8	5	localObject1	java.lang.Object
    //   22	13	6	str	java.lang.String
    //   30	51	7	localObject2	java.lang.Object
    //   44	24	8	i	int
    //   50	15	9	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   10	24	90	finally
    //   24	32	90	finally
    //   39	74	90	finally
    //   80	87	90	finally
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeCDATA
 * JD-Core Version:    0.7.0.1
 */