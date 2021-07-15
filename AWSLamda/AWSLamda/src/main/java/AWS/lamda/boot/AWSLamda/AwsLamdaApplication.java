package AWS.lamda.boot.AWSLamda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import AWS.lamda.boot.domain.Order;
import AWS.lamda.boot.repository.OrderDao;

@SpringBootApplication
public class AwsLamdaApplication {
	
	
	private OrderDao orderDao;
	
	@Bean
	public Supplier<List<Order>> Orders() {
		return ()->orderDao.buildOrders();
		
	}
	@Bean
public Function<String, List<Order>> findByOrderName () {
		return (input)->orderDao.buildOrders().stream().filter(order->order.getName().equals(input)).collect(Collectors.toList());
		
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsLamdaApplication.class, args);
	}

}
