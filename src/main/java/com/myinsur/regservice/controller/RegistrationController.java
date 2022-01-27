package com.myinsur.regservice.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myinsur.regservice.model.Registration;
import com.myinsur.regservice.repository.RegistrationRepository;
import com.myinsur.regservice.util.ValidatorUtils;

@RestController
public class RegistrationController {
  @Autowired
  private RegistrationRepository registrationRepository;
  
  @GetMapping(path="/regservice/{id}")
  public ResponseEntity<Object> getById(@PathVariable("id") Integer Id){
	  Optional<Registration> regInfo = registrationRepository.findById(Id);
	  return (regInfo.isPresent()) ? new ResponseEntity<>(regInfo.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @GetMapping(path="/regservice")
  public List<Registration> findAll(){
	List<Registration> regInfo = registrationRepository.findAll();
    return regInfo;
  }
  
  @DeleteMapping(path="/regservice")
  public void deleteAll(){
	  registrationRepository.deleteAll();
  }

  @PostMapping(path="/regservice")
  public ResponseEntity<Object> create(@RequestBody Registration regInfo){
	  String phoneNo = regInfo.getPhoneno();	  
	  boolean validPhoneNo = ValidatorUtils.checkPhoneNo(phoneNo);  
	  	   
	  if (validPhoneNo) {	  
		  Optional<Integer> phoneNoExist = registrationRepository.phoneNoExist(phoneNo);	
		  
		  if (!phoneNoExist.isPresent()) {
			  regInfo.setCreatedate(LocalDateTime.now().toString());	  
			  Registration newRegInfo = (Registration) registrationRepository.saveAndFlush(regInfo);
			  return new ResponseEntity<Object>(newRegInfo, HttpStatus.CREATED);
		  }else {
			  return new ResponseEntity<Object>("Phone No already registered!", HttpStatus.BAD_REQUEST);
		  }
	  }else {
		  return new ResponseEntity<Object>("Invalid Phone No!", HttpStatus.BAD_REQUEST);
	  }
  }
}