public class Solution {
    
    int[] x = {-1,-2,-2,-1,1,2,2,1};
    int[] y = {2,1,-1,-2,-2,-1,1,2};
    
    public int knight(int A, int B, int C, int D, int E, int F) {
        
        if(C == E && D == F) return 0;
        
        Queue<Point> q = new LinkedList();
        q.add(new Point(C,D, 0));
        boolean[][] visited = new boolean[A+1][B+1];
        
        
        while(!q.isEmpty()){
            
            Point p = q.poll();    
            
            if(p.x == E && p.y == F) return p.dis;
            
            for(int i=0;i<8;i++){
                
                int x_pos = x[i] + p.x;
                int y_pos = y[i] + p.y;
                
                if(x_pos >=1 && x_pos <= A && y_pos >=1 && y_pos <= B && !visited[x_pos][y_pos]){
                    
                    visited[x_pos][y_pos] = true;    
                    q.add(new Point(x_pos,y_pos,p.dis+1));
                }
                
            }
            
        }
        
        
        return -1;
    }
    
    class Point{
        int x,y,dis;
        Point(int x,int y,int d){
            this.x = x;
            this.y = y;
            this.dis = d;
        }
    }
}
