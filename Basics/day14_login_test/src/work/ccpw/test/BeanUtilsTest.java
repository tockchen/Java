package work.ccpw.test;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import work.ccpw.domain.User;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-22 00:28
 **/
public class BeanUtilsTest {

    @Test
    public void test() {

        User user = new User();
        try {
            BeanUtils.setProperty(user, "username", "male");
            System.out.println(user);

            String gender = BeanUtils.getProperty(user, "username");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
