package Logics;

import java.util.ArrayList;

import Cells.Cell;
import DataCenter.Bridge;
import Scenarios.Scenario;

/**
 * <h1>Build Cell Colony</h1> Builds the cell colony. Surprising right? Uses a
 * simple algorithm which iterates over positions based on the user's chosen
 * lattice size.
 * <p>
 * <b>The algorithm runs in multiple steps / ways:</b>
 * <ul>
 * <li><b>Random Layout:</b> cells are picked at random and set to be defectors.
 * This stops once the calculated quantity satisfies the user defined ratio. All
 * other cells are cooperators.</li>
 * <li><b>Predefined Layout:</b> the user can draw directly on the panel how
 * he/she wants the lattice to be layed out. In this case the first step is
 * skipped.</li>
 * <li><b>Conversion:</b> Step two consists of converting these values into
 * actual cells. New cells are built each with its own instance and placed in an
 * {@link ArrayList}.</li>
 * </ul>
 * 
 * @param prep
 *            int[][]
 * @param Ratio
 *            int
 * @param Q
 *            int
 * @param cells
 *            ArrayList<Cell>
 * @param bridge
 *            Bridge
 * @param s
 *            Scenario
 * @see {@link Cells.Cellular info about cells}
 */
public class buildCellColony
{
	/** {@link Logics.buildCellColony INFO IS HERE} */
	public void build(int[][] prep, int Ratio, int Q, ArrayList<Cell> cells, Bridge bridge, Scenario s)
	{
		if (prep == null)
		{
			int q = (int) (((double) Ratio) / 100 * ((double) Q * (double) Q));
			prep = new int[Q][Q];
			for (int i = 0; i < q; i++)
			{
				int ii = (int) (Math.random() * ((double) Q));
				int jj = (int) (Math.random() * ((double) Q));
				if (prep[ii][jj] == 1)
				{
					q += 1;
				} else
				{
					prep[ii][jj] = 1;
				}
			}
		}
		boolean R;
		for (int i = 0; i < Q; i++)
		{
			for (int j = 0; j < Q; j++)
			{
				if (prep[i][j] == 1)
				{
					R = true;
				} else
				{
					R = false;
				}
				cells.add(s.getCell());
				cells.get(cells.size() - 1).Cell(R, i, j, bridge);
			}
		}
	}
}
