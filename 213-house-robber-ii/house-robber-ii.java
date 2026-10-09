class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n == 1){
            return nums[0];
        }
        int [] first=new int[n-1];
        int [] sec=new int[n-1];
        //excluding the last element 
        for(int i=0;i<n-1;i++){
            first[i]=nums[i];
            sec[i]=nums[i+1];
            
        }
        return Math.max(solve(first),solve(sec));
    }
    public int solve(int [] nums){
        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int incl=prev2+nums[i];
            int excl=prev1;
            int ans=Math.max(incl,excl);
            prev2=prev1;
            prev1=ans;
        }
        return prev1;
    }
}