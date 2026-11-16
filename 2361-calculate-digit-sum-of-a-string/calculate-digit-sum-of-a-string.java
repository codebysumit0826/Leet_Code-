class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;

        StringBuilder next = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            int sum = 0;
            for (int j = i; j < s.length() && j < i + k; j++)
                sum += s.charAt(j) - '0';
            next.append(sum);
        }

        return digitSum(next.toString(), k);

        
    }
}