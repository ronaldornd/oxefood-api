package br.com.ifpe.oxefoodapi.api.entregador;
import br.com.ifpe.oxefoodapi.modelo.entregador.Entregador;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    private String nome;
    
    private String cpf;
    
    private String rg;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
 
    private String foneCelular;
 
    private String foneFixo;
    
    private Integer qtdEntregasRealizadas;
    
    private Double valorFrete;
    
    private String enderecoRua;
    
    private String enderecoNumero;
    
    private String enderecoBairro;
    
    private String enderecoCidade;
    
    private String enderecoCep;
    
    private String enderecoUf;
    
    private String enderecoComplemento;
    
    private Boolean ativo;


   public Entregador build() {

       return Entregador.builder()
               .nome(nome)
               .cpf(cpf)
               .rg(rg)
               .dataNascimento(dataNascimento)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .qtdEntregasRealizadas(qtdEntregasRealizadas)
               .valorFrete(valorFrete)
               .enderecoRua(enderecoRua)
               .enderecoNumero(enderecoNumero)
               .enderecoBairro(enderecoBairro)
               .enderecoCidade(enderecoCidade)
               .enderecoCep(enderecoCep)
               .enderecoUf(enderecoUf)
               .enderecoComplemento(enderecoComplemento)
               .ativo(ativo)
               .build();
   }
  
}
