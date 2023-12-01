package br.com.ifpe.oxefoodapi.modelo.fornecedor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefoodapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Fornecedor")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor extends EntidadeAuditavel {

   @Column(nullable = false, length = 100)
   private String nome;

   @Column
   private String endereco;

   @Column
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataFundacao;

   @Column
   private Double valorMercado;

   @Column
   private String paginaWeb;

   @Column
   private String contatoVendedor;

}
