package com.st.myprojects.main.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates if certain member Variables are significant for the
 * HashCodeGeneration
 *
 * @author Sundeep Tonse
 * @since 1.8
 * @jls N/A
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ ElementType.FIELD })
public @interface Significant {

}
