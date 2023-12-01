package br.com.ifpe.oxefoodapi.api.entregador;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefoodapi.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    @NotNull(message = "O CPF é de preenchimento obrigatório")
    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String foneCelular;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String foneFixo;

    private Integer qtdEntregasRealizadas;

    private Double valorFrete;

    private String enderecoRua;

    private String enderecoNumero;

    private String enderecoBairro;

    private String enderecoCidade;

    @Length(min = 8, max = 8, message = "O campo CEP precisa ter {min}  caracteres")
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
