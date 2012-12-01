package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Semibreve extends Note 
{

	
	public Semibreve(int dots) 
	{
		super(1, dots, MainActivity.getBitmap("one_rest"), MainActivity.getBitmap("one_single"));
	}


}
