package com.rhythm.app;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.rhythm.music.Note;

public class RenderBar 
{
	ArrayList<RenderNote> toRender = new ArrayList<RenderNote>();
	
	public RenderBar(ArrayList<Note> ToRender) 
	{
		for(int i =0; i < ToRender.size();i++)
		{
			toRender.add(new RenderNote(i, ToRender));
		}
	}
	
	public void Draw(Canvas canvas, float xOffset, float centreY, Paint paintMode)
	{
		BarOffsetReference offset = new BarOffsetReference(xOffset);
		
		for(RenderNote note : toRender)
		{
			note.Draw(canvas, offset, centreY, paintMode);
			
			if(offset.getOffset() >= canvas.getWidth()-20) return;
		}
	}

}
