package com.myriadrecord.library;
import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

import com.viewpagerindicator.CirclePageIndicator;


public class ImagesDisplayView extends RelativeLayout {
	private static final String TAG = "ImagesDisplayView";
	private ViewPager mViewPager;
	private CirclePageIndicator mCirclePageIndicator;
	private List<DisplayStruct> list;
	private DisplayFragmentPagerAdapter mDisplayFragmentPagerAdapter;
	private int currentPage = 0;
	private long time = 8000;
	private Runnable autoSwitchThread = new AutoSwitchThread();
	private boolean isTouched = false;
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
		
		mViewPager = (ViewPager) findViewById(com.myriadrecord.library.R.id.pager);
		mCirclePageIndicator = (CirclePageIndicator) findViewById(com.myriadrecord.library.R.id.indicator);
		
		mViewPager.setOnTouchListener(new OnViewPagerTouchListener(){
			
		});
	}
	
	public void init(FragmentActivity activity,List<DisplayStruct> list){
		mDisplayFragmentPagerAdapter = new DisplayFragmentPagerAdapter(activity.getSupportFragmentManager(), list);
		mViewPager.setAdapter(mDisplayFragmentPagerAdapter);
		mCirclePageIndicator.setViewPager(mViewPager);
		currentPage = 0;
		this.list = list;
	}
	
	public void startAutoSwitch(long time){
		mHandler.postDelayed(autoSwitchThread, time);
	}
	
	public void stopAutoSwitch(){
		mHandler.removeCallbacks(autoSwitchThread);
	}
	
	@Override
	public boolean isInEditMode() {
		return false;
	}
	
	public CirclePageIndicator getIndicator(){
		return mCirclePageIndicator;
	}
	
	private void nextPic(){
		mCirclePageIndicator.setCurrentItem((++currentPage)%(list.size()));
	}
	
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			nextPic();
		}
		
	};
	
	private class AutoSwitchThread implements Runnable{
		@Override
		public void run() {
			if(!isTouched)
				mHandler.sendEmptyMessage(0);
			mHandler.postDelayed(this, time);
		}
	}
	
	/**
	 * 监听 ViewPager 的触摸事件。当用户触碰到ViewPager 时，停止自动切换图片的计时，避免用户操作过程中图片被切换走。
	 */
	private class OnViewPagerTouchListener implements OnTouchListener {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN: {
				isTouched = true;
				break;
			}
			case MotionEvent.ACTION_UP: {
				isTouched = false;
				break;
			}
			}
			return false;
		}

	}

}
