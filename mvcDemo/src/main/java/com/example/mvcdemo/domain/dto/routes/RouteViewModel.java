package com.example.mvcdemo.domain.dto.routes;

import com.example.mvcdemo.domain.dto.categories.CategoryViewModel;
import com.example.mvcdemo.domain.dto.comments.CommentViewModel;
import com.example.mvcdemo.domain.dto.pictures.PictureViewModel;
import com.example.mvcdemo.domain.dto.users.UserViewModel;
import com.example.mvcdemo.domain.enums.Level;

import java.util.Set;

public class RouteViewModel {
    private Long id;
    private String gpxCoordinates;
    private Level level;
    private String name;
    private UserViewModel author;
    private String video;
    private String description;
    private Set<CommentViewModel> comments;
    private Set<PictureViewModel> pictures;
    private Set<CategoryViewModel> categories;
    
    public RouteViewModel() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }
    
    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }
    
    public Level getLevel() {
        return level;
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public UserViewModel getAuthor() {
        return author;
    }
    
    public void setAuthor(UserViewModel author) {
        this.author = author;
    }
    
    public String getVideo() {
        return video;
    }
    
    public void setVideo(String video) {
        this.video = video;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Set<CommentViewModel> getComments() {
        return comments;
    }
    
    public void setComments(Set<CommentViewModel> comments) {
        this.comments = comments;
    }
    
    public Set<PictureViewModel> getPictures() {
        return pictures;
    }
    
    public void setPictures(Set<PictureViewModel> pictures) {
        this.pictures = pictures;
    }
    
    public Set<CategoryViewModel> getCategories() {
        return categories;
    }
    
    public void setCategories(Set<CategoryViewModel> categories) {
        this.categories = categories;
    }
}
