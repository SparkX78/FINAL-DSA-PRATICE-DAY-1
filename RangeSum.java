public class RangeSum {
    private static int[][] prefix;
    public static void prefix_Matrix(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int top = (i > 0) ? prefix[i-1][j] : 0;
                int left = (j > 0) ? prefix[i][j-1] : 0;
                int topleft = (i > 0 && j > 0) ? prefix[i-1][j-1] : 0;
                prefix[i][j] = matrix[i][j] + top + left - topleft;

            }
        }
    }

    public static int sum_region(int row1, int col1, int row2, int col2){
        int top = (row1 > 0) ? prefix[row1-1][col2] : 0;
        int left = (col1 > 0) ? prefix[row2][col1-1] : 0;
        int topleft = (row1 > 0 && col1 > 0) ? prefix[row1-1][col1-1] : 0;
        int total = prefix[row2][col2];
        return  total - top - left + topleft;
    }

    public static void main(String[] args){
        int[][] matrix = { {2, 4, 6},
                            {0, 1, 1},
                            {4, 3, 9}};
        prefix_Matrix(matrix);

        int row1 = 1;
        int row2 = 2;
        int col1 = 1;
        int col2 = 2;

        System.out.println("THE SUM OF THE GIVEN REGION :"+ sum_region(row1, col1, row2, col2));
    }
}
