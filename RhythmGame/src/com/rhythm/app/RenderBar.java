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
		int noNotes = 0;
		float length = 0;
		boolean hasNoteVariation = false;
		for(int i =0; i < ToRender.size();i++)
		{
			Note note = ToRender.get(i);
			
			toRender.add(new RenderNote(i, ToRender));
			boolean shouldReset = false;
			
			if(RenderNote.isJoinable(note))
			{
				if(nextNoteJoinable(i, ToRender, noNotes, length, hasNoteVariation))
				{
					//TODO: if(RenderNote.getNote(ToRender, i+1).getLength() != note.getLength()) hasNoteVariation = true;
					
					if(noNotes == 0 && RenderNote.isJoinable(RenderNote.getNote(ToRender, i+1))) toRender.get(i).setNoteState(0);
					else toRender.get(i).setNoteState(1); 
				
					length += 0.25f;
					noNotes ++;
				}
			}
			
			if(shouldReset)
			{
				noNotes = 0;
				length = 0;
				hasNoteVariation = false;
			}
			//TODO: Change to actual length method
		}
	}
	
	static boolean nextNoteJoinable(int pos, ArrayList<Note> notes, int noNotes, float length, boolean hasNoteVariation)
	{
		Note nextNote = RenderNote.getNote(notes, pos + 1);
		float newLength = length + 0.25f;
		
		if(!RenderNote.isJoinable(nextNote)) return false;
		if(noNotes == 3) return false;
		if(newLength > 0.5f/*TODO: nextNote.getLength*/) return false;
		if(hasNoteVariation && newLength > 0.25f) return false;
		
		return true;
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
