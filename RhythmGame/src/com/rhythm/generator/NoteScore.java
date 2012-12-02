package com.rhythm.generator;

import com.rhythm.music.Note;

public class NoteScore {
	
	private final static int baseScore = 50;
	
	private boolean scorable;
		
	private double startBeats;
	private double endBeats;
	
	private int score = 0;
	private Note note;
	
	public NoteScore(Note thisNote, double beats) {
		scorable = true;
		score = 0;
		note = thisNote;
		startBeats = beats;
		endBeats = startBeats + note.getLength();
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
