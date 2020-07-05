package work.ccpw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-03 17:10
 **/
@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源正在执行....");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","Andy");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
