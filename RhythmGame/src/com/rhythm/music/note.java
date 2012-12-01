package com.rhythm.music;

import android.graphics.Bitmap;

public class Note {

	protected double trueLength;
	protected double undottedLength;
	protected Bitmap icon;
	
	public Note(double length, int dots)
	{
		undottedLength = length;
		trueLength = length * (2-2^(-dots));
	}
	
	protected Bitmap getIcon(int length){
		switch(length){
		case 1 : 
			
		case 0.5 :
		
		case 0.25 :
			
			
		}
		return null;
	}
	
	
}
