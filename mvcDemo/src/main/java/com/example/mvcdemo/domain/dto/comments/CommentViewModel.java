package com.example.mvcdemo.domain.dto.comments;

import com.example.mvcdemo.domain.dto.routes.RouteViewModel;
import com.example.mvcdemo.domain.dto.users.UserViewModel;

import java.time.LocalDateTime;

public class CommentViewModel {
    private Long id;
    private Boolean approved;
    private LocalDateTime created;
    private String text;
    private UserViewModel author;
    private RouteViewModel route;
    
    public CommentViewModel() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Boolean getApproved() {
        return approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    
    public LocalDateTime getCreated() {
        return created;
    }
    
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
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
