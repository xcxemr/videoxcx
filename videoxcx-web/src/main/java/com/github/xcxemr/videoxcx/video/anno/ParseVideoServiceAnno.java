package com.github.xcxemr.videoxcx.video.anno;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParseVideoServiceAnno {

    String searchKey() default "";

}
