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
					if(RenderNote.getNote(ToRender, i+1).getLength() != note.getLength()) hasNoteVariation = true;
					
					if(noNotes == 0 && RenderNote.isJoinable(RenderNote.getNote(ToRender, i+1))) toRender.get(i).setNoteState(0);
					else toRender.get(i).setNoteState(1); 
					
					length += note.getLength();
					noNotes ++;
				}
				else if(noNotes > 0)
				{
					toRender.get(i).setNoteState(2); 
					shouldReset = true;
				}
			}
			else shouldReset = true;
			
			if(shouldReset)
			{
				noNotes = 0;
				length = 0;
				hasNoteVariation = false;
			}
		}
		
		for(int i=0; i < toRender.size();i++)
		{
			RenderNote note = toRender.get(i);
			
			note.addRenderStates(i, ToRender);
		}
	}
	
	static boolean nextNoteJoinable(int pos, ArrayList<Note> notes, int noNotes, float length, boolean hasNoteVariation)
	{
		Note nextNote = RenderNote.getNote(notes, pos + 1);
		if(nextNote == null) return false;
		
		float newLength = length + (float)nextNote.getLength();
		
		if(!RenderNote.isJoinable(nextNote)) return false;
		if(noNotes == 3) return false;
		if(newLength > 0.5f) return false;
		if(hasNoteVariation && newLength > 0.25f) return false;
		
		return true;
	}
	
	//Return -1 for all not visible to the left, 0 for some part is visible, 1 for some part not visible to the right
	public int Draw(Canvas canvas, BarOffsetReference xOffset, float centreY, Paint paintMode)
	{
		BarOffsetReference offset = xOffset;
		int initialPos = (int)offset.getOffset();
		
		offset.setOffset(offset.getOffset() + 5);
		
		for(RenderNote note : toRender)
		{
			note.Draw(canvas, offset, centreY, paintMode);
		}
		
		offset.setOffset(offset.getOffset() + 5);
		
		return (int)offset.getOffset()-initialPos;
	}

}
