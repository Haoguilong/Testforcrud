package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private IUserService is;

    @RequestMapping(value = "/all")
    //    //查询所有的用户
    public String findAllUser(Model model) throws Exception {
        for (User u:is.findall()){
            System.out.println(u);
        }

        List<User> list=is.findall();

        model.addAttribute("userlist",list);

        return "two";
    }

    @RequestMapping(value = "/find")
    //根据用户的Id查询用户
    public String findOne(int id,Model model) throws Exception {

        Optional<User> user= Optional.of(new User());

        user=is.selectUserById(id);

        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "/insert")
    //修改一个用户
    public ModelAndView insertUser(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("email") String email) throws Exception {
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        is.addUser(user);
        System.out.println("成功插入一条数据");
        return new ModelAndView("redirect:/all");
    }

    @RequestMapping(value = "/goadd")
    //增加一个用户
    public String addtUser(@RequestParam("name") String name,@RequestParam("email") String email) throws Exception {
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        is.addUser(user);
        System.out.println("成功插入一条数据");
        return "redirect:/all";
    }


    @RequestMapping(value = "/add")
    public String insertUser(){

        return "add";
    }

    @RequestMapping(value = "/delete/{id}")
    //根据用户的Id来删除一个用户
    public ModelAndView deleteUser(@PathVariable int id) throws Exception {
        is.deleteById(id);
        System.out.println("成功删除一条数据");
        return new ModelAndView("redirect:/all");
    }

    @RequestMapping(value = "/modify/{id}")
    //对用户进行修改
    public ModelAndView modifyUser(@PathVariable("id") int id,Model model)
            throws Exception {

        model.addAttribute("user",is.selectUserById(id));

        return new ModelAndView("modefiy","userModel",model);
    }

}
