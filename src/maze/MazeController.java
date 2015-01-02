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
	/* Créer une méthode dans maze qui fasse apparaître un nouveau type de case, chemin en jaune, on va l'utiliser ici.
	Ici si la liste des cases chemin est nulle on 
	va appliquer dijkstra d'un départ jusqu'à une arrivée, et on aura le chemin. Si la liste est pleine,
	il y a déjà un chemin donc faut vider
	ces cases.  */
	public void calculateShortestPath() {
		
	}
	
	
	
	
	
	
	@Override
	public MazeViewSource getMazeViewSource() {
		return maze;
	}
	@Override
	public MazeViewSource newMaze() {
		// construire un nouveau maze de taille donnée
		maze = new Maze(this.maze.getHeight(),this.maze.getWidth());
		 return maze;
			
		
	}
	@Override
	public MazeViewSource openMaze(String fileName) {
		// ouvrir un maze à partir du fichier texte
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
