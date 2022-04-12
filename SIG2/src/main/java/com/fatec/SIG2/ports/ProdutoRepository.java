package com.fatec.SIG2.ports;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fatec.SIG2.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Optional<Produto> findByCpf(String cpfFornecedor);

	List<Produto> findAllByNomeIgnoreCaseContaining(String nomeFornecedor);

	Optional<Produto> findByPreco(Float preco);

	Optional<Produto> findByMarca(Float marca);
}
