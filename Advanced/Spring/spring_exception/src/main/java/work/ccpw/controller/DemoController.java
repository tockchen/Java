package work.ccpw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import work.ccpw.service.DemoService;

/**
 * @program: Spring_test
 * @description:
 * @author: Andy
 * @create: 2020-07-05 11:29
 **/
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;
    @RequestMapping(value = "/show")
    public String show(@RequestParam(value = "name",required = true)String name){
        System.out.println("show running ...");
        demoService.show1();
//        demoService.show2();
//        demoService.show3();
//        demoService.show4();
//        demoService.show5();
        return "index";
    }
}
