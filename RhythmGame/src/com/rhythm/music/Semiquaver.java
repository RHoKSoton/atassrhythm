package com.rhythm.music;

import android.graphics.Bitmap;

import com.rhythm.app.MainActivity;

public class Semiquaver extends Joinable
{
	protected Bitmap cutJoin;

	public Semiquaver(int dots, boolean aRest)
	{
		super(0.0625, dots, aRest, MainActivity.getBitmap("sixteen_rest"), MainActivity.getBitmap("sixteen_single"), MainActivity.getBitmap("sixteen_injoin"), MainActivity.getBitmap("sixteen_endjoin"));

		cutJoin = MainActivity.getBitmap("sixteen_cutjoin");
	}

	@Override
	public Bitmap getIcon(IconType style)
	{
		switch(style)
		{
			case CUTJOIN: return this.cutJoin;
			default: return super.getIcon(style);
		}
	}
}
