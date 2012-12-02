package com.rhythm.app;

import com.rhythm.music.Note;

public class NoteScore {
	
	
	private boolean scorable;
		
	private int score;
	private Note note;
	
	public NoteScore(Note thisNote, double beats) {
		scorable = true;
		score = 0;
		note = thisNote;
		if (note.Rest())
		{
			score = 10;
		}
		else
		{
			score = 0;
		}
		
	}
	
	public void notScorable()
	{
		scorable = false;
	}
	
	public void setScore(int points){
			score = points;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public Note getNote()
	{
		return note;
	}
	
	public void setNote(Note aNote)
	{
		note = aNote;
	}
}
