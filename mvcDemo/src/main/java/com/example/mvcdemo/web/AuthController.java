package com.example.mvcdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("auth/")
public class AuthController extends BaseController{
    @GetMapping("register")
    public ModelAndView getRegister() {
        return super.view("register");
    }
}
