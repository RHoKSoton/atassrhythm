package com.rhythm.app;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MusicRenderer extends SurfaceView implements Callback 
{
	SurfaceHolder holder;
	Timer tmr = new Timer();
	
	public MusicRenderer(Context context) 
	{
		super(context);
		
		Initialise();
	}

	public MusicRenderer(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		
		Initialise();
	}

	public MusicRenderer(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
		
		Initialise();
	}

	private void Initialise()
	{
		holder = this.getHolder();
		holder.addCallback(this);
	}
	
	//Callback methods
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) 
	{
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) 
	{
		TimerTask drawTask = new TimerTask()
		{

			@Override
			public void run() 
			{
				Canvas canvas = holder.lockCanvas();
				draw(canvas);
				holder.unlockCanvasAndPost(canvas);
			}
			
		};
		
		tmr.schedule(drawTask, 0, 16);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) 
	{
		tmr.cancel();
	}

	public void draw(Canvas canvas)
	{
		Paint white = new Paint();
		white.setColor(Color.WHITE);
		
		canvas.drawRect(canvas.getClipBounds(), white);
	}
}
