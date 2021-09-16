package springcloudalibaba.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springcloudalibaba.conf.FeignConfiguration;

@FeignClient(value = "service-a",configuration = FeignConfiguration.class)
public interface IFeignService {

    @RequestMapping(value = "/",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String hellWord(@RequestParam String name);
}
