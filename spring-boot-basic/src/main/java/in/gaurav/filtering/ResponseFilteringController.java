package in.gaurav.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResponseFilteringController {

    @GetMapping("/filtering")
    public ResponseEntity<MappingJacksonValue> filtering() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(
                new DummyBean("value1", "value2", "value3")
        );
        PropertyFilter propertyFilter = SimpleBeanPropertyFilter.serializeAllExcept(
                "field2"
        );
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("DummyFilter", propertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return ResponseEntity.ok(mappingJacksonValue);
    }

    @GetMapping("/filtering-list")
    public ResponseEntity<MappingJacksonValue> filteringList() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(
                List.of(
                        new DummyBean("value1", "value2", "value3"),
                        new DummyBean("value1", "value2", "value3"),
                        new DummyBean("value1", "value2", "value3")
                )
        );
        PropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(
                "field2", "field3"
        );
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("DummyFilter", propertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return ResponseEntity.ok(mappingJacksonValue);
    }

}
