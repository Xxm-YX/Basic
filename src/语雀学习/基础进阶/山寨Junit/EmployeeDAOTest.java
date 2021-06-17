package 语雀学习.基础进阶.山寨Junit;

import 语雀学习.基础进阶.山寨Junit.anno.MyAfter;
import 语雀学习.基础进阶.山寨Junit.anno.MyBefore;
import 语雀学习.基础进阶.山寨Junit.anno.MyTest;

/**
 * 和我们平时使用Junit测试一样
 */
public class EmployeeDAOTest {
    @MyBefore
    public void init() {
        System.out.println("初始化...");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }
}