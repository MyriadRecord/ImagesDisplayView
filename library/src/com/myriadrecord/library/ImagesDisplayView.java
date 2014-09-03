package com.myriadrecord.library;
import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.viewpagerindicator.CirclePageIndicator;


public class ImagesDisplayView extends RelativeLayout {
	private static final String TAG = "ImagesDisplayView";
	private ViewPager mViewPager;
	private CirclePageIndicator mCirclePageIndicator;
	private List<DisplayStruct> list;
	private DisplayFragmentPagerAdapter mDisplayFragmentPagerAdapter;
	public ImagesDisplayView(Context context) {
		super(context);
		inflate();
	}

	public ImagesDisplayView(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
		inflate();
	}
	
	public ImagesDisplayView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inflate();
	}
	
	private void inflate(){
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li;
		li = (LayoutInflater) getContext().getSystemService(infService);
		li.inflate(com.myriadrecord.library.R.layout.images_display_view, this, true);
	}
	
	public void init(FragmentActivity activity,List<DisplayStruct> list){
		mViewPager = (ViewPager) findViewById(com.myriadrecord.library.R.id.pager);
		mCirclePageIndicator = (CirclePageIndicator) findViewById(com.myriadrecord.library.R.id.indicator);
		mDisplayFragmentPagerAdapter = new DisplayFragmentPagerAdapter(activity.getSupportFragmentManager(), list);
		mViewPager.setAdapter(mDisplayFragmentPagerAdapter);
		mCirclePageIndicator.setViewPager(mViewPager);
	}
	
	@Override
	public boolean isInEditMode() {
		return false;
	}
}
