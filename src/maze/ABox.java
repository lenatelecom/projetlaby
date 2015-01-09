package maze;
import java.io.PrintWriter;
//classe de la case d'arrivee
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
