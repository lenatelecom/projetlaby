package maze;
import java.util.ArrayList;

import dijkstra.*;
import fr.enst.inf103.ui.MazeViewSource;
import fr.enst.inf103.ui.MazeViewController;

public class MazeController implements  MazeViewController {

	private MazeViewSource maze;
	
	public MazeController(int h, int w){
		maze = new Maze(h, w);
	}
	
	@Override
	/* Creer une methode dans maze qui fasse apparaire un nouveau type de case, chemin en jaune, on va l'utiliser ici.
	Ici si la liste des cases chemin est nulle on 
	va appliquer dijkstra d'un depart jusqu'a une arrivee, et on aura le chemin. Si la liste est pleine,
	il y a deja un chemin donc faut vider
	ces cases.  */
	public void calculateShortestPath() {
		try{Maze maze1 = (Maze) maze;
		ArrayList<MBox> caseschemin = maze1.casesjaunes();
		
		if(caseschemin.size()==0){
			Previous previous = (Previous) Dijkstra.dijkstra(maze1,maze1.getDeparture());
			ArrayList<MBox> chemin = previous.getShortestPathTo(maze1.getArrival());
			for(int i= chemin.size()-1 ; i>= 0 ; i--) {
				MBox box = (MBox) chemin.get(i);
				maze.setSymbolForBox(box.getLine(),box.getColumn(),"*");
			}
		}
		
		else {
			for (int i = 0;i<caseschemin.size();i++){
				MBox box = (MBox) caseschemin.get(i);
				maze.setSymbolForBox(box.getLine(),box.getColumn(),"E");
			}
		}
		}catch(NullPointerException e){
			System.out.println("Il manque une case arrivé et/ou départ");
			
		}
		
	}
	
	
	
	
	
	
	@Override
	public MazeViewSource getMazeViewSource() {
		return maze;
	}

	@Override
	public MazeViewSource newMaze() {
		// construire un nouveau maze de taille donnee
		maze = new Maze(this.maze.getHeight(),this.maze.getWidth());
		 return maze;
	}
	@Override
	public MazeViewSource openMaze(String fileName) {
		// ouvrir un maze a partir du fichier texte
		Maze mazee = (Maze) maze;
		 mazee.initFromTextFile(fileName);
		 maze=mazee;
		 return mazee;
		 
		
	}
	@Override
	public void saveMazeAs(String fileName) {
		// sauvegarder un maze dans un fichier texte
		Maze mazee = (Maze) maze;
		mazee.saveToTextFile(fileName);
	}
}
