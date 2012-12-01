package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Semiquaver extends Joinable
{

	public Semiquaver(int dots, type myType)
	{
		super(0.0625, dots, myType, MainActivity.getBitmap("sixteen_rest"), MainActivity.getBitmap("sixteen_single"), MainActivity.getBitmap("sixteen_injoin"), MainActivity.getBitmap("sixteen_endjoin"));
	}

}
