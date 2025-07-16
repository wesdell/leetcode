package top100liked;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
        39. Generate Parentheses
        Execution explanation at the bottom
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combine(candidates, target, 0, new ArrayList<>(), 0, res);
        return res;
    }

    private void combine(int[] candidates, int target, int idx, List<Integer> combination, int sum, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (sum > target || idx >= candidates.length) {
            return;
        }

        combination.add(candidates[idx]);
        combine(candidates, target, idx, combination, sum + candidates[idx], res);
        combination.removeLast();
        combine(candidates, target, idx + 1, combination, sum, res);
    }

    /*
        -------------------------------

        candidates -> [2, 3, 5] | target -> 8

        idx -> 0 | combination -> [] |
        res -> [] | sum -> 0
                            combination -> [2] | sum -> 2
                                        combination -> [2, 2] | sum -> 4
                                                combination -> [2, 2, 2] | sum -> 6
                                                        combination -> [2, 2, 2, 2] | sum -> 8
                                                        res -> [ [2, 2, 2, 2] ]

                                                combination -> [2, 2, 2] | idx -> 1
                                                ....

                                        combination -> [2, 2] | ixd -> 1
                                        ....
                            combination -> [2] | idx -> 1
                                        combination -> [2, 3] | sum -> 5
                                                combination -> [2, 3, 3] | sum -> 8
                                                res -> [ [2, 2, 2, 2] [2, 3, 3] ]

                                        combination -> [2, 3] | idx -> 2
                                        ....

                           combination -> [2] | idx -> 2
                           ....

        idx -> 1 | combination -> [2] |
        res -> [ [2, 2, 2, 2] [2, 3, 3] ] | sum -> 0
                           combination -> [3] | sum -> 3
                                        combination -> [3, 3] | sum -> 6
                                                combination -> [3, 3, 3] | sum -> 9

                           combination -> [3] | idx -> 2
                                        combination -> [3, 5] | sum -> 8
                                        res -> res -> [ [2, 2, 2, 2] [2, 3, 3] [3, 5] ]

        --------------------------------
    */
}
