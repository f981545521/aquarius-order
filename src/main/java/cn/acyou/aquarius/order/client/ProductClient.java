package cn.acyou.aquarius.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author youfang
 * @version [1.0.0, 2020/8/26]
 **/
@FeignClient("aquarius-product")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test/outStock")
    List<String> outStock();

}
