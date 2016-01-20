package pl.marchuck.pokeapi.interfaces;

import java.util.List;

/**
 * Created by Łukasz Marczak
 *
 * @since 19.01.16
 */
public interface PokesReceiver<T> {
    void onReceived(List<T> pokemons);
}
