package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order oder;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    // ORDINAL : 숫자로 들어감(다른 숫자가 들어가면 문제 발생) -> 쓰지 말기
    private DeliveryStatus status; //READY, COMP
}
