package com.rhythm.music;

import android.graphics.Bitmap;

public abstract class Joinable extends Note {

	protected Bitmap injoin;
	protected Bitmap endjoin;
	
	
	protected Joinable(double length, int dots, type myType, Bitmap restImg, Bitmap singleImg, Bitmap injoinImg, Bitmap endjoinImg) {
		super(length, dots, myType, restImg, singleImg);
		// TODO Auto-generated constructor stub
		injoin = injoinImg;
		endjoin = endjoinImg;
	}

	@Override
	protected abstract Bitmap getIcon();

}
