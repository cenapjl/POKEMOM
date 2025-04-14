package com.Pokemon.Gabriel.repositories;

import com.Pokemon.Gabriel.domains.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PokemonRepository extends JpaRepository<Pokemon, Long> {

     Optional<Pokemon> findByCpfPokemon(String cpfPokemon);

}
