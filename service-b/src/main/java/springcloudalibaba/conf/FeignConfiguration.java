package springcloudalibaba.conf;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class FeignConfiguration {


    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.FULL; //日志配置
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                    requestTemplate.header("AUTHOR","1234"); //feign的拦截器为所有请求添加head
            }
        };
    }

    @Bean
    public Request.Options options(){
        return new Request.Options(15, // 超时配置 设置为15s
                TimeUnit.SECONDS,15,TimeUnit.SECONDS,false);
    }
}
