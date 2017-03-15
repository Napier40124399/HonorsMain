package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import DataCenter.Storage;

public class BottomPanel
{
	private Storage store;
	
	public BottomPanel(Storage store)
	{
		this.store = store;
	}
	
	public void makePanel()
	{
		int pos = 540;
		// Labels
		store.BottomOptionsLbl.add(new JLabel("Area"));
		store.BottomOptionsLbl.add(new JLabel("C/D"));
		store.BottomOptionsLbl.add(new JLabel("Start Pos"));
		store.BottomOptionsLbl.add(new JLabel("End Pos"));
		store.BottomOptionsLbl.add(new JLabel("Clear"));
		// Text Fields
		store.BottomOptionsTxt.add(new JTextField());
		store.BottomOptionsTxt.add(new JTextField());
		store.BottomOptionsTxt.add(new JTextField());
		store.BottomOptionsTxt.add(new JTextField());
		for (JLabel lbl : store.BottomOptionsLbl)
		{
			lbl.setBounds(4, pos, 100, 20);
			store.frame.getContentPane().add(lbl);
			store.vLog.lblBuilder(lbl);
			pos += 30;
		}
		for (JTextField txt : store.BottomOptionsTxt)
		{
			txt.setBorder(new LineBorder(store.NeonGreen));
			txt.setForeground(store.NeonGreen);
			txt.setBackground(Color.white);
			store.frame.getContentPane().add(txt);
		}
		store.BottomOptionsTxt.get(0).setBounds(100, 600, 75, 20);
		store.BottomOptionsTxt.get(1).setBounds(200, 600, 75, 20);
		store.BottomOptionsTxt.get(2).setBounds(100, 630, 75, 20);
		store.BottomOptionsTxt.get(3).setBounds(200, 630, 75, 20);

		store.btnCD = new JButton();
		store.btnCD.setText("Cooperator");
		store.btnCD.setBounds(100, 570, 100, 20);
		store.vLog.btnBuilder(store.btnCD);
		store.frame.getContentPane().add(store.btnCD);

		store.btnClear = new JButton();
		store.btnClear.setText("Clear All");
		store.btnClear.setBounds(100, 660, 100, 20);
		store.vLog.btnBuilder(store.btnClear);
		store.frame.getContentPane().add(store.btnClear);

		store.btnDelete = new JButton();
		store.btnDelete.setText("Local Clear");
		store.btnDelete.setBounds(210, 660, 100, 20);
		store.vLog.btnBuilder(store.btnDelete);
		store.frame.getContentPane().add(store.btnDelete);

		store.btnPlace2 = new JButton("Place");
		store.btnPlace2.setBounds(290, 600, 150, 20);
		store.vLog.btnBuilder(store.btnPlace2);

		store.SliderArea = new JSlider();
		store.SliderArea.setBounds(100, 540, 200, 20);
		store.SliderArea.setBackground(Color.white);
		store.frame.getContentPane().add(store.SliderArea);

		store.btnPlace2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				int x = Integer.parseInt(store.BottomOptionsTxt.get(0).getText().toString());
				int y = Integer.parseInt(store.BottomOptionsTxt.get(1).getText().toString());
				int xx = Integer.parseInt(store.BottomOptionsTxt.get(2).getText().toString());
				int yy = Integer.parseInt(store.BottomOptionsTxt.get(3).getText().toString());
				for (int i = x; i <= xx; i++)
				{
					for (int j = y; j <= yy; j++)
					{
						store.vLog.drew(i, j);
					}
				}
			}
		});

		store.btnClear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				store.placing = false;
				store.btnPlace.setText("Place Cells");
				store.frame.setBounds(store.frame.getBounds().x, store.frame.getBounds().y, store.frame.getWidth(), 564);
				store.timer.stop();
				store.CDvals = null;
			}
		});

		store.btnDelete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				store.color = 2;
			}
		});

		store.SliderArea.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				store.area = store.SliderArea.getValue();
			}
		});

		store.btnCD.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (store.btnCD.getText().toString().equals("Cooperator"))
				{
					store.btnCD.setText("Defector");
					store.btnCD.setBackground(store.NeonRed);
					store.btnCD.setBorder(new LineBorder(store.NeonRed));
					store.using = Color.red;
					store.color = 1;
				} else
				{
					store.btnCD.setText("Cooperator");
					store.btnCD.setBorder(new LineBorder(store.NeonGreen));
					store.btnCD.setBackground(store.NeonGreen);
					store.using = Color.green;
					store.color = 0;
				}
			}
		});
		store.panel.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent arg0)
			{
				for (int i = arg0.getX() - store.area; i <= arg0.getX() + store.area; i++)
				{
					for (int j = arg0.getY() - store.area; j <= arg0.getY() + store.area; j++)
					{
						store.vLog.drew(i, j);
					}
				}
			}
		});
	}
}
