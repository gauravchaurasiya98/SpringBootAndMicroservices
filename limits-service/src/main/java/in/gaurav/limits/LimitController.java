package in.gaurav.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

	@Autowired
	private LimitConfiguration configuration;

	@GetMapping("limit")
	public ResponseEntity<Limit> getLimit() {
		return ResponseEntity.ok(new Limit(configuration.getMinimum(), configuration.getMaximum()));
	}
}
