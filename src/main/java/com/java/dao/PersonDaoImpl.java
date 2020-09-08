package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.java.domain.Person;

@Component
public class PersonDaoImpl implements PersonDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Registers a user
	 * 
	 * @param person - (Person)
	 * @return - (boolean)
	 */
	public boolean register(Person person) {
		String sql = "insert into person(first_name, last_name, address1, address2, city, state, zip, country) values(?,?,?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql, new Object[] { person.getFirstname(), person.getLastname(), person.getAddress1(),
				person.getAddress2(), person.getCity(), person.getState(), person.getZip(), person.getCountry() });
		if(i == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Get registered users list
	 * 
	 * @return - ({@literal List<Person>})
	 */
	public List<Person> getPersons(){  
		return jdbcTemplate.query("select first_name, last_name, address1, address2, city, state, zip, country, created_on from person order by created_on desc, first_name asc", new RowMapper<Person>(){  
			public Person mapRow(ResultSet rs, int row) throws SQLException {  
				Person person = new Person();  
				person.setFirstname(rs.getString(1));  
				person.setLastname(rs.getString(2));  
				person.setAddress1(rs.getString(3));  
				person.setAddress2(rs.getString(4));
				person.setCity(rs.getString(5)); 
				person.setState(rs.getString(6)); 
				person.setZip(rs.getString(7)); 
				person.setCountry(rs.getString(8));
				person.setCreatedon(rs.getTimestamp(9));
				return person;  
			}  
		});  
	}  

}
