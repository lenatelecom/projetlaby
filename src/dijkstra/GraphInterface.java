package dijkstra;
import java.util.ArrayList;

public interface GraphInterface {
 
	public ArrayList<VertexInterface> getAllVertices() ;
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
	
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2);
}
