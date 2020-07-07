package work.ccpw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import work.ccpw.domain.Account;
import work.ccpw.service.AccountService;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Andy
 * @create: 2020-07-07 15:54
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    /**
     * 保存
     * @param account
     * @return
     */
    @RequestMapping(value = "/save",produces = "text/html;charset=utf8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        System.out.println(accountList);
        return modelAndView;
    }
}
