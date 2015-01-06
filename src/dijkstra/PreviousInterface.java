package dijkstra;
import maze.Maze;
import java.util.ArrayList;

import maze.MBox;
public interface PreviousInterface {

	public void setValue(VertexInterface vertex, VertexInterface value);
	public VertexInterface getValue(MBox vertex);
	public ArrayList<MBox> getShortestPathTo (MBox vertex);
}
