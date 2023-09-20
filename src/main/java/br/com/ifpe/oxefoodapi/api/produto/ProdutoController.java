package br.com.ifpe.oxefoodapi.api.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapi.modelo.produto.Produto;
import br.com.ifpe.oxefoodapi.modelo.produto.ProdutoService;


@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class ProdutoController {

   @Autowired
   private ProdutoService entregadorService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

       Produto entregador = entregadorService.save(request.build());
       return new ResponseEntity<Produto>(entregador, HttpStatus.CREATED);
   }
}