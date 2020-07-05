package work.ccpw.service;

import work.ccpw.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @program: Spring_test
 * @description:
 * @author: Andy
 * @create: 2020-07-05 11:32
 **/
public interface DemoService {
    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;
}
