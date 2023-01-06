package vttp2022.paf.assessment.eshop.services;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;

@Service
public class WarehouseService {

	// You cannot change the method's signature
	// You may add one or more checked exceptions
	public OrderStatus dispatch(Order order) {

		// TODO: Task 4
		final String urlString = "http://paf.chuklee.com/dispatch/"+order.getOrderId();

		String url = UriComponentsBuilder.fromUriString(urlString).toUriString();

		RequestEntity<Void> req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
		RestTemplate template = new RestTemplate();

		

		return null;
	}
}
