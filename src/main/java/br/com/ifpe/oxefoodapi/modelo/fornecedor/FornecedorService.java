package br.com.ifpe.oxefoodapi.modelo.fornecedor;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodapi.util.exception.FornecedorException;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor) {

        if (fornecedor.getValorMercado() <= 20.0) {
            throw new FornecedorException(FornecedorException.MSG_VALOR_MERCADO_BAIXO);
        }
        fornecedor.setHabilitado(Boolean.TRUE);
        fornecedor.setVersao(1L);
        fornecedor.setDataCriacao(LocalDate.now());
        return repository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Fornecedor fornecedorAlterado) {

        Fornecedor fornecedor = repository.findById(id).get();
        fornecedor.setNome(fornecedorAlterado.getNome());
        fornecedor.setEndereco(fornecedorAlterado.getEndereco());
        fornecedor.setDataFundacao(fornecedorAlterado.getDataFundacao());
        fornecedor.setValorMercado(fornecedorAlterado.getValorMercado());
        fornecedor.setPaginaWeb(fornecedorAlterado.getPaginaWeb());
        fornecedor.setContatoVendedor(fornecedorAlterado.getContatoVendedor());

        fornecedor.setVersao(fornecedor.getVersao() + 1);
        repository.save(fornecedor);
    }

    @Transactional
    public void delete(long id) {
        Fornecedor fornecedor = repository.findById(id).get();
        fornecedor.setHabilitado(Boolean.FALSE);
        fornecedor.setVersao(fornecedor.getVersao() + 1);

        repository.save(fornecedor);
    }
}
