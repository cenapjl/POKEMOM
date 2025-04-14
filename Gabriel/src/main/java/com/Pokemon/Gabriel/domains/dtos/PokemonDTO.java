package com.Pokemon.Gabriel.domains.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.Pokemon.Gabriel.domains.Pokemon;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PokemonDTO {

    private Long id ;
    @NotNull(message = "O campo nomePokemon não pode ser nulo")
    @NotBlank(message = "O campo nomePokemon não pode ser vazio")
    private String nomePokemon;

    private int tipoPokemon;
    private int niveisPokemon;



    private int pontosDeVida;

    private int ataque;

    private int defesa;

    private int velocidade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCaptura = LocalDate.now();

    private String cpfPokemon;


    public PokemonDTO() {
    }

    public PokemonDTO(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.nomePokemon = pokemon.getNomePokemon();
        this.tipoPokemon = pokemon.getTipoPokemon().getId();
        this.niveisPokemon = pokemon.getNiveisPokemon().getId();
        this.pontosDeVida = pokemon.getPontosDeVida();
        this.ataque = pokemon.getAtaque();
        this.defesa = pokemon.getDefesa();
        this.velocidade = pokemon.getVelocidade();
        this.dataCaptura = pokemon.getDataCaptura();
        this.cpfPokemon = pokemon.getCpfPokemon();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(@NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public int getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(int tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public int getNiveisPokemon() {
        return niveisPokemon;
    }

    public void setNiveisPokemon(int niveisPokemon) {
        this.niveisPokemon = niveisPokemon;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public LocalDate getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(LocalDate dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public @NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String getCpfPokemon() {
        return cpfPokemon;
    }

    public void setCpfPokemon(@NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String cpfPokemon) {
        this.cpfPokemon = cpfPokemon;
    }
}
