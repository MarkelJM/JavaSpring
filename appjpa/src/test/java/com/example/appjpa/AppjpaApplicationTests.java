package com.example.appjpa;

import com.example.appjpa.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@WebMvcTest
class AppjpaApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@MockBean
	private AuthorRepository authorRepository;

	@Test
	void findAuthortest(){
		
	}

}
