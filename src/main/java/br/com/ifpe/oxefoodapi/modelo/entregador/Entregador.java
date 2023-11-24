package br.com.ifpe.oxefoodapi.modelo.entregador;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefoodapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel  {

   @Column(nullable = false, length = 100)
   private String nome;
   
   @Column(unique = true)
   private String cpf;

   @Column
   private String rg;
   
   @Column
   private LocalDate dataNascimento;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;
   
   @Column
   private Integer qtdEntregasRealizadas;
   
   @Column
   private Double valorFrete;
   
   @Column
   private String enderecoRua;
   
   @Column
   private String enderecoNumero;
   
   @Column
   private String enderecoBairro;
   
   @Column
   private String enderecoCidade;
   
   @Column
   private String enderecoCep;
   
   @Column
   private String enderecoUf;
   
   @Column
   private String enderecoComplemento;
   
   @Column
   private Boolean ativo;
}
