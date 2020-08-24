package cn.acyou.aquarius.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author youfang
 * @date 2018-04-15 下午 07:36
 **/
@Data
@EqualsAndHashCode
@Table(name = "t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 5350645545628778721L;

    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "JDBC")
    private Integer orderId;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "status")
    private Integer status;


}
