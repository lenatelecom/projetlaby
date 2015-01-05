 package maze;

import java.io.PrintWriter;

public class PBox extends MBox{ //Box of the Path



 
 public PBox(int line, int column){
 	 super("P",line,column);
 }
 public final void writeCharTo(PrintWriter pw)
	{
		pw.print('P');
	}
}
