import java.util.Scanner;

import fr.enst.inf103.ui.MazeWindow;

import maze.MazeController;

public class MainTest {

	 private static int h = 10;
	 private static int w = 10;
	  
	public static void main(String[] args) {
	
	Scanner scan = null;
	 	
	 
	 	 try {
	 	 	  scan = new Scanner(System.in);
	 	 	 System.out.println("Hauteur du labyrinthe ?");
	 	 	
	 	 	 System.out.println("Largeur du labyrinthe ?");
	 	 	   h = scan.nextInt(); 
	 	 	   w = scan.nextInt();
	 
	 	MazeController mc = new MazeController(h,w);
	 	 MazeWindow mazeWindow = new MazeWindow("My awesome laby", mc);
	 	 }
	 	 catch (Exception e) {
	 	 	 System.out.println("Mauvaise saisie. Le labyrinthe aura la taille par defaut.");
	 	 }

	 	 finally {
	 	 	 MazeController mc = new MazeController(h+2,w+2);
	 	 	 MazeWindow mazeWindow = new MazeWindow("My awesome laby", mc);
	 	 }
	    
	 

	     }
	
	   
}
