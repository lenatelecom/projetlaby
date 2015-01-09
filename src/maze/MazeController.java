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
	//cette methode permet de trouver le plus court chemin entre le depart et l'arrivee
	//en cliquant sur solve. Ce chemin apparait en jaune. Si un chemin est affiche et qu'on 
	//clique sur solve, il s'efface.
	public void calculateShortestPath() {
		try{Maze maze1 = (Maze) maze;
		ArrayList<MBox> caseschemin = maze1.casesjaunes();

		if(caseschemin.size()==0){
			Previous previous = (Previous) Dijkstra.dijkstra(maze1,maze1.getDeparture());
			ArrayList<MBox> chemin = previous.getPathTo(maze1.getArrival());
			for(int i= chemin.size()-1 ; i>= 0 ; i--) {
				MBox box = chemin.get(i);
				maze.setSymbolForBox(box.getLine(),box.getColumn(),"*");
			}
		}

		else {
			for (int i = 0;i<caseschemin.size();i++){
				MBox box = caseschemin.get(i);
				maze.setSymbolForBox(box.getLine(),box.getColumn(),"E");
			}
		}
		}catch(NullPointerException e){
			System.out.println("Case arrivee/depart absente/inaccessible");

		}

	}






	@Override
	public MazeViewSource getMazeViewSource() {
		return maze;
	}

	@Override
	// construire un nouveau maze de taille donnee
	public MazeViewSource newMaze() {

		maze = new Maze(this.maze.getHeight(),this.maze.getWidth());
		return maze;
	}
	// ouvrir un maze a partir du fichier texte grace a initFromTextFile
	@Override
	public MazeViewSource openMaze(String fileName) {

		Maze mazee = (Maze) maze;
		mazee.initFromTextFile(fileName);
		maze=mazee;
		return mazee;


	}
	// sauvegarder un maze dans un fichier texte grace a saveToTextFile
	@Override
	public void saveMazeAs(String fileName) {

		Maze mazee = (Maze) maze;
		mazee.saveToTextFile(fileName);
	}
}
