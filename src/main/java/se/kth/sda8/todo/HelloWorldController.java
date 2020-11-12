package se.kth.sda8.todo;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

        @RequestMapping("/")
        public String HelloFromLee() {
            return  "hello world from lee";
        }

        @RequestMapping("/hello-person/{name}")
        public String helloPerson (@PathVariable String name){
            return "Hello " + name;
        }
        @RequestMapping("/hello-person-age")
        public String helloPersonAge(@RequestParam String name, @RequestParam Integer age){
            return "hello " + name + " your age is " + age;
        }


}


