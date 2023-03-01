package com.techigai.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techigai.model.Item;
@Repository
public interface ItemReposatory extends  CrudRepository<Item, Long>{
	 @Override
	List<Item> findAll();
	List<Item> findByIdIn(List list);
}
