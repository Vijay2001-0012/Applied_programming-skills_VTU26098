class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int transpose[][] = new int[matrix[0].length][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j<matrix[0].length;j++){
                transpose[j][i] = matrix[i][j];

            }
        }
        return transpose;

        
    }
}