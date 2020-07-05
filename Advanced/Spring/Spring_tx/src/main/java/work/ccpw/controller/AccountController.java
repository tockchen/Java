package work.ccpw.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import work.ccpw.service.AccountService;

/**
 * @author Andy
 */
public class AccountController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean("accountService", AccountService.class);
        accountService.transfer("lisi","Andy",500);
    }

}
