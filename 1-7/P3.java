public class Solution {
    
    int[] x = {0, -1, 0, 1};
    int[] y = {1, 0, -1, 0};
    
    class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
   
        if(A.size() == 0) return 0;
   
        LinkedList<Point> q = new LinkedList();
        
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                if(A.get(i).get(j) == 2)    q.add(new Point(i,j));
            }
        }
        
        q.add(null);
        
        boolean[][] visited = new boolean[A.size()][A.get(0).size()];
        int time = 0;
        
        while(!q.isEmpty()){
            
            Point p = q.poll();
            
            if(p == null){
                if(q.isEmpty()) break;
                time++;    
                q.add(null);
                continue;
            }
            
            visited[p.x][p.y] = true;
            
            for(Point p1: getAdjacent(p,A)){
                
                if(!visited[p1.x][p1.y]){
                   
                   A.get(p1.x).set(p1.y, 2);    
                   q.add(new Point(p1.x, p1.y)); 
                    
                }
                
            }
            
            
        }
        
        
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                if(A.get(i).get(j) == 1)    return -1;
            }
        }
        return time; 
        
    }
    
    public List<Point> getAdjacent(Point p, ArrayList<ArrayList<Integer>> A){
        
        List<Point> ans = new ArrayList();
        
        for(int i=0;i<4;i++){
            
            int x1 = x[i] + p.x; 
            int y1 = y[i] + p.y;
            
            if(x1 >=0 && x1 < A.size() && y1 >=0 && y1 < A.get(x1).size() && A.get(x1).get(y1) == 1){
                ans.add(new Point(x1,y1));
            }
            
        }
        
        return ans;
    }   
    
    
}
