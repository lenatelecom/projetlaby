package maze;
import fr.enst.inf103.ui.MazeViewSource;
import fr.enst.inf103.ui.MazeViewController;
public class MazeController implements  MazeViewController {

	private MazeViewSource maze;
	
	public MazeController(int h, int w){
		maze = new Maze(h, w);
	}
	
	@Override
	public void calculateShortestPath() {
		// à remplir
		
	}
	@Override
	public MazeViewSource getMazeViewSource() {
		// TODO Auto-generated method stub
		return maze;
	}
	@Override
	public MazeViewSource newMaze() {
		// TODO Auto-generated method stub
		maze = new Maze(this.maze.getHeight(),this.maze.getWidth());
		 return maze;
			
		
	}
	@Override
	public MazeViewSource openMaze(String fileName) {
		// TODO Auto-generated method stub
		Maze mazee = (Maze) maze;
		 mazee.initFromTextFile(fileName);
		 return mazee;
		 
		
	}
	@Override
	public void saveMazeAs(String fileName) {
		// TODO Auto-generated method stub
		Maze mazee = (Maze) maze;
		mazee.saveToTextFile(fileName);
	}
}
