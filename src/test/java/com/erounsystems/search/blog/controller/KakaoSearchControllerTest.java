package com.erounsystems.search.blog.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class KakaoSearchControllerTest {
	/*
    @InjectMocks
    KakaoSearchController blogSearchController;

    @Mock
    BlogSearchService blogSearchService;

    @Autowired
    private MockMvc mockMvc;
    
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(blogSearchService).build();
    }

    

//	@Test
//	@DisplayName("게시글 삭제")
//	void testRestTemplateTest1() {		
//		//BlogSearchController blogSearchController = new BlogSearchController();		
//		//fail("Not yet implemented");
//		
//    	// given
//
//        // when, then
//   
//
//        //verify(blogSearchService).callPostExternalServer();
//	}

    @Test
    public void hello() throws  Exception {
        String hello = "hello";

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andDo(print());
        
               // .andExpect(content().string(hello));
    }
	
*/
    @Test 
    public void testHello() {
    	System.out.println("Hello");
    	
    	Assertions.assertEquals(2200, 2200);
    }
}
