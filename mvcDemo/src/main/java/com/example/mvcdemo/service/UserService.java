package com.example.mvcdemo.service;

import com.example.mvcdemo.domain.dto.roles.RoleEditViewModel;
import com.example.mvcdemo.domain.dto.users.UserLoginViewModel;
import com.example.mvcdemo.domain.dto.users.UserProfileViewModel;
import com.example.mvcdemo.domain.dto.users.UserRegisterViewModel;
import com.example.mvcdemo.domain.dto.users.UserViewModel;
import com.example.mvcdemo.domain.entities.Role;
import com.example.mvcdemo.domain.entities.User;
import com.example.mvcdemo.domain.enums.Level;
import com.example.mvcdemo.domain.enums.RoleName;
import com.example.mvcdemo.helpers.LoggedUser;
import com.example.mvcdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterViewModel userRegister){
        final UserViewModel user = modelMapper.map(userRegister, UserViewModel.class);

        user.setRole(userRepository.count() == 0
                ? roleService.findAllRoles()
                : Set.of(roleService.findRoleByName("USER")));

        final User userToSave = modelMapper.map(user, User.class)
                .setLevel(Level.BEGINNER);

        modelMapper.map(userRepository.saveAndFlush(userToSave), UserViewModel.class);
    }

    public UserViewModel loginUser(UserLoginViewModel user){
        Optional<User> loginCandidate = userRepository.findByUsername(user.getUsername());
        UserViewModel userModel = loginCandidate.isPresent()
                && loginCandidate.get().getPassword().equals(user.getPassword())
                ? modelMapper.map(loginCandidate.get(), UserViewModel.class)
                : new UserViewModel();

        if (userModel.isValid()){
            loggedUser
                    .setId(userModel.getId())
                    .setUsername(userModel.getUsername())
                    .setRoles(userModel.getRoles());
        }
        return userModel;
    }

    public void logout(){
        loggedUser.clearFields();
    }

    public Set<RoleName> ChangeUserPremissions(Long userId, RoleEditViewModel roleModelToSet, boolean replaceCurrentRoles){
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);

        final Role roleToSave = modelMapper.map(
                roleService.findRoleByName(roleModelToSet.getRoleName()),
                Role.class);

        if (replaceCurrentRoles){
            user.setRoles(Set.of(roleToSave));
        }
        else {
            user.getRoles().add(roleToSave);
        }
        userRepository.saveAndFlush(user);

        return user.getRoles().stream().map(Role::getRole).collect(Collectors.toSet());
    }

    public UserViewModel findByUsername(String username){
        var user = userRepository.findByUsername(username).orElse(new User());
        return modelMapper.map(user, UserViewModel.class);
    }

    public UserProfileViewModel getLoggedUserProfile(){
        var user = userRepository.findById(loggedUser.getId());
        return modelMapper.map(user, UserProfileViewModel.class);
    }
}
