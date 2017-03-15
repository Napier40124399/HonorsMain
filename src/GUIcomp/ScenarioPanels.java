package GUIcomp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Vars;
import Variables.Colors;
import main.ScenarioOptions;

public class ScenarioPanels
{
	private boolean selected = false;
	private int ID;
	private String title;
	private Color background;
	private Color highlited;
	private Color hover;
	private Vars vars;
	//
	private JPanel panel;
	private JLabel label;
	private JButton btn1;
	private JButton btn2;
	private ScenarioPanels sp;
	private ScenarioOptions so;
	
	public ScenarioPanels(int ID, String title, Vars vars, ScenarioOptions so)
	{
		this.vars = vars;
		Colors cls = new Colors();
		highlited = cls.getTableSelected();
		hover = cls.getTableHover();
		this.ID = ID;
		this.title = title;
		
		//PANEL
		if(ID % 2 == 0){background = cls.getTableLight();}else{background = cls.getTableDark();}
		panel = new JPanel();
		panel.setBackground(background);
		panel.setFocusable(true);
		panel.setLayout(null);
		panel.setBounds(0, ID * 40, 400, 40);
		//LABEL
		label = new JLabel(ID+". "+title);
		label.setFont(new Font("sansserif", Font.PLAIN, 30));
		label.setBounds(1, 5, 350, 30);
		panel.add(label);
		//BUTTONS
		btn1 = new JButton();
		btn1.setText("");
		btn1.setBounds(290, -5, 50, 50);
		btn1.setIcon(new ImageIcon("res\\settings.png"));
		btn1.setRolloverIcon(new ImageIcon("res\\settingsHover.png"));
		btn1.setBorder(BorderFactory.createEmptyBorder());
		btn1.setContentAreaFilled(false);
		panel.add(btn1);
		
		btn2 = new JButton();
		btn2.setText("");
		btn2.setBounds(335, -5, 50, 50);
		btn2.setIcon(new ImageIcon("res\\delete.png"));
		btn2.setRolloverIcon(new ImageIcon("res\\deleteHover.png"));
		btn2.setBorder(BorderFactory.createEmptyBorder());
		btn2.setContentAreaFilled(false);
		panel.add(btn2);
		

		btn1.setVisible(false);
		btn2.setVisible(false);
		
		//Listeners
		panel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				if(!selected)
				{
					panel.setBackground(background);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				if(!selected)
				{
					panel.setBackground(hover);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(vars.getSP() != null)
				{
					if(!vars.getSP().equals(sp))
					{
						panel.setBackground(highlited);
						label.setForeground(Color.white);
						btn1.setVisible(true);
						btn2.setVisible(true);
						selected = true;
						vars.setSP(sp);
					}
					else
					{
						panel.setBackground(background);
						label.setForeground(Color.black);
						selected = false;
						btn1.setVisible(false);
						btn2.setVisible(false);
						vars.setSP(null);
					}
				}else
				{
					panel.setBackground(highlited);
					label.setForeground(Color.white);
					btn1.setVisible(true);
					btn2.setVisible(true);
					selected = true;
					vars.setSP(sp);
				}
			}
		});
		btn1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				so.extending();
			}
		});
	}
	
	public void unSelect()
	{
		btn1.setVisible(false);
		btn2.setVisible(false);
		panel.setBackground(background);
		label.setForeground(Color.black);
		selected = false;
	}
	
	public void setSP(ScenarioPanels sp)
	{
		this.sp = sp;
	}
	
	public void resize(int width)
	{
		panel.setBounds(0, ID * 40, width, 40);
		label.setBounds(1, 5, width - 50, 30);
	}
	
	public JPanel getPanel()
	{
		return this.panel;
	}
}
