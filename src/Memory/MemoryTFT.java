package Memory;

import java.util.ArrayList;

public class MemoryTFT
{
	private ArrayList<Boolean> memory = new ArrayList<Boolean>();
	private ArrayList<Boolean> memCur = new ArrayList<Boolean>();
	
	private ArrayList<Boolean> opMem = new ArrayList<Boolean>();
	private ArrayList<Boolean> opCur = new ArrayList<Boolean>();
	
	private int size;
	
	public MemoryTFT(int size)
	{
		this.size = size;
		for(int i = 0; i < size; i++)
		{
			memory.add(true);
			opMem.add(true);
		}
		memCur = (ArrayList<Boolean>) memory.clone();
		opCur = (ArrayList<Boolean>) opMem.clone();
	}
	
	public void reset()
	{
		memory.clear();
		memCur.clear();
		opMem.clear();
		opCur.clear();
		for(int i = 0; i < size; i++)
		{
			memory.add(true);
			opMem.add(true);
		}
		memCur = (ArrayList<Boolean>) memory.clone();
		opCur = (ArrayList<Boolean>) opMem.clone();
	}
	
	public ArrayList<Float> getMem()
	{
		ArrayList temp = new ArrayList<Float>();
		
		for(int i = 0; i < size; i++)
		{
			temp.add(memory.get(i));
		}
		for(int i = 0; i < size; i++)
		{
			temp.add(opMem.get(i));
		}
		return temp;
	}
	
	public void normalize()
	{
		memory = (ArrayList<Boolean>) memCur.clone();
		opMem = (ArrayList<Boolean>) opCur.clone();
	}
	
	public Boolean getMem(int i)
	{
		return memory.get(i);
	}
	
	public void save(Boolean mem)
	{
		memCur.add(mem);
		memCur.remove(0);
	}
	
	public void saveOP(Boolean mem)
	{
		opCur.add(mem);
		opCur.remove(0);
	}
}