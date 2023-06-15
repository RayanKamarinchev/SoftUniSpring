package com.example.mvcdemo.domain.dto.pictures;

import com.example.mvcdemo.domain.dto.routes.RouteViewModel;
import com.example.mvcdemo.domain.dto.users.UserViewModel;

public class PictureViewModel {
    private Long id;
    private String title;
    private String url;
    private UserViewModel author;
    private RouteViewModel route;
    
    public PictureViewModel() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public UserViewModel getAuthor() {
        return author;
    }
    
    public void setAuthor(UserViewModel author) {
        this.author = author;
    }
    
    public RouteViewModel getRoute() {
        return route;
    }
    
    public void setRoute(RouteViewModel route) {
        this.route = route;
    }
}
