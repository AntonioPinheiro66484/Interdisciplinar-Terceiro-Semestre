package com.fatec.SIG2.model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduto;
	@NotBlank(message = "Nome do produto é requerido")
	private String nomeProduto;
	@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/-](0?[1-9]|1[012])[\\/-]\\d{4}$", message = "A data de fabricação deve estar no formato dd/MM/YYYY")
	// https://www.regular-expressions.info/
	private String dataFabricacao;
	private String dataCadastroProduto;
	private String produtoDescricao;
	private Float precoProduto;
	private String fabricante;
	private String marcaProduto;

	public Produto(String nomeProduto, String dataFabricacao, String dataCadastroProduto) {
		this.nomeProduto = nomeProduto;
		setDataFabricacao(dataFabricacao);
		setDataCadastroProduto(dataCadastroProduto);

	}

	private void setDataCadastroProduto(String dataCadastroProduto2) {
		// TODO Auto-generated method stub

	}

	private void setDataFabricacao(String dataFabricacao2) {
		// TODO Auto-generated method stub

	}

	public Produto() {

	}

	public Long getId() {
		return idProduto;
	}

	public void setId(Long id) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNome(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public String getDataFabricação() {
		return dataFabricacao;
	}

	public Float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Float precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}
	
	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public void setDataNascimento(String dataFabricacao) {
		if (validaData(dataFabricacao) == true) {
			this.dataFabricacao = dataFabricacao;
		} else {
			throw new IllegalArgumentException("Data invalida");
		}
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



	// equals e tostring omitidos

}
