package com.twkf.validator;

import com.twkf.util.ValidatorUtil;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/1/27 - 19:28
 */
public class IsPhoneValidator implements ConstraintValidator<IsPhone, String> {

    private boolean required = false;

    @Override
    public void initialize(IsPhone constraintAnnotation) {
        required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(required){
            return ValidatorUtil.isPhone(value);
        }else {
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidatorUtil.isPhone(value);
            }
        }
    }
}
