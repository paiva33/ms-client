package br.com.brasilprev.application.customer.adapter.in.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brasilprev.application.customer.adapter.in.web.payload.AddressRequest;
import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerRequest;


@WebMvcTest
@ActiveProfiles
public class CustomerEndPointTest {
	
	
	static String CUSTOMER_API = "/api/customer/v1";
	
	@Autowired
	MockMvc mvc;
	
	@Test
	@DisplayName("Deve criar um cliente com sucesso.")
	public void createCustomerTest() throws Exception {
		
		CustomerRequest customerRequest = createNewCustomer();
		
		//BDDMockito.given(null)
		String json = new ObjectMapper().writeValueAsString(customerRequest);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(CUSTOMER_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);
		
		mvc
			.perform(request)
			.andExpect(status().isCreated())
			.andExpect(jsonPath("id").value(1));
	}
	
	@Test
	@DisplayName("Deve lançar erro de validação quando não houver dados suficientes para criação do cliente.")
	public void createInvalidCustomer() throws Exception {
		
		String json = new ObjectMapper().writeValueAsString(CustomerRequest.builder().build());
		
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(CUSTOMER_API)
				.contentType(MediaType.APPLICATION_JSON);
				
	}

	private CustomerRequest createNewCustomer() {
		return CustomerRequest.builder()
				.document("11111111111")
				.name("\"Michael C. Feathers")
				.address(AddressRequest.builder()
							.street("Bellenden Way")
							.city("Moreno Valley")
							.number(11L)
							.country("Rwanda")
							.zipCode("1111")
							.build())
				.build();
	}
}
