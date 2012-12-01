package com.rhythm.music;

import com.rhythm.app.MainActivity;
import com.rhythm.app.Note;

public class Minim extends Note 
{

	protected Minim(int dots, type myType) 
	{
		super(0.5, dots, myType, MainActivity.getBitmap("two_rest"), MainActivity.getBitmap("two_single"));
		// TODO Auto-generated constructor stub
	}


}
