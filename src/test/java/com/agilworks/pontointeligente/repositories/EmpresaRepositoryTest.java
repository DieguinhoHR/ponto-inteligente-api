package com.agilworks.pontointeligente.repositories;

import com.agilworks.pontointeligente.entities.Empresa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class EmpresaRepositoryTest extends TestCase {
    @Autowired
    private EmpresaRepository empresaRepository;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() throws Exception {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa de exemplo");
        empresa.setCnpj(CNPJ);

        this.empresaRepository.save(empresa);
    }

    @After
    public void tearDown() {
        this.empresaRepository.deleteAll();
    }

    @Test
    public void deve_buscar_por_cnpj() {
        Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);

        assertEquals(CNPJ, empresa.getCnpj());
    }
}
