import java.lang.annotation.Annotation;

/**
 * Created by Andrey_pers on 26.10.2016.
 */
public class MyClass {
    @Annot1(delay =0)
    public void Method1()
    {
        System.out.println("This is Method1 with Annot1");
    }

    @Annot1(delay = 5000)
    public void Method2()
    {
        System.out.println("This is Method2 with Annot1");
    }

    @Annot2(delay = 3000)
    public void Method3()
    {
        System.out.println("This is Method3 with Annot2");
    }


}
