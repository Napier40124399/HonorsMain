package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DataCenter.Storage;

public class FrameBuilder
{
	private Storage store;
	
	public FrameBuilder(Storage store)
	{
		this.store = store;
	}
	
	public void makeFrame()
	{
		store.frame = new JFrame();
		store.frame.setTitle("Console");
		store.frame.setBounds(400, 600, 512, 580);
		store.frame.setMinimumSize(new Dimension(512, 580));
		store.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		store.frame.setLayout(null);
		store.frame.getContentPane().setBackground(Color.white);
		store.frame.setResizable(false);

		store.panel = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				store.vLog.Decide(g);
			}
		};
		
		store.panel.setBounds(0, 0, 500, 500);
		store.frame.getContentPane().add(store.panel);

		store.btnRun = new JButton("Run");
		store.btnRun.setBounds(10, 502, 150, 30);
		store.vLog.btnBuilder(store.btnRun);

		store.btnPlace = new JButton("Place Cells");
		store.btnPlace.setBounds(170, 502, 150, 30);
		store.vLog.btnBuilder(store.btnPlace);

		store.btnExtend = new JButton(">");
		store.btnExtend.setBounds(470, 502, 30, 30);
		store.vLog.btnBuilder(store.btnExtend);
		
		store.btn4K = new JButton("4K");
		store.btn4K.setBounds(430, 502, 30, 30);
		store.vLog.btnBuilder(store.btn4K);
		
		store.btnMonitor = new JButton("Monitor");
		store.btnMonitor.setBounds(330, 502, 80, 30);
		store.vLog.btnBuilder(store.btnMonitor);
	}
}
