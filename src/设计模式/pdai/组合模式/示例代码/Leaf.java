package 设计模式.pdai.组合模式.示例代码;

/**
 * 叶子对象，叶子对象不再包含其它子对象
 */
public class Leaf extends Component {
    /**
     * 示意方法，叶子对象可能有自己的功能方法
     */
    public void someOperation() {
        // do something
    }
}
