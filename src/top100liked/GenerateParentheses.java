package top100liked;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
        22. Generate Parentheses
        Execution explanation at the bottom
    */

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        mix(0, 0, n, res, "");
        return res;
    }

    public void mix(int left, int right, int n, List<String> res, String str) {
        if (str.length() == n * 2) {
            res.add(str);
            return;
        }

        if (left < n) {
            mix(left + 1, right, n, res, str + "(");
        }

        if (right < left) {
            mix(left, right + 1, n, res, str + ")");
        }
    }

    /*
        -------------------------------

        res -> [] | str -> "" | n -> 3

        l -> 0 | r -> 0
                       l -> 1 | r -> 0 | str -> "("
                                                    l -> 2 | r -> 0 | str -> "(("
                                                                                 l -> 3 | r -> 0 | str -> "((("
                                                                                          r -> 1 | str -> "((()"
                                                                                          r -> 2 | str -> "((())"
                                                                                          r -> 3 | str -> "((()))"
                                                    l -> 2 | r -> 1 | str -> "(()"
                                                                                 l -> 3 | r -> 1 | str -> "(()("
                                                                                          r -> 2 | str -> "(()()"
                                                                                          r -> 3 | str -> "(()())"
                                                    l -> 2 | r -> 2 | str -> "(())
                                                                                 l -> 3 | r -> 2 | str -> "(())("
                                                                                          r -> 3 | str -> "(())()"
                       l -> 1 | r -> 1 | str -> "()"
                                                    l -> 2 | r -> 1 | str -> "()("
                                                                                 l -> 3 | r -> 1 | str -> "()(("
                                                                                        | r -> 2 | str -> "()(()"
                                                                                        | r -> 3 | str -> "()(())"
                                                    l -> 2 | r -> 2 | str -> "()()"
                                                                                 l -> 3 | r -> 2 | str -> "()()("
                                                                                        | r -> 3 | str -> "()()()"

        --------------------------------
    */
}
