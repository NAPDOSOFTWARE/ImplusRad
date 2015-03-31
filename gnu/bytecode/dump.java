package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class dump
  extends ClassFileInput
{
  ClassTypeWriter writer;
  
  dump(InputStream paramInputStream, ClassTypeWriter paramClassTypeWriter)
    throws IOException, ClassFormatError
  {
    super(paramInputStream);
    this.ctype = new ClassType();
    readFormatVersion();
    readConstants();
    readClassInfo();
    readFields();
    readMethods();
    readAttributes(this.ctype);
    paramClassTypeWriter.print(this.ctype);
    paramClassTypeWriter.flush();
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore_1
    //   3: new 46	gnu/bytecode/ClassTypeWriter
    //   6: dup
    //   7: aconst_null
    //   8: getstatic 69	java/lang/System:out	Ljava/io/PrintStream;
    //   11: iconst_0
    //   12: invokespecial 72	gnu/bytecode/ClassTypeWriter:<init>	(Lgnu/bytecode/ClassType;Ljava/io/OutputStream;I)V
    //   15: astore_2
    //   16: iload_1
    //   17: ifne +9 -> 26
    //   20: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   23: invokestatic 79	gnu/bytecode/dump:usage	(Ljava/io/PrintStream;)V
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: iload_1
    //   30: if_icmpge +701 -> 731
    //   33: aload_0
    //   34: iload_3
    //   35: aaload
    //   36: astore 4
    //   38: aload 4
    //   40: ldc 81
    //   42: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifne +13 -> 58
    //   48: aload 4
    //   50: ldc 89
    //   52: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +15 -> 70
    //   58: aload_2
    //   59: bipush 15
    //   61: invokevirtual 93	gnu/bytecode/ClassTypeWriter:setFlags	(I)V
    //   64: iinc 3 1
    //   67: goto -39 -> 28
    //   70: aload 4
    //   72: invokestatic 97	gnu/bytecode/dump:uriSchemeSpecified	(Ljava/lang/String;)Z
    //   75: ifeq +474 -> 549
    //   78: aload 4
    //   80: ldc 99
    //   82: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   85: istore 16
    //   87: iload 16
    //   89: ifeq +126 -> 215
    //   92: aload 4
    //   94: iconst_4
    //   95: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   98: astore 17
    //   100: aload 17
    //   102: invokestatic 97	gnu/bytecode/dump:uriSchemeSpecified	(Ljava/lang/String;)Z
    //   105: ifne +83 -> 188
    //   108: aload 17
    //   110: bipush 33
    //   112: invokevirtual 110	java/lang/String:indexOf	(I)I
    //   115: istore 32
    //   117: iload 32
    //   119: iflt +69 -> 188
    //   122: aload 17
    //   124: iconst_0
    //   125: iload 32
    //   127: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: astore 33
    //   132: new 115	java/io/File
    //   135: dup
    //   136: aload 33
    //   138: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore 34
    //   143: aload 34
    //   145: invokevirtual 122	java/io/File:toURI	()Ljava/net/URI;
    //   148: invokevirtual 128	java/net/URI:toURL	()Ljava/net/URL;
    //   151: invokevirtual 134	java/net/URL:toString	()Ljava/lang/String;
    //   154: astore 35
    //   156: new 136	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   163: ldc 99
    //   165: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 35
    //   170: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 17
    //   175: iload 32
    //   177: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   180: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 4
    //   188: aload 17
    //   190: ldc 144
    //   192: invokevirtual 147	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   195: ifge +20 -> 215
    //   198: aload 4
    //   200: bipush 33
    //   202: invokevirtual 150	java/lang/String:lastIndexOf	(I)I
    //   205: istore 29
    //   207: iload 29
    //   209: ifgt +72 -> 281
    //   212: iconst_0
    //   213: istore 16
    //   215: new 130	java/net/URL
    //   218: dup
    //   219: aload 4
    //   221: invokespecial 151	java/net/URL:<init>	(Ljava/lang/String;)V
    //   224: astore 18
    //   226: aload 18
    //   228: invokevirtual 155	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   231: invokevirtual 161	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   234: astore 28
    //   236: aload 28
    //   238: astore 5
    //   240: aload 5
    //   242: aload 4
    //   244: aload_2
    //   245: invokestatic 165	gnu/bytecode/dump:process	(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V
    //   248: goto -184 -> 64
    //   251: astore 6
    //   253: aload 6
    //   255: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   258: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   261: ldc 170
    //   263: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   266: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   269: aload 6
    //   271: invokevirtual 178	java/io/PrintStream:print	(Ljava/lang/Object;)V
    //   274: iconst_m1
    //   275: invokestatic 181	java/lang/System:exit	(I)V
    //   278: goto -214 -> 64
    //   281: aload 4
    //   283: bipush 47
    //   285: iload 29
    //   287: invokevirtual 184	java/lang/String:indexOf	(II)I
    //   290: ifge -75 -> 215
    //   293: aload 4
    //   295: iload 29
    //   297: iconst_1
    //   298: iadd
    //   299: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   302: bipush 46
    //   304: bipush 47
    //   306: invokevirtual 188	java/lang/String:replace	(CC)Ljava/lang/String;
    //   309: astore 30
    //   311: new 136	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   318: aload 4
    //   320: iconst_0
    //   321: iload 29
    //   323: iconst_1
    //   324: iadd
    //   325: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   328: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: bipush 47
    //   333: invokevirtual 191	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   336: aload 30
    //   338: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 193
    //   343: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: astore 31
    //   351: aload 31
    //   353: astore 4
    //   355: goto -140 -> 215
    //   358: astore 20
    //   360: iload 16
    //   362: ifeq +58 -> 420
    //   365: aload 18
    //   367: invokevirtual 196	java/net/URL:getFile	()Ljava/lang/String;
    //   370: astore 22
    //   372: aload 22
    //   374: bipush 33
    //   376: invokevirtual 150	java/lang/String:lastIndexOf	(I)I
    //   379: istore 23
    //   381: iload 23
    //   383: ifle +17 -> 400
    //   386: aload 22
    //   388: iconst_0
    //   389: iload 23
    //   391: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   394: astore 24
    //   396: aload 24
    //   398: astore 22
    //   400: new 130	java/net/URL
    //   403: dup
    //   404: aload 22
    //   406: invokespecial 151	java/net/URL:<init>	(Ljava/lang/String;)V
    //   409: astore 25
    //   411: aload 25
    //   413: invokevirtual 155	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   416: invokevirtual 161	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   419: pop
    //   420: aload 20
    //   422: athrow
    //   423: astore 19
    //   425: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   428: ldc 198
    //   430: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   433: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   436: aload 4
    //   438: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   441: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   444: ldc 202
    //   446: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   449: iconst_m1
    //   450: invokestatic 181	java/lang/System:exit	(I)V
    //   453: aconst_null
    //   454: astore 5
    //   456: goto -216 -> 240
    //   459: astore 26
    //   461: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   464: ldc 204
    //   466: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   469: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   472: aload 22
    //   474: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   477: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   480: ldc 202
    //   482: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   485: iconst_m1
    //   486: invokestatic 181	java/lang/System:exit	(I)V
    //   489: goto -69 -> 420
    //   492: astore 21
    //   494: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   497: ldc 206
    //   499: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   502: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   505: aload 4
    //   507: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   510: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   513: ldc 202
    //   515: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   518: aload 21
    //   520: invokevirtual 207	java/util/zip/ZipException:printStackTrace	()V
    //   523: aload 21
    //   525: invokevirtual 211	java/util/zip/ZipException:getCause	()Ljava/lang/Throwable;
    //   528: ifnull +11 -> 539
    //   531: aload 21
    //   533: invokevirtual 211	java/util/zip/ZipException:getCause	()Ljava/lang/Throwable;
    //   536: invokevirtual 212	java/lang/Throwable:printStackTrace	()V
    //   539: iconst_m1
    //   540: invokestatic 181	java/lang/System:exit	(I)V
    //   543: aconst_null
    //   544: astore 5
    //   546: goto -306 -> 240
    //   549: new 214	java/io/FileInputStream
    //   552: dup
    //   553: aload 4
    //   555: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   558: astore 5
    //   560: goto -320 -> 240
    //   563: astore 7
    //   565: aload 4
    //   567: invokestatic 221	gnu/bytecode/ObjectType:getContextClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   570: invokevirtual 227	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   573: astore 15
    //   575: aload 15
    //   577: astore 9
    //   579: new 136	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   586: aload 4
    //   588: bipush 46
    //   590: bipush 47
    //   592: invokevirtual 188	java/lang/String:replace	(CC)Ljava/lang/String;
    //   595: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc 193
    //   600: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: astore 10
    //   608: aload 9
    //   610: aload 10
    //   612: invokevirtual 233	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   615: astore 12
    //   617: aload 12
    //   619: invokevirtual 155	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   622: invokevirtual 161	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   625: astore 5
    //   627: aload 12
    //   629: invokevirtual 134	java/net/URL:toString	()Ljava/lang/String;
    //   632: astore 13
    //   634: aload 13
    //   636: astore 4
    //   638: goto -398 -> 240
    //   641: astore 14
    //   643: invokestatic 236	gnu/bytecode/ObjectType:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   646: astore 9
    //   648: goto -69 -> 579
    //   651: astore 8
    //   653: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   656: ldc 238
    //   658: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   661: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   664: aload 4
    //   666: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   669: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   672: ldc 202
    //   674: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   677: iconst_m1
    //   678: invokestatic 181	java/lang/System:exit	(I)V
    //   681: aconst_null
    //   682: astore 9
    //   684: goto -105 -> 579
    //   687: astore 11
    //   689: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   692: ldc 240
    //   694: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   697: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   700: aload 4
    //   702: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   705: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   708: ldc 242
    //   710: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   713: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   716: aload 11
    //   718: invokevirtual 244	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   721: iconst_m1
    //   722: invokestatic 181	java/lang/System:exit	(I)V
    //   725: aconst_null
    //   726: astore 5
    //   728: goto -488 -> 240
    //   731: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	paramArrayOfString	String[]
    //   2	29	1	i	int
    //   15	230	2	localClassTypeWriter	ClassTypeWriter
    //   27	38	3	j	int
    //   36	665	4	localObject1	java.lang.Object
    //   238	489	5	localObject2	java.lang.Object
    //   251	19	6	localIOException	IOException
    //   563	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   651	1	8	localThrowable1	java.lang.Throwable
    //   577	106	9	localClassLoader1	java.lang.ClassLoader
    //   606	5	10	str1	String
    //   687	30	11	localThrowable2	java.lang.Throwable
    //   615	13	12	localURL1	java.net.URL
    //   632	3	13	str2	String
    //   641	1	14	localNoClassDefFoundError	java.lang.NoClassDefFoundError
    //   573	3	15	localClassLoader2	java.lang.ClassLoader
    //   85	276	16	bool	boolean
    //   98	91	17	str3	String
    //   224	142	18	localURL2	java.net.URL
    //   423	1	19	localFileNotFoundException2	java.io.FileNotFoundException
    //   358	63	20	localZipException1	java.util.zip.ZipException
    //   492	40	21	localZipException2	java.util.zip.ZipException
    //   370	103	22	localObject3	java.lang.Object
    //   379	11	23	k	int
    //   394	3	24	str4	String
    //   409	3	25	localURL3	java.net.URL
    //   459	1	26	localFileNotFoundException3	java.io.FileNotFoundException
    //   234	3	28	localInputStream	InputStream
    //   205	120	29	m	int
    //   309	28	30	str5	String
    //   349	3	31	str6	String
    //   115	61	32	n	int
    //   130	7	33	str7	String
    //   141	3	34	localFile	File
    //   154	15	35	str8	String
    // Exception table:
    //   from	to	target	type
    //   78	87	251	java/io/IOException
    //   92	117	251	java/io/IOException
    //   122	188	251	java/io/IOException
    //   188	207	251	java/io/IOException
    //   215	226	251	java/io/IOException
    //   226	236	251	java/io/IOException
    //   240	248	251	java/io/IOException
    //   281	351	251	java/io/IOException
    //   365	381	251	java/io/IOException
    //   386	396	251	java/io/IOException
    //   400	420	251	java/io/IOException
    //   420	423	251	java/io/IOException
    //   425	453	251	java/io/IOException
    //   461	489	251	java/io/IOException
    //   494	539	251	java/io/IOException
    //   539	543	251	java/io/IOException
    //   549	560	251	java/io/IOException
    //   565	575	251	java/io/IOException
    //   579	608	251	java/io/IOException
    //   608	634	251	java/io/IOException
    //   643	648	251	java/io/IOException
    //   653	681	251	java/io/IOException
    //   689	725	251	java/io/IOException
    //   226	236	358	java/util/zip/ZipException
    //   215	226	423	java/io/FileNotFoundException
    //   226	236	423	java/io/FileNotFoundException
    //   365	381	423	java/io/FileNotFoundException
    //   386	396	423	java/io/FileNotFoundException
    //   420	423	423	java/io/FileNotFoundException
    //   461	489	423	java/io/FileNotFoundException
    //   400	420	459	java/io/FileNotFoundException
    //   215	226	492	java/util/zip/ZipException
    //   365	381	492	java/util/zip/ZipException
    //   386	396	492	java/util/zip/ZipException
    //   400	420	492	java/util/zip/ZipException
    //   420	423	492	java/util/zip/ZipException
    //   461	489	492	java/util/zip/ZipException
    //   549	560	563	java/io/FileNotFoundException
    //   565	575	641	java/lang/NoClassDefFoundError
    //   565	575	651	java/lang/Throwable
    //   608	634	687	java/lang/Throwable
  }
  
  public static void process(InputStream paramInputStream, String paramString, ClassTypeWriter paramClassTypeWriter)
    throws IOException
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
    localBufferedInputStream.mark(5);
    int i = readMagic(localBufferedInputStream);
    if (i == -889275714)
    {
      paramClassTypeWriter.print("Reading .class from ");
      paramClassTypeWriter.print(paramString);
      paramClassTypeWriter.println('.');
      new dump(localBufferedInputStream, paramClassTypeWriter);
      return;
    }
    if (i == 1347093252)
    {
      localBufferedInputStream.reset();
      paramClassTypeWriter.print("Reading classes from archive ");
      paramClassTypeWriter.print(paramString);
      paramClassTypeWriter.println('.');
      ZipInputStream localZipInputStream = new ZipInputStream(localBufferedInputStream);
      for (;;)
      {
        ZipEntry localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null) {
          break;
        }
        String str = localZipEntry.getName();
        if (localZipEntry.isDirectory())
        {
          paramClassTypeWriter.print("Archive directory: ");
          paramClassTypeWriter.print(str);
          paramClassTypeWriter.println('.');
        }
        else
        {
          paramClassTypeWriter.println();
          if (readMagic(localZipInputStream) == -889275714)
          {
            paramClassTypeWriter.print("Reading class member: ");
            paramClassTypeWriter.print(str);
            paramClassTypeWriter.println('.');
            new dump(localZipInputStream, paramClassTypeWriter);
          }
          else
          {
            paramClassTypeWriter.print("Skipping non-class member: ");
            paramClassTypeWriter.print(str);
            paramClassTypeWriter.println('.');
          }
        }
      }
      System.exit(-1);
      return;
    }
    System.err.println("File " + paramString + " is not a valid .class file");
    System.exit(-1);
  }
  
  public static void process(InputStream paramInputStream, String paramString, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    process(paramInputStream, paramString, new ClassTypeWriter(null, paramOutputStream, paramInt));
  }
  
  public static void process(InputStream paramInputStream, String paramString, Writer paramWriter, int paramInt)
    throws IOException
  {
    process(paramInputStream, paramString, new ClassTypeWriter(null, paramWriter, paramInt));
  }
  
  static int readMagic(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    for (int j = 0;; j++)
    {
      int k;
      if (j < 4)
      {
        k = paramInputStream.read();
        if (k >= 0) {}
      }
      else
      {
        return i;
      }
      i = i << 8 | k & 0xFF;
    }
  }
  
  static int uriSchemeLength(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      char c = paramString.charAt(j);
      if (c == ':') {
        return j;
      }
      if (j == 0)
      {
        if (Character.isLetter(c)) {}
      }
      else {
        while ((!Character.isLetterOrDigit(c)) && (c != '+') && (c != '-') && (c != '.')) {
          return -1;
        }
      }
    }
    return -1;
  }
  
  static boolean uriSchemeSpecified(String paramString)
  {
    int i = 1;
    int j = uriSchemeLength(paramString);
    if ((j == i) && (File.separatorChar == '\\'))
    {
      int k = paramString.charAt(0);
      boolean bool;
      if (k >= 97)
      {
        bool = false;
        if (k <= 122) {}
      }
      else if (k >= 65)
      {
        bool = false;
        if (k <= 90) {}
      }
      else
      {
        bool = i;
      }
      return bool;
    }
    if (j > 0) {}
    for (;;)
    {
      return i;
      i = 0;
    }
  }
  
  public static void usage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Prints and dis-assembles the contents of JVM .class files.");
    paramPrintStream.println("Usage: [--verbose] class-or-jar ...");
    paramPrintStream.println("where a class-or-jar can be one of:");
    paramPrintStream.println("- a fully-qualified class name; or");
    paramPrintStream.println("- the name of a .class file, or a URL reference to one; or");
    paramPrintStream.println("- the name of a .jar or .zip archive file, or a URL reference to one.");
    paramPrintStream.println("If a .jar/.zip archive is named, all its.class file members are printed.");
    paramPrintStream.println();
    paramPrintStream.println("You can name a single .class member of an archive with a jar: URL,");
    paramPrintStream.println("which looks like: jar:jar-spec!/p1/p2/cl.class");
    paramPrintStream.println("The jar-spec can be a URL or the name of the .jar file.");
    paramPrintStream.println("You can also use the shorthand syntax: jar:jar-spec!p1.p2.cl");
    System.exit(-1);
  }
  
  public Attribute readAttribute(String paramString, int paramInt, AttrContainer paramAttrContainer)
    throws IOException
  {
    return super.readAttribute(paramString, paramInt, paramAttrContainer);
  }
  
  public ConstantPool readConstants()
    throws IOException
  {
    this.ctype.constants = super.readConstants();
    return this.ctype.constants;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.dump
 * JD-Core Version:    0.7.0.1
 */