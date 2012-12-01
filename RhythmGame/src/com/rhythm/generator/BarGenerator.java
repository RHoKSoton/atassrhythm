package com.rhythm.generator;

import com.rhythm.app.Difficulty;
import com.rhythm.music.*;
import java.util.Random;

public class BarGenerator
{

	private Difficulty difficulty;
	
	public BarGenerator(Difficulty trickiness)
	{
		difficulty = trickiness;
	}

	
	public Note MakeNotes(double length)
	{
		
		Random rnd = new Random();
		int range = 0;
		int offset = 0;
		int result;
		
		switch (difficulty)
		{
			case EASY  : //min note length 1/4
				range = 3;
			case MEDIUM : //min note length 1/8
				range = 4;
			case HARD :	//min note length 1/16
				range = 5;
		}
		
		if (length < 1) 
		{
			offset = 1;
		}
		else if (length < 0.5)
		{
			offset = 2;
		}
		else if (length < 0.25)
		{
			offset = 3;
		}
		else if (length < 0.125)
		{
			offset = 4;
		}
		
		result = rnd.nextInt(range-offset) + offset;
		
		switch (result)
		{
		case 0 :
			//new sem
		case 1 :
			
		case 2 :
			
		case 3 :
			
		case 4 :
			
		}
		return null;
	}
}
