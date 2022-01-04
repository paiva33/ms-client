package br.com.brasilprev.application.customer.adapter.out.persistence.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Entity Address
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"street", "district", "city", "zipCode", "number"})
@Table(name = "addresses")
@Entity(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private long number;
    private String country;
    private String city;
    private String state;

    @Column(name = "zipcode")
    private String zipCode;
}
