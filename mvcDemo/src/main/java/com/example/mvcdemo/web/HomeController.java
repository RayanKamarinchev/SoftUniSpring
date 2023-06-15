package com.example.mvcdemo.web;

import com.example.mvcdemo.domain.dto.routes.MostCommentedRouteViewModel;
import com.example.mvcdemo.service.RouteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
    private static final String USERNAME_SESSION_KEY = "username";
    private final RouteService routeService;

    @Autowired
    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView, HttpSession httpSession) {
        final String username = httpSession.getAttribute(USERNAME_SESSION_KEY) != null ?
                httpSession.getAttribute(USERNAME_SESSION_KEY).toString()
                : "";
        modelAndView.addObject(USERNAME_SESSION_KEY, username);

        try{
            final MostCommentedRouteViewModel mostCommented = routeService.getMostCommented();
            modelAndView.addObject("mostCommented", mostCommented);
        }
        catch (Exception e){
            modelAndView.addObject("mostCommented", new MostCommentedRouteViewModel("","",""));
        }
        return super.view("index", modelAndView);
    }

    @GetMapping
    public ModelAndView getAbout(){
        return super.view("about");
    }
}
