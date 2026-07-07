class Solution {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int h) {

        if (l >= h)
            return;

        int mid = l + (h - l) / 2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, h);

        merge(nums, l, mid, h);
    }

    void merge(int[] nums, int l, int mid, int h) {

        int[] temp = new int[h - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= h) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= h) {
            temp[k++] = nums[j++];
        }

        for (i = l, k = 0; i <= h; i++, k++) {
            nums[i] = temp[k];
        }
    }
}