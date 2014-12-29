package maze;
import java.io.PrintWriter;

import dijkstra.VertexInterface;

public abstract class MBox 
	implements VertexInterface
{

	private int line;
	private int column;
	private String type;
	
	public abstract void writeCharTo(PrintWriter pw) ;
	
	public MBox(String type, int line, int column){
		this.line = line;
		this.column = column;
		this.type = type;
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

