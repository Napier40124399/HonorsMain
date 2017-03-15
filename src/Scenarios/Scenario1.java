package Scenarios;

import Cells.Cell;
import Cells.Cell_Hard;
import Cells.Cell_NN;
import DataCenter.Bridge;

/**
 * <h1>Scenario 1 - HardCoded & Synchronous</h1> Does what title says, purely
 * hardcoded cells run in synchronous logic. Cells play the IPD (iterated
 * prisonner's dilemma) against all their neighboors and gain a fitness score.
 * This is done for all cells. The scores are then compared to all their
 * neighboors and copy the neighboor with highest fitness onto themselves. All
 * cells start with random values.
 *
 * @see params {@link Scenarios.Scenario see variables}
 * @see {@link Cells.Cell_Hard hard coded cell}
 * @see Scenario2
 * @see InterruptedException
 */
public class Scenario1 extends Scenario
{
	public Scenario1(int Q, int Ratio, int[][] pass, int loops, Bridge bridge)
	{
		super(Q, Ratio, pass, loops, bridge);
	}

	@Override
	public Cell getCell()
	{
		return new Cell_Hard();
	}
	
	@Override
	public void live()
	{
		for(int i = 0; i < bridge.getItPerGen(); i++)
		{
			for (Cell c : cells)
			{
				c.setFitness(); //FITNESS
			}
		}
		for (Cell c : cells)
		{
			c.setNewGeneration(); //NEW GEN
		}
		for (Cell c : cells)
		{
			c.updateCell(); //UPDATE
		}
		for (Cell c : cells)
		{
			c.mutationLogic(); //MUTATION
		}
		bridge.setGen(gen++);
		bridge.setReady();
		HandleProp();
		try
		{
			Thread.sleep(bridge.getSpeed() * 10);
		} catch (InterruptedException e)
		{
		}
	}
	
	private void HandleProp()
	{
		int c1 = 0;
		int c2 = 0;
		for(Cell c : cells)
		{
			if(c.getR())
			{
				c1 += 1;
			}else
			{
				c2 +=1;
			}
		}
		bridge.setProp(new Float(c1), 0);
		bridge.setProp(new Float(c2), 1);
	}
}
