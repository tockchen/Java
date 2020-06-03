package work.ccpw.day07.demo19;

import java.util.Calendar;

/**
 * @program: Entry
 * @description: java.util.Calendar类:日历类
 * @author: cone
 * @create: 2020-06-03 15:03
 *
 * Calendar类是一个抽象类,里边提供了很多操作日历字段的方法(YEAR、MONTH、DAY_OF_MONTH、HOUR )
 * Calendar类无法直接创建对象使用,里边有一个静态方法叫getInstance(),该方法返回了Calendar类的子类对象
 * static Calendar getInstance() 使用默认时区和语言环境获得一个日历。
 **/
public class Demo01Calendar {
    public static void main(String[] args) {
        // 多态
        Calendar c = Calendar.getInstance();
        System.out.println(c);
    }
}
