package com.rhythm.music;

import android.graphics.Bitmap;

public abstract class Note {
	
	enum type {INJOIN,ENDJOIN,SINGLE,REST}
	
	protected Bitmap rest;
	protected Bitmap single;

	protected type style;
	protected double trueLength;
	protected double undottedLength;
	protected Bitmap icon;
	
	protected Note(double length, int dots, type myType, Bitmap restImg, Bitmap singleImg)
	{
		undottedLength = length;
		trueLength = length * (2-2^(-dots));
		rest = restImg;
		single = singleImg;		
		style = myType;
	}
	
	protected abstract Bitmap getIcon();
	
	
}
