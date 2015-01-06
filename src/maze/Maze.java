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
import fr.enst.inf103.ui.MazeWindow;


public class Maze 
implements GraphInterface, MazeViewSource

{
	/** On rend les parametres hauteur et largeur variables, pour en donner le choix a l'utilisateur */
	public int Width;
	public int Height;
	private MBox[][] maze ;

	// Creation d'une MBox de taille donnee ou toutes les cases sont des E 


	public Maze(int Width, int Height)
	{
		this.Width = Width;
		this.Height = Height;
		this.maze = new MBox[Height][Width];
		for (int i=0;i<Height;i++){
			for (int j=0;j<Width;j++){
				maze[i][j]=new EBox(i,j);
			}   
		}
		for (int j=0;j<Height;j++){
			maze[j][0]=new WBox(j,0);
			maze[j][Width-1]=new WBox(j,Width-1);
		}
		for (int j=0;j<Width; j++){
			maze[0][j]= new WBox(0,j);
			maze[Height-1][j]=new WBox(Height-1,j);
		}

	}



	public final MBox getBox(int line, int column)
	{
		return maze[line][column];
	}
	public final ArrayList<VertexInterface> getAllVertices()
	{
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();

		for(int line = 0; line<Height;line++){
			MBox[] theLine = maze[line];
			for (int column = 0;column<Width;column++)
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
		if (line < Height-1){
			MBox neighbor = maze[line-1][column];
			if(neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column>0){
			MBox neighbor = maze[line+1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		if (column<Width-1){
			MBox neighbor = maze[line][column+1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		return successors;
	}

	/** Obtenir le poids entre deux sommets: 0 si c'est le m�me sommet, 1 s'ils sont li�s, -1 sinon */

	public final int getWeight(VertexInterface vertex1, VertexInterface vertex2)
	{
		if(vertex1==vertex2) { 
			return 0; 
		}
		else { ArrayList<VertexInterface> successors = getSuccessors(vertex1); 
		if (successors.contains(vertex2)){ return 1; }
		else {return -1;}
		}
	}	

	public final void initFromTextFile(String fileName)
	{
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			for (int lineNo=0; lineNo < Height ; lineNo++)
			{
				String line = br.readLine();

				if(line == null)
					throw new MazeReadingException(fileName, lineNo, "not enough lines");
				if ( line.length() < Width)
					throw new MazeReadingException(fileName, lineNo,"line too short");
				if(line.length()> Width)
					throw new MazeReadingException(fileName ,lineNo,"line too long");

				for (int colNo=0;colNo < Width;colNo++)
				{
					switch (line.charAt(colNo))
					{
					case 'D' :
						maze[lineNo][colNo] = new DBox(lineNo,colNo); break;
					case 'A' :
						maze[lineNo][colNo] = new ABox(lineNo,colNo); break;
					case 'W' :
						maze[lineNo][colNo] = new WBox(lineNo,colNo); break;
					case 'E' : 
						maze[lineNo][colNo] = new EBox(lineNo,colNo); break;
					case 'P' : 
						maze[lineNo][colNo] = new PBox(lineNo,colNo); break;
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
		} finally 
		{
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

			for(int lineNo=0; lineNo < Height ; lineNo++){
				MBox[] line = maze[lineNo];
				for(int colNo=0;colNo< Width;colNo++)
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
				try { pw.close() ; } catch (Exception e){

				}}
	}



	@Override
	public boolean drawMaze(Graphics arg0, MazeView arg1) {
		return false;
	}
	@Override
	public int getHeight() {
		return Height;
	}
	@Override
	public String getSymbolForBox(int line, int column) {
		MBox box = maze[line][column];
		return box.getSymbol();  
	}
	@Override
	public int getWidth() {
		return Width;
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
		// La m�thode nous permet de d�finir murs, arriv�e et d�part. 
		//On initialise puis avec le click ou shiftclick on pose nos cases
		//(la gestion du click et du shift est d�j� dans la MazeView.class du coup)
		if(arg0!=0 && arg0!=Height-1 && arg1!=0 && arg1!=Width-1){

			MBox box = null;
			if(arg2.equals("D")) {
				box = new DBox(arg0,arg1);
			}
			if(arg2.equals("E")) {
				box = new EBox(arg0,arg1);
			}
			if(arg2.equals("A")) {
				box = new ABox(arg0,arg1);
			}

			if(arg2.equals("W")) {
				box = new WBox(arg0,arg1);
			}
			if(arg2.equals("*")) {
				box = new PBox(arg0,arg1);
			}
			maze[arg0][arg1]=box;

		}
	}

	public MBox getDeparture()
	{

		for(int line = 0; line<getHeight(); line++)
		{
			MBox[] theLine = maze[line];
			for (int column = 0; column<getWidth(); column++)
			{

				MBox box = theLine[column];
				String name = box.getSymbol();

				if (name.equals("D")) {
					return maze[line][column];


				}
			}
		}
		return null;
	}	
	public MBox getArrival()
	{

		for(int line = 0; line<getHeight(); line++)
		{
			MBox[] theLine = maze[line];
			for (int column = 0; column<getWidth(); column++)
			{
				MBox box = theLine[column];

				String name = box.getSymbol();

				if (name.equals("A")) 
					return maze[line][column];

			}
		}
		return null;
	}
	public ArrayList<MBox> casesjaunes() { //renvoie la liste des cases du chemin 	 
	 	 ArrayList<MBox> liste = new ArrayList<MBox>();
	 	 for (int i = 0;i<getHeight();i++) {
	 	 	 for(int j = 0;j<getWidth();j++) {
	 	 	 	 MBox box = maze[i][j];
	 	 	 	 if (box.getSymbol().equals("*")) {liste.add(box);}
	 	 	 }
	 	 }
	 	 return liste;
	 }}



