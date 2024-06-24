package com.onesoft.helloresttemplate1.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Hello1 {
	
	@Autowired
	RestTemplate rest;
	@GetMapping("getData")
	public String get() {
	String url="http://localhost:8081/Hi";
	ResponseEntity<String> a=rest.exchange(url,HttpMethod.GET, null, String.class);
	String d=a.getBody();       //for String conversion
	return d;
	}
/*	@GetMapping("getadd/{a}/{b}")
	public int getadd(@PathVariable int a,@PathVariable int b) {
		String url="http://localhost:8081/add/";
		ResponseEntity<Integer> g=rest.exchange(url+a+"/"+b,HttpMethod.GET,null,Integer.class);
		int f=g.getBody();    //for int conversion
		return f;
	}*/
	@GetMapping("getb/brand")
	public String getdata(@PathVariable String brand) {
		String url="http://localhost:8081/getdata/";
		ResponseEntity<String> h=rest.exchange(url,HttpMethod.GET,null,String.class);
		String g=h.getBody();
		return g;
	}
	@GetMapping("getall")
	public List<UseCar> getdetail(){
		String url="http://localhost:8080/getalldetails";
		ResponseEntity<List<UseCar>> h=rest.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<UseCar>>() {});
		List<UseCar> d=h.getBody();
		return d;
	}
	@GetMapping("getmax")
	public UseCar getmax() {
		String url="http://localhost:8080/maxprice";
		ResponseEntity <UseCar> h=rest.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference <UseCar> () {});
		UseCar d=h.getBody();
		return d;
	}
	@GetMapping("getprice/{price}")
	public List<UseCar> getprice(@PathVariable int price) {
		String url="http://localhost:8080/getprice/";
		ResponseEntity<List<UseCar>> h=rest.exchange(url+price,HttpMethod.GET,null,new ParameterizedTypeReference<List<UseCar>>() {});
		List<UseCar> d=h.getBody();
		return d.stream().peek(x->x.setPrice(x.getPrice()-5000)).collect(Collectors.toList());	
	}
	@GetMapping("getadd/{a}/{b}")
	public int getadd(@PathVariable int a,@PathVariable int b) {
		String url="http://localhost:8081/add/";
		ResponseEntity<Integer> g=rest.exchange(url+a+"/"+b,HttpMethod.GET,null,Integer.class);
		int f=g.getBody();    
		return f;
	}
	
}
