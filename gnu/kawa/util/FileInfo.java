package gnu.kawa.util;

import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.text.Path;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileInfo
{
  static final Pattern childPat;
  static Hashtable fileMap = new Hashtable();
  static final Pattern linkPat = Pattern.compile(" href=['\"]([^'\"]*)['\"]");
  static final Pattern parentPat;
  StringBuffer beforeNavbarText;
  ByteArrayOutputStream bout;
  String[] childLinkText;
  OutPort cout;
  File file;
  FileInputStream fin;
  InPort in;
  int nchildren;
  StringBuffer newNavbarText;
  StringBuffer oldNavbarText;
  FileInfo parent;
  String parentName;
  String path;
  boolean scanned;
  boolean writeNeeded;
  
  static
  {
    childPat = Pattern.compile("<a .*</a>");
    parentPat = Pattern.compile("<ul[^>]* parent=['\"]([^'\"]*)['\"]");
  }
  
  public static FileInfo find(File paramFile)
    throws Throwable
  {
    String str = paramFile.getCanonicalPath();
    FileInfo localFileInfo = (FileInfo)fileMap.get(str);
    if (localFileInfo == null)
    {
      localFileInfo = new FileInfo();
      localFileInfo.file = paramFile;
      fileMap.put(str, localFileInfo);
    }
    return localFileInfo;
  }
  
  public void scan()
    throws Throwable
  {
    if (this.scanned) {
      return;
    }
    this.scanned = true;
    this.fin = new FileInputStream(this.file);
    this.in = new InPort(new BufferedInputStream(this.fin));
    this.oldNavbarText = new StringBuffer();
    this.newNavbarText = new StringBuffer();
    if (this.writeNeeded)
    {
      this.bout = new ByteArrayOutputStream();
      this.cout = new OutPort(this.bout);
    }
    int i = 0;
    int j = 0;
    Vector localVector = new Vector();
    label385:
    for (;;)
    {
      String str = this.in.readLine();
      if (str == null) {}
      do
      {
        String[] arrayOfString = new String[localVector.size()];
        this.nchildren = arrayOfString.length;
        localVector.copyInto(arrayOfString);
        this.childLinkText = arrayOfString;
        if (!this.writeNeeded) {
          this.in.close();
        }
        if (this.parentName == null) {
          break;
        }
        FileInfo localFileInfo = find(new File(this.file.toURI().resolve(this.parentName)));
        localFileInfo.scan();
        this.parent = localFileInfo;
        return;
        if (i == 0) {
          break label372;
        }
      } while (str.indexOf("<!--end-generated-navbar-->") >= 0);
      this.oldNavbarText.append(str);
      this.oldNavbarText.append('\n');
      if (j != 0)
      {
        if (str.indexOf("<!--end-children-toc-->") >= 0) {
          j = 0;
        }
      }
      else {
        label271:
        if (str.indexOf("<!--start-children-toc-->") >= 0) {
          j = 1;
        }
      }
      for (;;)
      {
        if ((!this.writeNeeded) || (i != 0)) {
          break label385;
        }
        this.cout.println(str);
        break;
        Matcher localMatcher1 = childPat.matcher(str);
        if (localMatcher1.find()) {
          localVector.add(localMatcher1.group());
        }
        Matcher localMatcher2 = parentPat.matcher(str);
        if ((!localMatcher2.find()) || (this.parentName != null)) {
          break label271;
        }
        this.parentName = localMatcher2.group(1);
        break label271;
        label372:
        if (str.indexOf("<!--start-generated-navbar-->") >= 0) {
          i = 1;
        }
      }
    }
  }
  
  public void write()
    throws Throwable
  {
    int i = 0;
    FileInfo localFileInfo = this;
    while (localFileInfo.parent != null)
    {
      localFileInfo = localFileInfo.parent;
      i++;
    }
    this.cout.println("<!--start-generated-navbar-->");
    writeLinks(i, this.newNavbarText);
    this.cout.print(this.newNavbarText);
    this.cout.println("<!--end-generated-navbar-->");
    for (;;)
    {
      String str = this.in.readLine();
      if (str == null)
      {
        new StringBuffer();
        this.in.close();
        if (!this.oldNavbarText.toString().equals(this.newNavbarText.toString())) {
          break;
        }
        System.err.println("fixup " + this.file + " - no change");
        return;
      }
      this.cout.println(str);
    }
    FileOutputStream localFileOutputStream = new FileOutputStream(this.file);
    localFileOutputStream.write(this.bout.toByteArray());
    localFileOutputStream.close();
    System.err.println("fixup " + this.file + " - updated");
  }
  
  public void writeLinks(int paramInt, StringBuffer paramStringBuffer)
    throws Throwable
  {
    FileInfo localFileInfo1 = this;
    FileInfo localFileInfo2 = null;
    int i = paramInt;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      localFileInfo2 = localFileInfo1;
      localFileInfo1 = localFileInfo1.parent;
    }
    if (paramInt == 0) {
      paramStringBuffer.append("<!--start-children-toc-->\n");
    }
    int j;
    label96:
    String str1;
    int k;
    if ((paramInt == 0) && (this.parentName != null))
    {
      paramStringBuffer.append("<ul parent=\"");
      paramStringBuffer.append(this.parentName);
      paramStringBuffer.append("\">\n");
      URI localURI1 = this.file.toURI();
      URI localURI2 = localFileInfo1.file.toURI();
      j = 0;
      if (j >= localFileInfo1.nchildren) {
        break label327;
      }
      str1 = localFileInfo1.childLinkText[j];
      k = 0;
      if (paramInt <= 0) {
        break label281;
      }
      Matcher localMatcher = linkPat.matcher(str1);
      localMatcher.find();
      String str2 = localMatcher.group(1);
      URI localURI3 = localURI2.resolve(str2);
      str1 = localMatcher.replaceFirst(" href=\"" + Path.relativize(localURI3.toString(), localURI1.toString()) + "\"");
      int m = str2.indexOf('#');
      if (m >= 0) {
        str2 = str2.substring(0, m);
      }
      if (find(new File(localURI2.resolve(str2))) != localFileInfo2) {
        break label275;
      }
      k = 1;
      label248:
      if ((k != 0) || (paramInt <= 1)) {
        break label281;
      }
    }
    for (;;)
    {
      j++;
      break label96;
      paramStringBuffer.append("<ul>\n");
      break;
      label275:
      k = 0;
      break label248;
      label281:
      paramStringBuffer.append("<li>");
      paramStringBuffer.append(str1);
      if (k != 0)
      {
        paramStringBuffer.append('\n');
        writeLinks(paramInt - 1, paramStringBuffer);
      }
      paramStringBuffer.append("</li>\n");
    }
    label327:
    paramStringBuffer.append("</ul>\n");
    if (paramInt == 0) {
      paramStringBuffer.append("<!--end-children-toc-->\n");
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.FileInfo
 * JD-Core Version:    0.7.0.1
 */