package org.example.hotel.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quarto {
    private Long id;

    @NotBlank(message = "Informar número.")
    @Size(min = 1, max = 5, message = "O número deve conter de 1 à 5 caracteres.")
    private String numero;

    @NotNull(message = "Informar andar.")
    private Integer andar;

    @NotNull(message = "Informe o tipo do quarto.")
    private TipoQuarto tipoQuarto;

    private StatusQuarto statusQuarto;

    @Positive(message = "O valor deve ser maior que zero.")
    private double valorDiaria;

    public Quarto() {
        this.statusQuarto = StatusQuarto.LIVRE;
    }

    public void ocupar() {
        if (statusQuarto == StatusQuarto.LIVRE){
            statusQuarto = StatusQuarto.OCUPADO;
        }
    }

    public void liberar() {
        if (statusQuarto == StatusQuarto.OCUPADO){
            statusQuarto = StatusQuarto.LIVRE;
        }
    }

    public void enviarManutencao() {
        if (statusQuarto == StatusQuarto.LIVRE){
            statusQuarto = StatusQuarto.MANUTENCAO;
        }
    }

}
