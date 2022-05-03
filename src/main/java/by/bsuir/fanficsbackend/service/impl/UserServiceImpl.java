package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.User;
import by.bsuir.fanficsbackend.persistence.repository.UserRepository;
import by.bsuir.fanficsbackend.security.Role;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.UserService;
import by.bsuir.fanficsbackend.service.assembler.UserRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.UserResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.UserRequestDTO;
import by.bsuir.fanficsbackend.service.dto.UserResponseDTO;
import by.bsuir.fanficsbackend.service.dto.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserServiceImpl extends AbstractCrudService<UserResponseDTO, UserRequestDTO, UserRequestDTO, UserSearchDTO,
        User, UserRepository> implements UserService, UserDetailsService {
    @Autowired
    public UserServiceImpl(UserResponseDTOAssembler responseDTOAssembler, UserRequestDTOAssembler requestAssembler) {
        super(responseDTOAssembler, requestAssembler, User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username);
        Role userRole;

        if (user.getAdmin()) {
            userRole = Role.ADMIN;
        } else {
            userRole = Role.USER;
        }

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                userRole.getAuthorities());
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        return false;
    }

    @Override
    protected List<Predicate> buildSearchPredicates(UserSearchDTO dto, Root<User> root) {
        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        if (dto != null) {
            predicates.add(criteriaBuilder.equal(root.get("name"), dto.getName()));
            predicates.add(criteriaBuilder.equal(root.get("password"), dto.getPassword()));
        }

        return predicates;
    }
}
