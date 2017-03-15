package Memory;

import java.util.ArrayList;

public class Brain
{
	private MemSup mem;
	private ArrayList<ArrayList<Node>> network = new ArrayList<ArrayList<Node>>();
	private ArrayList<Node> nodes;
	
	public Brain(int size)
	{
		nodes = new ArrayList<Node>();
		nodes.add(new Node());
		network.add(nodes);
	}
	
	public void think(MemSup mem)
	{
		//INPUTING VALUES
		for(Node n : network.get(0))
		{
			for(int i = 0; i <= mem.getSize(); i++)
			{
				n.send(mem.remember(i, true));
				n.send(mem.remember(i, false));
			}
		}
		for(ArrayList<Node> arr : network)
		{
			for(Node n: arr)
			{
				n.think();
			}
		}
		
		Float res = new Float(0);
		for(int i = 0; i < network.get(network.size()-1).size(); i++)
		{
			res += network.get(network.size()-1).get(i).getValue();
		}
		//HANDLE OUTPUT
		
		//TODO output
	}
	
	public void addLayer()
	{
		nodes = new ArrayList<Node>();
		Node n = new Node();
		nodes.add(n);
		
		network.add(nodes);
		network.get(network.size()-1).add(n);
		try
		{
			for(Node nn : network.get(network.size() - 1))
			{
				nn.addNeighbor(n);
			}
		} catch (Exception e){}
	}
	
	public void addNode(int layer)
	{
		Node n = new Node();
		network.get(layer).add(n);
		try
		{
			for(Node nn : network.get(layer - 1))
			{
				nn.addNeighbor(n);
			}
		} catch (Exception e){}
	}
}
