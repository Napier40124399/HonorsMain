package Cells;

import java.awt.Color;
import java.util.ArrayList;

import DataCenter.Bridge;

/**
 * <h1>Cell - Hard Coded</h1> This is the cell subclass for hardcoded cells.
 *
 * @see {@link Cells.Cellular super class}
 * @see {@link Cells.Cell interface}
 */
public class Cell_Hard extends Cellular implements Cell
{
	@Override
	public void mutationLogic()
	{
		if((Math.random() * 10000) < bridge.getMutation())
		{
			R = !R;
		}
	}
	
	@Override
	public void setFitness()
	{
		fitness = 0;
		for (Cell ce : neighboors)
		{
			if (!ce.getR())
			{
				if (R)
				{
					fitness += bridge.getT();
				} else
				{
					fitness += bridge.getR();
				}
			} else
			{
				if (R)
				{
					fitness += bridge.getP();
				} else
				{
					fitness += bridge.getS();
				}
			}
		}
	}

	@Override
	public void setNewGeneration()
	{
		daddys = new ArrayList<Cell>();
		double old = fitness;
		for (Cell ce : neighboors)
		{
			if (ce.getPower() > old)
			{
				daddys.clear();
				daddys.add(ce);
				old = ce.getPower();
			} else if (ce.getPower() == old)
			{
				daddys.add(ce);
			}
		}
		if (daddys.size() > 0)
		{
			nextGenR = daddys.get(((int) (Math.random() * (daddys.size())))).getR();
		}
	}
	
	@Override
	public void updateCell()
	{
		//Two color schemes based off seperate methods
		if(bridge.getColorMode() == 0){color1();}
		else{color2();}
		
		this.R = nextGenR;
	}
	
	private void color1()
	{
		if (this.c != Color.white)
		{
			if (this.R == true)
			{
				if (this.R != nextGenR)
				{
					c = Color.green;
				} else
				{
					c = Color.red;
				}
			} else
			{
				if (this.R != nextGenR)
				{
					c = Color.yellow;
				} else
				{
					c = Color.blue;
				}
			}
		} else
		{
			c = Color.white;
		}
	}
	
	private void color2()
	{
		Float t = (float) (9f * bridge.getT());
		Float tt = (float) (fitness) / t;
		Float ttt = tt * 250;
		int tttt = (int) (ttt*1);
		c = new Color(tttt, tttt, tttt);
	}
}