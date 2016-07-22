package com.stevegocoding.minitwit.persist.repository;

import com.stevegocoding.minitwit.model.User;

/**
 * Created by magkbdev on 7/20/16.
 */

public interface UserRepository extends GenericRepository<Long, User> {
    public User findByEmail(String email);
}
