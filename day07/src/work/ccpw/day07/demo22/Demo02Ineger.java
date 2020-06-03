package work.ccpw.day07.demo22;

import java.util.ArrayList;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 15:12
 * 自动装箱与自动拆箱:基本类型的数据和包装类之间可以自动的相互转换
 *     JDK1.5之后出现的新特性
 **/
public class Demo02Ineger {
    public static void main(String[] args) {

        // 自动装箱:直接把int类型的整数赋值包装类
        //            Integer in = 1; 就相当于 Integer in = new Integer(1);
        Integer in = 1;


        //自动拆箱:in是包装类,无法直接参与运算,可以自动转换为基本数据类型,在进行计算
        //        in+2;就相当于 in.intVale() + 2 = 3
        //        n = in.intVale() + 2 = 3 又是一个自动装箱
        in = in+2;

        ArrayList<Integer> list = new ArrayList<>();

        // ArrayList集合无法直接存储整数,可以存储Integer包装类
        // -->自动装箱 list.add(new Integer(1));
        list.add(1);
        // -->自动拆箱  list.get(0).intValue();
        int a = list.get(0);
    }
}
