package maze;

import java.io.PrintWriter;
// classe des cases du chemin
public class PBox extends MBox{ 



	@Override
	public boolean isAccessible()
	{
		return false;
	}
	public PBox(int line, int column){
		super("*",line,column);
	}
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('*');
	}
	@Override
	public final  String getSymbol()
	{
		return "*";
	}
}
