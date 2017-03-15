package Scenarios;

import Cells.Cell;
import Cells.Cell_NN2;
import DataCenter.Bridge;
import Logics.SplitTask;

/**
 * <h1>Scenario 4 - Artificial Intelligence & Synchronous</h1> Does what the
 * title says. Cells play the IPD (iterated prisonner's dilemma) against all
 * their neighboors and gain a fitness score. This is done for all cells. The
 * scores are then compared to all their neighboors and copy the neighboor with
 * highest fitness onto themselves. All cells start with random values.
 *
 * @see params {@link Scenarios.Scenario see variables}
 * @see {@link Cells.Cell_Hard hard coded cell}
 * @see Scenario2
 * @see InterruptedException
 */
public class Scenario5 extends Scenario
{
	private SplitTask sp = new SplitTask();
	public Scenario5(int Q, int Ratio, int[][] pass, int loops, Bridge bridge)
	{
		super(Q, Ratio, pass, loops, bridge);
		sp.splitTasks(cells, bridge.getCores());
	}

	@Override
	public Cell getCell()
	{
		return new Cell_NN2();
	}
	
	@Override
	public void live()
	{
		old();

		bridge.setGen(gen++);
		bridge.setReady();
		try
		{
			Thread.sleep(bridge.getSpeed() * 10);
		} catch (InterruptedException e)
		{
		}
	}
	
	private void old()
	{
		sp.splitCores(cells, bridge.getCores(), bridge, 1);
		sp.splitCores(cells, bridge.getCores(), bridge, 2);
		sp.splitCores(cells, bridge.getCores(), bridge, 4);
		sp.splitCores(cells, bridge.getCores(), bridge, 3);
	}
	
	private void notOld()
	{
		sp.doThreading(1);
		sp.doThreading(2);
		sp.doThreading(3);
		sp.doThreading(4);
	}
}
