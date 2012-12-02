package com.rhythm.app;

import java.util.ArrayList;
import java.util.Iterator;

import com.rhythm.music.Note;

public class Scorer
{
	boolean parity = false;
	ArrayList<NoteScore> items;
	
	public Scorer(ArrayList<Note> notes)
	{
		Iterator<Note> it = notes.iterator();
		Note note;
		while(it.hasNext())
		{
			note = it.next();
			items.add(new NoteScore());
		}
		
		
	}

	//call when a new note takes focus of the program
	public void pressed() 
	{
		parity = !parity;
		
	}
}
