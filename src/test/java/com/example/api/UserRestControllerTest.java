package com.example.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserRestControllerTest{
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                        
            Charset.forName("utf8")                     
    );
	

	@Autowired
    protected WebApplicationContext webApplicationContext;
	
	protected MockMvc mvc;

	@Before
	public void setUp(){
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
     * /item/detail/1
     * @throws Exception
     */
    @Test
    public void testSampleTest1() throws Exception {
    	
    	Integer id;
    	id = 1;
    	
    	// 実行し、値を検証
        mvc.perform(get("/users/{id}", id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("id", is(1)))
            .andExpect(jsonPath("name", is("杉崎　睦")))
            .andExpect(jsonPath("pass", is("sugisugi")));
    }
}
