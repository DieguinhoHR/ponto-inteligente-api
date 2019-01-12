package com.agilworks.pontointeligente.repositories;


import com.agilworks.pontointeligente.entities.Empresa;
import com.agilworks.pontointeligente.entities.Funcionario;
import com.agilworks.pontointeligente.enums.PerfilEnum;
import com.agilworks.pontointeligente.utils.PasswordUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class FuncionarioRepositoryTest extends TestCase {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private static final String CPF = "60251302059";
    private static final String EMAIL = "heinsenberg@gmail.com";

    @Before
    public void setUp() throws Exception {
        Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());

        this.funcionarioRepository.save(obterDadosFuncionario(empresa));
    }

    @After
    public void tearDown() {
        this.funcionarioRepository.deleteAll();
    }

    @Test
    public void deve_buscar_por_email() {
        Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);

        assertEquals(EMAIL, funcionario.getEmail());
    }

    @Test
    public void deve_buscar_por_cpf() {
        Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);

        assertEquals(CPF, funcionario.getCpf());
    }

    private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Fulano de Tal");
        funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha(PasswordUtil.gerarBCrypt("123456"));
        funcionario.setCpf(CPF);
        funcionario.setEmail(EMAIL);
        funcionario.setEmpresa(empresa);

        return funcionario;
    }

    private Empresa obterDadosEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa de exemplo");
        empresa.setCnpj("51463645000100");

        return empresa;
    }
}
