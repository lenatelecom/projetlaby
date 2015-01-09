package maze;
import java.io.PrintWriter;

// classe des cases vides accessibles
public class EBox extends MBox {
	
	public EBox(int line, int column)
	{
		super("E", line, column);
	}

	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('E');
	}
	public final String getSymbol()
	{
		return "E" ;
	}
}
