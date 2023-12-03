package com.pratyush.restfulwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	//static filter
	@GetMapping("/filtering")
	public someBean filtering() {
		return new someBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<someBean> filteringList() {
		return Arrays.asList(new someBean("value1","value2","value3"),new someBean("valur 4","value 5","value 6"));
	}
	
	
	//dynamic filter
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue  mappingJacksonValuefilteringDynamic() {
		someBean sb = new someBean("f1","f2","f3");
		
		MappingJacksonValue  mappingJacksonValue = new MappingJacksonValue(sb);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f1","f2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter",filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	

	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue mappingJacksonValuefilteringDynamicList() {
		List<someBean> list = Arrays.asList(new someBean("value1","value2","value3"),new someBean("valur 4","value 5","value 6"));
		MappingJacksonValue  mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f1","f2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter",filter);
		
		mappingJacksonValue.setFilters(filters);
		
		
		return  mappingJacksonValue;
	}
	
}
