package Memory;

import java.util.ArrayList;

public class Node
{
	private ArrayList<Node> next;
	private ArrayList<Float> weights = new ArrayList<Float>();
	private ArrayList<Float> results = new ArrayList<Float>();
	private Float value;
	
	public Node()
	{
		
	}
	
	/**
	 * Which of the next nodes are you accessing? Connection is that.
	 * @param connection
	 */
	public void pass(int connection)
	{
		Float temp = weights.get(connection) * value;
		// TODO Sigmoid!!       >>>     2[(1 + exp( - b))exp-1 - 0.51]
		
		next.get(connection).send(temp);
	}
	
	public void think()
	{
		for(int i = 0; i < next.size(); i++)
		{
			Float temp;
			temp = weights.get(i) * value;
			// TODO SIGMOID ADJUSTMENT
			next.get(i).send(temp);
		}
		reset();
	}
	
	public void send(Float temp)
	{
		value += temp;
	}
	
	public void reset()
	{
		value = new Float(0);
		results.clear();
	}
	
	public void passTo(ArrayList<Node> next)
	{
		for(int i = 0; i < next.size(); i++)
		{
			next.get(i).send(results.get(i));
		}
	}
	
	public void addNeighbor(Node n)
	{
		next.add(n);
		weights.add(new Float(Math.random()));
	}
	
	public Float getValue()
	{
		return this.value;
	}
	
	public void mutate()
	{
		for(Float f : weights)
		{
			
		}
	}
}
