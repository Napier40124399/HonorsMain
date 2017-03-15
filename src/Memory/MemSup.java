package Memory;

import java.util.ArrayList;

public class MemSup implements Cloneable
{
	private ArrayList<ArrayList<Float>> memory = new ArrayList<ArrayList<Float>>();
	private ArrayList<Float> val;
	
	public MemSup(int size)
	{
		for(int i = 0; i < size; i++)
		{
			val = new ArrayList<Float>();
			val.add(-0.5f);
			val.add(-0.5f);
			memory.add(val);
		}
	}
	
	public void newMem(Float me, Float op)
	{
		val = new ArrayList<Float>();
		val.add(me);
		val.add(op);
		memory.add(val);
		memory.remove(0);
	}
	
	public Float remember(int index, boolean me)
	{
		if(me)
		{
			return memory.get(index).get(0);
		}else
		{
			return memory.get(index).get(1);
		}
	}
	
	public int getSize()
	{
		return memory.size();
	}
}
