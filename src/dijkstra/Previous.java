package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

import maze.MBox;

public class Previous 
	implements PreviousInterface
{
	private Hashtable<VertexInterface,VertexInterface> table;
	
	public Previous()
	{
		table = new Hashtable<VertexInterface,VertexInterface>();
	}
	@Override
	public void setValue(VertexInterface vertex, VertexInterface value)
	{
		table.put(vertex, value);
	}
	@Override
	public VertexInterface getValue(MBox vertex)
	{
		return table.get(vertex);
		
	}
	@Override
	public ArrayList<MBox> getShortestPathTo(MBox vertex)
	{
		ArrayList<MBox> result = new ArrayList<MBox>();
		MBox box = (MBox) this.getValue(vertex);
		while (box.getSymbol()!="D" && box.getSymbol()!="W") {
			result.add(box);
			box=(MBox) this.getValue(box);
			
		}
		return result;
	}
}


