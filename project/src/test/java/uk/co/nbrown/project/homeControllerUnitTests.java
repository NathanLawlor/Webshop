package uk.co.nbrown.project;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import uk.co.nbrown.project.config.SecurityConfig;
import uk.co.nbrown.project.controllers.HomeController;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)


//@AutoConfigureMockMvc
public class homeControllerUnitTests {

//	@Autowired
//	private WebApplicationContext webApplicationContext;
	
//	@Autowired
    private MockMvc mockMvc;
//  private HomeController homeController;
	
	@Before
	public void setUp() {
		System.out.println("~before");	 
//		homeController = new HomeController();
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //used for integration test
		mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build(); //used for unit test
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void homeGetRequestTest() throws Exception {		
		mockMvc.perform(get("/home"))
				.andExpect(status().isOk());
	}
}
