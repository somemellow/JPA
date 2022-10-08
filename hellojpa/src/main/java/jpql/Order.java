package jpql;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS") //Order는 관례상 ORDERS로 변경을 해주어 사용을 한다.
public class Order {
    @Id@GeneratedValue
    private Long id;

    private int OrderAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MEMBER_ID")
    private Member member;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        OrderAmount = orderAmount;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
