class Solution {

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        int original = image[sr][sc];

        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    private void dfs(int[][] image,
                     int row,
                     int col,
                     int original,
                     int color) {

        if (row < 0 ||
            col < 0 ||
            row >= image.length ||
            col >= image[0].length ||
            image[row][col] != original) {

            return;
        }

        image[row][col] = color;

        dfs(image, row + 1, col, original, color);
        dfs(image, row - 1, col, original, color);
        dfs(image, row, col + 1, original, color);
        dfs(image, row, col - 1, original, color);
    }
}