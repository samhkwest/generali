package com.myinsur.regservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidatorRespository {
	@Query("select 1 from Registration where phoneno = :phoneNo")
	public Optional<Integer> phoneNoExist(String phoneNo);
}

