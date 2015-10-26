package base.repository;

import base.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    private RowMapper<User> userRowMapper = new UserRowMapper();

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        this.jdbcTemplate.update("insert into user (name, password) values (?, ?)", user.getName(), user.getPassword());
    }

    public boolean exists(User user) {
        return findUserByName(user.getName()) != null;
    }

    private User findUserByName(String userName) {
        List<User> users = this.jdbcTemplate.query("select * from user where name = ?", userRowMapper, userName);
        return (users != null && !users.isEmpty()) ? users.get(0) : null;
    }
}

class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setName(resultSet.getString("name"));
        user.setName(resultSet.getString("password"));

        return user;
    }
}

