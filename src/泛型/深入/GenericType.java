package 泛型.深入;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericType<T>{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 数组类型(GenericArrayType)、
     * 参数化类型(ParameterizedType)、
     * 类型变量(TypeVariable)、
     * 通配符类型(WildcardType)、
     * 原始类型(Class)、
     * 基本类型(Class)
     * @param args
     */
    public static void main(String[] args) {
        GenericType<String> genericType = new GenericType<String>(){};
        //得到超类的Type
        Type superclass = genericType.getClass().getGenericSuperclass();
        //getActualTypeArguments 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer]
        //转换成参数化类型(ParameterizedType)
        //getActualTypeArguments 表示返回实际类型参数的Type对象的数组
        //获取第一个，获取超类的泛型参数的实际类型
            Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
            System.out.println(type);
    }
}
