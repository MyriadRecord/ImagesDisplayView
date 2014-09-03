package com.myriadrecord.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class DisplayFragment extends Fragment {
	private DisplayStruct mDisplayStruct;
	
	public DisplayStruct getDisplayStruct() {
		return mDisplayStruct;
	}

	public void setDisplayStruct(DisplayStruct mDisplayStruct) {
		Log.v("DisplayFragment","setDisplayStruct()");
		this.mDisplayStruct = mDisplayStruct;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		Log.v("DisplayFragment","onCreateView()");
		if(null==mDisplayStruct)
			return super.onCreateView(inflater, container, savedInstanceState);
		else{
			View view = inflater.inflate(R.layout.fragment_display, container ,false);
			ImageView mImageView = (ImageView) view.findViewById(R.id.image);
			mImageView.setImageDrawable(mDisplayStruct.getDrawable());
			return view;
		}
	}
	
}
