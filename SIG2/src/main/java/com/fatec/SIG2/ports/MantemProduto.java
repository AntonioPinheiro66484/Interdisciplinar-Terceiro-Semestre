package com.fatec.SIG2.ports;

import java.util.List;
import java.util.Optional;
import com.fatec.SIG2.model.Produto;

public interface MantemProduto {
	List<Produto> consultaTodos();

	Optional<Produto> consultaPorCpf(String cpfFabricante);

	Optional<Produto> consultaPorIdProduto(Long idProduto);

	Optional<Produto> consultaPormarca(String marca);

	Optional<Produto> consultaPorpreco(Float preco);

	Optional<Produto> save(Produto produto);

	void delete(Long idProduto);

	Optional<Produto> altera(Produto produto);

	Optional<Produto> consultaPoIdProduto(Long idProduto);

	Optional<Produto> consultaPopreco(Float preco);
}
