package springcloudalibaba.controller;


import org.apache.dubbo.config.annotation.DubboReference;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloudalibaba.service.IFeignService;
import wrh.self.springcloudalibaba.dubbo.service.intf.DubboService;

@RestController
public class Controller {




    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("call_a")
    public Object callServiceA(){
        String url = "http://service-a/"; //loadBalance 注入 ribbon 拦截器
        return restTemplate.getForObject(url,String.class);
    }


    @Autowired
    private IFeignService iFeignService;


    @RequestMapping("call_a/feign")
    public Object feignCallServiceA(){
        return iFeignService.hellWord("wrh");
    }

    @DubboReference
    private DubboService dubboService;

    @RequestMapping("call_a/dubbo")
    public Object DubboCallServiceA(){
        return dubboService.serviceMethod0(12);
    }
}
