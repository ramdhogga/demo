package com.techigai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techigai.model.Item;
@Repository
public interface Itemjparepo extends JpaRepository<Item, Integer>{
	/**
	 * @param status
	 * @param id
	 */
	@Modifying
	@Transactional
	@Query("Update Item set status=:status where id=:id")
	Integer updateStatus(String status, Integer id);
}
