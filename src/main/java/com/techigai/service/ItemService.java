package com.techigai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.techigai.model.Item;
import com.techigai.repo.ItemReposatory;

@Service
public class ItemService {
   @Autowired
   private ItemReposatory repo;
   public ModelAndView getItem() {
	   ModelAndView obj=new ModelAndView();
	   List<Item> items = repo.findAll();
	   obj.addObject("result", items);
	   obj.setViewName("OrderPage");
    return obj;
   }
   public ModelAndView  getAllItems() {
	   ModelAndView obj=new ModelAndView();
	   List<Item> items = repo.findAll();
	   obj.addObject("result", items);
	   obj.setViewName("OrderPage");
    return obj;
   }
}
