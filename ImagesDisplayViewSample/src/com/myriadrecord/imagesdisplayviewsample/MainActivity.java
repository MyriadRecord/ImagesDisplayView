package com.myriadrecord.imagesdisplayviewsample;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.myriadrecord.library.DisplayStruct;
import com.myriadrecord.library.ImagesDisplayView;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<DisplayStruct> list = new ArrayList<DisplayStruct>();
		list.add(new DisplayStruct(getResources().getDrawable(android.R.drawable.ic_menu_manage)));
		list.add(new DisplayStruct(getResources().getDrawable(android.R.drawable.ic_delete)));
		list.add(new DisplayStruct(getResources().getDrawable(android.R.drawable.ic_menu_zoom)));
		
		ImagesDisplayView mImagesDisplayView = (ImagesDisplayView) findViewById(R.id.images_display);
		mImagesDisplayView.init(this,list); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
