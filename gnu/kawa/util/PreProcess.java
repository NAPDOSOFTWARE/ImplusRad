package gnu.kawa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class PreProcess
{
  static final String JAVA4_FEATURES = "+JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio";
  static final String JAVA5_FEATURES = "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName";
  static final String NO_JAVA4_FEATURES = "-JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android";
  static final String NO_JAVA6_FEATURES = "-JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer";
  static String[] version_features = { "java1", "-JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java2", "+JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4x", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 +use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java6compat5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6 -JAVA7 +JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java6", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 -JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java7", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer +use:java.dyn -Android", "android", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 -JAXP-QName -use:javax.xml.transform -JAVA6 -JAVA6COMPAT5 +Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer" };
  String filename;
  Hashtable keywords = new Hashtable();
  int lineno;
  byte[] resultBuffer;
  int resultLength;
  
  public static void main(String[] paramArrayOfString)
  {
    PreProcess localPreProcess = new PreProcess();
    localPreProcess.keywords.put("true", Boolean.TRUE);
    localPreProcess.keywords.put("false", Boolean.FALSE);
    for (int i = 0; i < paramArrayOfString.length; i++) {
      localPreProcess.handleArg(paramArrayOfString[i]);
    }
  }
  
  void error(String paramString)
  {
    System.err.println(this.filename + ':' + this.lineno + ": " + paramString);
    System.exit(-1);
  }
  
  public void filter(String paramString)
    throws Throwable
  {
    if (filter(paramString, new BufferedInputStream(new FileInputStream(paramString))))
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      localFileOutputStream.write(this.resultBuffer, 0, this.resultLength);
      localFileOutputStream.close();
      System.err.println("Pre-processed " + paramString);
    }
  }
  
  public boolean filter(String paramString, BufferedInputStream paramBufferedInputStream)
    throws Throwable
  {
    this.filename = paramString;
    Object localObject1 = new byte[2000];
    int i = 0;
    int j = 0;
    int k = -1;
    this.lineno = 1;
    int m = -1;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    Object localObject2 = null;
    boolean bool1 = false;
    int i3 = 0;
    int i4 = 0;
    int i5 = paramBufferedInputStream.read();
    Object localObject3;
    int i6;
    if (i5 < 0)
    {
      localObject3 = localObject1;
      i6 = i;
    }
    int i38;
    int i34;
    label272:
    label276:
    int i7;
    label330:
    int i30;
    do
    {
      if (i1 != 0)
      {
        this.lineno = i4;
        error("unterminated " + (String)localObject2);
      }
      this.resultBuffer = ((byte[])localObject3);
      this.resultLength = i6;
      return bool1;
      if (i + 10 < localObject1.length) {
        break label1392;
      }
      localObject3 = new byte[i * 2];
      System.arraycopy(localObject1, 0, localObject3, 0, i);
      if ((i5 == 10) && (i > 0) && (localObject3[(i - 1)] == 13))
      {
        int i40 = i + 1;
        localObject3[i] = ((byte)i5);
        i = i40;
        localObject1 = localObject3;
        break;
      }
      if ((m < 0) || (k >= 0) || (i3 > 0) || (i5 == 13) || (i5 == 10) || ((m != n) && ((i5 == 32) || (i5 == 9)))) {
        break label1381;
      }
      if (i5 != 47) {
        break label561;
      }
      paramBufferedInputStream.mark(100);
      i38 = paramBufferedInputStream.read();
      if (i38 != 47) {
        break label509;
      }
      i34 = 0;
      paramBufferedInputStream.reset();
      if (i34 == 0) {
        break label1381;
      }
      int i35 = i + 1;
      localObject3[i] = 47;
      int i36 = i35 + 1;
      localObject3[i35] = 47;
      int i37 = i36 + 1;
      localObject3[i36] = 32;
      bool1 = true;
      i6 = i37;
      i7 = 1;
      if ((i5 == 32) || (i5 == 9) || (k >= 0)) {
        break label1362;
      }
      if ((i1 <= 0) || (m == n) || (i5 != 47)) {
        break label1339;
      }
      i30 = paramBufferedInputStream.read();
    } while (i30 < 0);
    int i8;
    int i9;
    boolean bool2;
    if (i30 != 47)
    {
      int i33 = i6 + 1;
      localObject3[i6] = 47;
      i8 = i7;
      i9 = i33;
      k = i6;
      bool2 = bool1;
    }
    label419:
    int i11;
    int i13;
    int i14;
    label503:
    label509:
    int i31;
    label561:
    int i32;
    for (int i10 = i30;; i10 = i32)
    {
      localObject3[i9] = ((byte)i10);
      i = i9 + 1;
      if ((i10 != 13) && (i10 != 10)) {
        break label1253;
      }
      i11 = 0;
      int i12 = j;
      i13 = -1;
      for (i14 = i12; i14 < i - 1; i14++) {
        if ((localObject3[i14] != 32) && (localObject3[i14] != 9))
        {
          if (i13 >= 0) {
            break label1311;
          }
          i11 = i14;
          i13 = i14;
        }
      }
      if (i38 == 42)
      {
        int i39;
        do
        {
          i39 = paramBufferedInputStream.read();
        } while ((i39 == 32) || (i39 == 9));
        if (i39 != 35)
        {
          i34 = 1;
          break label272;
        }
        i34 = 0;
        break label272;
      }
      i34 = 1;
      break label272;
      i34 = 1;
      break label276;
      i31 = paramBufferedInputStream.read();
      if (i31 < 0) {
        break;
      }
      if (i31 != 32) {
        break label1318;
      }
      i31 = paramBufferedInputStream.read();
      if ((i31 != 32) && (i31 != 9)) {
        break label1318;
      }
      i32 = i31;
      i8 = -1;
      k = -1;
      i9 = i6;
      bool2 = true;
    }
    String str1;
    int i22;
    String str2;
    Object localObject4;
    if ((i11 - i13 >= 4) && (localObject3[i13] == 47) && (localObject3[(i13 + 1)] == 42) && (localObject3[(i11 - 1)] == 42) && (localObject3[i11] == 47))
    {
      for (int i19 = i13 + 2; (i19 < i11) && (localObject3[i19] == 32); i19++) {}
      for (int i20 = i11 - 2; (i20 > i19) && (localObject3[i20] == 32); i20--) {}
      if (localObject3[i19] == 35)
      {
        str1 = new String((byte[])localObject3, i19, 1 + (i20 - i19), "ISO-8859-1");
        int i21 = str1.indexOf(' ');
        i22 = this.lineno;
        if (i21 <= 0) {
          break label973;
        }
        localObject2 = str1.substring(0, i21);
        str2 = str1.substring(i21).trim();
        localObject4 = this.keywords.get(str2);
        label825:
        if ((!"#ifdef".equals(localObject2)) && (!"#ifndef".equals(localObject2))) {
          break label1050;
        }
        if (localObject4 != null) {
          break label1431;
        }
        System.err.println(paramString + ":" + this.lineno + ": warning - undefined keyword: " + str2);
      }
    }
    label1044:
    label1431:
    for (Object localObject5 = Boolean.FALSE;; localObject5 = localObject4)
    {
      int i23 = i1 + 1;
      if (i2 > 0)
      {
        i1 = i23;
        m = n;
        i4 = i22;
      }
      for (;;)
      {
        label920:
        k = -1;
        n = 0;
        this.lineno = (1 + this.lineno);
        j = i;
        int i15 = i4;
        int i16 = 0;
        int i17 = i15;
        label951:
        bool1 = bool2;
        localObject1 = localObject3;
        int i18 = i17;
        i3 = i16;
        i4 = i18;
        break;
        label973:
        str2 = "";
        localObject2 = str1;
        localObject4 = null;
        break label825;
        int i24;
        label1001:
        int i25;
        if (((String)localObject2).charAt(3) == 'n')
        {
          i24 = 1;
          if (localObject5 != Boolean.FALSE) {
            break label1044;
          }
          i25 = 1;
        }
        for (;;)
        {
          if (i24 != i25)
          {
            i2 = i23;
            i1 = i23;
            m = n;
            i4 = i22;
            break;
            i24 = 0;
            break label1001;
            i25 = 0;
            continue;
            label1050:
            if ("#else".equals(localObject2))
            {
              if (i1 == 0)
              {
                error("unexpected " + (String)localObject2);
                i4 = i22;
                break;
              }
              if (i1 == i2)
              {
                m = -1;
                i4 = i22;
                i2 = 0;
                break;
              }
              if (i2 != 0) {
                break label1409;
              }
              i2 = i1;
              m = n;
              i4 = i22;
              break;
            }
            int i26;
            int i27;
            if ("#endif".equals(localObject2))
            {
              if (i1 == 0) {
                error("unexpected " + (String)localObject2);
              }
              if (i1 == i2)
              {
                i26 = 0;
                i27 = -1;
              }
            }
            for (;;)
            {
              i1--;
              i2 = i26;
              m = i27;
              i4 = i22;
              break label920;
              if (i2 > 0)
              {
                i26 = i2;
                i27 = n;
                continue;
                error("unknown command: " + str1);
                i4 = i22;
                break label920;
                label1253:
                if (k < 0)
                {
                  if (i10 == 9) {}
                  for (n = 0xFFFFFFF8 & n + 8;; n++)
                  {
                    int i29 = i8;
                    i17 = i4;
                    i16 = i29;
                    break;
                  }
                }
                int i28 = i8;
                i17 = i4;
                i16 = i28;
                break label951;
                label1311:
                i11 = i14;
                break label503;
                label1318:
                i9 = i6;
                k = i6;
                bool2 = true;
                i10 = i31;
                i8 = -1;
                break label419;
                label1339:
                i8 = i7;
                k = i6;
                i9 = i6;
                bool2 = bool1;
                i10 = i5;
                break label419;
                label1362:
                i8 = i7;
                i9 = i6;
                bool2 = bool1;
                i10 = i5;
                break label419;
                label1381:
                i6 = i;
                i7 = i3;
                break label330;
                label1392:
                localObject3 = localObject1;
                break;
              }
              i26 = i2;
              i27 = m;
            }
            m = n;
            i4 = i22;
            break;
          }
        }
        i1 = i23;
        i4 = i22;
      }
    }
  }
  
  void handleArg(String paramString)
  {
    int i = 0;
    if (paramString.charAt(0) == '%')
    {
      String str3 = paramString.substring(1);
      for (;;)
      {
        if (i >= version_features.length)
        {
          System.err.println("Unknown version: " + str3);
          System.exit(-1);
        }
        if (str3.equals(version_features[i]))
        {
          String str4 = version_features[(i + 1)];
          System.err.println("(variant " + str3 + " maps to: " + str4 + ")");
          StringTokenizer localStringTokenizer = new StringTokenizer(str4);
          while (localStringTokenizer.hasMoreTokens()) {
            handleArg(localStringTokenizer.nextToken());
          }
        }
        i += 2;
      }
    }
    if (paramString.charAt(0) == '+')
    {
      this.keywords.put(paramString.substring(1), Boolean.TRUE);
      return;
    }
    if (paramString.charAt(0) == '-')
    {
      int j = paramString.indexOf('=');
      if (j > 1)
      {
        int k;
        String str1;
        String str2;
        Boolean localBoolean;
        if (paramString.charAt(1) == '-')
        {
          k = 2;
          str1 = paramString.substring(k, j);
          str2 = paramString.substring(j + 1);
          localBoolean = Boolean.FALSE;
          if (!str2.equalsIgnoreCase("true")) {
            break label280;
          }
          localBoolean = Boolean.TRUE;
        }
        for (;;)
        {
          this.keywords.put(str1, localBoolean);
          return;
          k = 1;
          break;
          label280:
          if (!str2.equalsIgnoreCase("false"))
          {
            System.err.println("invalid value " + str2 + " for " + str1);
            System.exit(-1);
          }
        }
      }
      this.keywords.put(paramString.substring(1), Boolean.FALSE);
      return;
    }
    try
    {
      filter(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.err.println("caught " + localThrowable);
      localThrowable.printStackTrace();
      System.exit(-1);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.PreProcess
 * JD-Core Version:    0.7.0.1
 */