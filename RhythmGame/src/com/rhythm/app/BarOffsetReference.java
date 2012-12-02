package com.rhythm.app;

public class BarOffsetReference 
{

	private float xOffset;
	
	public BarOffsetReference(float offset) 
	{
		xOffset = offset;
	}

	public void setOffset(float value)
	{
		xOffset = value;
	}
	
	public float getOffset()
	{
		return xOffset;
	}
}
