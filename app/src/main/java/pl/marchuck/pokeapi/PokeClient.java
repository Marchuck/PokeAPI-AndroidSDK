package pl.marchuck.pokeapi;

import pl.marchuck.pokeapi.model.PokeMove;
import pl.marchuck.pokeapi.model.PokeType;
import pl.marchuck.pokeapi.model.Pokedex;
import pl.marchuck.pokeapi.model.Pokemon;
import pl.marchuck.pokeapi.model.PokemonDescription;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Łukasz Marczak
 *
 * @since 25.12.15
 */
interface PokeClient {
    String POKEAPI_ENDPOINT = "http://pokeapi.co";

    @GET("/api/v1/pokedex/{version}/")
    rx.Observable<Pokedex> getPokedex(@Path("version") Integer id);

    @GET("/api/v1/pokemon/{id}/")
    rx.Observable<Pokemon> getPokemonById(@Path("id") Integer id);

    @GET("/api/v1/description/{id}/")
    rx.Observable<PokemonDescription> getPokemonDescription(@Path("id") Integer id);

    @GET("/api/v1/type/{id}/")
    rx.Observable<PokeType> getPokemonType(@Path("id") Integer id);

    @GET("/api/v1/move/{id}/")
    rx.Observable<PokeMove> getPokemonMove(@Path("id") Integer id);

}
