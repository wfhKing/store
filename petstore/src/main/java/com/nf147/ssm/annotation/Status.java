package com.nf147.ssm.annotation;

import java.lang.annotation.*;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Status {

    String message() default "没有这个类型，请重新选择";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
class StatusValidator implements ConstraintValidator<Status,String>{

    @Override
    public void initialize(Status constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.asList("create","shop").contains(s);
    }

}
