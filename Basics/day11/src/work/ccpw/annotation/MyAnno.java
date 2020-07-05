package work.ccpw.annotation;


/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-17 13:36
 **/
public @interface MyAnno {
    int value();
    Person per();
    MyAnno2 anno2();
    String[] strs();
    /*String name() default "张三";*/
     /*String show2();

     Person per();
     MyAnno2 anno2();

     String[] strs();*/
}
