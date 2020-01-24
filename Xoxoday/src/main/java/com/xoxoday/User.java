package com.xoxoday;

//import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("firstName")private String firstName;
	@JsonProperty("lastName")private String lastName;
	@JsonProperty("email")private String email;
	@JsonProperty("password")private String password;
//	@JsonProperty("otp")private char[] otp;
	User()
	{
		
	}
	User(String fname,String lname,String email, String pass)
	{
		this.firstName=fname;
		this.lastName=lname;
		this.email=email;
		this.password=pass;
	}
//	public String getOtp() {
//		return otp;
//	}
//	public void setOtp()
//	{
//		 // Using numeric values 
//        String numbers = "0123456789"; 
//  
//        // Using random method 
//        Random rndm_method = new Random(); 
//  
//        char[] otp = new char[6]; 
//  
//        for (int i = 0; i < 6; i++) 
//        { 
//            // Use of charAt() method : to get character value 
//            // Use of nextInt() as it is scanning the value as int 
//            otp[i] = 
//             numbers.charAt(rndm_method.nextInt(numbers.length())); 
//        }  
//	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public void setFirstName(String fname)
	{
		this.firstName=fname;
	}
	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lname)
	{
		this.lastName=lname;
	}
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String pass)
	{
		this.password=pass;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
}
