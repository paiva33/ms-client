package br.com.brasilprev.application.customer.adapter.out.persistence;

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
class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private long number;
    private String district;
    private String city;
    private String state;
    private String zipCode;
}
