package com.github.dvrecky.smartbudget.security.service;

import com.github.dvrecky.smartbudget.user.dao.UserDao;
import com.github.dvrecky.smartbudget.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + " not found"));

        return new CustomUserDetails(user.getId(), user.getEmail(), user.getPassword(), null);
    }
}
