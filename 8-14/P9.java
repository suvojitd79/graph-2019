public class Solution {
    
    Map<Integer, ArrayList<Integer>> graph; 
    Set<Integer> vertices;
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        
        graph = new HashMap();
        vertices = new HashSet();
        
        for(int i=0;i<B.size();i++){
            vertices.add(B.get(i));
            vertices.add(C.get(i));
            graph.put(B.get(i), new ArrayList());
            graph.put(C.get(i), new ArrayList());
        }
        
        
        for(int i=0;i<B.size();i++){
            graph.get(B.get(i)).add(C.get(i));
        }
        
        return isCycle();
    }
    
    public int isCycle(){
        
        Set<Integer> whiteSet = new HashSet(vertices);
        Set<Integer> greySet = new HashSet();
        Set<Integer> blackSet = new HashSet();
        
        while(whiteSet.size() > 0){
            
            Integer c = whiteSet.iterator().next();
            if(dfs(c, whiteSet, greySet, blackSet)) return 0;
        }
            
        return 1;
    }
    
    public boolean dfs(Integer c, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet){
        
        move(c, whiteSet, greySet);    
        
        for(Integer n : graph.get(c)){
            
            if(blackSet.contains(n)) continue;
            
            else if(greySet.contains(n)) return true;
            
            else if(dfs(n, whiteSet, greySet, blackSet)) return true;   
            
        }
        
        move(c, greySet, blackSet);
        
        return false;
    }
    
    
    public void move(Integer data, Set<Integer> source,Set<Integer> destination){
        
        source.remove(data);
        destination.add(data);
        
    }
    
    
}
