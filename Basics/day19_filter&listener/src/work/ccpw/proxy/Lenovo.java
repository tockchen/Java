package work.ccpw.proxy;

/**
 * @program: Entry
 * @description: 真实类
 * @author: cone
 * @create: 2020-06-25 23:50
 **/
public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+ money +"元买一台联想电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
