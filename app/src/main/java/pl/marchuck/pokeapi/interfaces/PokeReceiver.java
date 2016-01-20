package pl.marchuck.pokeapi.interfaces;

/**
 * Created by Łukasz Marczak
 *
 * @since 19.01.16
 */
public interface PokeReceiver <T>{
    void onReceived(T pokemon);
}
