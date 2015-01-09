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
	 
	 	 }
	 	 catch (Exception e) {
	 	 	 System.out.println("Mauvaise saisie. Le labyrinthe aura la taille par defaut.");
	 	 }

	 	 finally {
	 	 	 MazeController mc = new MazeController(h+2,w+2);
	 	 	 new MazeWindow("My awesome laby", mc);
	 	 }
	    
	 

	     }
	
	   
}
