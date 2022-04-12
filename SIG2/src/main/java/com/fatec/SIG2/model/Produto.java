package com.fatec.SIG2.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduto;
	@NotBlank(message = "Nome do Produto é Requerido")
	private String nomeProduto;
	private String nomeFornecedor;
	@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/-](0?[1-9]|1[012])[\\/-]\\d{4}$", message = "A data de vencimento deve estar no formato dd/MM/YYYY")
//https://www.regular-expressions.info/ 
	private String dataCadastroProduto;
	private String marca;
	private float preco;
	@CPF
	@Column(unique = true)
	private String cpfFornecedor;

	public Produto(String nomeProduto,Float preco, String nomeFornecedor, String dataCadastroProduto,  String marca) {
		this.nomeProduto = nomeProduto;
		setDataFabricacao(dataCadastroProduto);
		this.marca = marca;
		this.preco = preco;
		this.nomeFornecedor = nomeFornecedor;
	}



	public Produto() {
	}

	public Long getId() {
		return idProduto;

	}

	public void setId(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void getNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor=nomeFornecedor;
	}
	
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto=nomeProduto;
	}
	
	public String getDataCadastroProduto() {
		return dataCadastroProduto;
	}
	public void setDataCadastroProduto(String dataAtual) {
		this.dataCadastroProduto = dataAtual;
	}

	
	public Float getPreco() {
		return preco;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
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
		 this.dataCadastroProduto = dataAtual.toString(fmt);
		 } 
	
	
	
	private void setDataFabricacao(String dataCadastroProduto2) {
		// TODO Auto-generated method stub
		
	}

}
