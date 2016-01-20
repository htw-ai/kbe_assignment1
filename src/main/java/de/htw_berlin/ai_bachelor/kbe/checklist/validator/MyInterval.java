package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by timol on 20.01.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy=PriorityConstraintValidator.class)
@Documented
public @interface MyInterval {
    public String message() default "Der Wert liegt nicht im erlaubten Bereich.";
    public int max() default 10;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
