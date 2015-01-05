 package maze;

import java.io.PrintWriter;

public class PBox extends MBox{ //Box of the Path



 @Override
 public boolean isAccessible()
	{
		return false;
	}
 public PBox(int line, int column){
 	 super("P",line,column);
 }
 public final void writeCharTo(PrintWriter pw)
	{
		pw.print('P');
	}
}
