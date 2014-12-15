package maze;
import java.io.PrintWriter;

import dijkstra.VertexInterface;

public abstract class MBox 
	implements VertexInterface
{

	private final int line;
	private final int column;
	private final Maze maze;
	
	public abstract void writeCharTo(PrintWriter pw) ;
	
	public MBox(Maze maze, int line, int column){
		this.line = line;
		this.column = column;
		this.maze = maze;
									  			}
	public final String getLabel()
	{
		return "(" + line + "," + column + ")" ;
		
	}
	
	public final int getLine()
	{
		return line;
		
	}
	
	public final int getColumn()
	{
		return column;
		
	}

	public boolean isAccessible()
	{
		return true;
	}
	public String getSymbol()
	{
		return "E";
	}
	
	
	}

