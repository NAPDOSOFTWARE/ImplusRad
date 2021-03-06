package gnu.kawa.functions;

import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

class LispChoiceFormat
  extends ReportFormat
{
  Format[] choices;
  boolean lastIsDefault;
  int param;
  boolean skipIfFalse;
  boolean testBoolean;
  
  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int j;
    Format localFormat;
    if (this.testBoolean)
    {
      Format[] arrayOfFormat = this.choices;
      Object localObject = paramArrayOfObject[paramInt];
      Boolean localBoolean = Boolean.FALSE;
      j = 0;
      if (localObject == localBoolean)
      {
        localFormat = arrayOfFormat[j];
        paramInt++;
      }
    }
    for (;;)
    {
      return ReportFormat.format(localFormat, paramArrayOfObject, paramInt, paramWriter, paramFieldPosition);
      j = 1;
      break;
      if (!this.skipIfFalse)
      {
        int i = getParam(this.param, -1610612736, paramArrayOfObject, paramInt);
        if (this.param == -1610612736) {
          paramInt++;
        }
        if ((i < 0) || (i >= this.choices.length))
        {
          if (this.lastIsDefault) {
            i = -1 + this.choices.length;
          }
        }
        else
        {
          localFormat = this.choices[i];
          continue;
        }
        return paramInt;
      }
      else
      {
        if (paramArrayOfObject[paramInt] == Boolean.FALSE) {
          return paramInt + 1;
        }
        localFormat = this.choices[0];
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispChoiceFormat
 * JD-Core Version:    0.7.0.1
 */