package com.rhythm.app;

public class Scorer
{
	boolean parity = false;
	
	
	public Scorer()
	{
		
		
	}

	//call when a new note takes focus of the program
	public void pressed() 
	{
		parity = !parity;
		
	}
}
