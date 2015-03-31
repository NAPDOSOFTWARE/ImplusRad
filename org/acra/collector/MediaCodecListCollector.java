package org.acra.collector;

import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MediaCodecListCollector
{
  private static final String[] AAC_TYPES;
  private static final String[] AVC_TYPES;
  private static final String COLOR_FORMAT_PREFIX = "COLOR_";
  private static final String[] H263_TYPES;
  private static final String[] MPEG4_TYPES = { "mp4", "mpeg4", "MP4", "MPEG4" };
  private static Class<?> codecCapabilitiesClass;
  private static Field colorFormatsField;
  private static Method getCapabilitiesForTypeMethod;
  private static Method getCodecInfoAtMethod;
  private static Method getNameMethod;
  private static Method getSupportedTypesMethod;
  private static Method isEncoderMethod;
  private static Field levelField;
  private static SparseArray<String> mAACProfileValues = new SparseArray();
  private static SparseArray<String> mAVCLevelValues;
  private static SparseArray<String> mAVCProfileValues;
  private static SparseArray<String> mColorFormatValues;
  private static SparseArray<String> mH263LevelValues;
  private static SparseArray<String> mH263ProfileValues;
  private static SparseArray<String> mMPEG4LevelValues;
  private static SparseArray<String> mMPEG4ProfileValues;
  private static Class<?> mediaCodecInfoClass;
  private static Class<?> mediaCodecListClass;
  private static Field profileField;
  private static Field profileLevelsField;
  
  static
  {
    AVC_TYPES = new String[] { "avc", "h264", "AVC", "H264" };
    H263_TYPES = new String[] { "h263", "H263" };
    AAC_TYPES = new String[] { "aac", "AAC" };
    mediaCodecListClass = null;
    getCodecInfoAtMethod = null;
    mediaCodecInfoClass = null;
    getNameMethod = null;
    isEncoderMethod = null;
    getSupportedTypesMethod = null;
    getCapabilitiesForTypeMethod = null;
    codecCapabilitiesClass = null;
    colorFormatsField = null;
    profileLevelsField = null;
    profileField = null;
    levelField = null;
    mColorFormatValues = new SparseArray();
    mAVCLevelValues = new SparseArray();
    mAVCProfileValues = new SparseArray();
    mH263LevelValues = new SparseArray();
    mH263ProfileValues = new SparseArray();
    mMPEG4LevelValues = new SparseArray();
    mMPEG4ProfileValues = new SparseArray();
    try
    {
      mediaCodecListClass = Class.forName("android.media.MediaCodecList");
      Class localClass1 = mediaCodecListClass;
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      getCodecInfoAtMethod = localClass1.getMethod("getCodecInfoAt", arrayOfClass);
      mediaCodecInfoClass = Class.forName("android.media.MediaCodecInfo");
      getNameMethod = mediaCodecInfoClass.getMethod("getName", new Class[0]);
      isEncoderMethod = mediaCodecInfoClass.getMethod("isEncoder", new Class[0]);
      getSupportedTypesMethod = mediaCodecInfoClass.getMethod("getSupportedTypes", new Class[0]);
      getCapabilitiesForTypeMethod = mediaCodecInfoClass.getMethod("getCapabilitiesForType", new Class[] { String.class });
      codecCapabilitiesClass = Class.forName("android.media.MediaCodecInfo$CodecCapabilities");
      colorFormatsField = codecCapabilitiesClass.getField("colorFormats");
      profileLevelsField = codecCapabilitiesClass.getField("profileLevels");
      Field[] arrayOfField1 = codecCapabilitiesClass.getFields();
      int i = arrayOfField1.length;
      int j = 0;
      Class localClass2;
      Field[] arrayOfField2;
      int k;
      if (j < i)
      {
        Field localField1 = arrayOfField1[j];
        if ((Modifier.isStatic(localField1.getModifiers())) && (Modifier.isFinal(localField1.getModifiers())) && (localField1.getName().startsWith("COLOR_"))) {
          mColorFormatValues.put(localField1.getInt(null), localField1.getName());
        }
      }
      else
      {
        localClass2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        arrayOfField2 = localClass2.getFields();
        k = arrayOfField2.length;
      }
      for (int m = 0;; m++) {
        if (m < k)
        {
          Field localField2 = arrayOfField2[m];
          if ((Modifier.isStatic(localField2.getModifiers())) && (Modifier.isFinal(localField2.getModifiers()))) {
            if (localField2.getName().startsWith("AVCLevel")) {
              mAVCLevelValues.put(localField2.getInt(null), localField2.getName());
            } else if (localField2.getName().startsWith("AVCProfile")) {
              mAVCProfileValues.put(localField2.getInt(null), localField2.getName());
            } else if (localField2.getName().startsWith("H263Level")) {
              mH263LevelValues.put(localField2.getInt(null), localField2.getName());
            } else if (localField2.getName().startsWith("H263Profile")) {
              mH263ProfileValues.put(localField2.getInt(null), localField2.getName());
            } else if (localField2.getName().startsWith("MPEG4Level")) {
              mMPEG4LevelValues.put(localField2.getInt(null), localField2.getName());
            } else if (localField2.getName().startsWith("MPEG4Profile")) {
              mMPEG4ProfileValues.put(localField2.getInt(null), localField2.getName());
            } else if (localField2.getName().startsWith("AAC")) {
              mAACProfileValues.put(localField2.getInt(null), localField2.getName());
            }
          }
        }
        else
        {
          profileField = localClass2.getField("profile");
          levelField = localClass2.getField("level");
          return;
          j++;
          break;
        }
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return;
    }
    catch (SecurityException localSecurityException)
    {
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  /* Error */
  public static String collecMediaCodecList()
  {
    // Byte code:
    //   0: new 229	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   7: astore_0
    //   8: getstatic 89	org/acra/collector/MediaCodecListCollector:mediaCodecListClass	Ljava/lang/Class;
    //   11: ifnull +239 -> 250
    //   14: getstatic 93	org/acra/collector/MediaCodecListCollector:mediaCodecInfoClass	Ljava/lang/Class;
    //   17: ifnull +233 -> 250
    //   20: getstatic 89	org/acra/collector/MediaCodecListCollector:mediaCodecListClass	Ljava/lang/Class;
    //   23: ldc 232
    //   25: iconst_0
    //   26: anewarray 136	java/lang/Class
    //   29: invokevirtual 151	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   32: aconst_null
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 142	java/lang/Integer
    //   43: checkcast 142	java/lang/Integer
    //   46: invokevirtual 241	java/lang/Integer:intValue	()I
    //   49: istore 4
    //   51: iconst_0
    //   52: istore 5
    //   54: iload 5
    //   56: iload 4
    //   58: if_icmpge +192 -> 250
    //   61: aload_0
    //   62: ldc 243
    //   64: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: getstatic 91	org/acra/collector/MediaCodecListCollector:getCodecInfoAtMethod	Ljava/lang/reflect/Method;
    //   71: astore 7
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: astore 8
    //   79: aload 8
    //   81: iconst_0
    //   82: iload 5
    //   84: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: aload 7
    //   90: aconst_null
    //   91: aload 8
    //   93: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   96: astore 9
    //   98: aload_0
    //   99: iload 5
    //   101: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 256
    //   107: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 95	org/acra/collector/MediaCodecListCollector:getNameMethod	Ljava/lang/reflect/Method;
    //   113: aload 9
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: ldc 243
    //   127: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: ldc_w 261
    //   135: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: getstatic 97	org/acra/collector/MediaCodecListCollector:isEncoderMethod	Ljava/lang/reflect/Method;
    //   141: aload 9
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc 243
    //   155: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: getstatic 99	org/acra/collector/MediaCodecListCollector:getSupportedTypesMethod	Ljava/lang/reflect/Method;
    //   162: aload 9
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 262	[Ljava/lang/String;
    //   174: checkcast 262	[Ljava/lang/String;
    //   177: astore 12
    //   179: aload_0
    //   180: ldc_w 264
    //   183: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 12
    //   188: invokestatic 270	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   191: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 243
    //   196: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 12
    //   202: arraylength
    //   203: istore 14
    //   205: iconst_0
    //   206: istore 15
    //   208: iload 15
    //   210: iload 14
    //   212: if_icmpge +24 -> 236
    //   215: aload_0
    //   216: aload 9
    //   218: aload 12
    //   220: iload 15
    //   222: aaload
    //   223: invokestatic 274	org/acra/collector/MediaCodecListCollector:collectCapabilitiesForType	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   226: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: iinc 15 1
    //   233: goto -25 -> 208
    //   236: aload_0
    //   237: ldc 243
    //   239: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: iinc 5 1
    //   246: goto -192 -> 54
    //   249: astore_3
    //   250: aload_0
    //   251: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: areturn
    //   255: astore_2
    //   256: goto -6 -> 250
    //   259: astore_1
    //   260: goto -10 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	244	0	localStringBuilder	StringBuilder
    //   259	1	1	localNoSuchMethodException	NoSuchMethodException
    //   255	1	2	localIllegalAccessException	IllegalAccessException
    //   249	1	3	localInvocationTargetException	InvocationTargetException
    //   49	10	4	i	int
    //   52	192	5	j	int
    //   71	18	7	localMethod	Method
    //   77	15	8	arrayOfObject	Object[]
    //   96	121	9	localObject	Object
    //   177	42	12	arrayOfString	String[]
    //   203	10	14	k	int
    //   206	25	15	m	int
    // Exception table:
    //   from	to	target	type
    //   20	51	249	java/lang/reflect/InvocationTargetException
    //   61	205	249	java/lang/reflect/InvocationTargetException
    //   215	230	249	java/lang/reflect/InvocationTargetException
    //   236	243	249	java/lang/reflect/InvocationTargetException
    //   20	51	255	java/lang/IllegalAccessException
    //   61	205	255	java/lang/IllegalAccessException
    //   215	230	255	java/lang/IllegalAccessException
    //   236	243	255	java/lang/IllegalAccessException
    //   20	51	259	java/lang/NoSuchMethodException
    //   61	205	259	java/lang/NoSuchMethodException
    //   215	230	259	java/lang/NoSuchMethodException
    //   236	243	259	java/lang/NoSuchMethodException
  }
  
  private static String collectCapabilitiesForType(Object paramObject, String paramString)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCapabilitiesForTypeMethod.invoke(paramObject, new Object[] { paramString });
    int[] arrayOfInt = (int[])colorFormatsField.get(localObject);
    if (arrayOfInt.length > 0)
    {
      localStringBuilder.append(paramString).append(" color formats:");
      for (int m = 0; m < arrayOfInt.length; m++)
      {
        localStringBuilder.append((String)mColorFormatValues.get(arrayOfInt[m]));
        if (m < -1 + arrayOfInt.length) {
          localStringBuilder.append(',');
        }
      }
      localStringBuilder.append("\n");
    }
    Object[] arrayOfObject = (Object[])profileLevelsField.get(localObject);
    if (arrayOfObject.length > 0)
    {
      localStringBuilder.append(paramString).append(" profile levels:");
      int i = 0;
      if (i < arrayOfObject.length)
      {
        CodecType localCodecType = identifyCodecType(paramObject);
        int j = profileField.getInt(arrayOfObject[i]);
        int k = levelField.getInt(arrayOfObject[i]);
        if (localCodecType == null) {
          localStringBuilder.append(j).append('-').append(k);
        }
        switch (1.$SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[localCodecType.ordinal()])
        {
        }
        for (;;)
        {
          if (i < -1 + arrayOfObject.length) {
            localStringBuilder.append(',');
          }
          i++;
          break;
          localStringBuilder.append(j).append((String)mAVCProfileValues.get(j)).append('-').append((String)mAVCLevelValues.get(k));
          continue;
          localStringBuilder.append((String)mH263ProfileValues.get(j)).append('-').append((String)mH263LevelValues.get(k));
          continue;
          localStringBuilder.append((String)mMPEG4ProfileValues.get(j)).append('-').append((String)mMPEG4LevelValues.get(k));
          continue;
          localStringBuilder.append((String)mAACProfileValues.get(j));
        }
      }
      localStringBuilder.append("\n");
    }
    return "\n";
  }
  
  private static CodecType identifyCodecType(Object paramObject)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    String str = (String)getNameMethod.invoke(paramObject, new Object[0]);
    String[] arrayOfString1 = AVC_TYPES;
    int i = arrayOfString1.length;
    for (int j = 0; j < i; j++) {
      if (str.contains(arrayOfString1[j])) {
        return CodecType.AVC;
      }
    }
    String[] arrayOfString2 = H263_TYPES;
    int k = arrayOfString2.length;
    for (int m = 0; m < k; m++) {
      if (str.contains(arrayOfString2[m])) {
        return CodecType.H263;
      }
    }
    String[] arrayOfString3 = MPEG4_TYPES;
    int n = arrayOfString3.length;
    for (int i1 = 0; i1 < n; i1++) {
      if (str.contains(arrayOfString3[i1])) {
        return CodecType.MPEG4;
      }
    }
    String[] arrayOfString4 = AAC_TYPES;
    int i2 = arrayOfString4.length;
    for (int i3 = 0; i3 < i2; i3++) {
      if (str.contains(arrayOfString4[i3])) {
        return CodecType.AAC;
      }
    }
    return null;
  }
  
  private static enum CodecType
  {
    static
    {
      AAC = new CodecType("AAC", 3);
      CodecType[] arrayOfCodecType = new CodecType[4];
      arrayOfCodecType[0] = AVC;
      arrayOfCodecType[1] = H263;
      arrayOfCodecType[2] = MPEG4;
      arrayOfCodecType[3] = AAC;
      $VALUES = arrayOfCodecType;
    }
    
    private CodecType() {}
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.MediaCodecListCollector
 * JD-Core Version:    0.7.0.1
 */