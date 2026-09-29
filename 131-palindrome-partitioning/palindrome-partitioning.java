class Solution {
    public List<List<String>> partition(String s) {
        List<String> path=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();
        funct(0,path,result,s);
        return result;
        
    }
    public void funct(int index,List<String> path,List<List<String>> result,String s){
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                funct(i+1,path,result,s);
                path.remove(path.size()-1);
            }
        }
    }
     public boolean isPalindrome(String s,int start,int end){
            while(start<end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                end--;
                start++;
            }
            return true;
        }
    }

