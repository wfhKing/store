package com.nf147.ssm.annotation;


import com.nf147.ssm.entity.Order;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

public class Commvalidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        if (aClass == Order.class) {
            System.out.println("Order");
            return true;
        }
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (o == null){
            errors.reject(null,"这个为空呢？");
        }
        Order order=(Order) o;
        if (order.getOrderStatus()==null|| !Arrays.asList("create","shop").contains(order.getOrderStatus())){
            errors.rejectValue("status",null,"status出错" );
        }
    }

}
