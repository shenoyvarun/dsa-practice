class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int r1 = 0, c1 = 0, r2 = rows - 1, c2 = cols - 1;

        int row = -1;

        while(r1<=r2) {
            int mid = r1+(r2-r1)/2;

            if(target >= matrix[mid][0] && target<=matrix[mid][cols-1]) {
                row = mid;
                break;
            }
            if(target < matrix[mid][0]) {
                r2 = mid - 1;
            }
            else {
                r1 = mid + 1;
            }

        }
        if(row == -1)
            return false;

        int col = -1;

        while(c1<=c2) {
            int mid = c1+(c2-c1)/2;

            if(target == matrix[row][mid]) {
                col = mid;
                break;
            }
            if(target < matrix[row][mid]) {
                c2 = mid - 1;
            }
            else {
                c1 = mid + 1;
            }
        }
        return !(col == -1);
    }
}
