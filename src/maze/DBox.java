package maze;
import java.io.PrintWriter;

// classe de la case de depart
public class DBox extends MBox {
	public DBox(int line, int column)
	{
		super("D", line, column);
	}
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('D');
	}
	public final String getSymbol()
	{
		return "D" ;
	}
}

