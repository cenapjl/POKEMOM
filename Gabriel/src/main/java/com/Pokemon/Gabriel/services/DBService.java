package com.Pokemon.Gabriel.services;
import com.Pokemon.Gabriel.domains.Pokemon;
import com.Pokemon.Gabriel.domains.enums.NiveisPokemon;
import com.Pokemon.Gabriel.domains.enums.TipoPokemon;
import com.Pokemon.Gabriel.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class DBService {

    @Autowired

    private PokemonRepository pokeRepo;

    public void initDB(){

        Pokemon pokemon01 = new Pokemon(null, "Gabriel", TipoPokemon.ELETRICO, NiveisPokemon.INICIANTE, 5, 2, 3,7, LocalDate.now(),"1");
        Pokemon pokemon02 = new Pokemon(null, "Teste", TipoPokemon.FOGO, NiveisPokemon.AVANCADO, 10, 10, 10,8, LocalDate.now(),"2");
        Pokemon pokemon03 = new Pokemon(null, "Teste2", TipoPokemon.AGUA, NiveisPokemon.INTERMEDIARIO, 2, 4, 6,7, LocalDate.now(),"3");
        Pokemon pokemon04 = new Pokemon(null, "Teste3", TipoPokemon.PEDRA, NiveisPokemon.AVANCADO, 1, 4, 10,6, LocalDate.now(),"4");


        pokeRepo.save(pokemon01);
        pokeRepo.save(pokemon02);
        pokeRepo.save(pokemon03);
        pokeRepo.save(pokemon04);

    }




}
