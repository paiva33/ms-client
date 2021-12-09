package br.com.brasilprev.customer.adapter.out.persistence;

/**
 * Customer Entity Builder
 */
class CustomerEntityBuilder {

    private Long id;
    private String name;
    private String cpf;
    private AddressEntity address;

    private CustomerEntityBuilder() {}
    
    public static CustomerEntityBuilder builder() { return new CustomerEntityBuilder();}

    public CustomerEntityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerEntityBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public CustomerEntityBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CustomerEntityBuilder address(AddressEntity address) {
        this.address = address;
        return this;
    }

    public CustomerEntity build() {
        CustomerEntity entity = new CustomerEntity();
        entity.setName(this.name);
        entity.setCpf(this.cpf);
        entity.setId(this.id);
        entity.setAddress(this.address);
        return entity;
    }
}
