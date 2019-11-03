public class Solution {
    
    int[] x = {0, -1, 0, 1};
    int[] y = {1, 0, -1, 0};
    
    public void solve(ArrayList<ArrayList<Character>> a) {
        
        if(a.size()==0) return;
        
        boolean[][] visited = new boolean[a.size()][a.get(0).size()];
        for(boolean[] x:visited) Arrays.fill(x, false);
        
        
        for(int i=0;i<a.get(0).size();i++){
            
            if(a.get(0).get(i)=='O' && !visited[0][i])   
                    dfs(0,i,visited,a,'O','M');
                    
            if(a.get(a.size()-1).get(i)=='O' && !visited[a.size()-1][i])   
                    dfs(a.size()-1,i,visited,a,'O','M');
        }
        
        
        
        for(int i=0;i<a.size();i++){
            if(a.get(i).get(0)=='O' && !visited[i][0])   
                    dfs(i,0,visited,a,'O','M');
            
            int x1 = i;
            int y1 = a.get(x1).size()-1;
            if(a.get(x1).get(y1)=='O' && !visited[x1][y1])   
                    dfs(x1,y1,visited,a,'O','M');
        }
        
        
        visited = new boolean[a.size()][a.get(0).size()];
        
        
        
        for(int i=1;i<a.size()-1;i++){
            for(int j=1;j<a.get(i).size()-1;j++){
                            
                if(a.get(i).get(j)=='O' && !visited[i][j])   
                    dfs(i,j,visited,a,'O','X');
            }
        }
        
        visited = new boolean[a.size()][a.get(0).size()];
        
        for(int i=0;i<a.get(0).size();i++){
            
            if(a.get(0).get(i)=='M' && !visited[0][i])   
                    dfs(0,i,visited,a,'M','O');
                    
            if(a.get(a.size()-1).get(i)=='M' && !visited[a.size()-1][i])   
                    dfs(a.size()-1,i,visited,a,'M', 'O');
        }
        
        
        
        for(int i=0;i<a.size();i++){
            if(a.get(i).get(0)=='M' && !visited[i][0])   
                    dfs(i,0,visited,a,'M','O');
            
            int x1 = i;
            int y1 = a.get(x1).size()-1;
            if(a.get(x1).get(y1)=='M' && !visited[x1][y1])   
                    dfs(x1,y1,visited,a,'M','O');
        }
        
        
        
        
    }
    
    public void dfs(int x1,int y1, boolean[][] visited,ArrayList<ArrayList<Character>> a,char actual,char modified){
        
        visited[x1][y1] = true;
        a.get(x1).set(y1, modified);
        
        for(int i=0;i<4;i++){
            
            int pos_x = x[i] + x1;
            int pos_y = y[i] + y1;
            
            if(pos_x >= 0 && pos_x<a.size() && pos_y >= 0 && pos_y<a.get(pos_x).size() && a.get(pos_x).get(pos_y) == actual && !visited[pos_x][pos_y]){
                   
                    dfs(pos_x,pos_y,visited,a,actual,modified);    
                
            }
            
        }
    }
    
       
    
}
