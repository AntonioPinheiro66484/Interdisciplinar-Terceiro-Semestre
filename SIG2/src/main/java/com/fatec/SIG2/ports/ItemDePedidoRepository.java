package com.fatec.SIG2.ports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.SIG2.model.ItemDePedido;

@Repository
public interface ItemDePedidoRepository extends JpaRepository<ItemDePedido, Long> {
}
