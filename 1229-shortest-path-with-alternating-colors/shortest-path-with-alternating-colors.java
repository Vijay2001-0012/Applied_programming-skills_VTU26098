class Solution {

    public int[] shortestAlternatingPaths(int n,
                                          int[][] redEdges,
                                          int[][] blueEdges) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 = red, 1 = blue

        for (int[] edge : redEdges) {
            graph[edge[0]].add(new int[]{edge[1], 0});
        }

        for (int[] edge : blueEdges) {
            graph[edge[0]].add(new int[]{edge[1], 1});
        }

        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, -1});

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int node = current[0];
                int color = current[1];

                if (answer[node] == -1) {
                    answer[node] = distance;
                }

                for (int[] next : graph[node]) {

                    int nextNode = next[0];
                    int nextColor = next[1];

                    if (nextColor != color &&
                        !visited[nextNode][nextColor]) {

                        visited[nextNode][nextColor] = true;

                        queue.offer(
                            new int[]{nextNode, nextColor}
                        );
                    }
                }
            }

            distance++;
        }

        return answer;
    }
}