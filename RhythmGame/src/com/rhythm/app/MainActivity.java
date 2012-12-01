package com.rhythm.app;

import java.io.IOException;
import java.io.InputStream;
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
		loadFile("one_single");
		loadFile("one_rest");
		loadFile("two_single");
		loadFile("two_rest");
		loadFile("four_single");
		loadFile("four_rest");
		loadFile("eight_injoin");
		loadFile("eight_endjoin");
		loadFile("eight_single");
		loadFile("eight_rest");
		loadFile("sixteen_injoin");
		loadFile("sixteen_endjoin");
		loadFile("sixteen_single");
		loadFile("sixteen_rest");
	}
	
	private void loadFile(String location)
	{
		//Asset loading here
		try
		{
			AssetManager assets = getAssets();
			
			InputStream stream = assets.open(location + ".png");
			Bitmap aBitmap = BitmapFactory.decodeStream(stream);
			
			bitmaps.put(location, aBitmap);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public static Bitmap getBitmap(String name)
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
