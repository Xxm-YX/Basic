package 序列化;

import java.io.*;

public class User implements Externalizable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
    private String sex;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        try{
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:/user.txt"));
//            User user = new User(22,"老田");
//            objectOutputStream.writeObject(user);
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("C:/user.txt")));
            User o = (User) inputStream.readObject();
            System.out.println(o);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        StringBuffer reverse = new StringBuffer(name).reverse();
        out.writeObject(reverse);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age = age;
    }
}
