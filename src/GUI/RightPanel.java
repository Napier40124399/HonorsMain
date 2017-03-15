package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import DataCenter.Storage;

public class RightPanel
{
	private Storage store;
	private Float scale = new Float(1);
	
	public RightPanel(Storage store)
	{
		this.store = store;
	}

	public void makePanel()
	{
		store.seperator = new JPanel();
		store.seperator.setBackground(Color.red);
		store.frame.getContentPane().add(store.seperator);

		store.seperator2 = new JPanel();
		store.seperator2.setBackground(Color.black);
		store.frame.getContentPane().add(store.seperator2);

		store.checkTaurus = new JCheckBox();
		store.checkTaurus.setBackground(Color.white);
		store.checkTaurus.setForeground(store.NeonGreen);
		store.frame.getContentPane().add(store.checkTaurus);

		// Buttons
		store.btnUpdate = new JButton("Update");
		store.vLog.btnBuilder(store.btnUpdate);

		store.btnSettings = new JButton("Settings");
		store.vLog.btnBuilder(store.btnSettings);
		
		store.btnDisp = new JButton("MAP");
		store.vLog.btnBuilder(store.btnDisp);
		
		// Labels
		store.RightOptionsLbl.add(new JLabel("Cells"));
		store.RightOptionsLbl.add(new JLabel("Scenario"));
		store.RightOptionsLbl.add(new JLabel("C/D"));
		store.RightOptionsLbl.add(new JLabel("Delay"));
		store.RightOptionsLbl.add(new JLabel("Mutation"));
		store.RightOptionsLbl.add(new JLabel("T Value"));
		store.RightOptionsLbl.add(new JLabel("P Value"));
		store.RightOptionsLbl.add(new JLabel("Gen. Q."));
		store.RightOptionsLbl.add(new JLabel("Taurus"));
		store.RightOptionsLbl.add(new JLabel("R Value"));
		store.RightOptionsLbl.add(new JLabel("S Value"));
		store.RightOptionsLbl.add(new JLabel("It. / Gen"));
		store.RightOptionsLbl.add(new JLabel("Distance"));
		// Text Fields
		store.RightOptionsTxt.add(store.txtCells = new JTextField());
		store.RightOptionsTxt.add(store.txtSlider = new JTextField());
		store.RightOptionsTxt.add(store.txtSlider2 = new JTextField());
		store.RightOptionsTxt.add(store.txtSlider3 = new JTextField());
		store.RightOptionsTxt.add(store.txtT = new JTextField());
		store.RightOptionsTxt.add(store.txtR = new JTextField());
		store.RightOptionsTxt.add(store.txtP = new JTextField());
		store.RightOptionsTxt.add(store.txtS = new JTextField());
		store.RightOptionsTxt.add(store.txtLoops = new JTextField());
		store.RightOptionsTxt.add(store.txtItGen = new JTextField());
		store.RightOptionsTxt.add(store.txtDist = new JTextField());
		store.RightOptionsTxt.add(store.txtCores = new JTextField());
		// Sliders
		store.RightOptionsSlider.add(store.slider = new JSlider());
		store.RightOptionsSlider.add(store.slider2 = new JSlider());
		store.RightOptionsSlider.add(store.slider3 = new JSlider());

		for (JLabel lbl : store.RightOptionsLbl)
		{
			lbl.setFont(new Font("Arial", Font.BOLD, 25));
			store.vLog.lblBuilder(lbl);
		}
		for (JTextField txt : store.RightOptionsTxt)
		{
			txt.setBorder(new LineBorder(Color.black));
			txt.setForeground(Color.black);
			txt.setFont(new Font("Arial", Font.BOLD, 20));
			txt.setBackground(Color.white);
			store.frame.getContentPane().add(txt);
		}
		for (JSlider slide : store.RightOptionsSlider)
		{
			slide.setForeground(Color.black);
			slide.setBackground(Color.white);
			slide.setValue(0);
			store.frame.getContentPane().add(slide);
		}

		
		store.comboScenario = new JComboBox();
		store.comboScenario.setForeground(Color.black);
		store.comboScenario.setBorder(new LineBorder(Color.black));
		store.comboScenario.setBackground(Color.white);
		store.comboScenario.setFocusable(false);
		store.comboScenario.setFont(new Font("Arial", Font.BOLD, 20));
		store.frame.getContentPane().add(store.comboScenario);
		store.comboScenario.addItem("Synchronous");
		store.comboScenario.addItem("Asynchronous");
		store.comboScenario.addItem("TFT");
		store.comboScenario.addItem("NN1 - Beta");
		store.comboScenario.addItem("NN2 - Beta");
		
		store.comboColor = new JComboBox();
		store.comboColor.setForeground(Color.black);
		store.comboColor.setBorder(new LineBorder(Color.black));
		store.comboColor.setBackground(Color.white);
		store.comboColor.setFocusable(false);
		store.comboColor.setFont(new Font("Arial", Font.BOLD, 20));
		store.frame.getContentPane().add(store.comboColor);
		store.comboColor.addItem("Normal");
		store.comboColor.addItem("GreyScale");
		
		store.slider.setValue(20);
		store.slider2.setValue(1);
		store.checkTaurus.setSelected(true);
		

		store.txtCells.setText("100");
		store.txtSlider.setText("20%");
		store.txtSlider2.setText("10ms");
		store.txtSlider3.setText("0%");
		store.txtT.setText("1.5");
		store.txtR.setText("1");
		store.txtP.setText("0");
		store.txtS.setText("0");
		store.txtLoops.setText("0");
		store.txtDist.setText("1");
		store.txtItGen.setText("1");
		store.txtCores.setText("2");
		
		
		
		
		//Sizes
		int pos = 10;
		
		pos = store.panel.getX() + store.panel.getWidth();
		int poo = 10;
		for (JLabel lbl : store.RightOptionsLbl)
		{
			lbl.setBounds(pos + 20, poo, 200, 40);
			poo += 50;
		}
		
		store.RightOptionsLbl.get(9).setBounds(pos + 30 + 220, 255, 200, 40);
		store.RightOptionsLbl.get(10).setBounds(pos + 30 + 220, 305, 200, 40);
		store.RightOptionsLbl.get(11).setBounds(pos + 30 + 220, 355, 200, 40);
		store.RightOptionsLbl.get(12).setBounds(pos + 30 + 220, 410, 200, 40);
		
		store.btnUpdate.setBounds		(pos + 20, 502, 100, 30);
		store.btnSettings.setBounds		(pos + 30 + store.btnUpdate.getWidth(), 502, 100, 30);
		
		int width = store.RightOptionsLbl.get(0).getWidth();
		int x = pos + width + 30;
		store.txtCells.setBounds		(x, 5, 260, 40);
		store.comboScenario.setBounds	(x, 55, 260, 40);
		
		pos = 105;
		for(JSlider sl : store.RightOptionsSlider)
		{
			sl.setBounds(x-100, pos, 200, 40);
			pos += 50;
		}
		
		store.txtSlider.setBounds		(x+150, 105, 100, 40);
		store.txtSlider2.setBounds		(x+150, 155, 100, 40);
		store.txtSlider3.setBounds		(x+150, 205, 100, 40);
		
		store.txtT.setBounds			(x-80, 255, 60, 40);
		store.txtR.setBounds			(x+170, 255, 60, 40);
		store.txtP.setBounds			(x-80, 305, 60, 40);
		store.txtS.setBounds			(x+170, 305, 60, 40);
		store.txtLoops.setBounds		(x-80, 355, 60, 40);
		store.txtItGen.setBounds		(x+170, 355, 60, 40);
		store.txtDist.setBounds			(x+170, 410, 60, 40);
		store.checkTaurus.setBounds		(x-90, 410, 40, 40);
		store.comboColor.setBounds		(x, 460, 260, 40);
		store.txtCores.setBounds		(x-120, 460, 100, 40);
		store.btnDisp.setBounds			(x+10, 502, 100, 30);

		
		store.seperator2.setBounds		(x + 10, 250, 2, 150);
		store.seperator.setBounds		(-100, -120, 0, 0);
		
	}
	
	public int in(int in)
	{
		Float tt = new Float(in);
		tt = tt * scale;
		return Integer.parseInt(tt+"");
	}
}
