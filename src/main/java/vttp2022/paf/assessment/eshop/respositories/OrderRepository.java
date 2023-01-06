package vttp2022.paf.assessment.eshop.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Order;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class OrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	// TODO: Task 3

	public Integer createOrder(Order order) {
		
		return jdbcTemplate.update(SQL_INSERT_ORDER, order.generateOrderID(), order.generateDeliveryID(), order.getName());

	}

}
