package wrh.self.learn.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    private static final String HEADER_KEY = "x-request-auth";

    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                HttpHeaders headers = serverWebExchange.getRequest().getHeaders();
                return headers.containsKey(HEADER_KEY) && headers.get(HEADER_KEY).get(0).equals(config.pwd);
            }
        };
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("name"); //快捷配置对应的配置 不理解
    }

    static class Config {

        private String pwd;

/*        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }*/


        public String getName() {
            return pwd;
        }
        //一定得叫这个名字
        public void setName(String name) {
            this.pwd = name;
        }
    }
}
