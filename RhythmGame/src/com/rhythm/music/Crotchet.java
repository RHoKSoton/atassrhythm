package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Crotchet extends Note 
{

	public Crotchet(int dots, boolean aRest) 
	{
		super(0.25, dots, aRest, MainActivity.getBitmap("four_rest"), MainActivity.getBitmap("four_single"));
		// TODO Auto-generated constructor stub
	}

}
