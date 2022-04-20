package com.discodbank.Repository;

import com.discodbank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    void deleteByCpf(Long cpf);

    Optional<Cliente> findClienteByCpf();
}
