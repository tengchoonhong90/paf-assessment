package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;
import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class CustomerRepository {

	@Autowired
		private JdbcTemplate jdbcTemplate;

	// You cannot change the method's signature
	public List<Customer> findCustomerByName(String name) {
		// TODO: Task 3
		final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_CUSTOMER_BY_NAME, name);
		final List<Customer> customer = new LinkedList<>();
		
		while (rs.next())
			customer.add(Customer.create(rs));

		return customer;
	}
}


