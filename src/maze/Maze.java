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
	implements GraphInterface, MazeViewSource
	
{
	/** On rend les paramètres hauteur et largeur variables, pour en donner le choix à l'utilisateur */
	public int WIDTH;
	public int HEIGHT;
	private MBox[][] maze ;
	
	/** Création d'une MBox de taille donnée où toutes les cases sont des E */
	public Maze(int WIDTH, int HEIGHT)
	{
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.maze = new MBox[HEIGHT][WIDTH];
		for (int i=0;i<HEIGHT;i++){
			for (int j=0;j<WIDTH;j++){
				maze[i][j]=new EBox(i,j);
			}
		}
	}
	
	public final MBox getBox(int line, int column)
	{
		return maze[line][column];
	}
	
	public final ArrayList<VertexInterface> getAllVertices()
	{
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		
		for(int line = 0; line<HEIGHT;line++){
			MBox[] theLine = maze[line];
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
			MBox neighbor = maze[line-1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (line < HEIGHT-1){
			MBox neighbor = maze[line-1][column];
			if(neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column>0){
			MBox neighbor = maze[line+1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column<WIDTH-1){
			MBox neighbor = maze[line][column+1];
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
							maze[lineNo][colNo] = new DBox(lineNo,colNo); break;
						case 'A' :
							maze[lineNo][colNo] = new ABox(lineNo,colNo); break;
						case 'W' :
							maze[lineNo][colNo] = new WBox(lineNo,colNo); break;
						case 'E' : 
							maze[lineNo][colNo] = new EBox(lineNo,colNo); break;
						default :
							throw new MazeReadingException(fileName,lineNo,"unknown char'" + maze[lineNo][colNo] + "'");
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
					MBox[] line = maze[lineNo];
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
		public boolean drawMaze(Graphics arg0, MazeView arg1) {
			return false;
		}
		@Override
		public int getHeight() {
			return HEIGHT;
		}
		@Override
		public String getSymbolForBox(int line, int column) {
			MBox box = maze[line][column];
			return box.getSymbol();
		}
		@Override
		public int getWidth() {
			return WIDTH;
		}
		@Override
		public boolean handleClick(MouseEvent arg0, MazeView arg1) {
			return false;
		}
		@Override
		public boolean handleKey(KeyEvent arg0, MazeView arg1) {
			return false;
		}
		@Override
		public void setSymbolForBox(int arg0, int arg1, String arg2) {
			// à remplir
			
		}
		
		}
	
	

