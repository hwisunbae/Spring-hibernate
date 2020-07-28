package com.hwisun.demo3.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
//    define default
    public String value() default "BAE";
    public String message() default "must start with BAE";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
