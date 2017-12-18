package com.practice.scms.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.practice.scms.dao.BaseDAO;
import com.practice.scms.dao.UserDAO;
import com.practice.scms.model.LoginRqst;
import com.practice.scms.model.User;
import com.practice.scms.rowmapper.UsersRowMapper;


@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	/*@Autowired
	JdbcTemplate jdbcTemplate;*/
	
	public void save(User user) {
	
		String sql = "insert into users(name, contact ,email, address, loginname, password) values (:name, :contact ,:email, :address, :loginname, :password)";
		
		Map< String, Object> map = new HashMap();
		
		map.put("name", user.getName());
		map.put("contact", user.getContact());
		map.put("email", user.getEmail());
		map.put("address", user.getAddress());
		map.put("loginname", user.getLoginname());
		map.put("password", user.getPassword());
		
		KeyHolder kh = new GeneratedKeyHolder();  // Primary key id generation
		
		SqlParameterSource ps = new MapSqlParameterSource(map);
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		
		Integer userId = kh.getKey().intValue();
		
		user.setId(userId);
		
	}

	
	public User checkUser(User user1) {
		String sql = "select * from users where loginname= ? and password =  ?";
		User user = new  User();
		try {
			user = (User)getJdbcTemplate().queryForObject(
					sql, new Object[] { user1.getLoginname(),user1.getPassword() }, new UsersRowMapper());
		} catch (Exception e) {
			return null;
		}
		
		
		return user;
}

}	
	
