package com.myinsur.regservice;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myinsur.regservice.model.Registration;
import com.myinsur.regservice.repository.RegistrationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class RegistrationTest {
    ObjectMapper om = new ObjectMapper();
    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    MockMvc mockMvc;

    Map<String, Registration> testData;

    @Before
    public void setup() {
    	registrationRepository.deleteAll();
        testData = getTestData();
    }
    
    @Test
    public void testTradeCreationWithValidData() throws Exception {
    	try {
    		Registration expectedRecord = testData.get("reg1");
    		Registration actualRecord = om.readValue(mockMvc.perform(post("/regservice")
                    .contentType("application/json")
                    .content(om.writeValueAsString(expectedRecord)))
                    .andDo(print())
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Registration.class);

    		assertEquals(expectedRecord.getFirstname(), actualRecord.getFirstname());
    		assertEquals(expectedRecord.getLastname(), actualRecord.getLastname());
    		assertEquals(expectedRecord.getEventcode(), actualRecord.getEventcode());
    		assertEquals(expectedRecord.getAge(), actualRecord.getAge());
    		assertEquals(expectedRecord.getPhoneno(), actualRecord.getPhoneno());
    		
    		//check whether the new registration exists by searching for its Id
            assertEquals(true, registrationRepository.findById(actualRecord.getId()).isPresent());
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    private Map<String, Registration> getTestData() {
        Map<String, Registration> data = new HashMap<>();

        Registration reg1 = 
        		new Registration(
                "Tim",
                "Chan",
                "CONF-001",
                30,                
                "59005900");
        data.put("reg1", reg1);

        return data;
    }
}
