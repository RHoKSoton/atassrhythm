package com.rhythm.app;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.rhythm.music.IconType;
import com.rhythm.music.Joinable;
import com.rhythm.music.Note;

public class RenderNote 
{
	Note actualNote;
	
	ArrayList<NoteRenderState> renderStates = new ArrayList<NoteRenderState>();
	
	public RenderNote(int notePos, ArrayList<Note> notes) 
	{
		//TODO:Change to isJoinable instead of instanceof
		actualNote = getNote(notes, notePos);
		
		if(actualNote.Rest()) renderStates.add(new NoteRenderState(actualNote, IconType.REST));
		else
		{
			int state = -1; //getState(getNote(notes, notePos), getNote(notes, notePos-1), getNote(notes, notePos+1)); //-1 not join, 0 start, 1 middle, 2 end
		
			switch(state)
			{
			case -1: renderStates.add(new NoteRenderState(actualNote, IconType.SINGLE)); break;
				case 0: renderStates.add(new NoteRenderState(actualNote, IconType.INJOIN)); break;
				case 2: renderStates.add(new NoteRenderState(actualNote, IconType.ENDJOIN)); break;
			}
		}
	}
	
	public void Draw(Canvas canvas, BarOffsetReference xOffset, float centreY, Paint paintMode)
	{
		int largestWidth = 0;
		for(NoteRenderState state: renderStates)
		{
			if(state.getWidth() > largestWidth) largestWidth = state.getWidth();
		}
		
		if(xOffset.getOffset() >= 20 && xOffset.getOffset() + largestWidth < canvas.getWidth() - 20)
		{
			for(NoteRenderState state : renderStates)
			{
				state.Draw(canvas, xOffset, centreY, paintMode);
			}
		}
		
		xOffset.setOffset(xOffset.getOffset() + largestWidth);
	}
	
	static Note getNote(ArrayList<Note> notes, int position)
	{
		if(position < 0 || position >= notes.size()) return null;
		return notes.get(position);
	}
	
	static int getState(Note actualNote, Note prevNote, Note nextNote)
	{
		if(!isJoinable(actualNote) || !isJoinable(prevNote) && !isJoinable(nextNote)) return -1;
		if(isJoinable(prevNote) && !isJoinable(nextNote)) return 2;
		if(!isJoinable(prevNote) && isJoinable(nextNote)) return 0;
		
		return 1;
	}
	
	static boolean isJoinable(Note note)
	{
		if(note == null || !(note instanceof Joinable)) return false;
		return true;
	}

}
