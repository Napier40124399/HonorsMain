package Scenarios;

import java.awt.Color;
import java.util.ArrayList;

import Cells.Cell;
import DataCenter.Bridge;
import Logics.buildCellColony;

/**
 * <h1>Scenario</h1> The superclass to all scenarios. All scenarios may access
 * this class and make use of its utility. Removes a large amount of duplicate
 * code and is a relatively elegant solution to ease of use.
 * 
 * This makes use of protected values so be careful when editting!!
 * 
 * See Bridge for information about variables. Others are self explanatory.
 *
 * @see {@link DataCenter.Bridge bridge}
 */
public class Scenario implements Runnable
{
	// Variables
	protected int speed;
	protected int gen = 0;
	protected int iterations;
	protected boolean learn = true;
	protected boolean isRunning = false;

	// Instances
	protected Bridge bridge;
	protected Thread t;
	protected buildCellColony cellColony = new buildCellColony();
	protected ArrayList<Cell> cells = new ArrayList<Cell>();

	public Scenario(int Q, int Ratio, int[][] pass, int loops, Bridge bridge)
	{
		this.iterations = loops;
		this.bridge = bridge;
		cellColony.build(pass, Ratio, Q, cells, bridge, this);
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run()
	{
		isRunning = true;
		bridge.setCells(this.cells);
		bridge.setReady();
		splitTask(bridge.getCores());

		// Security measure, sometimes certain cells seem to be misassociated
		if (bridge.isTaurus())
		{
			boolean foreverAlone = false;
			for (Cell c : cells)
			{
				if (c.getNeighboors().size() < 1)
				{
					foreverAlone = true;
				}
			}
			while (true)
			{
				if (!foreverAlone)
				{
					break;
				} else
				{
					foreverAlone = false;

					splitTask(bridge.getCores());

					for (Cell c : cells)
					{
						if (c.getNeighboors().size() < 1)
						{
							foreverAlone = true;
						}
					}
				}
			}
		}
		
		// Do specific amount of iterations
		for (int i = 0; i < iterations; i++)
		{
			live();
		}
		if (iterations != 0)
		{
			learn = false;
		}
		// Do unlimited iterations
		while (learn)
		{
			live();
		}
		isRunning = false;
	}

	/**
	 * <h1>Split Tasks</h1> Splits the neighboor setting process into a group of
	 * threads and runs them in parallel. On a system with many cores this
	 * speeds up the process however on weaker systems with few cores but intel
	 * boost tech, it is advised to keep the parameter at 0.
	 *
	 * @param doing
	 *            simply tells the method into how many cores it must split the
	 *            task. 0 means it runs everything ont he main thread.
	 * @exception InterruptedException
	 * @see Thread
	 * @see Runnable
	 */
	protected void splitTask(int doing)
	{
		int thr = doing;
		ArrayList<Thread> threads = new ArrayList<Thread>();
		if (doing == 0)
		{
			for (int j = 0; j < cells.size(); j++)
			{
				cells.get(j).setNeighboors();
			}
		} else
		{
			int split = cells.size() / thr;
			int leftOver = cells.size() % thr;
			for (int i = 0; i < thr; i++)
			{
				int start = i * split;
				threads.add(new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						for (int j = start; j < start + split; j++)
						{
							cells.get(j).setNeighboors();
						}
					}
				}));
			}
			if (cells.size() % thr > 0)
			{
				threads.add(new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						for (int j = split * thr; j < split * thr + leftOver; j++)
						{
							cells.get(j).setNeighboors();
						}
					}
				}));
			}
			for (Thread tt : threads)
			{
				tt.start();
			}

			for (Thread tt : threads)
			{
				try
				{
					tt.join();
				} catch (InterruptedException e)
				{
				}
			}
		}
	}
	
	public void live()
	{
		
	}

	// Getters and setters
	public void Stop()
	{
		learn = false;
	}

	public void Start()
	{
		learn = true;
	}

	public Cell getCell()
	{
		return null;
	}

	public boolean isRunning()
	{
		return isRunning;
	}
}