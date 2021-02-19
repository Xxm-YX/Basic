package 泛型;

import org.junit.Test;

import java.util.*;

public class TypeParameterTest {

    //第一种：简单，灵活性低
    //<T extends  Comparable<T>>   这个并不是返回值 后面的void才是，这个地方只是定义了T的类型
    public static <T extends  Comparable<T>> void mySort1(List<T> list){
        Collections.sort(list);
    }

    //第二种 复杂 灵活性高
    public static <T extends  Comparable<? super T>> void mySort2(List<T> list){
        T max = Collections.max(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return 1;
            }
        });
    }

    @Test
    public void Test1(){
        //在这个方法中要创建一个 Animal List 和一个 Dog List，然后分别调用两个排序方法。
        //创建一个 Animal List
         List<Animal> animals = new ArrayList<Animal>();
         animals.add(new Animal(25));
         animals.add(new Dog(35));

         List<Dog> dogs = new ArrayList<>();
         dogs.add(new Dog(5));
         dogs.add(new Dog(18));

//         mySort1(animals);
//         mySort1(dogs);    编译报错， 因为Dog没有继承 Comparable<Dog>
        //它从Animal那里继承了 Comparable<Animal> 所以不行

//        mySort2(animals);
//        mySort2(dogs);
    }


    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        if (comp==null)
            return null;

        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (comp.compare(next, candidate) > 0)
                candidate = next;
        }
        return candidate;
    }

    @Test
    public void test3(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(25));
        animals.add(new Animal(26));
        animals.add(new Animal(27));
        animals.add(new Dog(35));
        animals.add(new Dog(36));

        max(animals, new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        List<String> s= new ArrayList<>();
        s.add("aaaa");

        Object b = null;
        s.add("bbb");

        max(s, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
