package com.xoxoday;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
//import jdk.internal.jline.internal.Log;

public class Otp {
	Logger log=org.slf4j.LoggerFactory.getLogger(Otp.class);
//	@JsonProperty("otp") char[] otp;
	@JsonProperty("otp")  char[] otp;
    public Otp generateOtp() {
//      log.info("Inside otp()");
         // Using numeric values 
    	Otp o=new Otp();
        String numbers = "0123456789"; 

// Using random method 
        Random rndm_method = new Random(); 

        o.otp = new char[6]; 

        for (int i = 0; i < 6; i++) 
        { 
  // Use of charAt() method : to get character value 
  // Use of nextInt() as it is scanning the value as int 
                o.otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
        }  
//String code=otp.toString();
//    log.info(code);

        return o;
}

}
