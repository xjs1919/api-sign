package comn.test;

import com.github.xjs.api.sign.EnableApiSignCheckAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jiashuai.xu
 * @date 2021/4/19 2:50 下午
 */
@EnableApiSignCheckAutoConfiguration
@SpringBootApplication
public class ApiSignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSignApplication.class, args);
    }

}
