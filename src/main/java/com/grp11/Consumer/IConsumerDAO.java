package com.grp11.Consumer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.grp11.Domain.UserDomain;


public interface IConsumerDAO extends CrudRepository<UserDomain, Long>{
	
	

	@Query("select u.username from user_domain u where u.username:username")
	public UserDomain findByUsername(@Param("username") String username);


}
