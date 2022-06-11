package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName SatisfiabilityOfEqualityEquations
 * @Description
 * You are given an array of strings equations that represent relationships between variables where each string
 * equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here,
 * xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if it is possible to assign integers to variable names so as to satisfy all the given equations,
 * or false otherwise.
 * @Author katefu
 * @Date 6/10/22 10:43 AM
 * @Version 1.0
 **/
public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        String[] e = {"a==b","b==c","c!=a"};
        Solution990 test = new Solution990();
        test.equationsPossibleSample(e);
    }
}

class Solution990 {
    //UF
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                // 如果相等关系成立，就是逻辑冲突
                if (uf.connected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
    }

    //DFS
    public boolean equationsPossibleSample(String[] equations) {
        if(equations.length == 0) return true;
        Map<Character, HashSet<Character>> map = new HashMap<>();
        for(String formula : equations) {
            if(formula.charAt(1) == '=') {
                Character pre = formula.charAt(0);
                Character nxt = formula.charAt(3);
                if(!map.containsKey(pre)) map.put(pre, new HashSet<>());
                map.get(pre).add(nxt);
                if(!map.containsKey(nxt)) map.put(nxt, new HashSet<>());
                map.get(nxt).add(pre);
            }
        }

        for(String formula : equations) {
            if(formula.charAt(1) == '!') {
                Character pre = formula.charAt(0);
                Character nxt = formula.charAt(3);
                if(pre == nxt) return false;
                if(!map.containsKey(pre) || !map.containsKey(nxt)) continue;
                if(hasConflict(pre, nxt, map, new HashSet<>())) return false;
            }
        }
        return true;
    }

    private boolean hasConflict(Character pre, Character nxt, Map<Character,
            HashSet<Character>> map, HashSet<Character> set) {
        if(pre == nxt) return true;
        set.add(pre);
        for(Character next : map.get(pre)) {
            if(set.contains(next)) continue;
            if(hasConflict(next, nxt, map, set)) return true;
        }
        return false;
    }
}

