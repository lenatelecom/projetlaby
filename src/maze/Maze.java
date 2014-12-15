package maze;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import fr.enst.inf103.ui.MazeView;
import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class Maze
	implements GraphInterface, MazeViewSource, MazeViewController
	
{

	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private final MBox[][] boxes ;
	
	public Maze()
	{
		boxes = new MBox[HEIGHT][WIDTH];
		
	}
	public final MBox getBox(int line, int column)
	{
		return boxes[line][column];
	}
	
	public final ArrayList<VertexInterface> getAllVertices()
	{
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		
		for(int line = 0; line<HEIGHT;line++){
			MBox[] theLine = boxes[line];
			for (int column = 0;column<WIDTH;column++)
				allVertices.add(theLine[column]);
		}
		return allVertices;
		}
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex)
	{
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		
		MBox box = (MBox)vertex; //cast
		int line = box.getLine();
		int column = box.getColumn();
		
		if (line>0){
			MBox neighbor = boxes[line-1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (line < HEIGHT-1){
			MBox neighbor = boxes[line-1][column];
			if(neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column>0){
			MBox neighbor = boxes[line+1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column<WIDTH-1){
			MBox neighbor = boxes[line][column+1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		return successors;
		}
		
		public final int getWeight(VertexInterface src, VertexInterface dst){
			return 1;
		}
		
		public final void initFromTextFile(String fileName)
		{
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				
				for (int lineNo=0; lineNo < HEIGHT ; lineNo++){
					String line = br.readLine();
					
					if(line == null)
						throw new MazeReadingException(fileName, lineNo, "not enough lines");
					if ( line.length() < WIDTH)
						throw new MazeReadingException(fileName, lineNo,"line too short");
					if(line.length()> WIDTH)
						throw new MazeReadingException(fileName ,lineNo,"line too long");
					
					for (int colNo=0;colNo < WIDTH;colNo++){
						switch (line.charAt(colNo)){
						case 'D' :
							boxes[lineNo][colNo] = new DBox(this,lineNo,colNo); break;
						case 'A' :
							boxes[lineNo][colNo] = new ABox(this,lineNo,colNo); break;
						case 'W' :
							boxes[lineNo][colNo] = new WBox(this,lineNo,colNo); break;
						case 'E' : 
							boxes[lineNo][colNo] = new EBox(this,lineNo,colNo); break;
						default :
							throw new MazeReadingException(fileName,lineNo,"unknown char'" + boxes[lineNo][colNo] + "'");
						}
						}
					
				}
				
			} catch (MazeReadingException e){
				System.err.println(e.getMessage());
			} catch (FileNotFoundException e ){
				System.err.println("Error class Maze, initFromTextFile : file not found\""+fileName+"\"");
			} catch (IOException e) {
				System.err.println("Error class Maze, initFromTextFile: read error on file\""+fileName+"\"");
			} catch (Exception e ){
				System.err.println("Error:unknown error.");
				e.printStackTrace(System.err);
			} finally {
				if(fr !=null)
					try{ fr.close();} catch (Exception e){};
				if (br!= null)
					try { br.close();} catch (Exception e)  {};
					}
		}
		
		public final void saveToTextFile(String fileName)
		{
			PrintWriter pw = null ;
			try {
				pw = new PrintWriter(fileName);
				
				for(int lineNo=0; lineNo < HEIGHT ; lineNo++){
					MBox[] line = boxes[lineNo];
					for(int colNo=0;colNo< WIDTH;colNo++)
						line[colNo].writeCharTo(pw);
					pw.println();
				}
				
			} catch (FileNotFoundException e){
				System.err.println("Error class maze, saveToTextFile : file not found\""+fileName+"\"");
			} catch (SecurityException e){
				System.err.println("Error class maze, saveToTextFile: security exception\""+fileName+"\"");
			} catch (Exception e){
				System.err.println("Error:unknown error.");
				e.printStackTrace(System.err);
			} finally {
				if(pw!=null)
					try { pw.close() ; } catch (Exception e){};
				}
			}
		@Override
		public void calculateShortestPath() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public MazeViewSource getMazeViewSource() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public MazeViewSource newMaze() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public MazeViewSource openMaze(String fileName) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void saveMazeAs(String fileName) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean drawMaze(Graphics arg0, MazeView arg1) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int getHeight() {
			// TODO Auto-generated method stub
			return HEIGHT;
		}
		@Override
		public String getSymbolForBox(int line, int column) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int getWidth() {
			// TODO Auto-generated method stub
			return WIDTH;
		}
		@Override
		public boolean handleClick(MouseEvent arg0, MazeView arg1) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean handleKey(KeyEvent arg0, MazeView arg1) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void setSymbolForBox(int arg0, int arg1, String arg2) {
			// TODO Auto-generated method stub
			
		}
		}
	
	

