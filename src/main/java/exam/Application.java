package exam;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;

@SpringBootApplication
public class Application {

    @RequestMapping("")
    String home() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addDialect(new LayoutDialect());
        SpringApplication.run(Application.class, args);
    }
}
///**
// * springboot学习日记day1
// */
///***** @RestController等于Spring中的@Controller与@ResponseBody******/
//@SpringBootApplication
//class Sprintbootday1Application extends SpringBootServletInitializer {
//    public static void main(String[] args) {
//        SpringApplication.run(Sprintbootday1Application.class, args);
//    }
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Sprintbootday1Application.class);
//
//    }
//}