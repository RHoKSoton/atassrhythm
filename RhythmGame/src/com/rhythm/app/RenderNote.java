package com.rhythm.app;

import java.util.ArrayList;

import com.rhythm.music.IconType;
import com.rhythm.music.Joinable;
import com.rhythm.music.Note;

public class RenderNote 
{
	Note actualNote;
	
	ArrayList<RenderNote> renderStates = new ArrayList<RenderNote>();
	
	public RenderNote(int notePos, ArrayList<Note> notes) 
	{
		//TODO:Change to isJoinable instead of instanceof
		actualNote = getNote(notes, notePos);
		int state = getState(getNote(notes, notePos), getNote(notes, notePos-1), getNote(notes, notePos+1)); //-1 not join, 0 start, 1 middle, 2 end
		
		switch(state)
		{
			case -1: renderStates.add(new RenderNote(actualNote, IconType.SINGLE)); break;
			case 0: renderStates.add(new RenderNote(actualNote, IconType.INJOIN)); break;
			case 2: renderStates.add(new RenderNote(actualNote, IconType.ENDJOIN)); break;
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
		if(note == null || !(note instanceof Joinable)) return false;
		return true;
	}

}
