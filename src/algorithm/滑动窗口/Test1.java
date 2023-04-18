package algorithm.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 基因序列，ABCDEFGHIJKLMNOPQRSTUVWXYZ012345
 *
 * 1、不超过3个种类
 * 2、最长子序列
 * 3、最左边的最长序列
 */
public class Test1 {

    public static void main(String[] args) {
        String s = "ABACADBABD";

        int hh = 0, tt = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> index = new HashMap<>();

        String res = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                if (map.size() == 3) {
                    // 再加进来大于了3
                    map.remove(s.charAt(hh));
                    hh = index.get(s.charAt(hh)) + 1;
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            index.put(c, i);
            if (res.length() < i - hh+1) {
                res = s.substring(hh, i+1);
            }
        }
        System.out.println(res);
    }
}
