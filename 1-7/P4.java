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
    
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
    
        ArrayList<ArrayList<Integer>> ans = new ArrayList();    
        
        LinkedList<Point> q = new LinkedList(); 
        
        for(int i=0;i<A.size();i++){
            ans.add(new ArrayList<Integer>());
            for(int j=0;j<A.get(i).size();j++){
                ans.get(i).add(Integer.MAX_VALUE);
                if(A.get(i).get(j) == 1) {
                    q.addLast(new Point(i,j));
                    ans.get(i).set(j, 0);
                }
            }
        }
        
        while(!q.isEmpty()){
            
            Point p = q.poll();
            
            for(Point p1: getAdjacent(p, A)){
                
                 if(ans.get(p1.x).get(p1.y) > ans.get(p.x).get(p.y) + 1){
                     
                     ans.get(p1.x).set(p1.y, ans.get(p.x).get(p.y) + 1);
                     q.add(new Point(p1.x, p1.y));          
                 }  
                
            }
            
        }
        
        return ans;
    }
    
    public List<Point> getAdjacent(Point p, ArrayList<ArrayList<Integer>> A){
        
            List<Point> ans = new ArrayList();        
            
            for(int i=0;i<4;i++){
                
                int x1 = p.x + x[i];
                int y1 = p.y + y[i];
                
                if(x1 >=0 && x1 < A.size() && y1 >= 0 && y1 < A.get(x1).size() && A.get(x1).get(y1) == 0){
                    
                    ans.add(new Point(x1,y1));
                    
                }
                
            }
     return ans;   
    }
    
    
    
    
}
