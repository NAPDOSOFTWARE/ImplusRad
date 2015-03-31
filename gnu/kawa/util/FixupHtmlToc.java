package gnu.kawa.util;

import java.io.File;
import java.io.PrintStream;

public class FixupHtmlToc
{
  static FileInfo[] argFiles;
  
  public static void main(String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        argFiles = new FileInfo[paramArrayOfString.length];
        int i = 0;
        if (i < paramArrayOfString.length)
        {
          FileInfo localFileInfo = FileInfo.find(new File(paramArrayOfString[i]));
          localFileInfo.writeNeeded = true;
          argFiles[i] = localFileInfo;
          i++;
          continue;
          if (j < paramArrayOfString.length)
          {
            argFiles[j].scan();
            argFiles[j].write();
            j++;
            continue;
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        System.err.println("caught " + localThrowable);
        localThrowable.printStackTrace();
      }
      int j = 0;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.FixupHtmlToc
 * JD-Core Version:    0.7.0.1
 */