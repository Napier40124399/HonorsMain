package Logics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import DataCenter.Bridge;
import DataCenter.Storage;

public class VisualLogic
{
	private Storage store;

	public VisualLogic(Storage store)
	{
		this.store = store;
	}

	public void setBridge(Bridge bridge)
	{
		bridge.setDistance(Integer.parseInt(store.txtDist.getText().toString()));
		bridge.setMutation(store.slider3.getValue());
		bridge.setSpeed(store.slider2.getValue());
		bridge.setT(Double.parseDouble(store.txtT.getText().toString()));
		bridge.setR(Double.parseDouble(store.txtR.getText().toString()));
		bridge.setP(Double.parseDouble(store.txtP.getText().toString()));
		bridge.setS(Double.parseDouble(store.txtS.getText().toString()));
		bridge.setTaurus(store.checkTaurus.isSelected());
		bridge.setColorMode(store.comboColor.getSelectedIndex());
		bridge.setCores(Integer.parseInt(store.txtCores.getText()));
	}

	public void btnBuilder(JButton btn)
	{
		store.frame.getContentPane().add(btn);
		btn.setForeground(Color.black);
		btn.setFocusable(false);
		btn.setBorder(new LineBorder(Color.black));
		btn.setBackground(Color.white);
		btn.setFont(new Font("Arial", Font.PLAIN, 20));
		btn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				Hover(arg0, arg0.getComponent().getForeground(), arg0.getComponent().getBackground());
			}

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				Hover(arg0, arg0.getComponent().getForeground(), arg0.getComponent().getBackground());
			}
		});
	}

	public void lblBuilder(JLabel lbl)
	{
		lbl.setForeground(Color.black);
		lbl.setBackground(Color.white);
		lbl.setFocusable(false);
		store.frame.getContentPane().add(lbl);
	}
	
	public void lblBuilder(JLabel lbl, int o)
	{
		lbl.setForeground(store.NeonGreen);
		lbl.setBackground(Color.white);
		lbl.setFocusable(false);
		//store.panels.get(o).add(lbl);
	}
	
	public void drew(int x, int y)
	{
		if (store.placing)
		{
			if (x < store.CDvals.length && x >= 0)
			{
				if (y < store.CDvals.length && y >= 0)
				{
					store.CDvals[x][y] = store.color;
				}
			}
		}
	}
	
	public void Decide(Graphics g)
	{
		if (store.placing)
		{
			Place(g);
		} else if (store.running)
		{
			Draw(g);
		}
	}

	public void Place(Graphics g)
	{
		for (int i = 0; i < store.CDvals.length; i++)
		{
			for (int j = 0; j < store.CDvals.length; j++)
			{
				if (store.CDvals[i][j] == 1)
				{
					g.setColor(Color.RED);
				} else if (store.CDvals[i][j] == 0)
				{
					g.setColor(Color.GREEN);
				} else
				{
					g.setColor(Color.black);
				}
				g.drawLine(i, j, i, j);
			}
		}
	}
	
	public void Draw(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, store.panel.getWidth(), store.panel.getHeight());
		g.drawImage(store.bridge.getImg(), 0, 0, null);

		// Displaying Generation
		if (store.big)
		{
			g.setColor(Color.black);
			g.fillRect(store.panel.getWidth() - (store.panel.getWidth() / 10) - 20, 0, (store.panel.getWidth() / 10) + 30, 50);

			g.setColor(Color.pink);
			g.setFont(new Font("Monospace", Font.BOLD, 40));
			g.drawString("Gen " + store.bridge.getGen(), store.panel.getWidth() - (store.panel.getWidth() / 10), 38);
		} else
		{
			g.setColor(Color.black);
			g.fillRect(store.panel.getWidth() - 80, 0, 100, 20);

			g.setColor(Color.pink);
			g.setFont(new Font("Monospace", Font.BOLD, 14));
			g.drawString("Gen " + store.bridge.getGen(), store.panel.getWidth() - 70, 12);
		}
	}
	
	//Privates
	private void Hover(MouseEvent arg, Color color1, Color color2)
	{
		arg.getComponent().setBackground(color1);
		arg.getComponent().setForeground(color2);
	}
}
