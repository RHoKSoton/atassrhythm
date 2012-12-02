package com.rhythm.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.rhythm.generator.NotesGenerator;
import com.rhythm.music.Crotchet;
import com.rhythm.music.Note;
import com.rhythm.music.Quaver;
import com.rhythm.music.Semiquaver;


public class MusicRenderer extends SurfaceView implements Callback 
{
	SurfaceHolder holder;
	Timer tmr;
	
	ArrayList<RenderBar> bars = new ArrayList<RenderBar>();
	NotesGenerator gen;
	
	float noteOffset = 0;
	
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
		ArrayList<Note> notes2 = new ArrayList<Note>();
		
		notes2.add(new Quaver(0, false));
		notes2.add(new Quaver(0, false));
		notes2.add(new Crotchet(0, true));
		notes2.add(new Quaver(0, true));
		notes2.add(new Semiquaver(0, true));
		
		gen = new NotesGenerator(Difficulty.HARD);
		
		for(int i =0;i<15; i++)
		{
			bars.add(new RenderBar(gen.generateBar()));
		}
		
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
		if(tmr != null) tmr.cancel();
		tmr = new Timer();
		
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
		Rect screenArea = canvas.getClipBounds();
		Paint white = new Paint();
		Paint black = new Paint();
		
		white.setColor(Color.WHITE);
		black.setColor(Color.BLACK);
		black.setStrokeWidth(2);
		
		float centreY = screenArea.exactCenterY();
		
		canvas.drawRect(canvas.getClipBounds(), white);
		canvas.drawLine(20, centreY, screenArea.right-20, centreY, black);
		
		int startPoint = 20 + (80-(int)(noteOffset % 80))%80;
		
		if(startPoint == 20) canvas.drawLine(20, centreY-20, 20, centreY+20, black);
		
		Iterator<RenderBar> itr = bars.iterator();
		BarOffsetReference offset = new BarOffsetReference(20-noteOffset);
		
		ArrayList<Integer> barsToAdd = new ArrayList<Integer>();
		
		while(itr.hasNext())
		{
			RenderBar bar = itr.next();
			int size = bar.Draw(canvas, offset, centreY, white);
			
			if(offset.getOffset() > screenArea.right-20) break;
			else if(offset.getOffset() < 20)
			{
				itr.remove();
				barsToAdd.add(size);
			}
			
			canvas.drawLine(offset.getOffset(), centreY-20, offset.getOffset(), centreY+20, black);
		}
		
		canvas.drawRect(new Rect(0,0, 20, screenArea.bottom), white);
		canvas.drawRect(new Rect(screenArea.right-20,0, screenArea.right, screenArea.bottom), white);
		
		for(int i =0;i<barsToAdd.size();i++)
		{
			bars.add(new RenderBar(gen.generateBar()));
			noteOffset -= barsToAdd.get(i);
		}
		
		noteOffset += 1;
	}
	
	public void setNotes(ArrayList<Note> newNotes)
	{
		//notes = newNotes;
	}
}
