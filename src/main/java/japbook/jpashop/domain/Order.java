package japbook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    private Long memberId;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStauts status;
}
