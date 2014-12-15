package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous 
	implements PreviousInterface
{
	private final Hashtable<VertexInterface,VertexInterface> table;
	
	public Previous()
	{
		table = new Hashtable<VertexInterface,VertexInterface>();
	}
	
	public void setValue(VertexInterface vertex, VertexInterface value)
	{
		table.put(vertex, value);
	}
	public VertexInterface getValue(VertexInterface vertex)
	{
		return table.get(vertex);
		
	}
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex)
	{
		ArrayList<VertexInterface> result = new ArrayList<VertexInterface>();
		while (vertex!= null) {
			result.add(vertex);
			vertex=getValue(vertex);
			
		}
		return result;
	}
}


