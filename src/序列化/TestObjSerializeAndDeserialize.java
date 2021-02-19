package 序列化;

import java.io.*;
import java.text.MessageFormat;

public class TestObjSerializeAndDeserialize {

    public static void main(String[] args) throws Exception {
        SerializePerson();//序列化对象
        Person p = DeserializePerson();//反序列化
        System.out.println(MessageFormat.format(
                "name={0},age={1},sex={2}"
                ,p.getName()
                , p.getAge()
                , p.getSex()));
    }

    /**
     * 反序列化对象
     * @return
     */
    private static Person DeserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File("C:/Person.txt")
                )
        );
        Person person = (Person) ois.readObject();
        return person;

    }

    /**
     * 序列化Person对象
     */
    private static void SerializePerson() throws Exception {
        Person person = new Person();
        person.setName("zhu");
        person.setAge(25);
        person.setSex("男");

        // ObjectOutputStream 对象输出流，
        // 将Person对象存储到E盘的Person.txt文件中，
        // 完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(
                new FileOutputStream(
                        new File("C:/Person.txt")
                )
        );

        oo.writeObject(person);
        System.out.println("person对象序列化成功");
        oo.close();
    }
}
