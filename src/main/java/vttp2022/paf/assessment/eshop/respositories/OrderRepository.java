package vttp2022.paf.assessment.eshop.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class OrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	// TODO: Task 3

	public Integer createOrder(Order order, LineItem lineItem) {

		String orderID = order.generateOrderID();
		
		jdbcTemplate.update(SQL_INSERT_ITEM, lineItem.getItem(), lineItem.getQuantity());
		
		return jdbcTemplate.update(SQL_INSERT_ORDER, orderID, order.getName());

	}

}
