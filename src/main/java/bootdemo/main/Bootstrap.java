package bootdemo.main;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by trq on 2016/6/16.
 */
@Configuration
@ComponentScan("bootdemo")
@EnableAutoConfiguration
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        //builder.r
        builder.application().run(Bootstrap.class,args);
        //SpringApplication.run(Bootstrap.class, args);
    }
}
