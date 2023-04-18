package base.IntrospectorDemo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) throws Exception {
        Point point = new Point(2, 5);
        String proName = "x";

        getProperty(point, proName);
        setProperty(point, proName);
    }

    private static void setProperty(Point point, String proName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, Point.class);
        Method methodSetX = proDescriptor.getWriteMethod();
        methodSetX.invoke(point, 8);
        System.out.println(point.getX());// 8
    }

    private static void getProperty(Point point, String proName) throws Exception {
//        PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, Point.class);
//        Method methodGetX = proDescriptor.getReadMethod();
//        Object objx = methodGetX.invoke(point);
//        System.out.println(objx);// 2
        BeanInfo beanInfo = Introspector.getBeanInfo(point.getClass());
        PropertyDescriptor[] proDescriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor prop: proDescriptors){
            if(prop.getName().equals(proName)){
                Method methodGetx = prop.getReadMethod();
                System.out.println(methodGetx.invoke(point));//8
                break;
            }
        }
    }
}
