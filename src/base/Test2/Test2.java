package base.Test2;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        Map<String, Map<String, String>> map = new HashMap<>(0);

        Map<String, String> map1 = new HashMap<>(0);

        map.put("a", map1);

        Map<String, String> a = map.get("a");

        a.put("aaa","bbb");
        a.put("ccc","ddd");

        Map<String, String> a1 = map.get("a");

        System.out.println(a1);
    }
}
