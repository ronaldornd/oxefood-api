package br.com.ifpe.oxefoodapi.api.empresa;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.ifpe.oxefoodapi.modelo.acesso.Usuario;
import br.com.ifpe.oxefoodapi.modelo.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

    private String chave;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    private String site;

    @CNPJ
    private String cnpj;

    private String inscricaoEstadual;

    private String nomeEmpresarial;

    private String nomeFantasia;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String fone;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String foneAlternativo;

    private String email;

    private String password;

    private String perfil;

    public Empresa buildEmpresa() {

        Empresa empresa = Empresa.builder()
                .chave(chave)
                .usuario(buildUsuario())
                .site(site)
                .cnpj(cnpj)
                .inscricaoEstadual(inscricaoEstadual)
                .nomeEmpresarial(nomeEmpresarial)
                .nomeFantasia(nomeFantasia)
                .fone(fone)
                .foneAlternativo(foneAlternativo)
                .build();

        return empresa;
    }

    public Usuario buildUsuario() {

        return Usuario.builder()
                .username(email)
                .password(password)
                .build();
    }

}
