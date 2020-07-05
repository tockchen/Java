package work.ccpw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import work.ccpw.domain.User;
import work.ccpw.domain.VO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-02 19:44
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running...");
        return "success";
    }

    @RequestMapping(value = "/quick2", method = RequestMethod.GET)
    public ModelAndView save2() {
        /*
            Model:封装数据
            View:展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("username", "work.ccpw");
        return modelAndView;
    }

    @RequestMapping(value = "/quick3", method = RequestMethod.GET)
    public ModelAndView save3(ModelAndView modelAndView) {

        // 设置视图
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("username", "Andy");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4", method = RequestMethod.GET)
    public String save4(Model model) {
        model.addAttribute("username", "陈灿");

        return "success";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "Andy");

        return "success";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        response.getWriter().write("hello 陈灿");

    }

    /**
     * ResponseBody 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() throws IOException {

        return "hello Andy";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {

        return "{\"username\":\"Andy\",\"age\": 12}";
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("陈灿");
        user.setAge(30);
        // 使用json的转换工具将对象转换为json格式字符串返回
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }

    /**
     * 期望SpringMVC自动给将User转换成json格式的字符串
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("陈灿");
        user.setAge(30);

        return user;
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username, Integer age) throws IOException {
        System.out.println(username + " : " + age);
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(String[] strings) throws IOException {
        System.out.println(Arrays.asList(strings));
    }

    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String username, Integer age) throws IOException {
        System.out.println(username + " : " + age);
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public void save14(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "陈灿") String username) throws IOException {
        System.out.println(username);
    }

    /**
     * localhost:8080/user/quick17/zhangsan
     *
     * @param username
     * @throws IOException
     */
    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        session.setAttribute("age", "12");
        System.out.println(session);

    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader("User-Agent") String userAgent) throws IOException {
        System.out.println(userAgent);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jSessionId) throws IOException {
        System.out.println(jSessionId);
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile,MultipartFile uploadFile2) {

        // 获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        String originalFilename2 = uploadFile2.getOriginalFilename();
        try {
            uploadFile.transferTo(new File("D://upload//" + originalFilename));
            uploadFile.transferTo(new File("D://upload//" + originalFilename2));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多文件上传使用数组
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {



        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D://upload//" + originalFilename));
        }


    }
}
