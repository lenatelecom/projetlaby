package maze;
import dijkstra.*;
import fr.enst.inf103.ui.MazeViewSource;
import fr.enst.inf103.ui.MazeViewController;

public class MazeController implements  MazeViewController {

	private MazeViewSource maze;
	
	public MazeController(int h, int w){
		maze = new Maze(h, w);
	}
	
	@Override
	/* Cr�er une m�thode dans maze qui fasse appara�tre un nouveau type de case, chemin en jaune, on va l'utiliser ici.
	Ici si la liste des cases chemin est nulle on 
	va appliquer dijkstra d'un d�part jusqu'� une arriv�e, et on aura le chemin. Si la liste est pleine,
	il y a d�j� un chemin donc faut vider
	ces cases.  */
	public void calculateShortestPath() {
		
	}
	
	
	
	
	
	
	@Override
	public MazeViewSource getMazeViewSource() {
		return maze;
	}
	@Override
	public MazeViewSource newMaze() {
		// construire un nouveau maze de taille donn�e
		maze = new Maze(this.maze.getHeight(),this.maze.getWidth());
		 return maze;
			
		
	}
	@Override
	public MazeViewSource openMaze(String fileName) {
		// ouvrir un maze � partir du fichier texte
		Maze mazee = (Maze) maze;
		 mazee.initFromTextFile(fileName);
		 return mazee;
		 
		
	}
	@Override
	public void saveMazeAs(String fileName) {
		// sauvegarder un maze dans un fichier texte
		Maze mazee = (Maze) maze;
		mazee.saveToTextFile(fileName);
	}
}
