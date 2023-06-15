package com.example.mvcdemo.service;

import com.example.mvcdemo.domain.dto.roles.RoleViewModel;
import com.example.mvcdemo.domain.enums.RoleName;
import com.example.mvcdemo.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired

    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public Set<RoleViewModel> findAllRoles() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RoleViewModel.class))
        .collect(Collectors.toSet());
    }

    public RoleViewModel findRoleByName(String roleName) {
        var role = this.roleRepository.findByRole(RoleName.valueOf(roleName))
                .orElseThrow(NoSuchElementException::new);
        return modelMapper.map(role, RoleViewModel.class);
    }
}
