package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class SourceDebugExtAttr
  extends Attribute
{
  int curFileIndex = -1;
  String curFileName;
  int curLineIndex = -1;
  byte[] data;
  private String defaultStratumId;
  int dlength;
  int fileCount;
  int[] fileIDs;
  String[] fileNames;
  int lineCount;
  int[] lines;
  int maxFileID;
  private String outputFileName;
  
  public SourceDebugExtAttr(ClassType paramClassType)
  {
    super("SourceDebugExtension");
    addToFrontOf(paramClassType);
  }
  
  private int fixLine(int paramInt1, int paramInt2)
  {
    int i = this.lines[paramInt2];
    int j = this.lines[(paramInt2 + 2)];
    if (paramInt1 < i) {
      if (paramInt2 <= 0) {}
    }
    int k;
    do
    {
      return -1;
      int m = -1 + (i + j);
      this.lines[paramInt2] = paramInt1;
      this.lines[(paramInt2 + 2)] = (1 + (m - paramInt1));
      this.lines[(paramInt2 + 3)] = paramInt1;
      i = paramInt1;
      k = this.lines[(paramInt2 + 3)] - i;
      if (paramInt1 < i + j) {
        return paramInt1 + k;
      }
    } while ((paramInt2 != 5 * (-1 + this.lineCount)) && ((paramInt2 != 0) || (paramInt1 >= this.lines[8])));
    this.lines[(paramInt2 + 2)] = (1 + (paramInt1 - i));
    return paramInt1 + k;
  }
  
  void addFile(String paramString)
  {
    if ((this.curFileName == paramString) || ((paramString != null) && (paramString.equals(this.curFileName)))) {
      return;
    }
    this.curFileName = paramString;
    String str1 = SourceFileAttr.fixSourceFile(paramString);
    int i = str1.lastIndexOf('/');
    String str2;
    label82:
    int j;
    if (i >= 0)
    {
      String str3 = str1;
      str1 = str1.substring(i + 1);
      str2 = str1 + '\n' + str3;
      if ((this.curFileIndex >= 0) && (str2.equals(this.fileNames[this.curFileIndex]))) {
        break label162;
      }
      j = this.fileCount;
    }
    for (int k = 0;; k++)
    {
      if (k >= j) {
        break label170;
      }
      if ((k != this.curFileIndex) && (str2.equals(this.fileNames[k])))
      {
        this.curFileIndex = k;
        this.curLineIndex = -1;
        return;
        str2 = str1;
        break label82;
        label162:
        break;
      }
    }
    label170:
    if (this.fileIDs == null)
    {
      this.fileIDs = new int[5];
      this.fileNames = new String[5];
    }
    for (;;)
    {
      this.fileCount = (1 + this.fileCount);
      int m = 1 + this.maxFileID;
      this.maxFileID = m;
      int n = m << 1;
      if (i >= 0) {
        n++;
      }
      this.fileNames[j] = str2;
      if (this.outputFileName == null) {
        this.outputFileName = str1;
      }
      this.fileIDs[j] = n;
      this.curFileIndex = j;
      this.curLineIndex = -1;
      return;
      if (j >= this.fileIDs.length)
      {
        int[] arrayOfInt = new int[j * 2];
        String[] arrayOfString = new String[j * 2];
        System.arraycopy(this.fileIDs, 0, arrayOfInt, 0, j);
        System.arraycopy(this.fileNames, 0, arrayOfString, 0, j);
        this.fileIDs = arrayOfInt;
        this.fileNames = arrayOfString;
      }
    }
  }
  
  public void addStratum(String paramString)
  {
    this.defaultStratumId = paramString;
  }
  
  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("SMAP\n");
    nonAsteriskString(this.outputFileName, localStringBuffer);
    localStringBuffer.append('\n');
    String str;
    int i;
    label92:
    int i5;
    if (this.defaultStratumId == null)
    {
      str = "Java";
      nonAsteriskString(str, localStringBuffer);
      localStringBuffer.append('\n');
      localStringBuffer.append("*S ");
      localStringBuffer.append(str);
      localStringBuffer.append('\n');
      localStringBuffer.append("*F\n");
      i = 0;
      if (i >= this.fileCount) {
        break label192;
      }
      i5 = this.fileIDs[i];
      if ((i5 & 0x1) == 0) {
        break label186;
      }
    }
    label186:
    for (int i6 = 1;; i6 = 0)
    {
      int i7 = i5 >> 1;
      if (i6 != 0) {
        localStringBuffer.append("+ ");
      }
      localStringBuffer.append(i7);
      localStringBuffer.append(' ');
      localStringBuffer.append(this.fileNames[i]);
      localStringBuffer.append('\n');
      i++;
      break label92;
      str = this.defaultStratumId;
      break;
    }
    label192:
    if (this.lineCount > 0)
    {
      int j = 0;
      localStringBuffer.append("*L\n");
      int k = 0;
      int m = 0;
      do
      {
        int n = this.lines[m];
        int i1 = this.fileIDs[this.lines[(m + 1)]] >> 1;
        int i2 = this.lines[(m + 2)];
        int i3 = this.lines[(m + 3)];
        int i4 = this.lines[(m + 4)];
        localStringBuffer.append(n);
        if (i1 != j)
        {
          localStringBuffer.append('#');
          localStringBuffer.append(i1);
          j = i1;
        }
        if (i2 != 1)
        {
          localStringBuffer.append(',');
          localStringBuffer.append(i2);
        }
        localStringBuffer.append(':');
        localStringBuffer.append(i3);
        if (i4 != 1)
        {
          localStringBuffer.append(',');
          localStringBuffer.append(i4);
        }
        localStringBuffer.append('\n');
        m += 5;
        k++;
      } while (k < this.lineCount);
    }
    localStringBuffer.append("*E\n");
    try
    {
      this.data = localStringBuffer.toString().getBytes("UTF-8");
      this.dlength = this.data.length;
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.toString());
    }
  }
  
  int fixLine(int paramInt)
  {
    if (this.curLineIndex >= 0)
    {
      int i2 = fixLine(paramInt, this.curLineIndex);
      if (i2 >= 0) {
        return i2;
      }
    }
    int i = 0;
    int j = this.curFileIndex;
    for (int k = 0; k < this.lineCount; k++)
    {
      if ((i != this.curLineIndex) && (j == this.lines[(i + 1)]))
      {
        int i1 = fixLine(paramInt, i);
        if (i1 >= 0)
        {
          this.curLineIndex = i;
          return i1;
        }
      }
      i += 5;
    }
    int m;
    int n;
    if (this.lines == null)
    {
      this.lines = new int[20];
      m = paramInt;
      if (i != 0) {
        break label219;
      }
      n = paramInt;
    }
    for (;;)
    {
      this.lines[i] = m;
      this.lines[(i + 1)] = j;
      this.lines[(i + 2)] = 1;
      this.lines[(i + 3)] = n;
      this.lines[(i + 4)] = 1;
      this.curLineIndex = i;
      this.lineCount = (1 + this.lineCount);
      return paramInt;
      if (i < this.lines.length) {
        break;
      }
      int[] arrayOfInt = new int[i * 2];
      System.arraycopy(this.lines, 0, arrayOfInt, 0, i);
      this.lines = arrayOfInt;
      break;
      label219:
      n = this.lines[(3 + (i - 5))] + this.lines[(2 + (i - 5))];
      if ((i == 5) && (n < 10000)) {
        n = 10000;
      }
      paramInt = n;
    }
  }
  
  public int getLength()
  {
    return this.dlength;
  }
  
  void nonAsteriskString(String paramString, StringBuffer paramStringBuffer)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramString.charAt(0) == '*')) {
      paramStringBuffer.append(' ');
    }
    paramStringBuffer.append(paramString);
  }
  
  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.println(this.dlength);
    try
    {
      paramClassTypeWriter.print(new String(this.data, 0, this.dlength, "UTF-8"));
      if ((this.dlength > 0) && (this.data[(-1 + this.dlength)] != 13) && (this.data[(-1 + this.dlength)] != 10)) {
        paramClassTypeWriter.println();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramClassTypeWriter.print("(Caught ");
        paramClassTypeWriter.print(localException);
        paramClassTypeWriter.println(')');
      }
    }
  }
  
  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.write(this.data, 0, this.dlength);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.SourceDebugExtAttr
 * JD-Core Version:    0.7.0.1
 */