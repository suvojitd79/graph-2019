public class Solution {
    
    int[] x = {0, -1 , 0, 1}; 
    int[] y = {1, 0, -1, 0};
    
    public int black(ArrayList<String> A) {
        
        if(A == null || A.size() == 0) return 0;
        
        boolean[][] visited = new boolean[A.size()][A.get(0).length()];
    
        for(boolean[] x: visited) Arrays.fill(x, false);
    
        int count = 0;
            
        for(int i=0;i<A.size();i++){
            
            for(int j=0;j<A.get(i).length();j++){
                
                if(!visited[i][j] && A.get(i).charAt(j) == 'X'){
                    
                    dfs(i,j,visited,A);
                    count++;
                }
                
            }
            
        }
        
        return count;
        
    }
    
    public void dfs(int x1,int y1, boolean[][] visited, ArrayList<String> A){
        
        visited[x1][y1] = true;
        
        for(int i=0;i<4;i++){
            
            int pos_x = x1 + x[i];
            int pos_y = y1 + y[i];
            
            if(pos_x >=0 && pos_x < A.size() && pos_y >= 0 && pos_y < A.get(pos_x).length() && !visited[pos_x][pos_y] && A.get(pos_x).charAt(pos_y) == 'X'){
                
                dfs(pos_x, pos_y, visited, A);
                
            }
            
            
        }
        
    }
    
}
