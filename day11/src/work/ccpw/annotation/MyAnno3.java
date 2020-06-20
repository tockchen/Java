package work.ccpw.annotation;

import java.lang.annotation.*;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-17 13:44
 * 元注解：用于描述注解的注解
 *      * @Target：描述注解能够作用的位置 TYPE只能作用在类上
 *      * @Retention：描述注解被保留的阶段
 *      * @Documented：描述注解是否被抽取到api文档中
 *      * @Inherited：描述注解是否被子类继承
 **/
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
