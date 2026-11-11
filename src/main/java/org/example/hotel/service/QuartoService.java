package org.example.hotel.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.hotel.model.Quarto;
import org.example.hotel.model.StatusQuarto;
import org.example.hotel.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuartoService {

    private final QuartoRepository repository;

    public List<Quarto> listarTodos() {
        return repository.findAll();
    }

    public Quarto salvar(Quarto quarto) {
        return repository.save(quarto);
    }

    public Quarto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Quarto> listarLivres() {
        return repository.findByStatusQuarto(StatusQuarto.LIVRE);
    }

    public long contarLivres() {
        return repository.countByStatusQuarto(StatusQuarto.LIVRE);
    }

    @Transactional
    public void ocupar(Long id) {
        Quarto quarto = buscarPorId(id);
        if (quarto != null) {
            quarto.ocupar();
            repository.save(quarto);
        }
    }

    @Transactional
    public void liberar(Long id) {
        Quarto quarto = buscarPorId(id);
        if (quarto != null) {
            quarto.liberar();
            repository.save(quarto);
        }
    }

    @Transactional
    public void enviarManutencao(Long id) {
        Quarto quarto = buscarPorId(id);
        if (quarto != null) {
            quarto.enviarManutencao();
            repository.save(quarto);
        }
    }

}
