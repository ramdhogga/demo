package com.techigai;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techigai.model.Item;
import com.techigai.model.Order;
import com.techigai.model.User;
import com.techigai.repo.ItemReposatory;
import com.techigai.repo.Itemjparepo;
import com.techigai.repo.OrderRepo;
@Controller
public class OrderController {
    @Autowired
	private OrderRepo repo;
    @Autowired
    private Itemjparepo itemjparepo;
    @Autowired
    private JdbcTemplate template;
    @Autowired
    private ItemReposatory itemrepo;
	@RequestMapping("/ordercontroller")
	public ModelAndView addOrder(@RequestParam("orderids") String orderids,@RequestParam("ammout") String totalcost,@RequestParam("itemquanties") String quantitie,HttpServletRequest request) {	
		HttpSession session = request.getSession();
		List<Item> listitem= (List) session.getAttribute("list");
		User usr=(User) session.getAttribute("user");
		
		char[] quantities=quantitie.toCharArray();
		char[] arraid=orderids.toCharArray();
		
		System.out.println("quantities....."+quantities.length);
		System.out.println("arraid....."+arraid.length);

		List list=new ArrayList();
		 for (int i = 0; i < arraid.length; i++){
			 if(arraid[i]!=',') {
		        int j = Character.getNumericValue(arraid[i]);
		        if(j!=0) {
		        list.add(j);
		        }
			 }
		   }
		Order obj=new Order();
		obj.setUser(usr);
		obj.setTotalcost(Double.parseDouble(totalcost));
		Order orobj=repo.save(obj);
		 for (int j = 0; j< arraid.length; j++){	
		 int qnty=Character.getNumericValue(quantities[j]);
		 for (int i = 0; i < listitem.size(); i++){
			 Item itm=listitem.get(i);
			 if(Character.getNumericValue(arraid[j])==itm.getId()) {
			 itm.setOrder(orobj);
			 itm.setQntyOut(itm.getQntyOut()+qnty);
			 
			 if(itm.getQntyIn()==itm.getQntyOut()) {
			      itm.setStatus("AP");
			 }else {
				 itm.setStatus("PN");
			 }
			itm.setAvlQnty(itm.getAvlQnty()-qnty);
		    itemrepo.save(itm);
			      }
			 }
			
		 }
		List<Item> items = itemrepo.findByIdIn(list);
		ModelAndView modelobj=new ModelAndView();
		modelobj.addObject("result", items);
	    modelobj.setViewName("sucesspayment");
     return modelobj;
	}
}
