package com.agilworks.pontointeligente.repositories;

import com.agilworks.pontointeligente.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Transactional(readOnly = true) // a melhora a perfomance da aplicação
    Empresa findByCnpj(String cnpj);
}
