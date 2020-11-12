package se.kth.sda8.todo.topics;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicControllerTests {


//    @MockBean

    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    public void  testGetById(){

//        arrange

//        act
//        Product[] responseProducts = testRestTemplate.getForObject("/products", Product[].class);



//        Assertions.assertEquals(0, responseProducts.length);


//        assert
    }
}
