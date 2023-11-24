package br.com.ifpe.oxefoodapi.api.produto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefoodapi.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
   @NotBlank(message = "A categoria é de preenchimento obrigatório")
   private Long idCategoria;
   @Length(max = 20, message = "O Código deverá ter no máximo {max} caracteres")
   private String codigo;

   private String titulo;
   @Length(max = 200, message = "A descrição deverá ter no máximo {max} caracteres")
   private String descricao;

   private Double valorUnitario;

   private Integer tempoEntregaMinimo;

   private Integer tempoEntregaMaximo;

   public Produto build() {

      return Produto.builder()
            .codigo(codigo)
            .titulo(titulo)
            .descricao(descricao)
            .valorUnitario(valorUnitario)
            .tempoEntregaMinimo(tempoEntregaMinimo)
            .tempoEntregaMaximo(tempoEntregaMaximo)
            .build();
   }
}
