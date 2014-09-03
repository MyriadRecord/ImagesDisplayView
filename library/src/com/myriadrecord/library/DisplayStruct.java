package com.myriadrecord.library;

import android.content.Intent;
import android.graphics.drawable.Drawable;

public class DisplayStruct {
	private Drawable mDrawable;
	private Intent mIntent;
	private String title;
	
	public DisplayStruct(Drawable mDrawable){
		this.mDrawable = mDrawable;
	}
	
	public DisplayStruct(Drawable mDrawable, Intent mIntent) {
		this.mDrawable = mDrawable;
		this.mIntent = mIntent;
	}
	
	public DisplayStruct(Drawable mDrawable, String title) {
		this.mDrawable = mDrawable;
		this.title = title;
	}
	
	public DisplayStruct(Drawable mDrawable, Intent mIntent, String title) {
		this.mDrawable = mDrawable;
		this.mIntent = mIntent;
		this.title = title;
	}

	public Drawable getDrawable() {
		return mDrawable;
	}

	public void setDrawable(Drawable mDrawable) {
		this.mDrawable = mDrawable;
	}

	public Intent getIntent() {
		return mIntent;
	}

	public void setIntent(Intent mIntent) {
		this.mIntent = mIntent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
