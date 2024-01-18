package in.gaurav.limits;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "limits-service")
public class LimitConfiguration {
	private Integer minimum;
	private Integer maximum;
}
