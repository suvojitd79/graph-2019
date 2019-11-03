public class Solution {
    
    class Node{
        int v, d;
        Node(int v,int d){
            this.v = v;
            this.d = d;
        }
    }
    
    class Comp implements Comparator<Node>{
        
        public int compare(Node x,Node y){
            return x.d - y.d;
        }
        
    }
    
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
    
        List<List<Node>> graph = new ArrayList();
        
        boolean[] visited = new boolean[A];
        int[] ans = new int[A];
        for(int i=0;i<ans.length;i++) ans[i] = Integer.MAX_VALUE;
        ans[C] = 0;
        
        for(int i=0;i<A;i++)
            graph.add(new ArrayList());
            
        for(ArrayList<Integer> x: B){
            graph.get(x.get(0)).add(new Node(x.get(1), x.get(2)));
            graph.get(x.get(1)).add(new Node(x.get(0), x.get(2)));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comp());
        pq.add(new Node(C, 0));
        
    
        while(!pq.isEmpty()){
            
            Node n = pq.poll();
            visited[n.v] = true;
            
            for(Node n1: graph.get(n.v)){
                
                if(!visited[n1.v]){
                    
                    if(ans[n1.v] > ans[n.v] + n1.d){
                       ans[n1.v] =  ans[n.v] + n1.d;
                       pq.add(new Node(n1.v, ans[n1.v]));
                    }
                    
                }
                
            }
            
            
        }
        
        ArrayList<Integer> a = new ArrayList();
        for(int x: ans){
            
            if(x == Integer.MAX_VALUE) a.add(-1);
            else a.add(x);
        }
        return a;
    }
    
}
