package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected  Address(){} // JPA 구현 라이브러리가 객체를 생성할때 리플렉선이나 프록시 같은 기술 사용 할 수 잇도록 지원을 해야 하기 때문에 생성자를 작성해 두어야 한다.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
