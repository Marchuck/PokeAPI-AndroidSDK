package pl.marchuck.pokeapi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
public class Pokedex {
    public String created;
    public String modified;
    public String name;
    public List<PokeDetail> pokemon = new ArrayList<>();

    public Pokedex() {
    }



}
