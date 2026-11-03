package org.example.hotel.repository;

import org.example.hotel.model.Quarto;
import org.example.hotel.model.StatusQuarto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    List<Quarto> findByStatusQuarto(StatusQuarto status);

    long countByStatusQuarto(StatusQuarto status);
}
