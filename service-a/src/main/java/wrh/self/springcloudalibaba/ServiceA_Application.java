package wrh.self.springcloudalibaba;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class ServiceA_Application {


    public static void main(String[] args) throws NacosException {
        ConfigurableApplicationContext context = SpringApplication.run(ServiceA_Application.class);

    }
}
