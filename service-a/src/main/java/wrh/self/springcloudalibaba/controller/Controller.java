package wrh.self.springcloudalibaba.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.fasterxml.jackson.core.JsonFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {


    @RequestMapping("/")
    public Object method0(@RequestParam String name,/* @RequestHeader*/ String AUTHOR){
        Map<String,Object> rs = new HashMap<>();
        rs.put("name",name);
        rs.put("AUTHOR",AUTHOR);
        return "hell word" + rs;
    }


    @RequestMapping("/server_a")
    public Object method1(){
        return "hell word";
    }




}
