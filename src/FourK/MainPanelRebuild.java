package FourK;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;

import DataCenter.Storage;

public class MainPanelRebuild
{
	private Storage store;

	public MainPanelRebuild(Storage store)
	{
		this.store = store;
	}

	public void goTo4K()
	{
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		int pos = (int) ((dimen.width - (dimen.getHeight() - 100)) / 2);
		store.panel.setBounds(pos, 20, (int) (dimen.getHeight() - 100), (int) (dimen.getHeight() - 100));
		store.panel.setBorder(new LineBorder(Color.white));
		store.panel.requestFocus();

		store.btnRun.setBounds(store.panel.getX() + store.panel.getWidth() + 20, 900, 200, 80);
		store.btnRun.setFont(new Font("Monospaced", Font.PLAIN, 40));

		store.btnUpdate.setBounds(store.btnRun.getX() + 220, 900, 200, 80);
		store.btnUpdate.setFont(new Font("Monospaced", Font.PLAIN, 40));

		store.btnSettings.setBounds(store.frame.getWidth() - 300, store.frame.getHeight() - 200, 200, 80);
		store.btnSettings.setFont(new Font("Monospaced", Font.PLAIN, 40));

		store.seperator.setBounds(-1000, -1000, 0, 0);
	}

	public void goBack()
	{

	}
}
