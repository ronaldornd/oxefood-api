package br.com.ifpe.oxefoodapi.modelo.cliente;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodapi.modelo.mensagens.EmailService;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public Cliente save(Cliente cliente) {
        cliente.setHabilitado(Boolean.TRUE);
        cliente.setVersao(1L);
        cliente.setDataCriacao(LocalDate.now());
        Cliente clienteSalvo = repository.save(cliente);
        emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);
        return clienteSalvo;

    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {

        Cliente cliente = repository.findById(id).get();
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());

        cliente.setVersao(cliente.getVersao() + 1);
        repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void delete(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);
        cliente.setVersao(cliente.getVersao() + 1);

        repository.save(cliente);
    }

    public List<Cliente> filtrar(String nome, String cpf) {
        List<Cliente> listaClientes = repository.findAll();
        if ((nome != null && !"".equals(nome)) &&
                (cpf == null || !"".equals(cpf))) {
            listaClientes = repository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
        } else if ((nome == null && !"".equals(nome)) &&
                (cpf != null && !"".equals(cpf))) {
            listaClientes = repository.findByCpfContaining(cpf);
        }

        return listaClientes;
    }

}