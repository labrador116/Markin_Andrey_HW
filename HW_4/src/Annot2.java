import java.lang.annotation.*;

/**
 * Created by Andrey_pers on 26.10.2016.
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Annot2 {

    int delay()  ;
}
