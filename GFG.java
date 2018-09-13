import java.util.*;

public class GFG {
	
	int numVertices;
	 
	public class Edge{
		public int u, v, w;
		
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		public String toString() {
			return " => " + v + " weight: " + w;
		}
		
		
	}
	
	LinkedList<Edge> e[];
	public GFG(int v) {
		numVertices = v;
		e = new LinkedList[numVertices];
		
		for(int i=0;i<numVertices;i++) {
			e[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(int u, int v, int w) {
		//System.out.println(u);
		e[u].add(new Edge(u, v, w));
		e[v].add(new Edge(v, u, w));
	}
	
	public int getWeight(int u, int v) {
		return e[u].get(v).w;
	}
	
	public LinkedList<Edge> getAllConected(int u) {
		return e[u];
	}
	
	public void reOrganize() {
		for(int j=0;j<numVertices;j++) {
			e[j].remove(j);
		}
	}
	
	public void printGraph() {
		for(int i=0;i<numVertices;i++)
			System.out.println(i + "" + e[i]);
	}
	
}
