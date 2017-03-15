package Scenarios;

import Cells.Cell;
import Cells.Cell_TitTat;
import DataCenter.Bridge;

/**
 * <h1>Scenario 3 - Neural Network & Synchronous</h1> Does what title says.
 * Cells play the IPD (iterated prisonner's dilemma) against all their
 * neighboors and gain a fitness score. This is done for all cells. The scores
 * are then compared to all their neighboors and copy the neighboor with highest
 * fitness onto themselves. All cells start with random values.
 *
 * @see params {@link Scenarios.Scenario see variables}
 * @see {@link Cells.Cell_Ai neural network cell}
 * @see Scenario2
 * @see InterruptedException
 */
public class Scenario3 extends Scenario
{
	public Scenario3(int Q, int Ratio, int[][] pass, int loops, Bridge bridge)
	{
		super(Q, Ratio, pass, loops, bridge);
	}

	@Override
	public Cell getCell()
	{
		return new Cell_TitTat();
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
			c.mutationLogic(); //MUTATION
		}
		for (Cell c : cells)
		{
			c.updateCell(); //UPDATE
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
		int c3 = 0;
		for(Cell c : cells)
		{
			if(c.getType() == 0)
			{
				if(c.getR())
				{
					c1 += 1;
				}else
				{
					c2 +=1;
				}
			}else
			{
				c3 += 1;
			}
		}
		bridge.setProp(new Float(c1), 0);
		bridge.setProp(new Float(c2), 1);
		bridge.setProp(new Float(c3), 2);
	}
}
