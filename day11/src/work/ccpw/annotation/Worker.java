package work.ccpw.annotation;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-17 13:46
 **/

@MyAnno(value=12,per = Person.P1,anno2 = @MyAnno2,strs="bbb")
@MyAnno3
public class Worker {
    @MyAnno3
    public String name = "aaa";
    @MyAnno3
    public void show(){
    }
}
