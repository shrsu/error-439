import java.util.*;

public class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // to mark visited elements
        backtrack(nums, new ArrayList<>(), ans, used);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> ans, boolean[] used) {
        // base case: permutation complete
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path)); // add a copy of current path
            return;
        }

        // try each number
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue; // skip if already used

            // choose
            used[i] = true;
            path.add(nums[i]);

            // explore
            backtrack(nums, path, ans, used);

            // unchoose (backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // quick test
    public static void main(String[] args) {
        PermutationsSolution solver = new PermutationsSolution();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> results = solver.permute(nums);

        for (List<Integer> perm : results) {
            System.out.println(perm);
        }
    }
}
