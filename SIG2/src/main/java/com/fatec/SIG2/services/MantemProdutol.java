package com.fatec.SIG2.services;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.SIG2.model.Produto;
import com.fatec.SIG2.ports.MantemProduto;
import com.fatec.SIG2.ports.ProdutoRepository;

@Service
public abstract class MantemProdutol implements MantemProduto {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	ProdutoRepository repository;

	public List<Produto> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos produtos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<Produto> consultaPorCpf(String cpfFornecedor) {
		logger.info(">>>>>> servico consultaPorCpf do Fornecedor chamado");
		return repository.findByCpf(cpfFornecedor);
	}
	
	@Override
	public Optional<Produto> consultaPopreco(Float preco) {
		logger.info(">>>>>> servico consultaPorId do Produto chamado");
		return repository.findByPreco(preco);
	}
	
	public Optional<Produto> consultamarca(Float marca) {
		logger.info(">>>>>> servico consultaPorId do Produto chamado");
		return repository.findByMarca(marca);
	}

	@Override
	public Optional<Produto> consultaPoIdProduto(Long idProduto) {
		logger.info(">>>>>> servico consultaPorId do Produto chamado");
		return repository.findById(idProduto);
	}
	

	
}

