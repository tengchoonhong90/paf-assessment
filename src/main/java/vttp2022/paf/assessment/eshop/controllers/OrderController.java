package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;
import java.util.logging.ErrorManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

public class OrderController {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository cusRepo;

	//TODO: Task 3
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

}
