package work.ccpw.day10.demo25.ConstructorMethodReference;

/**
 * @program: Entry
 * @description: 定义一个创建Person对象的函数式接口
 * @author: cone
 * @create: 2020-06-09 21:13
 **/
public interface PersonBuilder {
    //定义一个方法,根据传递的姓名,创建Person对象返回
    Person builderPerson(String name);
}
