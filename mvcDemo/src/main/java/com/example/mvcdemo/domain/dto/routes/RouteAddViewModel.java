package com.example.mvcdemo.domain.dto.routes;

import com.example.mvcdemo.domain.enums.Level;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RouteAddViewModel {
    @NotNull
    private MultipartFile gpxCoordinates;

    @NotNull
    private Level level;

    @Size(min = 4, max = 20)
    private String name;

    @NotNull
    private String video;

    @Size(min = 20)
    private String description;

    @NotNull
    private List<String> categories;

    public RouteAddViewModel() {
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
