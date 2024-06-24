package com.onesoft.helloresttemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@GetMapping("Hi")
	public String getMsg() {
		return "Hello World";
	}
	@GetMapping("add/{a}/{b}")
	public int add(@PathVariable int a,@PathVariable int b) {
		return a+b;
	}
  @GetMapping("getdata/brand")
  public String getdata(@PathVariable String brand) {
  return brand;

  }
}
