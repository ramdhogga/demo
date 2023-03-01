package com.techigai.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techigai.model.User;

@Repository
public interface UserRepo extends  CrudRepository<User, Long>{
	@Query("SELECT u FROM User u where u.uname =:uname and u.password =:password")
	User findUserRole(String uname, String password);
}
