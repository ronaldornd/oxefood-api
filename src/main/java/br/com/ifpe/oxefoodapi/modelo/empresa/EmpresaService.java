package br.com.ifpe.oxefoodapi.modelo.empresa;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodapi.modelo.acesso.UsuarioService;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;
    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Empresa save(Empresa empresa) {
        usuarioService.save(empresa.getUsuario());
        empresa.setHabilitado(Boolean.TRUE);
        empresa.setVersao(1L);
        empresa.setDataCriacao(LocalDate.now());
        return repository.save(empresa);
    }

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Empresa findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Empresa empresaAlterado) {

        Empresa empresa = repository.findById(id).get();
        empresa.setSite(empresaAlterado.getSite());
        empresa.setCnpj(empresaAlterado.getCnpj());
        empresa.setInscricaoEstadual(empresaAlterado.getInscricaoEstadual());
        empresa.setNomeEmpresarial(empresaAlterado.getNomeEmpresarial());
        empresa.setNomeFantasia(empresaAlterado.getNomeFantasia());
        empresa.setFone(empresaAlterado.getFone());
        empresa.setFoneAlternativo(empresaAlterado.getFoneAlternativo());
        empresa.setVersao(empresa.getVersao() + 1);
        repository.save(empresa);
    }

    @Transactional
    public void delete(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(Boolean.FALSE);
        empresa.setVersao(empresa.getVersao() + 1);

        repository.save(empresa);
    }
}
