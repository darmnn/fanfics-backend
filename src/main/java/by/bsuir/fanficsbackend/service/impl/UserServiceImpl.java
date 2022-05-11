package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.exception.ResourceNotFoundException;
import by.bsuir.fanficsbackend.exception.ValidationException;
import by.bsuir.fanficsbackend.persistence.entity.Book;
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
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            User currentUser = repository.findByName(currentUserName);
            User user = repository.findById(id).orElseThrow();

            return currentUser.equals(user);
        } else {
            return false;
        }
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

    @Override
    public UserResponseDTO patch(Long id, UserRequestDTO dto) throws HttpRequestMethodNotSupportedException {
        User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user with ID" +
                id.toString()));

        if (dto.getPassword() != null) {
            entity.setPassword(dto.getPassword());
        }
        if (dto.getContactInfo() != null) {
            entity.setContactInfo(dto.getContactInfo());
        }
        if (dto.getAbout() != null) {
            entity.setAbout(dto.getAbout());
        }

        repository.save(entity);

        return responseAssembler.toModel(entity);
    }
}
