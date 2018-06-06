package com.cykj.service.base.annotoin;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author yangsq
 * @date 2018/6/6 16:29.
 */
@Target({ METHOD, CONSTRUCTOR, FIELD })
@Retention(RUNTIME)
public @interface Lock {


}
