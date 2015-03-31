package gnu.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipLoader
  extends ClassLoader
{
  private Vector<Object> loadedClasses;
  int size;
  ZipFile zar;
  private String zipname;
  
  public ZipLoader(String paramString)
    throws IOException
  {
    this.zipname = paramString;
    this.zar = new ZipFile(paramString);
    this.size = 0;
    Enumeration localEnumeration = this.zar.entries();
    while (localEnumeration.hasMoreElements()) {
      if (!((ZipEntry)localEnumeration.nextElement()).isDirectory()) {
        this.size = (1 + this.size);
      }
    }
    this.loadedClasses = new Vector(this.size);
  }
  
  public void close()
    throws IOException
  {
    if (this.zar != null) {
      this.zar.close();
    }
    this.zar = null;
  }
  
  public Class loadAllClasses()
    throws IOException
  {
    Enumeration localEnumeration = this.zar.entries();
    Object localObject = null;
    while (localEnumeration.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
      String str1 = localZipEntry.getName().replace('/', '.');
      String str2 = str1.substring(0, str1.length() - "/class".length());
      int i = (int)localZipEntry.getSize();
      InputStream localInputStream = this.zar.getInputStream(localZipEntry);
      byte[] arrayOfByte = new byte[i];
      new DataInputStream(localInputStream).readFully(arrayOfByte);
      Class localClass = defineClass(str2, arrayOfByte, 0, i);
      if (localObject == null) {
        localObject = localClass;
      }
      this.loadedClasses.addElement(str2);
      this.loadedClasses.addElement(localClass);
    }
    close();
    return localObject;
  }
  
  public Class loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    int i = this.loadedClasses.indexOf(paramString);
    Class localClass;
    if (i >= 0) {
      localClass = (Class)this.loadedClasses.elementAt(i + 1);
    }
    for (;;)
    {
      if (paramBoolean) {
        resolveClass(localClass);
      }
      return localClass;
      if ((this.zar == null) && (this.loadedClasses.size() == 2 * this.size))
      {
        localClass = Class.forName(paramString);
        continue;
      }
      String str = paramString.replace('.', '/') + ".class";
      ZipFile localZipFile = this.zar;
      int j = 0;
      if (localZipFile == null) {}
      ZipEntry localZipEntry;
      try
      {
        this.zar = new ZipFile(this.zipname);
        j = 1;
        localZipEntry = this.zar.getEntry(str);
        if (localZipEntry == null) {
          if (j == 0) {}
        }
      }
      catch (IOException localIOException3)
      {
        try
        {
          close();
          localClass = Class.forName(paramString);
        }
        catch (IOException localIOException2)
        {
          throw new RuntimeException("failed to close \"" + this.zipname + "\"");
        }
        localIOException3 = localIOException3;
        throw new ClassNotFoundException("IOException while loading " + str + " from ziparchive \"" + paramString + "\": " + localIOException3.toString());
      }
      try
      {
        int k = (int)localZipEntry.getSize();
        InputStream localInputStream = this.zar.getInputStream(localZipEntry);
        byte[] arrayOfByte = new byte[k];
        new DataInputStream(localInputStream).readFully(arrayOfByte);
        localClass = defineClass(paramString, arrayOfByte, 0, k);
        this.loadedClasses.addElement(paramString);
        this.loadedClasses.addElement(localClass);
        if (2 * this.size != this.loadedClasses.size()) {
          continue;
        }
        close();
      }
      catch (IOException localIOException1)
      {
        throw new ClassNotFoundException("IOException while loading " + str + " from ziparchive \"" + paramString + "\": " + localIOException1.toString());
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ZipLoader
 * JD-Core Version:    0.7.0.1
 */