import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;

public class main {
	
	public static void main(String[] args) throws FileNotFoundException {
		  System.out.print("Number of vertex: ");
		  DrawGraph.input = new Scanner(System.in);
		  DrawGraph.g1 = new GFG(DrawGraph.input.nextInt());
		   	Scanner scanner = null;
		    Scanner file = null;
		    
		    file = new Scanner(new File("src/gr120.tsp"));
		    int m=0;
		    while(file.hasNextInt()) {
		    	for(int i=0;i<=m;i++) {
		    		DrawGraph.g1.addEdge(m, i, file.nextInt());
		    		//System.out.println(m);
		    	}

		    	m++;
		    }
		    DrawGraph.g1.reOrganize();
		    
			try {
				scanner = new Scanner(new File("src/coords2.txt.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    while(scanner.hasNextDouble())
		    {
		        DrawGraph.coords.add((int)scanner.nextDouble());
		    } 
		  
		    
		   //MLP.random(DrawGraph.g1, DrawGraph.path);
		   MLP.nearestNeighbour(DrawGraph.g1, DrawGraph.path);
		    //MLP.nearestNeighbour(DrawGraph.g1, DrawGraph.path);
		    
		    DrawGraph.g1.printGraph();
		    System.out.println(MLP.calculatePath(DrawGraph.g1, DrawGraph.path));
		    
	    DrawGraph points = new DrawGraph();
	    JFrame frame = new JFrame("Points");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(points);
	    frame.setSize(2000, 1000);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    file.close();
	   // MLP.findBest(DrawGraph.g1);
	}
}
