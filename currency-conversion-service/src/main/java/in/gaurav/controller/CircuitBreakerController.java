package in.gaurav.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CircuitBreakerController {

	// int failureCount = 0;

	@GetMapping("sample-api")
	@Retry(name = "sampleApi", fallbackMethod = "hardcodedResponse")
	// @CircuitBreaker(name = "sampleApi", fallbackMethod = "hardcodedResponse")
	// @RateLimiter(name = "sampleApi", fallbackMethod = "hardcodedResponse")
	// @Bulkhead(name = "sampleApi", fallbackMethod = "hardcodedResponse")
	public String sampleApi() throws Exception {
		log.info("Sample api call received");
		/*Thread.sleep(2000);
		failureCount++;
		if (failureCount < 9 || (failureCount > 10 && failureCount < 18) || (failureCount > 20 && failureCount < 48)) {
			System.out.println("Failure count : " + failureCount);*/
		return new RestTemplate().getForObject("http://127.0.0.1:8080/any-dummy-api", String.class);
		/*} else {
			return "Sample API";
		}*/
	}

	public String hardcodedResponse(Exception ex) {
		return ex.getMessage();
	}

}
