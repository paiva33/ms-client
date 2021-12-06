package br.com.brasilprev.customer.adapter.out.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Setter
@Getter
class CustomerEntity {

    private Long id;
    private String name;
    private String cpf;
    private AddressEntity address;

}
