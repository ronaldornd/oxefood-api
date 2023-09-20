package br.com.ifpe.oxefoodapi.modelo.entregador;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {
       entregador.setVersao(1L);
       return repository.save(entregador);
   }

}
