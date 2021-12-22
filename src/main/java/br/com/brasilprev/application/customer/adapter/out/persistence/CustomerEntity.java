package br.com.brasilprev.application.customer.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;

/**
 * Entity Customer
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name", "cpf"})
@ToString(of = {"name", "cpf"})
@Entity(name="customer")
@Table(name = "customers")
class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

}
