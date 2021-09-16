package wrh.self.springcloudalibaba.service;


import wrh.self.springcloudalibaba.dubbo.service.intf.DubboService;

import java.util.HashMap;
import java.util.Map;

@org.apache.dubbo.config.annotation.DubboService
public class DubboServiceImpl implements DubboService {



    @Override
    public Map<String,String> serviceMethod0(Integer id){
        Map<String,String> rs = new HashMap<>();
        rs.put("id",id.toString());
        rs.put("name","wrh");
        return rs;
    }
}
