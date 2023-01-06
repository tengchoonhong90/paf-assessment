package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

@Controller
@RequestMapping(path="/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository cusRepo;

	//TODO: Task 3
	@GetMapping
	public ResponseEntity<String> getName(@RequestParam String name) {

		List<Customer> customer = cusRepo.findCustomerByName(name);
		String errorMsg = ("Error: Customer "+name+" not found");

		if (customer != null)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(customer.toString());
		else
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(errorMsg);
	}

	@PostMapping
	public ResponseEntity<Order> postOrder(@RequestBody MultiValueMap<String, String> form, Model model) {

		Order order = new Order();
		order.setName(form.getFirst("name"));

		Integer count = orderRepo.createOrder(order);

		if (count == 1) 
			return ResponseEntity
				.status(HttpStatus.OK)
				.body(order);
		else
			return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(order);
	}

}
