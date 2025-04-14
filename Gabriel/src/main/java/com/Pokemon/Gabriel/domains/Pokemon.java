package com.Pokemon.Gabriel.domains;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.Pokemon.Gabriel.domains.dtos.PokemonDTO;
import com.Pokemon.Gabriel.domains.enums.NiveisPokemon;
import com.Pokemon.Gabriel.domains.enums.TipoPokemon;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pokemon")
    private Long id;

    @NotNull
    @NotBlank
    private String nomePokemon;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tipoPokemon")
   private TipoPokemon tipoPokemon;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "niveisPokemon")
    private NiveisPokemon niveisPokemon;


    private int pontosDeVida;
    private int ataque;
    private int defesa;
    private int velocidade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCaptura = LocalDate.now();

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String cpfPokemon;


    public Pokemon() {
        this.niveisPokemon = NiveisPokemon.INICIANTE;
        this.tipoPokemon = TipoPokemon.NORMAL;
    }

    public Pokemon(Long id, String nomePokemon, TipoPokemon tipoPokemon, NiveisPokemon niveisPokemon, int pontosDeVida, int ataque, int defesa, int velocidade, LocalDate dataCaptura, String cpfPokemon) {
        this.id = id;
        this.nomePokemon = nomePokemon;
        this.tipoPokemon = tipoPokemon;
        this.niveisPokemon = niveisPokemon;
        this.pontosDeVida = pontosDeVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.dataCaptura = dataCaptura;
        this.cpfPokemon = cpfPokemon;
    }

    public Pokemon(PokemonDTO pokemonDTO){
        this.id = pokemonDTO.getId();
        this.nomePokemon = pokemonDTO.getNomePokemon();
        this.tipoPokemon = TipoPokemon.toEnum(pokemonDTO.getTipoPokemon());
        this.niveisPokemon = NiveisPokemon.toEnum(pokemonDTO.getNiveisPokemon());
        this.pontosDeVida = pokemonDTO.getPontosDeVida();
        this.ataque = pokemonDTO.getAtaque();
        this.defesa = pokemonDTO.getDefesa();
        this.velocidade = pokemonDTO.getVelocidade();
        this.dataCaptura = pokemonDTO.getDataCaptura();
        this.cpfPokemon = pokemonDTO.getCpfPokemon();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public TipoPokemon getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(TipoPokemon tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public NiveisPokemon getNiveisPokemon() {
        return niveisPokemon;
    }

    public void setNiveisPokemon(NiveisPokemon niveisPokemon) {
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

    public String getCpfPokemon() {
        return cpfPokemon;
    }

    public void setCpfPokemon(String cpfPokemon) {
        this.cpfPokemon = cpfPokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return pontosDeVida == pokemon.pontosDeVida && ataque == pokemon.ataque && defesa == pokemon.defesa && velocidade == pokemon.velocidade && Objects.equals(id, pokemon.id) && Objects.equals(nomePokemon, pokemon.nomePokemon) && tipoPokemon == pokemon.tipoPokemon && niveisPokemon == pokemon.niveisPokemon && Objects.equals(dataCaptura, pokemon.dataCaptura) && Objects.equals(cpfPokemon, pokemon.cpfPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePokemon, tipoPokemon, niveisPokemon, pontosDeVida, ataque, defesa, velocidade, dataCaptura, cpfPokemon);
    }
}
