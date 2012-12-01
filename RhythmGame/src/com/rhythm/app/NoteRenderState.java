package com.rhythm.app;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.rhythm.music.IconType;
import com.rhythm.music.Note;

public class NoteRenderState 
{
	Note noteToRender;
	IconType renderType;
	
	public NoteRenderState(Note NoteToRender, IconType RenderType) 
	{
		noteToRender = NoteToRender;
		renderType = RenderType;
	}

	public void Draw(Canvas canvas, float xOffset, float centreY, Paint paintMode)
	{
		Bitmap toDraw = noteToRender.getIcon(renderType);
		
		canvas.drawBitmap(toDraw, xOffset, centreY - toDraw.getHeight() + 5, paintMode);
	}
}
