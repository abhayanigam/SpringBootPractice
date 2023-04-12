package com.learning.repository;

import com.learning.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository, RowMapper<User> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setAge(rs.getInt("age"));
        return user;
    }

    private static String selectUserQuery =
            " SELECT id, firstname, lastname, email, age FROM app_user WHERE id =  :userId ";

    @Override
    public User getUser(Integer userId) {
        try {
            return jdbcTemplate.queryForObject(
                    selectUserQuery, Collections.singletonMap("userId", userId), this);
        } catch (DataAccessException e) {
            log.error("Error occurred in fetching User from DB", e);
            return null;
        }
    }

    private static String selectUsersQuery =
            " SELECT id, firstname, lastname, email, age FROM app_user ";
    @Override
    public List<User> getUsers() {
        try {

            List<User> users = jdbcTemplate.query(selectUsersQuery, this);

            return users;

        } catch (DataAccessException e) {
            log.error("Error occurred in fetching User from DB", e);
            return null;
        }
    }

    public static String createUserQuery =
            " INSERT INTO app_user"
                    + "  (firstname, lastname, email, age)"
                    + " VALUES ( :firstname,  :lastname,  :email,  :age) ";

    public Integer createUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstname", user.getFirstname());
        namedParameters.addValue("lastname", user.getLastname());
        namedParameters.addValue("email", user.getEmail());
        namedParameters.addValue("age", user.getAge());
        jdbcTemplate.update(createUserQuery, namedParameters, keyHolder, new String[] {"id"});
        user.setId(keyHolder.getKey().intValue());

        return user.getId();
    }

    public static String updateUserQuery =
            " UPDATE app_user"
                    + " SET firstname =  :firstname, lastname =  :lastname, email =  :email, age =  :age"
                    + " WHERE id =  :id ";

    public void updateUser(User user) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("id", user.getId());
        namedParameters.put("firstname", user.getFirstname());
        namedParameters.put("lastname", user.getLastname());
        namedParameters.put("email", user.getEmail());
        namedParameters.put("age", user.getAge());
        jdbcTemplate.update(updateUserQuery, namedParameters);
    }

    public static String deleteUserQuery = " DELETE FROM app_user WHERE  id =  :userId ";

    public void deleteUser(Integer userId) {
        Map<String, Integer> namedParameters = new HashMap<>();
        namedParameters.put("userId", userId);
        jdbcTemplate.update(deleteUserQuery, namedParameters);
    }


}
