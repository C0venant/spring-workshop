package com.spring.workshop.jwt.service;

import com.spring.workshop.jwt.domain.AppUser;
import com.spring.workshop.jwt.domain.Role;
import com.spring.workshop.jwt.repository.RoleRepository;
import com.spring.workshop.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j//for logs
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (Objects.isNull(user)){
            log.error("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        log.info("user found in the database: {}", username);
        var authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new User(user.getUsername(), user.getPassword(), authorities);

    }

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("saving user in db {}", user);
        //encode password before saving user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role in db {}", role);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        var user = userRepository.findByUsername(username);
        var role = roleRepository.findByName(roleName);
        log.info("adding role {} to user {}", roleName, username);
        user.getRoles().add(role);//this will be saved in db because class is transactional!
    }

    @Override
    public AppUser getUser(String username) {
        log.info("getting user");
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("getting allUsers");
        return userRepository.findAll();
    }


}
