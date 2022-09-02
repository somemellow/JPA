package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    @Id @GeneratedValue
    @Column(name ="ORDER_ID")
    private Long Id;
    @Column(name="MEMBER_ID")
    private Long memberId;
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
