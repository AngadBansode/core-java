package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Makes the annotation available at runtime
@Target(ElementType.METHOD) // Specifies that this annotation can only be applied to methods
public @interface User {
    String username();
    String permissionLevel() default "USER"; // Default permission level
}
