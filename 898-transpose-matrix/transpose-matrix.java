class Solution {
    public int[][] transpose(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        //non square matrix -> new matrix
        if(n != m) {
            int[][] tMat = new int[m][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                
                    tMat[j][i] = mat[i][j];
                
                }
            }
        return tMat;
        }

        //square matrix -> no new matrix req
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(j > i) {
                        //swap
                        int temp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = temp;
                }
            }
        }
        
        return mat;
    }
}