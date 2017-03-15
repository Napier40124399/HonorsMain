package GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DataCenter.Bridge;

public class SettingsWindow
{
	//Colors
	private Color NeonGreen = new Color(0,255,128);
	private Color NeonBlue = new Color(0,155,255);
	private Color NeonRed = new Color(255,102,102);
	private Color Fade = new Color(45,45,45);
	//Components
	private JFrame frame;
	private JCheckBox checkSave;
	//Instances
	private Bridge bridge;

	public SettingsWindow(Bridge bridge)
	{
		this.bridge = bridge;
		initialize();
	}
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Fade);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Settings");
		
		JLabel lblSave = new JLabel("Save");
		lblSave.setText("Save");
		lblSave.setBounds(10, 50, 70, 20);
		lblSave.setForeground(NeonGreen);
		lblSave.setBorder(null);
		lblSave.setFocusable(false);
		frame.getContentPane().add(lblSave);
		
		
		checkSave = new JCheckBox();
		checkSave.setBounds(50, 50, 20, 20);
		checkSave.setBackground(Color.white);
		checkSave.setForeground(NeonGreen);
		frame.getContentPane().add(checkSave);
		
		JLabel lblPath = new JLabel("Path");
		lblPath.setText("Path");
		lblPath.setBounds(10, 20, 70, 20);
		lblPath.setForeground(NeonGreen);
		lblPath.setBorder(null);
		lblPath.setFocusable(false);
		frame.getContentPane().add(lblPath);
		
		JTextField txt = new JTextField();
		txt.setBounds(50, 20, 200, 20);
		txt.setForeground(NeonGreen);
		txt.setBackground(Fade);
		txt.setEditable(false);
		txt.setBorder(new LineBorder(NeonGreen));
		frame.getContentPane().add(txt);
		
		JButton btn = new JButton();
		btn.setBounds(260, 20, 100, 20);
		btn.setText("Browse");
		btn.setForeground(NeonGreen);
		btn.setBackground(Fade);
		btn.setBorder(new LineBorder(NeonGreen));
		btn.setFocusable(false);
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
		frame.getContentPane().add(btn);
		
		
		checkSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				bridge.setSave(checkSave.isSelected());
				bridge.setPath(txt.getText());
			}
		});
		
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(1);
				Component comp = null;
				File f = new File("C:/");
				fc.setCurrentDirectory(f);
				fc.showOpenDialog(comp);
				try
				{
					File ff = fc.getSelectedFile();
					if(ff.exists())
					{
						txt.setText(fc.getSelectedFile()+"");
						checkSave.setSelected(true);
						bridge.setSave(checkSave.isSelected());
						bridge.setPath(fc.getSelectedFile()+"");
					}
				}catch(Exception ee){}
			}
		});
	}
	
	private void Hover(MouseEvent arg, Color color1, Color color2)
	{
		arg.getComponent().setBackground(color1);
		arg.getComponent().setForeground(color2);
	}
}
