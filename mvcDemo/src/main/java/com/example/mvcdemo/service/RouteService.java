package com.example.mvcdemo.service;

import com.example.mvcdemo.domain.dto.categories.CategoryViewModel;
import com.example.mvcdemo.domain.dto.routes.MostCommentedRouteViewModel;
import com.example.mvcdemo.domain.dto.routes.RouteAddViewModel;
import com.example.mvcdemo.domain.dto.routes.RoutePartialViewModel;
import com.example.mvcdemo.domain.dto.routes.RouteViewModel;
import com.example.mvcdemo.domain.entities.Category;
import com.example.mvcdemo.domain.entities.Route;
import com.example.mvcdemo.domain.entities.User;
import com.example.mvcdemo.domain.enums.CategoryName;
import com.example.mvcdemo.helpers.LoggedUser;
import com.example.mvcdemo.repository.CategoryRepository;
import com.example.mvcdemo.repository.RouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    
    @Autowired
    
    public RouteService(RouteRepository routeRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.routeRepository = routeRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }
    
    public MostCommentedRouteViewModel getMostCommented() {
        final Route route = this.routeRepository
                .findMostCommented()
                .orElseThrow(NoSuchElementException::new)
                .get(0);
        
        return MostCommentedRouteViewModel.fromRoute(route);
    }
    
    public List<RoutePartialViewModel> getAllRoutePartialViews() {
        return routeRepository.findAll()
                              .stream()
                              .map(RoutePartialViewModel::fromRoute)
                              .toList();
    }
    
    public void addNewRoute(RouteAddViewModel routeModel) throws IOException {
        Route route = modelMapper.map(routeModel, Route.class);
        
        var user = userService.findByUsername(loggedUser.getUsername());
        User userDb = modelMapper.map(user, User.class);
        
        var categories = routeModel.getCategories()
                                   .stream()
                                   .map(c -> categoryService.findByName(CategoryName.valueOf(c)))
                                   .map(c -> modelMapper.map(c, Category.class))
                                   .collect(Collectors.toSet());
        
        String gpxcoordinates = new String(routeModel.getGpxCoordinates().getBytes());
        route.setAuthor(userDb)
             .setCategories(categories)
             .setGpxCoordinates(gpxcoordinates);
        
        routeRepository.saveAndFlush(route);
    }
    
    public RouteViewModel findById(Long id){
        Route route = routeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return modelMapper.map(route, RouteViewModel.class);
    }
    
    public List<RoutePartialViewModel> findAllByCategoryName(String categoryName){
        CategoryViewModel categoryModel = categoryService
                .findByName(CategoryName.valueOf(categoryName.toUpperCase()));
        Category categoryDb = modelMapper.map(categoryModel, Category.class);
        return routeRepository
                .findAllByCategoriesContains(categoryDb)
                .orElseThrow()
                .stream()
                .map(RoutePartialViewModel::fromRoute)
                .collect(toList());
    }
}
