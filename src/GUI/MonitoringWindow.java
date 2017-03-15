package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import DataCenter.Bridge;

public class MonitoringWindow
{
	private Color neonBlue = new Color(30,144,255);
	private JFrame frame;
	private Bridge bridge;
	private JTabbedPane tabs;
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private Color e = new Color(50,120,255);
	private Timer timer;

	public MonitoringWindow(Bridge bridge)
	{
		this.bridge = bridge;
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Monitoring");
		frame.setBounds(100, 100, 700, 600);
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel lbl1 = new JLabel("Proportions");
		lbl1.setForeground(neonBlue);
		lbl1.setFont(new Font("Monospaced", Font.BOLD, 40));
		lbl1.setBounds(0, -10, 270, 50);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Hard Defect");
		JLabel lbl3 = new JLabel("Hard Coop");
		JLabel lbl4 = new JLabel("TFT");
		JLabel lbl5 = new JLabel("Neural");
		
		lbl2.setFont(new Font("Monospaced", Font.BOLD, 40));
		lbl3.setFont(new Font("Monospaced", Font.BOLD, 40));
		lbl4.setFont(new Font("Monospaced", Font.BOLD, 40));
		lbl5.setFont(new Font("Monospaced", Font.BOLD, 40));
		
		lbl2.setForeground(neonBlue);
		lbl3.setForeground(neonBlue);
		lbl4.setForeground(neonBlue);
		lbl5.setForeground(neonBlue);
		
		lbl2.setBounds(30,30,280,50);
		lbl3.setBounds(30,90,280,50);
		lbl4.setBounds(30,150,280,50);
		lbl5.setBounds(30,210,280,50);
		
		frame.getContentPane().add(lbl2);
		frame.getContentPane().add(lbl3);
		frame.getContentPane().add(lbl4);
		frame.getContentPane().add(lbl5);
		
		for(int i = 0; i < 4; i++)
		{
			makeTxt(new JTextField(), (i*60)+30);
		}
		
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Float total = new Float(bridge.getSize());
				for(int i = 0; i < 4; i++)
				{
					String p1 = String.format("%1$"+9+ "s", (int) ((double) (bridge.getProp()[i])));
					String p2 = String.format("%1$"+3+ "s", (int) ((double) (bridge.getProp()[i]/total*100)));
					texts.get(i).setText(p1+" / "+p2+"%");
				}
			}
		});
	}
	
	private void makeTxt(JTextField txt, int y)
	{
		texts.add(txt);
		txt.setForeground(neonBlue);
		txt.setFont(new Font("Monospaced", Font.PLAIN, 40));
		txt.setBorder(new LineBorder(neonBlue));
		txt.setCaretColor(Color.red);
		txt.setBackground(Color.white);
		txt.setBounds(320,y,350,50);
		txt.setEditable(false);
		frame.getContentPane().add(txt);
	}
	
	public void setBridge(Bridge bridge)
	{
		this.bridge = bridge;
	}
	
	public void setVisible(Boolean bool)
	{
		frame.setVisible(bool);
		if(frame.isVisible())
		{
			timer.start();
		}else
		{
			timer.stop();
		}
	}
}
