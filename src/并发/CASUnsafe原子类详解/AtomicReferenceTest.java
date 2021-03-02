package 并发.CASUnsafe原子类详解;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args) {

        Person p1 = new Person(101);
        Person p2 = new Person(102);

        //新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);

        //通过CAS设置ar，如果ar的值为p1的华，则将其设置为p2
        ar.compareAndSet(p1,p2);

        Person p3 = (Person) ar.get();

        System.out.println("p3 is "+p3);
        System.out.println("p3.equals(p1)="+p3.equals(p1));

    }
    static class Person {
        volatile long id;
        public Person(long id) {
            this.id = id;
        }
        public String toString() {
            return "id:"+id;
        }
    }
}


