package maze;
import java.io.PrintWriter;

public class ABox extends MBox {
	 
	public ABox(int line, int column)
	{
		super("A", line, column);
	}
	
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('A');
	}
	@Override
	public final  String getSymbol()
	{
		return "A";
	}
}
