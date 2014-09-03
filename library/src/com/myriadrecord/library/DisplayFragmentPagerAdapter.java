package com.myriadrecord.library;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DisplayFragmentPagerAdapter extends FragmentPagerAdapter {
	private List<DisplayStruct> list;

	public DisplayFragmentPagerAdapter(FragmentManager fm,List<DisplayStruct> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int position) {
		if(null==list)
			return null;
		else{
			DisplayFragment mDisplayFragment = new DisplayFragment();
			mDisplayFragment.setDisplayStruct(list.get(position));
			return mDisplayFragment;
		}
	}

	@Override
	public int getCount() {
		return list.size();
	}

}
