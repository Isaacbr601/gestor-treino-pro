package com.isaac.academia.academiaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "logs_treino")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exercicio;
    private double carga;
    private int series;
    private int repeticoes;
    private double volumeTotal;

    public Treino() {}

    public Treino(String exercicio, double carga, int series, int repeticoes) {
        this.exercicio = exercicio;
        this.carga = carga;
        this.series = series;
        this.repeticoes = repeticoes;
        this.volumeTotal = carga * series * repeticoes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getExercicio() { return exercicio; }
    public void setExercicio(String exercicio) { this.exercicio = exercicio; }
    public double getCarga() { return carga; }
    public void setCarga(double carga) { this.carga = carga; }
    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }
    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }
    public double getVolumeTotal() { return volumeTotal; }
    public void setVolumeTotal(double volumeTotal) { this.volumeTotal = volumeTotal; }
}