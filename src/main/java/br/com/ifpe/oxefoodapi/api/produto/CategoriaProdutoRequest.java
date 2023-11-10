package br.com.ifpe.oxefoodapi.api.produto;

import br.com.ifpe.oxefoodapi.modelo.produto.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

   private String descricao;

   public CategoriaProduto build() {

      return CategoriaProduto.builder()
            .descricao(descricao)
            .build();
   }
}
