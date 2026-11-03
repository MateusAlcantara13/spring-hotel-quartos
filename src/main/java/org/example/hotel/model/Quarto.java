package org.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quartos")
@Getter
@Setter
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informar número.")
    @Size(min = 1, max = 5, message = "O número deve conter de 1 à 5 caracteres.")
    @Column(nullable = false, length = 5)
    private String numero;

    @NotNull(message = "Informar andar.")
    private Integer andar;

    @NotNull(message = "Informe o tipo do quarto.")
    @Enumerated(EnumType.STRING)
    private TipoQuarto tipoQuarto;

    @Enumerated(EnumType.STRING)
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
