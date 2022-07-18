package com.example.proyecto.service;

import com.example.proyecto.data.entity.Menu;
import com.example.proyecto.data.entity.Role;
import com.example.proyecto.data.entity.User;
import com.example.proyecto.data.repository.MenuRepository;
import com.example.proyecto.data.repository.RoleRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.MenuDTO;
import com.example.proyecto.service.mapper.MenuServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MenuService extends AbstractBusinessService<Menu, Integer, MenuDTO, MenuRepository, MenuServiceMapper> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    protected MenuService(MenuRepository repository, MenuServiceMapper serviceMapper,
                          UserRepository userRepository, RoleRepository roleRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<MenuDTO> getMenuForUserId(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(String.format("The user ID %s does not exist", userId)));
        return getMenuForRole(user.getRole());
    }

    public List<MenuDTO> getMenuForRole(Collection<Role> roles) {
        List<Menu> menus = this.getRepository().findDistinctByRoleIn(roles);
        return this.getServiceMapper().toDto(menus);
    }
}
