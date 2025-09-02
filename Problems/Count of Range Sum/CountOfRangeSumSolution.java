public class CountOfRangeSumSolution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return (int) countAndSort(prefix, 0, prefix.length, (long) lower, (long) upper);
    }

    // counts valid pairs in sums[lo:hi), while sorting that range in-place
    private long countAndSort(long[] sums, int lo, int hi, long lower, long upper) {
        if (hi - lo <= 1)
            return 0;
        int mid = (lo + hi) >>> 1;
        long count = countAndSort(sums, lo, mid, lower, upper)
                + countAndSort(sums, mid, hi, lower, upper);

        // Count cross pairs where left index in [lo, mid) and right in [mid, hi)
        int l = mid, r = mid;
        for (int i = lo; i < mid; i++) {
            while (l < hi && sums[l] - sums[i] < lower)
                l++;
            while (r < hi && sums[r] - sums[i] <= upper)
                r++;
            count += r - l;
        }

        // Merge step (standard merge of two sorted halves)
        long[] merged = new long[hi - lo];
        int i = lo, j = mid, k = 0;
        while (i < mid && j < hi) {
            if (sums[i] <= sums[j])
                merged[k++] = sums[i++];
            else
                merged[k++] = sums[j++];
        }
        while (i < mid)
            merged[k++] = sums[i++];
        while (j < hi)
            merged[k++] = sums[j++];

        // Copy back
        System.arraycopy(merged, 0, sums, lo, merged.length);
        return count;
    }
}