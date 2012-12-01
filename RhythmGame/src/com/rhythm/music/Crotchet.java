package com.rhythm.music;

import com.rhythm.app.MainActivity;
import com.rhythm.app.Note;

public class Crotchet extends Note 
{

	public Crotchet(int dots, type myType) 
	{
		super(0.25, dots, myType, MainActivity.getBitmap("four_rest"), MainActivity.getBitmap("four_single"));
		// TODO Auto-generated constructor stub
	}

}
