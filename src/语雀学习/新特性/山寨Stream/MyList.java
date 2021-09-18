package 语雀学习.新特性.山寨Stream;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/14 18:13
 */
@Getter
public class MyList<T> {

    private List<T> list = new ArrayList<>();

    public boolean add(T t){
        return list.add(t);
    }

    /**
     * @description: 给MyList传递具体的判断规则，
     * 然后MyList把内部现有符合判断（true）的元素返回
     * @author zyx
     * @date 2021/5/14 17:51
     * @version 1.0
     */
    public MyList<T> filter(Predicate<T> predicate){
        MyList<T> filterdList = new MyList<>();

        for (T t : list) {
            if(predicate.test(t)){
                //收集判断为true的元素
                filterdList.add(t);
            }
        }
        return filterdList;
    }


    /**
     * @description: 把MyList中的List<T>转为List<R>
     * @author zyx
     * @date 2021/5/14 17:54
     * @version 1.0
     */
    public <R> MyList<R> map(Function<T, R> mapper) {
        MyList<R> mappedList = new MyList<>();

        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }

        return mappedList;
    }
}
