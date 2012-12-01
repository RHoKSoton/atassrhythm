package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Semibreve extends Note 
{

	
	public Semibreve(int dots, boolean aRest) 
	{
		super(1, dots, aRest, MainActivity.getBitmap("one_rest"), MainActivity.getBitmap("one_single"));
	}


}
