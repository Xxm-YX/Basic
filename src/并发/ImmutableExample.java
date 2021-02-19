package 并发;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableExample {
    public static void main(String[] args) throws Exception{
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a",1);
    }
}
