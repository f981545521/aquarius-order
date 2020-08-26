package cn.acyou.aquarius.order.controller;

import cn.acyou.aquarius.order.client.ProductClient;
import cn.acyou.aquarius.order.common.Result;
import cn.acyou.aquarius.order.entity.Order;
import cn.acyou.aquarius.order.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author youfang
 * @version [1.0.0, 2020/8/20]
 **/
@RestController
@RequestMapping("test")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductClient productClient;

    @Value("${local.ip}")
    private String localIp;

    @GetMapping(value = "/list")
    public Result<?> list() {
        List<Order> orders = orderMapper.selectAll();
        return Result.success(orders);
    }
    @GetMapping(value = "/detail")
    public Result<?> detail() {
        Map<String, String> detailInfo = new HashMap<>();
        detailInfo.put("我是服务", localIp);
        for (int i = 0; i < 10; i++) {
            detailInfo.put("订单详情" + i, String.valueOf(i));
        }
        return Result.success(detailInfo);
    }

    @GetMapping(value = "/testOpenFeign")
    @GlobalTransactional(rollbackFor = Exception.class)
    public Result<?> testOpenFeign(String key) {
        log.info("ORDER XID is: {}", RootContext.getXID());
        List<String> strings = productClient.outStock();
        System.out.println(strings);
        Order order = new Order();
        order.setOrderName(new Random().nextInt(1000) + "A");
        orderMapper.insertSelective(order);
        if ("e".equals(key)){
            throw new RuntimeException();
        }
        return Result.success();
    }
}
