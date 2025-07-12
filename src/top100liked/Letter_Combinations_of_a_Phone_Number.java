package top100liked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
    /*
        17. Letter Combinations of a Phone Number
        Execution explanation at the bottom
    */

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        mix(0, digits, res, map, new StringBuilder());

        return res;
    }

    private void mix(int idx, String digits, List<String> res, Map<Character, String> map, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            mix(idx + 1, digits, res, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /*
        -------------------------------
        digits -> 23

        idx -> 0 --- 2 -> [a, b, c]
        idx -> 1 --- 3 -> [d, e, f]


        idx -> 0 | res -> [] | sb -> "" | letters -> [a, b, c]

        letter -> a | sb -> a
                                            idx -> 1 | letters -> [d, e, f]
                                            |    letter -> d | sb -> ad    |    idx -> 2 | res = [ad]
                                                 sb -> a
                                            |    letter -> e | sb -> ae    |    idx -> 2 | res = [ad, ae]
                                                 sb -> a
                                            |    letter -> f | sb -> af    |    idx -> 2 | res = [ad, ae, af]
                                                 sb -> a
        sb -> ""


       idx -> 0 | res -> [ad, ae, af] | sb -> ""  | letters -> [a, b, c]

       letter -> b | sb -> b

        --------------------------------
    */
}
