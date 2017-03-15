package FourK;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import DataCenter.Storage;

public class RightPanelRebuild
{
	private Storage store;

	public RightPanelRebuild(Storage store)
	{
		this.store = store;
	}

	public void goTo4K()
	{
		int y = 20;
		// Resizing Labels
		for (JLabel lbl : store.RightOptionsLbl)
		{
			lbl.setFont(new Font("Monospace", Font.PLAIN, 40));
			lbl.setBounds(store.panel.getWidth() + store.panel.getX() + 50, y, 200, 40);
			y += 80;
		}
		// Resizing Sliders
		y = 180;
		for (JSlider slider : store.RightOptionsSlider)
		{
			slider.setBounds(store.RightOptionsLbl.get(0).getX() + 210, y, 500, 60);
			BasicSliderUI sliderUI = new javax.swing.plaf.basic.BasicSliderUI(slider)
			{
				protected Dimension getThumbSize()
				{
					return new Dimension(60, 60);
				}
			};
			slider.setUI(sliderUI);
			y += 80;
		}
		store.btnUpdate.setBounds(738, 505, 100, 20);
		store.btnSettings.setBounds(628, 505, 100, 20);

		store.txtCells.setText("100");
		store.txtCells.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtCells.setBounds(store.RightOptionsLbl.get(0).getX() + 210, 20, 550, 60);

		store.txtSlider.setText("20%");
		store.txtSlider.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtSlider.setBounds(
				store.RightOptionsSlider.get(0).getX() + store.RightOptionsSlider.get(0).getWidth(), 180, 120, 60);

		store.txtSlider2.setText("10ms");
		store.txtSlider2.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtSlider2.setBounds(
				store.RightOptionsSlider.get(1).getX() + store.RightOptionsSlider.get(1).getWidth(), 260, 120, 60);

		store.txtSlider3.setText("0%");
		store.txtSlider3.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtSlider3.setBounds(
				store.RightOptionsSlider.get(2).getX() + store.RightOptionsSlider.get(2).getWidth(), 340, 120, 60);

		store.txtT.setText("1.5");
		store.txtT.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtT.setBounds(store.RightOptionsLbl.get(5).getX()+210, 420, 80, 60);
		store.txtR.setText("1");
		store.txtR.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtR.setBounds(store.RightOptionsLbl.get(5).getX()+210, 500, 80, 60);
		store.txtP.setText("0");
		store.txtP.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtP.setBounds(store.RightOptionsLbl.get(5).getX()+520, 420, 80, 60);
		store.txtS.setText("0");
		store.txtS.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtS.setBounds(store.RightOptionsLbl.get(5).getX()+520, 500, 80, 60);
		store.txtLoops.setBounds(store.RightOptionsLbl.get(5).getX()+210, 580, 80, 60);
		store.txtLoops.setText("0");
		store.txtLoops.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtDist.setText("1");
		store.txtDist.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.txtDist.setBounds(store.RightOptionsLbl.get(5).getX()+520, 580, 80, 60);
		store.RightOptionsLbl.get(9).setBounds(store.RightOptionsLbl.get(5).getX()+340, 420, 200, 60);
		store.RightOptionsLbl.get(10).setBounds(store.RightOptionsLbl.get(5).getX()+340, 500, 200, 60);
		store.RightOptionsLbl.get(11).setBounds(store.RightOptionsLbl.get(5).getX()+340, 580, 200, 60);
		
		store.checkTaurus.setBounds(store.RightOptionsLbl.get(5).getX()+210, 660, 60, 60);
		
		store.comboScenario.setBounds(store.RightOptionsLbl.get(5).getX()+210, 100, 550, 60);
		store.comboScenario.setFont(new Font("Monospaced", Font.PLAIN, 40));
		store.seperator2.setBounds(store.txtT.getX()+100,420,2,240);
	}

	public void goBack()
	{

	}
}
