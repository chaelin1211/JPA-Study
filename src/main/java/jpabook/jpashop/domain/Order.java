package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    // 일대일인 경우, 액세스를 자주 하는 쪽에 fk를 준다
    private Delivery delivery;

    private LocalDateTime ordDateTime; //날짜 + 시간(시, 분, 초)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
