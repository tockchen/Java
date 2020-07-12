package work.ccpw.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import work.ccpw.ssm.pojo.Item;
import work.ccpw.ssm.service.ItemService;

/**
 * @program: mavenProjects
 * @description:
 * @author: Andy
 * @create: 2020-07-09 17:08
 **/
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/showItem/{id}")
    public String findById(@PathVariable("id") int id, Model model){
        Item item = itemService.findById(id);
        model.addAttribute("item",item);
        return "item";
    }
}
