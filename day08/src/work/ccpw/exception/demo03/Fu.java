package work.ccpw.exception.demo03;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-07 16:56
 **/
public class Fu {
    public void show01() throws NullPointerException,ClassCastException{}
    public void show02() throws IndexOutOfBoundsException{}
    public void show03() throws IndexOutOfBoundsException{}
    public void show04() throws Exception {}
}

class Zi extends Fu{
    //子类重写父类方法时,抛出和父类相同的异常
    @Override
    public void show01() throws NullPointerException,ClassCastException{}
    //子类重写父类方法时,抛出父类异常的子类
    @Override
    public void show02() throws ArrayIndexOutOfBoundsException{}
    //子类重写父类方法时,不抛出异常
    @Override
    public void show03() {}

    /*
        父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。

     */
    //public void show04() throws Exception{}

    //此时子类产生该异常，只能捕获处理，不能声明抛出
    @Override
    public void show04()  {
        try {
            throw  new Exception("编译期异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
