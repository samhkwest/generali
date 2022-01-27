package com.myinsur.regservice.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstname;
    private String lastname;
    private String eventcode;
    private Integer age;
    private String phoneno;
    private String createdate;

    public Registration() {
    }

    public Registration(Integer id, String firstname, String lastname, String eventcode, Integer age, String phoneno) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.eventcode = eventcode;
        this.age = age;
        this.phoneno = phoneno;
        this.createdate = LocalDateTime.now().toString();
    }

    public Registration(String firstname, String lastname, String eventcode, Integer age, String phoneno) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.eventcode = eventcode;
        this.age = age;
        this.phoneno = phoneno;
        this.createdate = LocalDateTime.now().toString();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getEventcode() {
		return eventcode;
	}

	public void setEventcode(String eventcode) {
		this.eventcode = eventcode;
	}
}
