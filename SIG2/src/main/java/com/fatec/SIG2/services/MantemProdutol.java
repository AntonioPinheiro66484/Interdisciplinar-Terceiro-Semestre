package com.fatec.SIG2.services;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.fatec.SIG2.model.Produto;
import com.fatec.SIG2.model.Endereco;
import com.fatec.SIG2.ports.MantemProduto;

@Service
public class MantemProdutoI implements MantemProdutoI {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	ProdutoRepository repository;

	public List <Produto> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}


	@Override
	public Optional<Produto> consultaPorId(Long idProduto) {
		logger.info(">>>>>> servico consultaPorIdProduto chamado");
		return repository.findById(idProduto);
	}

	@Override
	public Optional<Produto> save(Produto produto) {
		logger.info(">>>>>> servico save chamado ");
		Optional<Produto> umProduto = consultaPorCpf(produto.getidProduto());
		Endereco endereco = obtemEndereco(produto.getCep());

		if (umProduto.isEmpty() & endereco != null) {
			logger.info(">>>>>> servico save - dados validos");
			produto.dataFabricacao(new DateTime());
			produto.setFabricante(fabricante.getLogradouro());
			return Optional.ofNullable(repository.save(produto));
		} else {
			return Optional.empty();
		}

	}

	@Override
	public void delete(Long idProduto) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(idProduto);
	}

	@Override
	public Optional<Produto> altera(Produto produto) {
		logger.info(">>>>>> 1.servico altera Produto chamado");
		Optional<Produto> umProduto = consultaPorId(produto.getIdProduto());
		Endereco endereco = obtemFabricante(produto.getFabricante());
		if (umProduto.isPresent() & endereco != null) {
			Produto produto = new Produto(produto.getNome(), produto.getDataNascimento(), produto.getSexo(),
					produto.getFornecedor(), produto.getFornecedor());
			produtoModificado.setId(produto.getIdProduto());
			produtoModificado.obtemData(new DateTime());
			produtoModificado.setfornecedor(Fornecedor.getProduto());
			logger.info(">>>>>> 2. servico altera Produto cep valido para o id => " + produtoModificado.getIdProduto());
			return Optional.ofNullable(repository.save(produtoModificado));
		} else {
			return Optional.empty();
		}
	}

	public Endereco obtemEndereco(String fabricante) {
		RestTemplate template = new RestTemplate();
		String url = "https://viacep.com.br/ws/{cep}/json/";
		logger.info(">>>>>> servico consultaFabricante - " + fabricante);
		ResponseEntity<Endereco> resposta = null;
		try {
			resposta = template.getForEntity(url, Endereco.class, fabricante);
			return resposta.getBody();
		} catch (ResourceAccessException e) {
			logger.info(">>>>>> consulta Fabricante erro nao esperado ");
			return null;
		} catch (HttpProdutorrorException e) {
			logger.info(">>>>>> consulta Fabricante inválido erro HttpProdutorrorException =>" + e.getMessage());
			return null;
		}
	}
}
