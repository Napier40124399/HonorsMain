package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DataCenter.Bridge;

public class DrawWindow
{
	private JFrame frame;
	private Bridge bridge;

	public DrawWindow()
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
	}
	
	public void setBridge()
	{
		this.bridge = bridge;
	}
	
	public void setVisible(Boolean bool)
	{
		frame.setVisible(bool);
	}
}
