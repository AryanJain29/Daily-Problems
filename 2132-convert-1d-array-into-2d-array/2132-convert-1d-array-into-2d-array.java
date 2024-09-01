class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total number of elements matches m * n
        if (m * n != original.length) {
            return new int[0][0]; // Return an empty 2D array if sizes don't match
        }

        int index = 0;
        int[][] res = new int[m][n]; // Create a 2D array with m rows and n columns
        
        // Fill the 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index];
                index++;
            }
        }
        
        return res; // Return the constructed 2D array
    }
}
