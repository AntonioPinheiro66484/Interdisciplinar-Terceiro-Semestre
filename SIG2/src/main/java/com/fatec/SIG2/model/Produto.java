package com.fatec.SIG2.model;


//equals e tostring omitidos. Criado na aula de 05/04/2022
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome é requerido!")
	private String nome;
	@NotBlank(message = "Descrição é requerida!")
	private String descricao;
	@NotBlank(message = "Nome do fabricante é requirido!")
	private String fabricante;
	@NotBlank(message = "Nome do fornecedor é requirido!")
	private String fornecedor;
	@NotBlank(message = "CNPJ do fornecedor é requirido!")
	private String cnpjFornecedor;
	@NotNull(message = "Quantidade do estoque é requirido!")
	private int qtdEstoque;
	@NotNull(message = "Digite o Preço do produto!")
	private Double preco;
	private String dataCadastro;

	
	public Produto(String nome, Double preco,String descricao,String fabricante,String fornecedor, String cnpjFornecedor) {
		this.nome = nome;
		this.descricao= descricao;
		this.fabricante=fabricante;
		this.fornecedor=fornecedor;
		this.cnpjFornecedor=cnpjFornecedor;
		this.setPreco(preco);
		
	}

	public Produto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque( int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataAtual) {
		this.dataCadastro = dataAtual;
	}

	public boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida (exemplo 30 fev - 31 nov)
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	public void obtemDataAtual(DateTime dataAtual) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		this.dataCadastro = dataAtual.toString(fmt);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}

	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}


	// equals e tostring omitidos. Cliado na aula de 05/04/2022

}
