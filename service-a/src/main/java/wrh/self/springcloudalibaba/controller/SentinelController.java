package wrh.self.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sentinel")
public class SentinelController {

    @PostConstruct
    void initSentinelFlowRule(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置受保护的资源
        rule.setResource("sentinel_test");
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值,只允许1/s 的QPS
        rule.setCount(1);
        rules.add(rule);
        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    @RequestMapping("test")
    public Object test(){
        Entry resource = null;
        try{
            // 资源名可使用任意有业务语义的字符串，比如方法名、接口名或其它可唯一标识的字符串。
            resource = SphU.entry("sentinel_test");
            // do something....
            return "ok";
        } catch (BlockException e) {
            // 资源访问阻止，被限流或被降级
            //进行相应的处理操作
            return "sentinel block!!!!";
        }catch (Exception e){
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(e,resource);
            return "biz error !!!";
        }finally {
            if (resource != null)
                resource.exit();
        }

    }


    @SentinelResource(
             value = "sentinel_test"
            ,fallback = "fallback"
            //这个地方很坑,指定的方法参数列表必须是 annoTest 参数 + BlockException ,不然匹配不上
            ,fallbackClass = SentinelController.class
            ,blockHandlerClass = SentinelController.class
            ,blockHandler = "annoTestBlockHandler"
    )
    @RequestMapping("anno_test")
    public Object annoTest(){
        return "ok";
    }

    //如果
    public static Object annoTestBlockHandler(BlockException exception){
        System.out.println("==============限流处理===============");
        System.out.println("exception:" + exception);
        return "annoTestBlockHandler result";
    }

    public static Object fallback(Throwable e){
        System.out.println("===被熔断降级啦===");
        return "fallback";
    }

}
