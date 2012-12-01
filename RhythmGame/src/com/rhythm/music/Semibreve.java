package com.rhythm.music;

import android.graphics.Bitmap;

public class Semibreve extends Joinable {

	
	protected Semibreve(double length, int dots, type myType) {
		super(0.125, 0, myType, restImg, singleImg, injoinImg, endjoinImg);
		
	}

	@Override
	protected Bitmap getIcon() {


		
		return null;
	}

}
