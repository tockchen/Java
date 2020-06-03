package work.ccpw.day07.demo06;

/**
 * @program: Entry
 * @description: instanceof
 * @author: cone
 * @create: 2020-06-03 12:05
 * 如何才能知道一个父类引用的对象，本来是什么子类？
 * 格式：
 * 对象 instanceof 类名称
 * 这将会得到一个boolean值结果，也就是判断前面的对象能不能当做后面类型的实例。
 **/
public class Demo02Instanceof {
    public static void main(String[] args) {
        // 本来是一只狗
        Animal animal = new Dog();
        animal.eat(); // 狗吃SHIT

        // 如果希望掉用子类特有方法，需要向下转型
        // 判断一下父类引用animal本来是不是Dog
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
        // 判断一下animal本来是不是Cat
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }

        giveMeApet(new Dog());
    }

    public static void giveMeApet(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }
    }

}
