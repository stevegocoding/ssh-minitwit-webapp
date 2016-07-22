package com.stevegocoding.minitwit.persist.repository.impl;

import com.google.common.collect.ImmutableMap;
import com.stevegocoding.minitwit.model.User;
import com.stevegocoding.minitwit.persist.repository.UserRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by magkbdev on 7/21/16.
 */
@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

    private static String FIND_ALL_USERS = "select * from users";
    private static String FIND_BY_EMAIL = "select user_id, email, nickname, register_time from Users where email = :email";

    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    private RowMapper<User> mapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserId(rs.getLong("user_id"));
        user.setEmail(rs.getString("email"));
        user.setNickname(rs.getString("nickname"));
        user.setRegisterTime(rs.getTimestamp("register_time"));
        return user;
    };

    public JdbcUserRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcOperations = namedParameterJdbcTemplate;
    }

    @Override
    public Iterable<User> getAll() {
        List<User> users = (List)namedParameterJdbcOperations.query(FIND_ALL_USERS, mapper);
        return users;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public void add(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User findByEmail(String email) {
        Map<String, String> params = ImmutableMap.of("email", email);
        User user = (User) namedParameterJdbcOperations.queryForObject(FIND_BY_EMAIL, params, mapper);
        return user;
    }
}
