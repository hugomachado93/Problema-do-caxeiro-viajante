import java.util.*;
public class MLP {
	
	//static LinkedList<Integer> path;
	static int min = Integer.MAX_VALUE;
	public static int calculatePath(GFG g, LinkedList<Integer> path) {
		
		int sum = 0;
		
		if(path.size() == 1) {
			return 0;
		}
		
		for(int i=0;i<path.size()-1;i++) {
			//System.out.println(i);
			sum += g.getWeight(path.get(i), path.get(i+1));
		}
		
		sum += g.getWeight(path.getLast(), path.getFirst());
		
		return sum;
		
	}
	
	//Gera um caminho random
	public static void random(GFG g, LinkedList<Integer> path) {
		for(int i=0;i<g.numVertices;i++) {
			path.add(i);
		}
		Collections.shuffle(path);
	}
	
	//Troca duas cidades aleatoriamente
	public static void Swap(GFG g, LinkedList<Integer> l) {
		int temp;
		Random r = new Random();
		int x = r.nextInt(g.numVertices);
		int y = r.nextInt(g.numVertices);
		
		temp = l.get(x);
		l.set(x, l.get(y));
		l.set(y, temp);
	}
	
	//Acha o melhor caminho(Forca Bruta usando melhor solução)
	public static void findBest(GFG g) {
		while(true) {
			LinkedList<Integer> tempPath = (LinkedList<Integer>) DrawGraph.path.clone();
			int temp;
			Swap(g, tempPath);
			if(min > (temp = calculatePath(g, tempPath))) {
				min = temp;
				System.out.println(min);
				DrawGraph.path = (LinkedList<Integer>) tempPath.clone();
			}
		}
	}
	
	//Percorre pela cidade mais proxima
	public static LinkedList<Integer> nearestNeighbour(GFG g, LinkedList<Integer> path) {

		
		boolean visited[] = new boolean[g.numVertices];
		visited[0] = true;
		int min = Integer.MAX_VALUE;
		int index = 0;
		int temp=0;
		path.add(0);
		for(int i=0;i<g.numVertices;i++) {
			for(int j=0;j<g.numVertices;j++) {
				if(min > g.getWeight(temp, j) && visited[j] != true) {
					min = g.getWeight(temp, j);
					index = j;
				}
			}
			min = Integer.MAX_VALUE;
			temp=index;
			path.add(index);
			visited[index] = true;
		}
		path.removeLast();
		
		return path;
		
	}
	
	//Implementar algoritmo  de Simulated Annealing
	
}
