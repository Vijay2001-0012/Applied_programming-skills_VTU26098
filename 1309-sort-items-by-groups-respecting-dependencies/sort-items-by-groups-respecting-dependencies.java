class Solution {

    public int[] sortItems(int n,
                           int m,
                           int[] group,
                           List<List<Integer>> beforeItems) {

        // Assign unique groups to ungrouped items
        for (int i = 0; i < n; i++) {

            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        for (int item = 0; item < n; item++) {

            for (int prev : beforeItems.get(item)) {

                itemGraph.get(prev).add(item);
                itemIndegree[item]++;

                if (group[item] != group[prev]) {

                    groupGraph.get(group[prev]).add(group[item]);

                    groupIndegree[group[item]]++;
                }
            }
        }

        List<Integer> itemOrder =
            topoSort(itemGraph, itemIndegree, n);

        List<Integer> groupOrder =
            topoSort(groupGraph, groupIndegree, m);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }

        Map<Integer, List<Integer>> groupedItems =
            new HashMap<>();

        for (int item : itemOrder) {

            groupedItems
                .computeIfAbsent(group[item],
                    k -> new ArrayList<>())
                .add(item);
        }

        List<Integer> result = new ArrayList<>();

        for (int grp : groupOrder) {

            result.addAll(
                groupedItems.getOrDefault(
                    grp,
                    new ArrayList<>()
                )
            );
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private List<Integer> topoSort(List<List<Integer>> graph,
                                   int[] indegree,
                                   int size) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();

            order.add(current);

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (order.size() == size) {
            return order;
        }

        return new ArrayList<>();
    }
}