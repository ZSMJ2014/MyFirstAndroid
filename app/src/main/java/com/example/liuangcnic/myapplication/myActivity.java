package com.example.liuangcnic.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.List;


public class myActivity extends ActionBarActivity {

    public static final String MESSAGEEXTRA = "com.example.liuangcnic.myapplication.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view){
        Intent intent=new Intent(this,DisplayMessage.class);
        EditText editText=(EditText)findViewById(R.id.edit_message);
        String message=editText.getText().toString();
        intent.putExtra(MESSAGEEXTRA,message);
        startActivity(intent);
    }
    public void showLocation(View view){
        Uri location=Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent=new Intent(Intent.ACTION_VIEW,location);

        PackageManager packageManager=getPackageManager();
        List<ResolveInfo> activities=packageManager.queryIntentActivities(mapIntent,0);
        boolean isIntentSafe=activities.size()>0;
        if(isIntentSafe){
            startActivity(mapIntent);
        }
    }
}
