package com.rhythm.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity 
{

	private static HashMap<String, Bitmap> bitmaps = new HashMap<String, Bitmap>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		loadAssets();
	}
	
	private void loadAssets()
	{
		//Asset loading here
		try
		{
			AssetManager assets = getAssets();
			
			InputStream stream = assets.open("aFile.png");
			Bitmap aBitmap = BitmapFactory.decodeStream(stream);
			
			bitmaps.put("bitmapName", aBitmap);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public Bitmap getBitmap(String name)
	{
		return bitmaps.get(name);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
