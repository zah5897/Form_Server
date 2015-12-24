package com.haoqi.webapp.forly.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {
	IgoreType TYPE() default IgoreType.Persistence;
}
