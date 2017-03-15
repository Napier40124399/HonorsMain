package GUI_2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main
{

	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnTools;
	private JMenu mnWindow;
	private JMenuItem mntmSimSettings;
	private JMenuItem mntmUpdateables;
	private JMenuItem mntmLatticeLayout;
	
	//Instances
	private SimSettings sSets;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Main()
	{
		sSets = new SimSettings();
		initialize();
	}

	private void initialize()
	{
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setResizable(false);
		frame.setSize(500, 500);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		mntmSimSettings = new JMenuItem("Sim Settings");
		mnTools.add(mntmSimSettings);
		
		mntmUpdateables = new JMenuItem("Updateables");
		mnTools.add(mntmUpdateables);
		
		mntmLatticeLayout = new JMenuItem("Lattice Layout");
		mnTools.add(mntmLatticeLayout);
		
		mnWindow = new JMenu("Window");
		menuBar.add(mnWindow);
		
		mntmSimSettings.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				sSets.setVisible(getPlacement());
			}
		});
	}
	
	private Point getPlacement()
	{
		int x = frame.getLocation().x + frame.getWidth();
		return new Point(x,(int) frame.getLocation().getY());
	}
}
