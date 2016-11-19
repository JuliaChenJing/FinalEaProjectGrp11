package com.grp11.Order;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class OrderCtrl {
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllExamples() {
		System.out.println("here");
		return "home2";
	}
}