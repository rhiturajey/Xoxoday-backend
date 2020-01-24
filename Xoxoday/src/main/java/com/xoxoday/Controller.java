package com.xoxoday;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import java.util.List;

//import java.util.List;
//
import org.slf4j.Logger;

//import java.util.List;

//import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/xoxoday")
@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class Controller
{	
	Logger log=org.slf4j.LoggerFactory.getLogger(Controller.class);
//	
	@Autowired
	UserRepository repo;
	Otp otp;
	@RequestMapping(method=RequestMethod.POST,value= "/post")
	@ResponseBody
	public User post(@RequestBody User usr)
	{
		log.info("Inside Post() method of the controller ");
		log.info(usr.getEmail());
		repo.createRecord(usr);
		return usr;
//		return en.getRollNo();
//		if (repo.createRecord(usr)!=0)
//		{
//			return "Created";
//		}
//		else
//		{
//			return "error";
//		}
	}
//	@RequestMapping(method=RequestMethod.PUT,value= "/put")
//	@ResponseBody
//	/*Method to process put requests
//	 * It updates the existing records as per the requests by invoking updateRecord() method 
//	 */
//	public int put(@RequestParam Integer rollNo,@RequestParam(required=false) String name,@RequestParam (required=false)Long no)
//	{
//		log.info("Inside the put() method of th controller class");
//		return studentrepo.updateRecord(rollNo,name,no);
//	}
//	
	@RequestMapping(method=RequestMethod.GET,value= "/get",produces = { "application/json", "application/xml" })
	@ResponseBody
	/*Method to process the get requests conditionally
	 * It invokes either of the two methods which satisfy the condition
	 */
	public User get(@RequestParam String email,@RequestParam String pass)
	{
		
		log.info("Inside Get() method of controller");
		
		return repo.validateUser(email,pass);
	}
//	}
//	@RequestMapping(method=RequestMethod.DELETE,value= "/delete")
//	@ResponseBody
//	/*
//	 * Method to process the delete requests
//	 * It invokes another method to process the request
//	 */
//	public int delete(@RequestParam Integer rollNo)
//	{
//		log.info("Inside delete() method of controller");
////		return en.getRollNo();
////		return en.getRollNo();
//		return studentrepo.deleteRecord(rollNo);
//	}
	@RequestMapping(method=RequestMethod.GET,value= "/getOtp",produces = { "application/json", "application/xml" })
	@ResponseBody
	public Otp otpGenerator()
	{
		log.info("beofre json");
		Otp o=new Otp();
//        System.out.println(o.generateOtp());
        log.info(o.toString());
        return o.generateOtp();

//		return o;
	}
}
