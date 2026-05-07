class Solution {

    int[] indexes;
    int[] tempIndexes;
    int[] counts;
    int[] tempNums;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        indexes = new int[n];
        tempIndexes = new int[n];
        counts = new int[n];
        tempNums = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            tempNums[i] = nums[i];
            tempIndexes[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (tempNums[j] < tempNums[i]) {

                nums[k] = tempNums[j];
                indexes[k] = tempIndexes[j];

                rightCount++;
                j++;

            } else {

                nums[k] = tempNums[i];
                indexes[k] = tempIndexes[i];

                counts[tempIndexes[i]] += rightCount;

                i++;
            }

            k++;
        }

        while (i <= mid) {

            nums[k] = tempNums[i];
            indexes[k] = tempIndexes[i];

            counts[tempIndexes[i]] += rightCount;

            i++;
            k++;
        }

        while (j <= right) {

            nums[k] = tempNums[j];
            indexes[k] = tempIndexes[j];

            j++;
            k++;
        }
    }
}