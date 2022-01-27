package com.myinsur.regservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myinsur.regservice.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>, ValidatorRespository {
		
	public Optional<Registration> findById(long id);
	
	public List<Registration> findAll();
	
	public Registration saveAndFlush(Registration registration);
	
	public void deleteAll();
}
