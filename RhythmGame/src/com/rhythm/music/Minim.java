package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Minim extends Note 
{

	public Minim(int dots, boolean aRest) 
	{
		super(0.5, dots, aRest, MainActivity.getBitmap("two_rest"), MainActivity.getBitmap("two_single"));
		// TODO Auto-generated constructor stub
	}


}
