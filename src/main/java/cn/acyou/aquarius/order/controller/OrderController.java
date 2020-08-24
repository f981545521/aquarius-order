package cn.acyou.aquarius.order.controller;

import cn.acyou.aquarius.order.common.Result;
import cn.acyou.aquarius.order.entity.Order;
import cn.acyou.aquarius.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author youfang
 * @version [1.0.0, 2020/8/20]
 **/
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(value = "/list")
    public Result<?> list() {
        List<Order> orders = orderMapper.selectAll();
        return Result.success(orders);
    }
}