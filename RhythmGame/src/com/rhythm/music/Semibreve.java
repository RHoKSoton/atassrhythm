package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Semibreve extends Note 
{

	
	protected Semibreve(int dots, type myType) 
	{
		super(1, dots, myType, MainActivity.getBitmap("one_rest"), MainActivity.getBitmap("one_single"));
	}


}
