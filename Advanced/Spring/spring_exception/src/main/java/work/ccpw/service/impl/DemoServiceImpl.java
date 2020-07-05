package work.ccpw.service.impl;

import work.ccpw.exception.MyException;
import work.ccpw.service.DemoService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @program: Spring_test
 * @description:
 * @author: Andy
 * @create: 2020-07-05 11:33
 **/
public class DemoServiceImpl implements DemoService {
    @Override
    public void show1() {
        System.out.println("抛出类型转换异常...");
        Object str = "zhangsan";
        Integer num = (Integer) str;
    }

    @Override
    public void show2() {
        System.out.println("抛出除零异常...");
        int i = 1 / 0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("文件找不到异常...");
        FileInputStream in = new FileInputStream("C:/xxx.txt");
    }

    @Override
    public void show4() {
        System.out.println("空指针异常....");
        String string = null;
        string.length();
    }

    @Override
    public void show5() throws MyException {
        System.out.println("自定义异常...");
        throw new MyException();
    }
}
