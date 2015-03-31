package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.util.Log;
import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.GoogleKeyInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.fusiontables.Fusiontables;
import com.google.api.services.fusiontables.Fusiontables.Builder;
import com.google.api.services.fusiontables.Fusiontables.Query;
import com.google.api.services.fusiontables.Fusiontables.Query.Sql;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ClientLoginHelper;
import com.google.appinventor.components.runtime.util.IClientLoginHelper;
import com.google.appinventor.components.runtime.util.OAuth2Helper;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

@DesignerComponent(category=ComponentCategory.STORAGE, description="<p>A non-visible component that communicates with Google Fusion Tables. Fusion Tables let you store, share, query and visualize data tables; this component lets you query, create, and modify these tables.</p> <p>This component uses the <a href=\"https://developers.google.com/fusiontables/docs/v1/getting_started\" target=\"_blank\">Fusion Tables API V1.0</a>. <p>Applications using Fusion Tables must authentication to Google's servers. There are two ways this can be done. The first way uses an API Key which you the developer obtain (see below). With this approach end-users must also login to access a Fusion Table. The second approach is to use a Service Account. With this approach you create credentials and a special \"Service Account Email Address\" which you obtain from the <a href=\"https://code.google.com/apis/console/\" target=\"_blank\">Google APIs Console</a>. You then tell the Fusion Table Control the name of the Service Account Email address and upload the secret key as an asset to your application and set the KeyFile property to point at this file. Finally you check the \"UseServiceAuthentication\" checkbox in the designer. When using a Service Account, end-users do not need to login to use Fusion Tables, your service account authenticates all access.</p> <p>To get an API key, follow these instructions.</p> <ol><li>Go to your <a href=\"https://code.google.com/apis/console/\" target=\"_blank\">Google APIs Console</a> and login if necessary.</li><li>Select the <i>Services</i> item from the menu on the left.</li><li>Choose the <i>Fusiontables</i> service from the list provided and turn it on.</li><li>Go back to the main menu and select the <i>API Access</i> item. </li></ol><p>Your API Key will be near the bottom of that pane in the section called \"Simple API Access\".You will have to provide that key as the value for the <i>ApiKey</i> property in your Fusiontables app.</p><p>Once you have an API key, set the value of the <i>Query</i> property to a valid Fusiontables SQL query and call <i>SendQuery</i> to execute the query.  App Inventor will send the query to the Fusion Tables server and the <i>GotResult</i> block will fire when a result is returned from the server.Query results will be returned in CSV format, and can be converted to list format using the \"list from csv table\" or \"list from csv row\" blocks.</p><p>Note that you do not need to worry about UTF-encoding the query. But you do need to make sure the query follows the syntax described in <a href=\"https://developers.google.com/fusiontables/docs/v1/getting_started\" target=\"_blank\">the reference manual</a>, which means that things like capitalization for names of columns matters, and that single quotes must be used around column names if there are spaces in them.</p>", iconName="images/fusiontables.png", nonVisible=true, version=3)
@SimpleObject
@UsesLibraries(libraries="fusiontables.jar,google-api-client-beta.jar,google-api-client-android2-beta.jar,google-http-client-beta.jar,google-http-client-android2-beta.jar,google-http-client-android3-beta.jar,google-oauth-client-beta.jar,guava-14.0.1.jar,gson-2.1.jar")
@UsesPermissions(permissionNames="android.permission.INTERNET,android.permission.ACCOUNT_MANAGER,android.permission.MANAGE_ACCOUNTS,android.permission.GET_ACCOUNTS,android.permission.USE_CREDENTIALS")
public class FusiontablesControl
  extends AndroidNonvisibleComponent
  implements Component
{
  public static final String APP_NAME = "App Inventor";
  public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
  public static final String AUTH_TOKEN_TYPE_FUSIONTABLES = "oauth2:https://www.googleapis.com/auth/fusiontables";
  private static final String DEFAULT_QUERY = "show tables";
  private static final String DIALOG_TEXT = "Choose an account to access FusionTables";
  public static final String FUSIONTABLES_POST = "https://www.googleapis.com/fusiontables/v1/tables";
  public static final String FUSIONTABLES_URL = "https://www.googleapis.com/fusiontables/v1/query";
  private static final String FUSIONTABLE_SERVICE = "fusiontables";
  private static final String FUSION_QUERY_URL = "http://www.google.com/fusiontables/api/query";
  private static final String LOG_TAG = "FUSION";
  private static final int SERVER_TIMEOUT_MS = 30000;
  private final Activity activity;
  private String apiKey;
  private String authTokenType = "oauth2:https://www.googleapis.com/auth/fusiontables";
  private File cachedServiceCredentials = null;
  private final ComponentContainer container;
  private String errorMessage;
  private boolean isServiceAuth = false;
  private String keyPath = "";
  private String query;
  private String queryResultStr;
  private final IClientLoginHelper requestHelper;
  private String scope = "https://www.googleapis.com/auth/fusiontables";
  private String serviceAccountEmail = "";
  private String standardErrorMessage = "Error on Fusion Tables query";
  
  public FusiontablesControl(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.container = paramComponentContainer;
    this.activity = paramComponentContainer.$context();
    this.requestHelper = createClientLoginHelper("Choose an account to access FusionTables", "fusiontables");
    this.query = "show tables";
    if (SdkLevel.getLevel() < 5) {
      showNoticeAndDie("Sorry. The Fusiontables component is not compatible with this phone.", "This application must exit.", "Rats!");
    }
  }
  
  private IClientLoginHelper createClientLoginHelper(String paramString1, String paramString2)
  {
    if (SdkLevel.getLevel() >= 5)
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      HttpConnectionParams.setSoTimeout(localDefaultHttpClient.getParams(), 30000);
      HttpConnectionParams.setConnectionTimeout(localDefaultHttpClient.getParams(), 30000);
      return new ClientLoginHelper(this.activity, paramString2, paramString1, localDefaultHttpClient);
    }
    return null;
  }
  
  /* Error */
  private String doPostRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 225	java/lang/String:trim	()Ljava/lang/String;
    //   4: ldc 227
    //   6: invokevirtual 230	java/lang/String:length	()I
    //   9: invokevirtual 234	java/lang/String:substring	(I)Ljava/lang/String;
    //   12: astore_3
    //   13: ldc 56
    //   15: new 236	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   22: ldc 239
    //   24: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 252	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: new 254	org/apache/http/client/methods/HttpPost
    //   41: dup
    //   42: new 236	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 256
    //   52: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: invokevirtual 259	com/google/appinventor/components/runtime/FusiontablesControl:ApiKey	()Ljava/lang/String;
    //   59: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 262	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   68: astore 5
    //   70: new 264	org/apache/http/entity/StringEntity
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 265	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   78: astore 6
    //   80: aload 6
    //   82: ldc_w 267
    //   85: invokevirtual 270	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   88: aload 5
    //   90: ldc_w 272
    //   93: new 236	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   100: ldc 32
    //   102: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_2
    //   106: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 276	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: aload 6
    //   119: invokevirtual 280	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   122: new 188	org/apache/http/impl/client/DefaultHttpClient
    //   125: dup
    //   126: invokespecial 191	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   129: astore 7
    //   131: aload 7
    //   133: aload 5
    //   135: invokeinterface 284 2 0
    //   140: astore 10
    //   142: aload 10
    //   144: invokeinterface 290 1 0
    //   149: invokeinterface 295 1 0
    //   154: istore 11
    //   156: aload 10
    //   158: ifnull +316 -> 474
    //   161: iload 11
    //   163: sipush 200
    //   166: if_icmpne +308 -> 474
    //   169: aload 10
    //   171: invokestatic 299	com/google/appinventor/components/runtime/FusiontablesControl:httpApacheResponseToString	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   174: astore 15
    //   176: new 301	org/json/JSONObject
    //   179: dup
    //   180: aload 15
    //   182: invokespecial 302	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: astore 16
    //   187: aload 16
    //   189: ldc_w 304
    //   192: invokevirtual 308	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: ifeq +206 -> 401
    //   198: aload_0
    //   199: new 236	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 310
    //   209: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 16
    //   214: ldc_w 304
    //   217: invokevirtual 314	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   220: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: putfield 171	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   229: ldc 56
    //   231: new 236	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 319
    //   241: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 10
    //   246: invokeinterface 290 1 0
    //   251: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 252	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   260: pop
    //   261: ldc 56
    //   263: new 236	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 321
    //   273: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 323
    //   283: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: getfield 171	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   290: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 252	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   299: pop
    //   300: aload_0
    //   301: getfield 171	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   304: areturn
    //   305: astore 19
    //   307: aload 19
    //   309: invokevirtual 326	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   312: new 236	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 328
    //   322: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 19
    //   327: invokevirtual 331	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: areturn
    //   337: astore 9
    //   339: aload 9
    //   341: invokevirtual 332	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   344: new 236	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 328
    //   354: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 9
    //   359: invokevirtual 333	org/apache/http/client/ClientProtocolException:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: areturn
    //   369: astore 8
    //   371: aload 8
    //   373: invokevirtual 334	java/io/IOException:printStackTrace	()V
    //   376: new 236	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 328
    //   386: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 8
    //   391: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   394: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: areturn
    //   401: aload_0
    //   402: aload 15
    //   404: putfield 171	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   407: goto -178 -> 229
    //   410: astore 14
    //   412: aload 14
    //   414: invokevirtual 336	java/lang/IllegalStateException:printStackTrace	()V
    //   417: new 236	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 328
    //   427: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 14
    //   432: invokevirtual 337	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   435: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: areturn
    //   442: astore 13
    //   444: aload 13
    //   446: invokevirtual 338	org/json/JSONException:printStackTrace	()V
    //   449: new 236	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 328
    //   459: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 13
    //   464: invokevirtual 339	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   467: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: areturn
    //   474: ldc 56
    //   476: new 236	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 328
    //   486: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 10
    //   491: invokeinterface 290 1 0
    //   496: invokevirtual 342	java/lang/Object:toString	()Ljava/lang/String;
    //   499: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 252	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   508: pop
    //   509: aload_0
    //   510: aload 10
    //   512: invokeinterface 290 1 0
    //   517: invokevirtual 342	java/lang/Object:toString	()Ljava/lang/String;
    //   520: putfield 171	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   523: goto -223 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	this	FusiontablesControl
    //   0	526	1	paramString1	String
    //   0	526	2	paramString2	String
    //   12	63	3	str1	String
    //   68	66	5	localHttpPost	HttpPost
    //   78	40	6	localStringEntity	org.apache.http.entity.StringEntity
    //   129	3	7	localDefaultHttpClient	DefaultHttpClient
    //   369	21	8	localIOException	IOException
    //   337	21	9	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   140	371	10	localHttpResponse	org.apache.http.HttpResponse
    //   154	13	11	i	int
    //   442	21	13	localJSONException	org.json.JSONException
    //   410	21	14	localIllegalStateException	java.lang.IllegalStateException
    //   174	229	15	str2	String
    //   185	28	16	localJSONObject	org.json.JSONObject
    //   305	21	19	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   70	80	305	java/io/UnsupportedEncodingException
    //   131	142	337	org/apache/http/client/ClientProtocolException
    //   131	142	369	java/io/IOException
    //   169	229	410	java/lang/IllegalStateException
    //   401	407	410	java/lang/IllegalStateException
    //   169	229	442	org/json/JSONException
    //   401	407	442	org/json/JSONException
  }
  
  private HttpUriRequest genFusiontablesQuery(String paramString)
    throws IOException
  {
    HttpPost localHttpPost = new HttpPost("http://www.google.com/fusiontables/api/query");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new BasicNameValuePair("sql", paramString));
    UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList, "UTF-8");
    localUrlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
    localHttpPost.setEntity(localUrlEncodedFormEntity);
    return localHttpPost;
  }
  
  public static String httpApacheResponseToString(org.apache.http.HttpResponse paramHttpResponse)
  {
    String str1 = "";
    if (paramHttpResponse != null)
    {
      if (paramHttpResponse.getStatusLine().getStatusCode() != 200) {
        str1 = paramHttpResponse.getStatusLine().getStatusCode() + " " + paramHttpResponse.getStatusLine().getReasonPhrase();
      }
    }
    else {
      return str1;
    }
    try
    {
      String str2 = parseResponse(paramHttpResponse.getEntity().getContent());
      return str2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str1;
  }
  
  public static String httpResponseToString(com.google.api.client.http.HttpResponse paramHttpResponse)
  {
    String str1 = "";
    if (paramHttpResponse != null)
    {
      if (paramHttpResponse.getStatusCode() != 200) {
        str1 = paramHttpResponse.getStatusCode() + " " + paramHttpResponse.getStatusMessage();
      }
    }
    else {
      return str1;
    }
    try
    {
      String str2 = parseResponse(paramHttpResponse.getContent());
      return str2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str1;
  }
  
  public static String parseResponse(InputStream paramInputStream)
  {
    String str1 = "";
    BufferedReader localBufferedReader;
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        localStringBuilder.append(str2 + "\n");
      }
      str1 = localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return str1;
    }
    Log.i("FUSION", "resultStr = " + str1);
    localBufferedReader.close();
    return str1;
  }
  
  private String parseSqlCreateQueryToJson(String paramString)
  {
    Log.i("FUSION", "parsetoJSonSqlCreate :" + paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = paramString.trim();
    String str2 = str1.substring("create table".length(), str1.indexOf('(')).trim();
    String[] arrayOfString1 = str1.substring(1 + str1.indexOf('('), str1.indexOf(')')).split(",");
    localStringBuilder.append("{'columns':[");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString2 = arrayOfString1[i].split(":");
      localStringBuilder.append("{'name': '" + arrayOfString2[0].trim() + "', 'type': '" + arrayOfString2[1].trim() + "'}");
      if (i < -1 + arrayOfString1.length) {
        localStringBuilder.append(",");
      }
    }
    localStringBuilder.append("],");
    localStringBuilder.append("'isExportable':'true',");
    localStringBuilder.append("'name': '" + str2 + "'");
    localStringBuilder.append("}");
    localStringBuilder.insert(0, "CREATE TABLE ");
    Log.i("FUSION", "result = " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  private void showNoticeAndDie(String paramString1, String paramString2, String paramString3)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.activity).create();
    localAlertDialog.setTitle(paramString2);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setMessage(paramString1);
    localAlertDialog.setButton(paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FusiontablesControl.this.activity.finish();
      }
    });
    localAlertDialog.show();
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Your Google API Key. For help, click on the questionmark (?) next to the FusiontablesControl component in the Palette. ")
  public String ApiKey()
  {
    return this.apiKey;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ApiKey(String paramString)
  {
    this.apiKey = paramString;
  }
  
  @SimpleFunction(description="DEPRECATED. This block is deprecated as of the end of 2012.  Use SendQuery.")
  public void DoQuery()
  {
    if (this.requestHelper != null)
    {
      QueryProcessor localQueryProcessor = new QueryProcessor(null);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.query;
      localQueryProcessor.execute(arrayOfString);
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "DoQuery", 3, new Object[0]);
  }
  
  @SimpleFunction(description="Forget end-users login credentials. Has no effect on service authentication")
  public void ForgetLogin()
  {
    OAuth2Helper.resetAccountCredential(this.activity);
  }
  
  @SimpleFunction(description="Gets all the rows from a specified fusion table. The tableId field is the id of therequired fusion table. The columns field is a comma-separeted list of the columns to retrieve.")
  public void GetRows(String paramString1, String paramString2)
  {
    this.query = ("SELECT " + paramString2 + " FROM " + paramString1);
    QueryProcessorV1 localQueryProcessorV1 = new QueryProcessorV1(this.activity);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.query;
    localQueryProcessorV1.execute(arrayOfString);
  }
  
  @SimpleFunction(description="Gets all the rows from a fusion table that meet certain conditions. The tableId field isthe id of the required fusion table. The columns field is a comma-separeted list of the columns toretrieve. The conditions field specifies what rows to retrieve from the table, for example the rows in whicha particular column value is not null.")
  public void GetRowsWithConditions(String paramString1, String paramString2, String paramString3)
  {
    this.query = ("SELECT " + paramString2 + " FROM " + paramString1 + " WHERE " + paramString3);
    QueryProcessorV1 localQueryProcessorV1 = new QueryProcessorV1(this.activity);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.query;
    localQueryProcessorV1.execute(arrayOfString);
  }
  
  @SimpleEvent(description="Indicates that the Fusion Tables query has finished processing, with a result.  The result of the query will generally be returned in CSV format, and can be converted to list format using the \"list from csv table\" or \"list from csv row\" blocks.")
  public void GotResult(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "GotResult", new Object[] { paramString });
  }
  
  @SimpleFunction(description="Inserts a row into the specified fusion table. The tableId field is the id of thefusion table. The columns is a comma-separated list of the columns to insert values into. The values field specifies what values to insert into each column.")
  public void InsertRow(String paramString1, String paramString2, String paramString3)
  {
    this.query = ("INSERT INTO " + paramString1 + " (" + paramString2 + ")" + " VALUES " + "(" + paramString3 + ")");
    QueryProcessorV1 localQueryProcessorV1 = new QueryProcessorV1(this.activity);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.query;
    localQueryProcessorV1.execute(arrayOfString);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Specifies the path of the private key file.  This key file is used to get access to the FusionTables API.")
  public String KeyFile()
  {
    return this.keyPath;
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty
  public void KeyFile(String paramString)
  {
    if (paramString.equals(this.keyPath)) {
      return;
    }
    if (this.cachedServiceCredentials != null)
    {
      this.cachedServiceCredentials.delete();
      this.cachedServiceCredentials = null;
    }
    if (paramString == null) {
      paramString = "";
    }
    this.keyPath = paramString;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The query to send to the Fusion Tables API. <p>For legal query formats and examples, see the <a href=\"https://developers.google.com/fusiontables/docs/v1/getting_started\" target=\"_blank\">Fusion Tables API v1.0 reference manual</a>.</p> <p>Note that you do not need to worry about UTF-encoding the query. But you do need to make sure it follows the syntax described in the reference manual, which means that things like capitalization for names of columns matters, and that single quotes need to be used around column names if there are spaces in them.</p> ")
  public String Query()
  {
    return this.query;
  }
  
  @DesignerProperty(defaultValue="show tables", editorType="string")
  @SimpleProperty
  public void Query(String paramString)
  {
    this.query = paramString;
  }
  
  @SimpleFunction(description="Send the query to the Fusiontables server.")
  public void SendQuery()
  {
    QueryProcessorV1 localQueryProcessorV1 = new QueryProcessorV1(this.activity);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.query;
    localQueryProcessorV1.execute(arrayOfString);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The Service Account Email Address when service account authentication is in use.")
  public String ServiceAccountEmail()
  {
    return this.serviceAccountEmail;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ServiceAccountEmail(String paramString)
  {
    this.serviceAccountEmail = paramString;
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void UseServiceAuthentication(boolean paramBoolean)
  {
    this.isServiceAuth = paramBoolean;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Indicates whether a service account should be used for authentication")
  public boolean UseServiceAuthentication()
  {
    return this.isServiceAuth;
  }
  
  public void handleOAuthError(String paramString)
  {
    Log.i("FUSION", "handleOAuthError: " + paramString);
    this.errorMessage = paramString;
  }
  
  public com.google.api.client.http.HttpResponse sendQuery(String paramString1, String paramString2)
  {
    Log.i("FUSION", "executing " + paramString1);
    Fusiontables localFusiontables = new Fusiontables.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), new GoogleCredential()).setApplicationName("App Inventor Fusiontables/v1.0").setJsonHttpRequestInitializer(new GoogleKeyInitializer(ApiKey())).build();
    try
    {
      Fusiontables.Query.Sql localSql = localFusiontables.query().sql(paramString1);
      localSql.put("alt", "csv");
      localSql.setOauthToken(paramString2);
      com.google.api.client.http.HttpResponse localHttpResponse = localSql.executeUnparsed();
      return localHttpResponse;
    }
    catch (GoogleJsonResponseException localGoogleJsonResponseException)
    {
      localGoogleJsonResponseException.printStackTrace();
      this.errorMessage = localGoogleJsonResponseException.getMessage();
      Log.e("FUSION", "JsonResponseException");
      Log.e("FUSION", "e.getMessage() is " + localGoogleJsonResponseException.getMessage());
      Log.e("FUSION", "response is " + null);
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      this.errorMessage = localIOException.getMessage();
      Log.e("FUSION", "IOException");
      Log.e("FUSION", "e.getMessage() is " + localIOException.getMessage());
      Log.e("FUSION", "response is " + null);
    }
    return null;
  }
  
  void signalJsonResponseError(String paramString1, String paramString2)
  {
    this.form.dispatchErrorOccurredEventDialog(this, "SendQuery", 2601, new Object[] { paramString1, paramString2 });
  }
  
  private class QueryProcessor
    extends AsyncTask<String, Void, String>
  {
    private ProgressDialog progress = null;
    
    private QueryProcessor() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      try
      {
        HttpUriRequest localHttpUriRequest = FusiontablesControl.this.genFusiontablesQuery(paramVarArgs[0]);
        Log.d("FUSION", "Fetching: " + paramVarArgs[0]);
        org.apache.http.HttpResponse localHttpResponse = FusiontablesControl.this.requestHelper.execute(localHttpUriRequest);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localHttpResponse.getEntity().writeTo(localByteArrayOutputStream);
        Log.d("FUSION", "Response: " + localHttpResponse.getStatusLine().toString());
        String str = localByteArrayOutputStream.toString();
        return str;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return localIOException.getMessage();
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      this.progress.dismiss();
      FusiontablesControl.this.GotResult(paramString);
    }
    
    protected void onPreExecute()
    {
      this.progress = ProgressDialog.show(FusiontablesControl.this.activity, "Fusiontables", "processing query...", true);
    }
  }
  
  private class QueryProcessorV1
    extends AsyncTask<String, Void, String>
  {
    private static final String STAG = "FUSION_SERVICE_ACCOUNT";
    private static final String TAG = "QueryProcessorV1";
    private final Activity activity;
    private final ProgressDialog dialog;
    
    QueryProcessorV1(Activity paramActivity)
    {
      Log.i("QueryProcessorV1", "Creating AsyncFusiontablesQuery");
      this.activity = paramActivity;
      this.dialog = new ProgressDialog(paramActivity);
    }
    
    /* Error */
    private String serviceAuthRequest(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   4: ldc 52
      //   6: invokestatic 58	com/google/appinventor/components/runtime/FusiontablesControl:access$502	(Lcom/google/appinventor/components/runtime/FusiontablesControl;Ljava/lang/String;)Ljava/lang/String;
      //   9: pop
      //   10: invokestatic 64	com/google/api/client/extensions/android2/AndroidHttp:newCompatibleTransport	()Lcom/google/api/client/http/HttpTransport;
      //   13: astore_3
      //   14: new 66	com/google/api/client/json/gson/GsonFactory
      //   17: dup
      //   18: invokespecial 67	com/google/api/client/json/gson/GsonFactory:<init>	()V
      //   21: astore 4
      //   23: ldc 9
      //   25: new 69	java/lang/StringBuilder
      //   28: dup
      //   29: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   32: ldc 72
      //   34: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: aload_0
      //   38: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   41: invokestatic 80	com/google/appinventor/components/runtime/FusiontablesControl:access$1000	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   44: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   50: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   53: pop
      //   54: aload_0
      //   55: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   58: invokestatic 88	com/google/appinventor/components/runtime/FusiontablesControl:access$1100	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/io/File;
      //   61: ifnonnull +33 -> 94
      //   64: aload_0
      //   65: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   68: aload_0
      //   69: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   72: invokestatic 92	com/google/appinventor/components/runtime/FusiontablesControl:access$1200	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Lcom/google/appinventor/components/runtime/ComponentContainer;
      //   75: invokeinterface 98 1 0
      //   80: aload_0
      //   81: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   84: invokestatic 80	com/google/appinventor/components/runtime/FusiontablesControl:access$1000	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   87: invokestatic 104	com/google/appinventor/components/runtime/util/MediaUtil:copyMediaToTempFile	(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)Ljava/io/File;
      //   90: invokestatic 108	com/google/appinventor/components/runtime/FusiontablesControl:access$1102	(Lcom/google/appinventor/components/runtime/FusiontablesControl;Ljava/io/File;)Ljava/io/File;
      //   93: pop
      //   94: new 110	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder
      //   97: dup
      //   98: invokespecial 111	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:<init>	()V
      //   101: aload_3
      //   102: invokevirtual 115	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:setTransport	(Lcom/google/api/client/http/HttpTransport;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder;
      //   105: aload 4
      //   107: invokevirtual 119	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:setJsonFactory	(Lcom/google/api/client/json/JsonFactory;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder;
      //   110: aload_0
      //   111: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   114: invokestatic 122	com/google/appinventor/components/runtime/FusiontablesControl:access$1400	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   117: invokevirtual 126	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:setServiceAccountId	(Ljava/lang/String;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder;
      //   120: astore 10
      //   122: iconst_1
      //   123: anewarray 128	java/lang/String
      //   126: astore 11
      //   128: aload 11
      //   130: iconst_0
      //   131: aload_0
      //   132: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   135: invokestatic 131	com/google/appinventor/components/runtime/FusiontablesControl:access$1300	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   138: aastore
      //   139: new 133	com/google/api/services/fusiontables/Fusiontables$Builder
      //   142: dup
      //   143: aload_3
      //   144: aload 4
      //   146: aload 10
      //   148: aload 11
      //   150: invokevirtual 137	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:setServiceAccountScopes	([Ljava/lang/String;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder;
      //   153: aload_0
      //   154: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   157: invokestatic 88	com/google/appinventor/components/runtime/FusiontablesControl:access$1100	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/io/File;
      //   160: invokevirtual 141	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:setServiceAccountPrivateKeyFromP12File	(Ljava/io/File;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder;
      //   163: invokevirtual 145	com/google/api/client/googleapis/auth/oauth2/GoogleCredential$Builder:build	()Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      //   166: invokespecial 148	com/google/api/services/fusiontables/Fusiontables$Builder:<init>	(Lcom/google/api/client/http/HttpTransport;Lcom/google/api/client/json/JsonFactory;Lcom/google/api/client/http/HttpRequestInitializer;)V
      //   169: new 150	com/google/api/client/googleapis/services/GoogleKeyInitializer
      //   172: dup
      //   173: aload_0
      //   174: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   177: invokevirtual 153	com/google/appinventor/components/runtime/FusiontablesControl:ApiKey	()Ljava/lang/String;
      //   180: invokespecial 156	com/google/api/client/googleapis/services/GoogleKeyInitializer:<init>	(Ljava/lang/String;)V
      //   183: invokevirtual 160	com/google/api/services/fusiontables/Fusiontables$Builder:setJsonHttpRequestInitializer	(Lcom/google/api/client/http/json/JsonHttpRequestInitializer;)Lcom/google/api/services/fusiontables/Fusiontables$Builder;
      //   186: invokevirtual 163	com/google/api/services/fusiontables/Fusiontables$Builder:build	()Lcom/google/api/services/fusiontables/Fusiontables;
      //   189: invokevirtual 169	com/google/api/services/fusiontables/Fusiontables:query	()Lcom/google/api/services/fusiontables/Fusiontables$Query;
      //   192: aload_1
      //   193: invokevirtual 175	com/google/api/services/fusiontables/Fusiontables$Query:sql	(Ljava/lang/String;)Lcom/google/api/services/fusiontables/Fusiontables$Query$Sql;
      //   196: astore 12
      //   198: aload 12
      //   200: ldc 177
      //   202: ldc 179
      //   204: invokevirtual 185	com/google/api/services/fusiontables/Fusiontables$Query$Sql:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   207: pop
      //   208: aload 12
      //   210: invokevirtual 189	com/google/api/services/fusiontables/Fusiontables$Query$Sql:executeUnparsed	()Lcom/google/api/client/http/HttpResponse;
      //   213: astore 29
      //   215: aload 29
      //   217: astore 21
      //   219: aload 21
      //   221: ifnull +296 -> 517
      //   224: aload_0
      //   225: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   228: aload 21
      //   230: invokestatic 193	com/google/appinventor/components/runtime/FusiontablesControl:httpResponseToString	(Lcom/google/api/client/http/HttpResponse;)Ljava/lang/String;
      //   233: invokestatic 58	com/google/appinventor/components/runtime/FusiontablesControl:access$502	(Lcom/google/appinventor/components/runtime/FusiontablesControl;Ljava/lang/String;)Ljava/lang/String;
      //   236: pop
      //   237: ldc 9
      //   239: new 69	java/lang/StringBuilder
      //   242: dup
      //   243: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   246: ldc 195
      //   248: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   251: aload_1
      //   252: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   255: ldc 197
      //   257: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: aload_0
      //   261: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   264: invokestatic 200	com/google/appinventor/components/runtime/FusiontablesControl:access$500	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   267: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   276: pop
      //   277: ldc 9
      //   279: ldc 202
      //   281: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   284: pop
      //   285: ldc 9
      //   287: new 69	java/lang/StringBuilder
      //   290: dup
      //   291: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   294: ldc 204
      //   296: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   299: aload_0
      //   300: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   303: invokestatic 200	com/google/appinventor/components/runtime/FusiontablesControl:access$500	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   306: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   309: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   312: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   315: pop
      //   316: aload_0
      //   317: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   320: invokestatic 200	com/google/appinventor/components/runtime/FusiontablesControl:access$500	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   323: areturn
      //   324: astore 27
      //   326: ldc 9
      //   328: ldc 206
      //   330: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   333: pop
      //   334: aload_0
      //   335: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   338: aload_1
      //   339: aload_0
      //   340: aload 27
      //   342: invokevirtual 209	com/google/api/client/googleapis/json/GoogleJsonResponseException:getMessage	()Ljava/lang/String;
      //   345: invokevirtual 212	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:parseJsonResponseException	(Ljava/lang/String;)Ljava/lang/String;
      //   348: invokevirtual 216	com/google/appinventor/components/runtime/FusiontablesControl:signalJsonResponseError	(Ljava/lang/String;Ljava/lang/String;)V
      //   351: aconst_null
      //   352: astore 21
      //   354: goto -135 -> 219
      //   357: astore 6
      //   359: ldc 9
      //   361: ldc 218
      //   363: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   366: pop
      //   367: aload 6
      //   369: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
      //   372: aload_0
      //   373: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   376: aload 6
      //   378: invokevirtual 222	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   381: invokestatic 58	com/google/appinventor/components/runtime/FusiontablesControl:access$502	(Lcom/google/appinventor/components/runtime/FusiontablesControl;Ljava/lang/String;)Ljava/lang/String;
      //   384: pop
      //   385: goto -100 -> 285
      //   388: astore 14
      //   390: ldc 9
      //   392: ldc 224
      //   394: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   397: pop
      //   398: ldc 9
      //   400: new 69	java/lang/StringBuilder
      //   403: dup
      //   404: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   407: ldc 226
      //   409: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   412: aload 14
      //   414: invokevirtual 232	java/lang/Object:getClass	()Ljava/lang/Class;
      //   417: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   420: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   423: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   426: pop
      //   427: ldc 9
      //   429: new 69	java/lang/StringBuilder
      //   432: dup
      //   433: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   436: ldc 237
      //   438: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   441: aload 14
      //   443: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   446: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   449: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   452: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   455: pop
      //   456: ldc 9
      //   458: new 69	java/lang/StringBuilder
      //   461: dup
      //   462: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   465: ldc 240
      //   467: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   470: aload 14
      //   472: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   475: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   478: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   481: pop
      //   482: ldc 9
      //   484: ldc 242
      //   486: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   489: pop
      //   490: ldc 9
      //   492: ldc 244
      //   494: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   497: pop
      //   498: aload_0
      //   499: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   502: aload_1
      //   503: aload 14
      //   505: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   508: invokevirtual 216	com/google/appinventor/components/runtime/FusiontablesControl:signalJsonResponseError	(Ljava/lang/String;Ljava/lang/String;)V
      //   511: aconst_null
      //   512: astore 21
      //   514: goto -295 -> 219
      //   517: aload_0
      //   518: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   521: aload_0
      //   522: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   525: invokestatic 247	com/google/appinventor/components/runtime/FusiontablesControl:access$900	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   528: invokestatic 58	com/google/appinventor/components/runtime/FusiontablesControl:access$502	(Lcom/google/appinventor/components/runtime/FusiontablesControl;Ljava/lang/String;)Ljava/lang/String;
      //   531: pop
      //   532: ldc 9
      //   534: new 69	java/lang/StringBuilder
      //   537: dup
      //   538: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   541: ldc 249
      //   543: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   546: aload_0
      //   547: getfield 22	com/google/appinventor/components/runtime/FusiontablesControl$QueryProcessorV1:this$0	Lcom/google/appinventor/components/runtime/FusiontablesControl;
      //   550: invokestatic 247	com/google/appinventor/components/runtime/FusiontablesControl:access$900	(Lcom/google/appinventor/components/runtime/FusiontablesControl;)Ljava/lang/String;
      //   553: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   556: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   559: invokestatic 33	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   562: pop
      //   563: goto -286 -> 277
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	566	0	this	QueryProcessorV1
      //   0	566	1	paramString	String
      //   13	131	3	localHttpTransport	com.google.api.client.http.HttpTransport
      //   21	124	4	localGsonFactory	GsonFactory
      //   357	20	6	localThrowable	java.lang.Throwable
      //   120	27	10	localBuilder	com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder
      //   126	23	11	arrayOfString	String[]
      //   196	13	12	localSql	Fusiontables.Query.Sql
      //   388	116	14	localException	java.lang.Exception
      //   217	296	21	localHttpResponse1	com.google.api.client.http.HttpResponse
      //   324	17	27	localGoogleJsonResponseException	GoogleJsonResponseException
      //   213	3	29	localHttpResponse2	com.google.api.client.http.HttpResponse
      // Exception table:
      //   from	to	target	type
      //   208	215	324	com/google/api/client/googleapis/json/GoogleJsonResponseException
      //   54	94	357	java/lang/Throwable
      //   94	208	357	java/lang/Throwable
      //   208	215	357	java/lang/Throwable
      //   224	277	357	java/lang/Throwable
      //   277	285	357	java/lang/Throwable
      //   326	351	357	java/lang/Throwable
      //   390	511	357	java/lang/Throwable
      //   517	563	357	java/lang/Throwable
      //   208	215	388	java/lang/Exception
    }
    
    private String userAuthRequest(String paramString)
    {
      FusiontablesControl.access$502(FusiontablesControl.this, "");
      String str = new OAuth2Helper().getRefreshedAuthToken(this.activity, FusiontablesControl.this.authTokenType);
      if (str != null)
      {
        if (paramString.toLowerCase().contains("create table"))
        {
          FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.this.doPostRequest(FusiontablesControl.access$700(FusiontablesControl.this, paramString), str));
          return FusiontablesControl.this.queryResultStr;
        }
        com.google.api.client.http.HttpResponse localHttpResponse = FusiontablesControl.this.sendQuery(paramString, str);
        if (localHttpResponse != null)
        {
          FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.httpResponseToString(localHttpResponse));
          Log.i("QueryProcessorV1", "Query = " + paramString + "\nResultStr = " + FusiontablesControl.this.queryResultStr);
        }
        for (;;)
        {
          return FusiontablesControl.this.queryResultStr;
          FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.this.standardErrorMessage);
          Log.i("QueryProcessorV1", "Error:  " + FusiontablesControl.this.standardErrorMessage);
        }
      }
      return OAuth2Helper.getErrorMessage();
    }
    
    protected String doInBackground(String... paramVarArgs)
    {
      String str = paramVarArgs[0];
      Log.i("QueryProcessorV1", "Starting doInBackground " + str);
      if (FusiontablesControl.this.isServiceAuth) {
        return serviceAuthRequest(str);
      }
      return userAuthRequest(str);
    }
    
    protected void onPostExecute(String paramString)
    {
      Log.i("FUSION", "Query result " + paramString);
      if (paramString == null) {
        paramString = FusiontablesControl.this.errorMessage;
      }
      this.dialog.dismiss();
      FusiontablesControl.this.GotResult(paramString);
    }
    
    protected void onPreExecute()
    {
      this.dialog.setMessage("Fusiontables...");
      this.dialog.show();
    }
    
    String parseJsonResponseException(String paramString)
    {
      Log.i("FUSION_SERVICE_ACCOUNT", "parseJsonResponseException: " + paramString);
      return paramString;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.FusiontablesControl
 * JD-Core Version:    0.7.0.1
 */