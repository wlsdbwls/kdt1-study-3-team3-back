package kr.eddi.demo.order.entity;

import jakarta.persistence.*;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.product.entity.Product;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = { "product", "account" })
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Orders(Product product, Account account) {
        this.product = product;
        this.account = account;
    }
}
