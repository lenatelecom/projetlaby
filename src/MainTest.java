import java.util.Scanner;

import fr.enst.inf103.ui.MazeWindow;

import maze.MazeController;

public class MainTest {

	
	public static void main(String[] args) {
	
	
	 	
	  int h = 10;
	  int w = 10;
	 	 try {
	 	 	 Scanner scan = new Scanner(System.in);
	 	 	 System.out.println("Hauteur du labyrinthe ?");
	 	 	 h = scan.nextInt();
	 	 	 System.out.println("Largeur du labyrinthe ?");
	 	 	 w = scan.nextInt();
	 	 	 scan.close();
	 	 }
	 	 catch (Exception e) {
	 	 	 System.out.println("Mauvaise saisie. Le labyrinthe aura la taille par defaut.");
	 	 }
	 	 finally {
	 	 	 MazeController mc = new MazeController(h,w);
	 	 	 MazeWindow mazeWindow = new MazeWindow("My awesome laby", mc);
	 	 }
	    
	 
	  
	     }
	
	   
}
