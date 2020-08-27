package cn.acyou.aquarius.order.client;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author youfang
 * @version [1.0.0, 2020/8/27]
 **/
@Component
public class ProductClientFallback implements FallbackFactory<ProductClient> {
    private static final Logger log = LoggerFactory.getLogger(ProductClientFallback.class);

    @Override
    public ProductClient create(Throwable throwable) {
        log.info("访问失败，{}", throwable.getMessage());
        throw new RuntimeException("接口调用失败，请检查服务状态!");
/*        return new ProductClient() {
            @Override
            public List<String> outStock() {
                throw new RuntimeException("接口调用失败，请检查服务状态!");
            }
            @Override
            public List<String> inStock() {
                throw new RuntimeException("接口调用失败，请检查服务状态!");
            }
        };*/
    }
}
