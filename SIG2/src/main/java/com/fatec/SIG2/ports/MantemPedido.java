package com.fatec.SIG2.ports;

import java.util.List;
import java.util.Optional;
import com.fatec.SIG2.model.Pedido;

public interface MantemPedido {
	public Optional<Pedido> buscaPorId(Long id);

	public List<Pedido> buscaPorCpf(String cpf);

	public List<Pedido> consultaTodos();

	public void excluiPedido(Long id);

	public Pedido cadastrarPedido(Pedido pedido);

	public boolean isClienteCadastrado(String cpf);
}
