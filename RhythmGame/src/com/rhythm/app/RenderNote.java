package com.rhythm.app;

import java.util.ArrayList;

import com.rhythm.music.IconType;
import com.rhythm.music.Joinable;
import com.rhythm.music.Note;

public class RenderNote 
{
	Note actualNote;
	
	ArrayList<RenderNote> renderStates = new ArrayList<RenderNote>();
	
	public RenderNote(Note actualNote, Note prevNote, Note nextNote) 
	{
		//TODO:Change to isJoinable instead of instanceof
		
		int state = getState(actualNote, prevNote, nextNote); //-1 not join, 0 start, 1 middle, 2 end
		
		/*switch(state)
		{
			case -1: renderStates.add(new RenderNote(actualNote, IconType.SINGLE)); break;
			case 0: renderStates.add(new RenderNote(actualNote, IconType.INJOIN)); break;
			case 2: renderStates.add(new RenderNote(actualNote, IconType.ENDJOIN)); break;
		}*/
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
