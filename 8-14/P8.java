import java.util.*;

/*

	Commutable Islands-
		kruskal's algorithm(finding the minimal spanning tree)
		disjoint set (union by rank & path compression)

*/
public class Solution {
    
    class DisjointSet<T>{

        HashMap<T, Node> map = new HashMap();

        DisjointSet(){
            map = new HashMap();
        }


        class Node{
            T data;
            int rank;
            Node parent;
        }    


        public boolean union(T x1, T x2){

            Node r1 = findSet(x1);
            Node r2 = findSet(x2);

            if(r1 == null || r2 == null || r1 == r2) return false;

            if(r1.rank <= r2.rank){

                r2.rank = r1.rank == r2.rank ? r1.rank + 1 : r2.rank;
                r1.parent = r2;

            }else{

                r2.parent = r1;

            }
            return true;
        }

        public void makeSet(T x){

            Node n = new Node();
            n.data = x;
            n.rank = 0;
            n.parent = n;
            map.put(x, n);

        }

        public Node findSet(T x){

            return findSet(map.get(x));

        }

        public Node findSet(Node n){

            if(n == null) return null;

            Node p = n.parent;

            if(p == n) return p;

            n.parent = findSet(n.parent);

            return n.parent;
        }


    }
    
    
        // kruskal's algorithm
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        
        Set<Integer> vertices = new HashSet();
        for(ArrayList<Integer> x: B) {
            vertices.add(x.get(0));
            vertices.add(x.get(1));
            
        }
        
        DisjointSet<Integer> ds = new DisjointSet();
        
        for(Integer x: vertices) ds.makeSet(x);
        
        Collections.sort(B, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> x, ArrayList<Integer> y){
                return x.get(2) - y.get(2);
            }
        });
        
        int cost = 0;
        
        for(ArrayList<Integer> x: B){
            
         boolean ans =  ds.union(x.get(0), x.get(1));   
        
         if(ans) cost += x.get(2);    
         
        }
        
        return cost;
    }
    
}
