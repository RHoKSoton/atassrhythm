package com.rhythm.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.rhythm.music.Note;

public class Scorer
{
	boolean parity = false;
	static HashMap<Double,NoteScore> items;
	static ArrayList<Note> theNotes;
	
	public Scorer(ArrayList<Note> notes)
	{
		Iterator<Note> it = notes.iterator();
		Note note;
		Double length= new Double(0);
		theNotes = notes;
		
		while (it.hasNext()){
			note = it.next();
			items.put(length, new NoteScore(note,length));
			length = length + note.getLength();
		}
		
		
	}

	//call when button pressed
	public void pressed(int lengthPassed)
	{
		NoteScore thing = items.get(lengthPassed);
		if (thing.getNote().Rest()){//if they clicked when its a rest
			thing.setScore(0);//that rest gets no points
		} else if(thing.getScore()!=0){//if they already have points
			thing.notScorable();//mark it as not scorable
		} else {
			thing.setScore(10);//otherwise give them points for this note
		}
		
	}
}
