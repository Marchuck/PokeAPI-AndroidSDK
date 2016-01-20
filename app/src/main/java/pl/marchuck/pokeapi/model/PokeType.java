package pl.marchuck.pokeapi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
public class PokeType {
    public String created;
    public Integer id;
    public List<PokeDetail> ineffective = new ArrayList<PokeDetail>();
    public String modified;
    public String name;
    public List<Object> noEffect = new ArrayList<Object>();
    public List<Object> resistance = new ArrayList<Object>();
    public String resourceUri;
    public List<PokeDetail> superEffective = new ArrayList<PokeDetail>();
    public List<PokeDetail> weakness = new ArrayList<PokeDetail>();
}
