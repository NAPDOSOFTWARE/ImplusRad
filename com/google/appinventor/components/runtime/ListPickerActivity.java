package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.appinventor.components.runtime.util.AnimationUtil;

public class ListPickerActivity
  extends Activity
  implements AdapterView.OnItemClickListener
{
  static int backgroundColor;
  static int itemColor;
  MyAdapter adapter;
  private String closeAnim = "";
  private ListView listView;
  EditText txtSearchBox;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    Intent localIntent = getIntent();
    if (localIntent.hasExtra(ListPicker.LIST_ACTIVITY_ANIM_TYPE)) {
      this.closeAnim = localIntent.getStringExtra(ListPicker.LIST_ACTIVITY_ANIM_TYPE);
    }
    String str2;
    if (localIntent.hasExtra(ListPicker.LIST_ACTIVITY_ORIENTATION_TYPE))
    {
      str2 = localIntent.getStringExtra(ListPicker.LIST_ACTIVITY_ORIENTATION_TYPE).toLowerCase();
      if (str2.equals("portrait")) {
        setRequestedOrientation(1);
      }
    }
    else
    {
      if (localIntent.hasExtra(ListPicker.LIST_ACTIVITY_TITLE)) {
        setTitle(localIntent.getStringExtra(ListPicker.LIST_ACTIVITY_TITLE));
      }
      if (!localIntent.hasExtra(ListPicker.LIST_ACTIVITY_ARG_NAME)) {
        break label377;
      }
      String[] arrayOfString = getIntent().getStringArrayExtra(ListPicker.LIST_ACTIVITY_ARG_NAME);
      this.listView = new ListView(this);
      this.listView.setOnItemClickListener(this);
      itemColor = localIntent.getIntExtra(ListPicker.LIST_ACTIVITY_ITEM_TEXT_COLOR, -1);
      backgroundColor = localIntent.getIntExtra(ListPicker.LIST_ACTIVITY_BACKGROUND_COLOR, -16777216);
      localLinearLayout.setBackgroundColor(backgroundColor);
      this.adapter = new MyAdapter(this, arrayOfString);
      this.listView.setAdapter(this.adapter);
      String str1 = localIntent.getStringExtra(ListPicker.LIST_ACTIVITY_SHOW_SEARCH_BAR);
      this.txtSearchBox = new EditText(this);
      this.txtSearchBox.setSingleLine(true);
      this.txtSearchBox.setWidth(-2);
      this.txtSearchBox.setPadding(10, 10, 10, 10);
      this.txtSearchBox.setHint("Search list...");
      if ((str1 == null) || (!str1.equalsIgnoreCase("true"))) {
        this.txtSearchBox.setVisibility(8);
      }
      this.txtSearchBox.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          ListPickerActivity.this.adapter.getFilter().filter(paramAnonymousCharSequence);
        }
      });
    }
    for (;;)
    {
      localLinearLayout.addView(this.txtSearchBox);
      localLinearLayout.addView(this.listView);
      setContentView(localLinearLayout);
      localLinearLayout.requestLayout();
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
      getWindow().setSoftInputMode(3);
      return;
      if (!str2.equals("landscape")) {
        break;
      }
      setRequestedOrientation(0);
      break;
      label377:
      setResult(0);
      finish();
      AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnim);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)paramAdapterView.getAdapter().getItem(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra(ListPicker.LIST_ACTIVITY_RESULT_NAME, str);
    localIntent.putExtra(ListPicker.LIST_ACTIVITY_RESULT_INDEX, paramInt + 1);
    this.closeAnim = str;
    setResult(-1, localIntent);
    finish();
    AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnim);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnim);
      return bool;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  private static class MyAdapter
    extends ArrayAdapter<String>
  {
    private final Context mContext;
    
    public MyAdapter(Context paramContext, String[] paramArrayOfString)
    {
      super(17367040, paramArrayOfString);
      this.mContext = paramContext;
    }
    
    public long getItemId(int paramInt)
    {
      return ((String)getItem(paramInt)).hashCode();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TextView localTextView = (TextView)paramView;
      if (localTextView == null) {
        localTextView = (TextView)LayoutInflater.from(this.mContext).inflate(17367043, paramViewGroup, false);
      }
      localTextView.setText((CharSequence)getItem(paramInt));
      localTextView.setTextColor(ListPickerActivity.itemColor);
      return localTextView;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ListPickerActivity
 * JD-Core Version:    0.7.0.1
 */