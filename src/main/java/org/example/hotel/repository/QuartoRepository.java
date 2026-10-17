package org.example.hotel.repository;

import org.example.hotel.model.Quarto;
import org.example.hotel.model.StatusQuarto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuartoRepository {
    private final List<Quarto> QUARTOS = new ArrayList<>();
    private Long contador = 1L;

    public List<Quarto> getTodos() {
        return QUARTOS;
    }

    public void adicionar(Quarto quarto) {
        quarto.setId(contador++);
        QUARTOS.add(quarto);
    }

    public Quarto buscarPorId(Long id){
        for (Quarto q : QUARTOS){
            if (q.getId().equals(id)){
                return q;
            }
        }
        return null;
    }

    public List<Quarto> listarlivres() {
        List<Quarto> buscarLivres = new ArrayList<>();
        for (Quarto q : QUARTOS){
            if (q.getStatusQuarto() == StatusQuarto.LIVRE){
                buscarLivres.add(q);
            }
        }
        return listarlivres();
    }

    public int contarLivres(){
        int cont = 0;
        for (Quarto q : QUARTOS){
            if (q.getStatusQuarto() == StatusQuarto.LIVRE){
                cont++;
            }
        }
        return cont;
    }

}
