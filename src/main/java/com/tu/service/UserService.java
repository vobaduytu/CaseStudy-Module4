package com.tu.service;

import com.tu.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<User> showAll(Pageable pageable);

    void save(User user);

    Optional<User> findById(Long id);

    void delete(Long id);


}
