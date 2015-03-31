package org.acra;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.acra.collector.CrashReportData;

final class CrashReportPersister
{
  private static final int CONTINUE = 3;
  private static final int IGNORE = 5;
  private static final int KEY_DONE = 4;
  private static final String LINE_SEPARATOR = "\n";
  private static final int NONE = 0;
  private static final int SLASH = 1;
  private static final int UNICODE = 2;
  private final Context context;
  
  CrashReportPersister(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void dumpString(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (!paramBoolean)
    {
      int k = paramString.length();
      i = 0;
      if (k < 0)
      {
        int m = paramString.charAt(0);
        i = 0;
        if (m == 32)
        {
          paramStringBuilder.append("\\ ");
          i = 0 + 1;
        }
      }
    }
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      case '\013': 
      default: 
        if (("\\#!=:".indexOf(c) >= 0) || ((paramBoolean) && (c == ' '))) {
          paramStringBuilder.append('\\');
        }
        if ((c >= ' ') && (c <= '~')) {
          paramStringBuilder.append(c);
        }
        break;
      }
      for (;;)
      {
        i++;
        break;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        String str = Integer.toHexString(c);
        paramStringBuilder.append("\\u");
        for (int j = 0; j < 4 - str.length(); j++) {
          paramStringBuilder.append("0");
        }
        paramStringBuilder.append(str);
      }
    }
  }
  
  private boolean isEbcdic(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    int i;
    do
    {
      i = (byte)paramBufferedInputStream.read();
      if ((i == -1) || (i == 35) || (i == 10) || (i == 61)) {
        return false;
      }
    } while (i != 21);
    return true;
  }
  
  private CrashReportData load(Reader paramReader)
    throws IOException
  {
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject2;
    int m;
    int n;
    CrashReportData localCrashReportData;
    int i1;
    char c;
    int i4;
    for (;;)
    {
      BufferedReader localBufferedReader;
      int i2;
      try
      {
        localObject2 = new char[40];
        m = -1;
        n = 1;
        localCrashReportData = new CrashReportData();
        localBufferedReader = new BufferedReader(paramReader, 8192);
        i1 = 0;
        i2 = localBufferedReader.read();
        if (i2 == -1)
        {
          if ((i != 2) || (k > 4)) {
            break label812;
          }
          throw new IllegalArgumentException("luni.08");
        }
      }
      finally {}
      c = (char)i2;
      if (i1 == localObject2.length)
      {
        char[] arrayOfChar = new char[2 * localObject2.length];
        System.arraycopy(localObject2, 0, arrayOfChar, 0, i1);
        localObject2 = arrayOfChar;
      }
      if (i == 2)
      {
        int i3 = Character.digit(c, 16);
        if (i3 >= 0)
        {
          j = i3 + (j << 4);
          k++;
          if (k < 4) {
            continue;
          }
        }
        while (k > 4)
        {
          i = 0;
          i4 = i1 + 1;
          localObject2[i1] = ((char)j);
          if ((c == '\n') || (c == '')) {
            break label429;
          }
          i1 = i4;
          i = 0;
          break;
        }
        throw new IllegalArgumentException("luni.09");
        label214:
        int i5 = i1 + 1;
        localObject2[i1] = c;
        i1 = i5;
        n = 0;
        continue;
        label237:
        if (!Character.isWhitespace(c)) {
          break label797;
        }
        if (i != 3) {
          break label680;
        }
        i = 5;
        break label680;
        int i7;
        do
        {
          int i6 = localBufferedReader.read();
          if (i6 == -1) {
            break;
          }
          i7 = (char)i6;
          if ((i7 == 13) || (i7 == 10)) {
            break;
          }
        } while (i7 != 133);
        continue;
        label298:
        String str1 = new String((char[])localObject2, 0, i1);
        localCrashReportData.put(Enum.valueOf(ReportField.class, str1.substring(0, m)), str1.substring(m));
        break label757;
      }
    }
    for (;;)
    {
      if (m >= 0)
      {
        String str2 = new String((char[])localObject2, 0, i1);
        ReportField localReportField = (ReportField)Enum.valueOf(ReportField.class, str2.substring(0, m));
        String str3 = str2.substring(m);
        if (i == 1) {
          str3 = str3 + "";
        }
        localCrashReportData.put(localReportField, str3);
      }
      return localCrashReportData;
      label429:
      i1 = i4;
      if (i == 1)
      {
        i = 0;
        switch (c)
        {
        }
      }
      for (;;)
      {
        if (i != 4) {
          break label810;
        }
        m = i1;
        i = 0;
        break label214;
        i = 3;
        break;
        i = 5;
        break;
        c = '\b';
        i = 0;
        continue;
        c = '\f';
        i = 0;
        continue;
        c = '\n';
        i = 0;
        continue;
        c = '\r';
        i = 0;
        continue;
        c = '\t';
        i = 0;
        continue;
        i = 2;
        k = 0;
        j = 0;
        break;
        switch (c)
        {
        default: 
          if ((i1 == 0) || (i1 == m) || (i == 5)) {
            break;
          }
          if (m == -1) {
            i = 4;
          }
          break;
        case '!': 
        case '#': 
          if (n == 0) {
            break label237;
          }
          break;
        case '\n': 
          if (i == 3) {
            i = 5;
          }
          break;
        case '\r': 
        case '': 
          n = 1;
          if ((i1 > 0) || ((i1 == 0) && (m == 0)))
          {
            if (m != -1) {
              break label298;
            }
            m = i1;
            break label298;
          }
          m = -1;
          i = 0;
          i1 = 0;
          break;
        case '\\': 
          if (i == 4) {
            m = i1;
          }
          i = 1;
          break;
        case ':': 
        case '=': 
          label680:
          label757:
          if (m != -1) {
            break label237;
          }
          m = i1;
          i = 0;
          break;
          label797:
          if ((i == 5) || (i == 3)) {
            i = 0;
          }
          break;
        }
      }
      label810:
      break label214;
      label812:
      if ((m == -1) && (i1 > 0)) {
        m = i1;
      }
    }
  }
  
  public CrashReportData load(String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = this.context.openFileInput(paramString);
    if (localFileInputStream == null) {
      throw new IllegalArgumentException("Invalid crash report fileName : " + paramString);
    }
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localFileInputStream, 8192);
      localBufferedInputStream.mark(2147483647);
      boolean bool = isEbcdic(localBufferedInputStream);
      localBufferedInputStream.reset();
      if (!bool)
      {
        CrashReportData localCrashReportData1 = load(new InputStreamReader(localBufferedInputStream, "ISO8859-1"));
        return localCrashReportData1;
      }
      CrashReportData localCrashReportData2 = load(new InputStreamReader(localBufferedInputStream));
      return localCrashReportData2;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public void store(CrashReportData paramCrashReportData, String paramString)
    throws IOException
  {
    FileOutputStream localFileOutputStream = this.context.openFileOutput(paramString, 0);
    OutputStreamWriter localOutputStreamWriter;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localOutputStreamWriter = new OutputStreamWriter(localFileOutputStream, "ISO8859_1");
      Iterator localIterator = paramCrashReportData.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        dumpString(localStringBuilder, ((ReportField)localEntry.getKey()).toString(), true);
        localStringBuilder.append('=');
        dumpString(localStringBuilder, (String)localEntry.getValue(), false);
        localStringBuilder.append("\n");
        localOutputStreamWriter.write(localStringBuilder.toString());
        localStringBuilder.setLength(0);
      }
    }
    finally
    {
      localFileOutputStream.close();
    }
    localFileOutputStream.close();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.CrashReportPersister
 * JD-Core Version:    0.7.0.1
 */