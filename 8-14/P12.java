class Solution {
    public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, ArrayList<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);
        
        wordList = new ArrayList(set);
        
        ArrayList<ArrayList<String>> ans = new ArrayList();
        
        if(beginWord.equals(endWord)){
            ans.add(new ArrayList<>(Arrays.asList(beginWord)));
            return ans;
        }
        
        
        if(!wordList.contains(endWord)) return new ArrayList<ArrayList<String>>();
        
        Queue<ArrayList<String>> q = new LinkedList();
        q.add(new ArrayList<String>(Arrays.asList(beginWord)));
        
        int level = 1;
        int maxLevel = Integer.MAX_VALUE;
        Set<String> visited = new HashSet();
        if(wordList.contains(beginWord)) visited.add(beginWord);
        
        
        while(!q.isEmpty()){
            
            ArrayList<String> front = q.peek();
            q.poll();
            String last = front.get(front.size()-1);

            
            if(front.size() > level){
                
                for(String str: visited) wordList.remove(str);
                visited.clear();
                
                if(front.size() > maxLevel) break;
                
                level = front.size();
            }
                

            char[] l = last.toCharArray();

            for(int i=0;i<l.length;i++){


                char c = l[i];

                for(char j='a';j<='z';j++){

                    l[i] = j;

                    String new_str = new String(l);

                    if(wordList.contains(new_str)){

                        visited.add(new_str);

                        ArrayList<String> str = new ArrayList(front);    
                        str.add(new_str); 

                        if(new_str.equals(endWord)){
                            maxLevel = level;
                            ans.add(str);                            
                        }else
                            q.add(str);

                    }


                }
                    
                    l[i] = c;

            }
            
            
        }
        
        
        return ans;
    }
}