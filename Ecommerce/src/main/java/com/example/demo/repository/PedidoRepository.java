package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PedidoRepository extends JpaRepository<PedidoRepository, Integer>{

}
