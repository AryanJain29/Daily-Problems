import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void findCombination(int ind, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds)); // Add a copy of ds
            return;
        }
        if (ind == candidates.length || target < 0) {
            return;
        }

        // Pick the current candidate
        if (candidates[ind] <= target) {
            ds.add(candidates[ind]);
            findCombination(ind, candidates, target - candidates[ind], ds, ans);
            ds.remove(ds.size() - 1); // Backtrack
        }

        // Skip the current candidate
        findCombination(ind + 1, candidates, target, ds, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombination(0, candidates, target, ds, ans);
        return ans;
    }
}
