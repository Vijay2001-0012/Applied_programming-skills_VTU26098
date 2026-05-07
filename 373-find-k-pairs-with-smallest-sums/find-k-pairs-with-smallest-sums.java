class Solution {

    public List<List<Integer>> kSmallestPairs(
            int[] nums1,
            int[] nums2,
            int k) {

        List<List<Integer>> result =
                new ArrayList<>();

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(
                    (a, b) ->
                    (a[0] + a[1]) - (b[0] + b[1])
                );

        for (int i = 0;
             i < Math.min(nums1.length, k);
             i++) {

            minHeap.offer(
                new int[]{nums1[i], nums2[0], 0}
            );
        }

        while (k > 0 && !minHeap.isEmpty()) {

            int[] current = minHeap.poll();

            int num1 = current[0];
            int num2 = current[1];
            int index = current[2];

            result.add(
                Arrays.asList(num1, num2)
            );

            if (index + 1 < nums2.length) {

                minHeap.offer(
                    new int[]{
                        num1,
                        nums2[index + 1],
                        index + 1
                    }
                );
            }

            k--;
        }

        return result;
    }
}