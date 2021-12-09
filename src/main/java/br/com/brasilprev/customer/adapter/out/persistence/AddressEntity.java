package br.com.brasilprev.customer.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;

/**
 * Entity Address
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"street", "district", "city"})
@Table(name = "addresses")
@Entity(name = "address")
class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String district;
    private String city;
    private String state;
}
