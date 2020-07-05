package work.ccpw.day10.demo11.Lambda;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-09 17:53
 **/
@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接消息的抽象方法,返回被拼接的消息
    public abstract String builderMessage();
}
