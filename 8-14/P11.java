public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        
        if(C == D) return 0;
        
        
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<A;i++) graph.add(new ArrayList());
        for(ArrayList<Integer> x: B) {
            
            if(x.get(2) == 2){
                graph.add(new ArrayList());
                graph.get(x.get(0)).add(A);
                graph.get(A).add(x.get(0));
                graph.get(A).add(x.get(1));
                graph.get(x.get(1)).add(A);
                A++;
            }else{
                graph.get(x.get(0)).add(x.get(1));
                graph.get(x.get(1)).add(x.get(0));
            }
        }
        
        
        
        // for(List<Integer> x: graph)
        //     System.out.println(x);
            
            

        boolean[] visited = new boolean[A];
        LinkedList<Integer> q = new LinkedList();
        q.add(C);
        q.add(null);
        
        int dis = 1;
        
        while(!q.isEmpty()){
            
            Integer i = q.poll();    
        
            if(i == null){
                if(q.isEmpty()) break; 
                q.add(null);
                dis++;
                continue;
            }
            
            visited[i] = true;
            
            
            for(Integer n: graph.get(i)){
                
        
                if(!visited[n]){
                    
                    if(n == D) return dis;
                    
                    q.add(n);  
                    
                }
                
            }
            
            
        }
        
        
        return -1;
        
    }
}
