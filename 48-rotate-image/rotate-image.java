class Solution {
    public void rotate(int[][] matrix) {
        //transpose
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse
        for(int i=0;i<matrix.length;i++){
            int left=0;
            int right=matrix.length-1;
            while(left<right){
                int s=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=s;
                left++;
                right--;
            }
        }
        //printint the output
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}