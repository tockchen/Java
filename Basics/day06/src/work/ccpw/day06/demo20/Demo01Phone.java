package work.ccpw.day06.demo20;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-02 19:13
 **/
public class Demo01Phone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("==========");

        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }

}
