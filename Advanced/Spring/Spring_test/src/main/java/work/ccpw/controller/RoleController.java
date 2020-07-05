package work.ccpw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.ccpw.domain.Role;
import work.ccpw.service.RoleService;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-03 21:56
 **/
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/list")
    public String roleList(){

        List<Role> roleList = roleService.list();
        ObjectMapper mapper = new ObjectMapper();
        String roleJson = "";
        System.out.println(roleList);
        try {
            roleJson = mapper.writeValueAsString(roleList);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return roleJson;
    }

    @RequestMapping("/save")
    public String save(Role role){

        roleService.save(role);
        return "role-list";
    }
}
