package Logics;

import DataCenter.Storage;
import FourK.BottomPanelRebuild;
import FourK.MainPanelRebuild;
import FourK.RightPanelRebuild;

public class FourKHandler
{
	private Storage store;
	private MainPanelRebuild mpr;
	private RightPanelRebuild rpr;
	private BottomPanelRebuild bpr;
	
	public FourKHandler(Storage store)
	{
		this.store = store;
		this.mpr = new MainPanelRebuild(store);
		this.rpr = new RightPanelRebuild(store);
		this.bpr = new BottomPanelRebuild(store);
	}
	
	public void goToFourK()
	{
		mpr.goTo4K();
		rpr.goTo4K();
		bpr.goTo4K();
	}
	
	public void goBack()
	{
		
	}
}
