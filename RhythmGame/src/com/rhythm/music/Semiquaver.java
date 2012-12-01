package com.rhythm.music;

import com.rhythm.app.MainActivity;

public class Semiquaver extends Joinable
{

	public Semiquaver(int dots, boolean aRest)
	{
		super(0.0625, dots, aRest, MainActivity.getBitmap("sixteen_rest"), MainActivity.getBitmap("sixteen_single"), MainActivity.getBitmap("sixteen_injoin"), MainActivity.getBitmap("sixteen_endjoin"));
	}

}
