package br.com.system.gestaoConstrucaoCivil.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Table(name = "usuario")
public class Usuario extends AbstractPersistable<Long>{

	@ManyToOne
	@JoinColumn(name="id_funcionario",nullable = true)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name="id_empreendimento",nullable = true)
	private Empreendimento empreendimento;
	
	@Column(nullable = false,length = 50)
	private String nome;
	@Column(nullable = false,length = 50)
	private String login;
	@Column(nullable = false,length = 40)
	private String email;
	@Column(nullable = false,length = 256)
	private String senha;
	@Column(nullable = false)
	private boolean ativo;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Empreendimento getEmpreendimento() {
		return empreendimento;
	}
	public void setEmpreendimento(Empreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}
	
}
