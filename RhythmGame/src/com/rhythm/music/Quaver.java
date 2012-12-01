package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Quaver extends Joinable
{

	public Quaver(int dots, IconType myType) 
	{
		super(0.125, dots, myType, MainActivity.getBitmap("eight_rest"), MainActivity.getBitmap("eight_single"), MainActivity.getBitmap("eight_injoin"), MainActivity.getBitmap("eight_endjoin"));
	}

}
