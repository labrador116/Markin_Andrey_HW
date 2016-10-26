import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Andrey_pers on 26.10.2016.
 */
public class MainClass {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        MyClass myClass = new MyClass();
        Class cl = myClass.getClass();
        Method[] methods = cl.getMethods();

        String nameAnnot = new Scanner(System.in).nextLine();
        Annotation findAnnot = null;

        for (Method meth : methods) {
            Annotation[] annotation = meth.getAnnotations();
            for (Annotation annot : annotation) {
                if (nameAnnot.equals(annot.annotationType().getName())) {
                    meth.invoke(myClass);
                }
            }
        }
    }
}