package com.example.shop.service;

import com.example.shop.model.Role;
import com.example.shop.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;


    public Role createRole(Role role) { return roleRepository.save(role); }

    public List<Role> getAll() { return roleRepository.findAll(); }

    public Role updateRole(Role updatedRole, Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        role.setTitle(updatedRole.getTitle());
        role.setDescription(updatedRole.getDescription());
        return roleRepository.save(role);
    }
}
