public class Solution {
    
    int[] x = {0, -1, -1, -1, 0 , 1 , 1 , 1};
    int[] y = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
    
        
        int count = 0;
        if(A.size() == 0) return count;
        
        boolean[][] visited = new boolean[A.size()][A.get(0).size()];
        
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                
                if(A.get(i).get(j) == 1 && !visited[i][j]){
                    dfs(i,j, visited, A);
                    count++;
                }   
                
            }
        }
        return count;
    }
    
    public void dfs(int x1,int y1, boolean[][] visited, ArrayList<ArrayList<Integer>> A){
        
        visited[x1][y1] = true; 
        
        for(int i=0;i<8;i++){
            
            int pos_x = x1 + x[i];
            int pos_y = y1 + y[i];
            
            if(pos_x >= 0 && pos_x < A.size() && pos_y >=0 && pos_y < A.get(pos_x).size() && !visited[pos_x][pos_y] && A.get(pos_x).get(pos_y) == 1){
                
                dfs(pos_x, pos_y, visited, A);
                
            }
            
        }
        
    }
    
    
}
