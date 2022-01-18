package br.com.brasilprev.application.customer.adapter.in.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.brasilprev.application.customer.adapter.in.web.payload.AddressRequest;
import br.com.brasilprev.application.customer.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressRequestMapper {
	
	
	@Mapping(source = "street", target = "street")
	@Mapping(source = "state", target = "state")
    Address toDomain(AddressRequest request);

    @Mapping(source = "street", target = "street")
    @Mapping(source = "state", target = "state")
    AddressRequest toPayload(Address address);

    List<Address> toDomain(List<AddressRequest> source);
    List<AddressRequest> toPayLoad(List<Address> requests);
}
