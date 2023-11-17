package br.com.ifpe.oxefoodapi.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpfContaining(String cpf);

    List<Cliente> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
}