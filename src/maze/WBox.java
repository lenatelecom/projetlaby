package maze;
import java.io.PrintWriter;


public class WBox extends MBox {
	public WBox(int line, int column)
	{
		super("W", line, column);
	}
	
	@Override 
	public final boolean isAccessible()
	{
		return false;
		 
	}
	
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('W');
	}
	public final String getSymbol()
	{
		return "W";
	}
}

