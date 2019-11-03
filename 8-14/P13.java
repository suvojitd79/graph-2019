public class Solution {
    public int solve(String A, String B, ArrayList<String> C) {
        
        Set<String> words = new HashSet(C);
        if(!C.contains(B)) return 0;

        Set<String> s1 = new HashSet();
        Set<String> s2 = new HashSet();
        s1.add(A);
        s2.add(B);
        return helper(words, s1, s2, 1);
    }
    
    
    public int helper(Set<String> words, Set<String> s1,Set<String> s2, int level){
        
        if(s1.isEmpty()) return 0;
        
        if(s1.size() > s2.size()) return helper(words, s2 , s1, level);
        
        for(String str : s1) words.remove(str);
        for(String str : s2) words.remove(str);
        
        Set<String> set = new HashSet();
        
        for(String s: s1){
            
            char[] str = s.toCharArray();    
            
            for(int i=0;i<s.length();i++){
                
               char c = str[i]; 
                
                for(char x = 'a';x <= 'z';x++){
                    
                    str[i] = x;
                    
                    String new_str = new String(str);    
                        
                    if(s2.contains(new_str)) return level + 1;    
                        
                    if(words.contains(new_str)) 
                        set.add(new_str);
                    
                }
                    
                str[i] = c;
                
            }
            
            
        }
        return helper(words, s2, set,  level + 1);
        
    }
    
    
}


//////////////////////////////////////////////////////////
    

public class Solution {
    public int solve(String A, String B, ArrayList<String> C) {
        
        String[] words = new String[C.size()+2];
        for(int i=0;i<C.size();i++) words[i+1] = C.get(i);
        words[0] = A;
        words[words.length-1] = B;
        
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<words.length;i++) graph.add(new ArrayList());
        
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(checkWords(words[i],words[j])) graph.get(i).add(j);
            }
        }
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList();
        q.add(new Node(0, 1));
        visited[0] = true;
        
        while(!q.isEmpty()){
            
            Node n = q.poll();
            
            if(n.index == words.length-1) return n.dis;
            
            for(Integer x : graph.get(n.index)){
                
                if(!visited[x]){
                    
                    visited[x] = true;
                    q.add(new Node(x, n.dis + 1));
                    
                }
                
            }

        }
        
        return 0;
    }
    
    // check whether x is reachable from y
    public boolean checkWords(String x, String y){
        
        int count = 0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i) != y.charAt(i)) count++;
            if(count > 1) return false;
        }
        return count == 1 ? true : false; // 0-1
    }
    
    class Node{
        int index;
        int dis;
        Node(int i,int d){
            this.index = i;
            this.dis = d;
        }
    }
    
    
    
}














