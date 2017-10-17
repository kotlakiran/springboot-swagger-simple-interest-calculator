package com.kiran.spring.swagger.simpleinterestcalculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/api", description = "Simple Interest Calculator ")
public class SimpleInterestCalculator  {
	
	
	@ApiOperation(value = "Calculate Total Amount Accrued (Principal + Interest)",produces="application/json",
		    notes = "P = Principal Amount\n" + 
		    		"R = Rate of Interest per year as a percent; R = r * 100\n" + 
		    		"t = Time Period involved in months",
		    responseContainer = "String")
	
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "P", value = "Principal Amount", required = true, dataType = "float", paramType = "query", defaultValue ="1000"),
		    @ApiImplicitParam(name = "R", value = "Rate of Interest per year as a percent", required = false, dataType = "string", paramType = "query", defaultValue ="10"),
		    @ApiImplicitParam(name = "t", value = "Time Period involved in months", required = false, dataType = "string", paramType = "query", defaultValue ="24"),
			
	 })
	
	
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfull Calculation"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	            @ApiResponse(code = 500, message = "internal server error")
	    }
	    )
	@RequestMapping(method = RequestMethod.GET, value = "/api/calculatetotalamount")
	public Float sayHello1(@ApiParam(value = "name that need to be updated", required = true,defaultValue ="") @RequestParam("P") Float p,@RequestParam("R") float R,@RequestParam("t") float t)  {
		
		float res=p*(1 + (R/100)*t/12);
		return res;
	}
	
}

