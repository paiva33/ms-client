package br.com.brasilprev.application.customer.adapter.in.web.mapper;

import java.util.List;

public interface PayloadMapper<D, P> {

    D toDomain(P payload);
    P toPayload(D domain);
    List<D> toDomainList(List<P> payload);
    List<P> toPayloadList(List<D> domain);

}
