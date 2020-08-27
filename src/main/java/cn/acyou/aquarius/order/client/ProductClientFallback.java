package cn.acyou.aquarius.order.client;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 不生效还要检查
 * @author youfang
 * @version [1.0.0, 2020/8/27]
 **/
@Component
public class ProductClientFallback implements FallbackFactory<ProductClient> {
    private static final Logger log = LoggerFactory.getLogger(ProductClientFallback.class);

    @Override
    public ProductClient create(Throwable throwable) {
        return new ProductClient() {
            @Override
            public List<String> outStock() {
                log.info("访问失败");
                return new ArrayList<>();
            }
        };
    }
}
