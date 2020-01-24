package com.xoxoday;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.exceptions.NotFound;

//import com.records.Entity;

//import com.records.Entity;

@Repository
public class UserRepository {

	Logger log=org.slf4j.LoggerFactory.getLogger(Controller.class);
	@Autowired
	JdbcTemplate template;
	
	public int createRecord(User usr)
	{
		log.info("Create Record");
		int res=0;
		String query = "INSERT INTO users(firstname,lastname,email,password) VALUES(?,?,?,?)";
		
			res=template.update(query,usr.getFirstName(),usr.getLastName(),usr.getEmail(),usr.getPassword());
			log.info("Created Record");
			return res;
	}
	public  User validateUser(String email,String pass)
	{
		User usr;
		usr=null;
		log.info(email+pass);
		List<User> us;
		String query=" SELECT * FROM users WHERE email='"+email+"'";
		log.info(query);
		try {
		us= template.query(query,(result,rowNum)->new User(result.getString("firstName"),
                result.getString("lastName"),result.getString("email"),result.getString("password")));
		}
		catch(Exception e)
		{
			throw new NotFound(null);
		}
		if(us.isEmpty()!=true) {
		log.info("done validation");
		log.info(us.get(0).getPassword());
//		log.info(pass);
		log.info("pasword validation");
		if(us.get(0).getPassword().equals(pass))
		{
			log.info(us.get(0).toString());
			usr= us.get(0);
		}
		else
			
			usr= null;
		}
		return usr;
	}
}

