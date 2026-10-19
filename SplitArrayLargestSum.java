class SplitArrayLargestSum {
    public boolean canDestribute(int arr[], int value, int k) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > value) {
                count++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }

        return count <= k;
    }

    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            low = Math.min(low, nums[i]);
            high += nums[i];
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDestribute(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}