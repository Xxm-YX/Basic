package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        Pattern p = Pattern.compile(".*");
        Matcher matcher = p.matcher("aaab");
        boolean b = matcher.matches();
        System.out.println(b);
    }
}
