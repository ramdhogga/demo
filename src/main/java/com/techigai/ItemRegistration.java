package com.techigai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techigai.model.Item;
import com.techigai.repo.ItemReposatory;
import com.techigai.service.ItemService;

@Controller
public class ItemRegistration {
	@Autowired
	private ItemReposatory repo;
	@Autowired
	private ItemService service;
	@RequestMapping("/addItem")
	public ModelAndView Add(@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") String price,@RequestParam("qnty") String qnty) {
		Model m = null;
		Item item = new Item();
		item.setName(name);
		item.setDesc(desc);
		item.setPrice(Double.parseDouble(price));
		item.setAvlQnty(Integer.parseInt(qnty));
		item.setQntyIn(Integer.parseInt(qnty));
		repo.save(item);
	    return service.getItem();
	}

}
