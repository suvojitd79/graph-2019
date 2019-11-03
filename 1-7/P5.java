public class Solution {
    
    public String multiple(int A) {
     
        if(A == 1) return "1";
        
        if(A == 0) return "0";
        

        long[] parent = new long[A+1];
        Arrays.fill(parent, -1L);
        
        LinkedList<Long> q = new LinkedList();
        q.add(1L);
        
        boolean[] visited = new boolean[A+1];
        
        while(parent[0] == -1L && !q.isEmpty()){
            
            long p = q.poll();
            
            long left = ( p * 10 ) % A;
            long right = (left + 1) % A;
            
            if(left != 1 && parent[(int)left] == -1L){
                
                parent[(int)left] = p;
                q.add(left);
                
            }
            
            
            if(right != 1 && parent[(int)right] == -1L){
                
                parent[(int)right] = p;
                visited[(int)right] = true;
                q.add(right);
                
            }
            
            
        }
        
        
        StringBuilder s = new StringBuilder();
        long pos  = 0;
        while(pos != 1L){
            
            s.append(visited[(int)pos] ? 1 : 0);
            pos = parent[(int)pos];
            
        }
        
        s.append("1");
        
        return s.reverse().toString();
    }
    
    
}
