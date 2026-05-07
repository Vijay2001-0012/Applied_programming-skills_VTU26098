class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] distance = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {

                    queue.offer(new int[]{i, j});

                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    !visited[newRow][newCol]) {

                    distance[newRow][newCol] =
                        distance[row][col] + 1;

                    visited[newRow][newCol] = true;

                    queue.offer(
                        new int[]{newRow, newCol}
                    );
                }
            }
        }

        return distance;
    }
}