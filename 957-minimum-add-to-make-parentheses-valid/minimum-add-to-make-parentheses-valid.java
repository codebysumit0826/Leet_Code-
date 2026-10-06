class Solution {
    public int minAddToMakeValid(String s) {
            while (true) {
            int pos = s.indexOf("()");

            if (pos == -1) {
                return s.length();
            }

            s = s.substring(0, pos) + s.substring(pos + 2);
        }

        
    }
}