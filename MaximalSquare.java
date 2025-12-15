public class MaximalSquare {
    public static int AreaMax(int[][] matrix){
        if(matrix == null || matrix[0].length == 0 || matrix.length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);

                }
                
            }
        }
        return maxSide*maxSide;
    }

    public static void main(String[] args){
        int[][] matrix = { {1, 0, 0, 1},
                           {1, 0, 1, 1},
                           {1, 0, 1, 1},
                           {1, 0, 0, 1}};

        System.out.println("MAX AREA "+ AreaMax(matrix));
    }
}
