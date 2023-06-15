package com.example.mvcdemo.domain.dto.routes;

import com.example.mvcdemo.domain.entities.Route;

import java.util.NoSuchElementException;

public class MostCommentedRouteViewModel {
    private String name;
    private String description;
    private String imageUrl;

    public MostCommentedRouteViewModel(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public static MostCommentedRouteViewModel fromRoute(Route route){
        return new MostCommentedRouteViewModel(route.getName(), route.getDescription()
                , route.getPictures()
                .stream()
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getUrl());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
