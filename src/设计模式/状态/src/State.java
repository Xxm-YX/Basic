package 设计模式.状态.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/14 22:39
 */
public interface State {

    /**
     * @description: 投入25分钱
     * @author zyx
     * @date 2021/5/14 22:40
     * @version 1.0
     */
    void insertQuarter();

    /**
     * @description: 退回25分钱
     * @author zyx
     * @date 2021/5/14 22:40
     * @version 1.0
     */
    void ejectQuarter();

    /**
     * @description: 转动曲柄
     * @author zyx
     * @date 2021/5/14 22:40
     * @version 1.0
     */
    void turnCrank();

    /**
     * @description: 发糖果啦
     * @author zyx
     * @date 2021/5/14 22:42
     * @version 1.0
     */
    void dispense();
}
