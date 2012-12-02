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
	int noteState = -1; //-1 Not connected, 0 start, 1 middle, 2 end
	
	public RenderNote(int notePos, ArrayList<Note> notes) 
	{
		//TODO:Change to isJoinable instead of instanceof
		actualNote = getNote(notes, notePos);
	}
	
	public void Draw(Canvas canvas, BarOffsetReference xOffset, float centreY, Paint paintMode)
	{
		int largestWidth = 0;
		for(NoteRenderState state: renderStates)
		{
			if(state.getWidth() > largestWidth) largestWidth = state.getWidth();
		}
		
		if(xOffset.getOffset() + largestWidth >= 20 && xOffset.getOffset() < canvas.getWidth() - 20)
		{
			for(NoteRenderState state : renderStates)
			{
				state.Draw(canvas, xOffset, centreY, paintMode);
			}
		}
		
		xOffset.setOffset(xOffset.getOffset() + largestWidth + (noteState < 0 || noteState > 1? 3:-5));
	}
	
	public int getNoteState()
	{
		return noteState;
	}
	
	public void setNoteState(int value)
	{
		noteState = value;
	}
	
	public void addRenderStates(int pos, ArrayList<Note> notes)
	{
		Note currentNote = notes.get(pos);
		Note lastNote = getNote(notes, pos - 1);
		Note nextNote = getNote(notes, pos + 1);

		if(currentNote.Rest()) renderStates.add(new NoteRenderState(currentNote, IconType.REST));
		else if(noteState == -1) renderStates.add(new NoteRenderState(currentNote, IconType.SINGLE));
		else if(noteState == 0)
		{
			if(currentNote.getLength() > 1.0/16.0 || nextNote.getLength() == currentNote.getLength()) renderStates.add(new NoteRenderState(currentNote, IconType.INJOIN));
			else if(currentNote.getLength() <= 1.0/16.0 && nextNote.getLength() != currentNote.getLength())
			{
				renderStates.add(new NoteRenderState(currentNote, IconType.CUTJOIN));
				renderStates.add(new NoteRenderState(nextNote, IconType.INJOIN));
			}
		}
		else if(noteState == 1)
		{
			if(currentNote.getLength() > 1.0/16.0)
			{
				renderStates.add(new NoteRenderState(currentNote, IconType.ENDJOIN));
				renderStates.add(new NoteRenderState(currentNote, IconType.INJOIN));
			}
			else
			{
				renderStates.add(new NoteRenderState(lastNote, IconType.ENDJOIN));
				renderStates.add(new NoteRenderState(nextNote, IconType.INJOIN));
			}
		}
		else
		{
			renderStates.add(new NoteRenderState(currentNote, IconType.ENDJOIN));
		}

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
		if(note == null || !(note instanceof Joinable) || note.Rest()) return false;
		return true;
	}

}
