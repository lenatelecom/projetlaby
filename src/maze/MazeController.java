package maze;


import fr.enst.inf103.ui.MazeViewSource;
import fr.enst.inf103.ui.MazeViewController;


public class MazeController implements  MazeViewController {

	private MazeViewSource maze;
	
	public MazeController(int height, int width){
		maze = new Maze(height,width);
	}
	
	
	@Override
	public void calculateShortestPath() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MazeViewSource getMazeViewSource() {
		// TODO Auto-generated method stub
		return maze;
	}
	@Override
	public MazeViewSource newMaze() {
		// TODO Auto-generated method stub
		maze = new Maze(this.getHeight(),this.getWidth());
		 return maze;
			
		
	}
	@Override
	public MazeViewSource openMaze(String fileName) {
		// TODO Auto-generated method stub
		 maze.initFromTextFile(fileName);
		return maze;
	}
	@Override
	public void saveMazeAs(String fileName) {
		// TODO Auto-generated method stub
		
	}
}
