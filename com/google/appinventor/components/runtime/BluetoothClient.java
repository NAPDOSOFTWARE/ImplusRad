package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@DesignerComponent(category=ComponentCategory.CONNECTIVITY, description="Bluetooth client component", iconName="images/bluetooth.png", nonVisible=true, version=5)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.BLUETOOTH, android.permission.BLUETOOTH_ADMIN")
public final class BluetoothClient
  extends BluetoothConnectionBase
{
  private static final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
  private Set<Integer> acceptableDeviceClasses;
  private final List<Component> attachedComponents = new ArrayList();
  
  public BluetoothClient(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "BluetoothClient");
  }
  
  private void connect(Object paramObject, UUID paramUUID)
    throws IOException
  {
    if ((!this.secure) && (SdkLevel.getLevel() >= 10)) {}
    for (Object localObject = BluetoothReflection.createInsecureRfcommSocketToServiceRecord(paramObject, paramUUID);; localObject = BluetoothReflection.createRfcommSocketToServiceRecord(paramObject, paramUUID))
    {
      BluetoothReflection.connectToBluetoothSocket(localObject);
      setConnection(localObject);
      Log.i(this.logTag, "Connected to Bluetooth device " + BluetoothReflection.getBluetoothDeviceAddress(paramObject) + " " + BluetoothReflection.getBluetoothDeviceName(paramObject) + ".");
      return;
    }
  }
  
  private boolean connect(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = BluetoothReflection.getBluetoothAdapter();
    if (localObject1 == null)
    {
      this.form.dispatchErrorOccurredEvent(this, paramString1, 501, new Object[0]);
      return false;
    }
    if (!BluetoothReflection.isBluetoothEnabled(localObject1))
    {
      this.form.dispatchErrorOccurredEvent(this, paramString1, 502, new Object[0]);
      return false;
    }
    int i = paramString2.indexOf(" ");
    if (i != -1) {
      paramString2 = paramString2.substring(0, i);
    }
    if (!BluetoothReflection.checkBluetoothAddress(localObject1, paramString2))
    {
      this.form.dispatchErrorOccurredEvent(this, paramString1, 503, new Object[0]);
      return false;
    }
    Object localObject2 = BluetoothReflection.getRemoteDevice(localObject1, paramString2);
    if (!BluetoothReflection.isBonded(localObject2))
    {
      this.form.dispatchErrorOccurredEvent(this, paramString1, 504, new Object[0]);
      return false;
    }
    if (!isDeviceClassAcceptable(localObject2))
    {
      this.form.dispatchErrorOccurredEvent(this, paramString1, 505, new Object[0]);
      return false;
    }
    try
    {
      UUID localUUID = UUID.fromString(paramString3);
      Disconnect();
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        connect(localObject2, localUUID);
        return true;
      }
      catch (IOException localIOException)
      {
        Disconnect();
        this.form.dispatchErrorOccurredEvent(this, paramString1, 507, new Object[0]);
      }
      localIllegalArgumentException = localIllegalArgumentException;
      this.form.dispatchErrorOccurredEvent(this, paramString1, 506, new Object[] { paramString3 });
      return false;
    }
  }
  
  private boolean isDeviceClassAcceptable(Object paramObject)
  {
    if (this.acceptableDeviceClasses == null) {
      return true;
    }
    Object localObject = BluetoothReflection.getBluetoothClass(paramObject);
    if (localObject == null) {
      return false;
    }
    int i = BluetoothReflection.getDeviceClass(localObject);
    return this.acceptableDeviceClasses.contains(Integer.valueOf(i));
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The addresses and names of paired Bluetooth devices")
  public List<String> AddressesAndNames()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BluetoothReflection.getBluetoothAdapter();
    if ((localObject1 != null) && (BluetoothReflection.isBluetoothEnabled(localObject1)))
    {
      Iterator localIterator = BluetoothReflection.getBondedDevices(localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (isDeviceClassAcceptable(localObject2))
        {
          String str1 = BluetoothReflection.getBluetoothDeviceName(localObject2);
          String str2 = BluetoothReflection.getBluetoothDeviceAddress(localObject2);
          localArrayList.add(str2 + " " + str1);
        }
      }
    }
    return localArrayList;
  }
  
  @SimpleFunction(description="Connect to the Bluetooth device with the specified address and the Serial Port Profile (SPP). Returns true if the connection was successful.")
  public boolean Connect(String paramString)
  {
    return connect("Connect", paramString, "00001101-0000-1000-8000-00805F9B34FB");
  }
  
  @SimpleFunction(description="Connect to the Bluetooth device with the specified address and UUID. Returns true if the connection was successful.")
  public boolean ConnectWithUUID(String paramString1, String paramString2)
  {
    return connect("ConnectWithUUID", paramString1, paramString2);
  }
  
  @SimpleFunction(description="Checks whether the Bluetooth device with the specified address is paired.")
  public boolean IsDevicePaired(String paramString)
  {
    Object localObject = BluetoothReflection.getBluetoothAdapter();
    if (localObject == null)
    {
      this.form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 501, new Object[0]);
      return false;
    }
    if (!BluetoothReflection.isBluetoothEnabled(localObject))
    {
      this.form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 502, new Object[0]);
      return false;
    }
    int i = paramString.indexOf(" ");
    if (i != -1) {
      paramString = paramString.substring(0, i);
    }
    if (!BluetoothReflection.checkBluetoothAddress(localObject, paramString))
    {
      this.form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 503, new Object[0]);
      return false;
    }
    return BluetoothReflection.isBonded(BluetoothReflection.getRemoteDevice(localObject, paramString));
  }
  
  boolean attachComponent(Component paramComponent, Set<Integer> paramSet)
  {
    HashSet localHashSet;
    if (this.attachedComponents.isEmpty()) {
      if (paramSet == null)
      {
        localHashSet = null;
        this.acceptableDeviceClasses = localHashSet;
      }
    }
    label25:
    do
    {
      this.attachedComponents.add(paramComponent);
      boolean bool1 = true;
      boolean bool2;
      do
      {
        do
        {
          return bool1;
          localHashSet = new HashSet(paramSet);
          break;
          if (this.acceptableDeviceClasses == null)
          {
            if (paramSet == null) {
              break label25;
            }
            return false;
          }
          bool1 = false;
        } while (paramSet == null);
        bool2 = this.acceptableDeviceClasses.containsAll(paramSet);
        bool1 = false;
      } while (!bool2);
    } while (paramSet.containsAll(this.acceptableDeviceClasses));
    return false;
  }
  
  void detachComponent(Component paramComponent)
  {
    this.attachedComponents.remove(paramComponent);
    if (this.attachedComponents.isEmpty()) {
      this.acceptableDeviceClasses = null;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.BluetoothClient
 * JD-Core Version:    0.7.0.1
 */