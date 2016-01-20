package pl.marchuck.pokeapi;

import java.util.List;

import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.interfaces.PokesReceiver;
import pl.marchuck.pokeapi.model.PokeMove;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
public class MoveGET {

    public void getSingle(int id, PokeReceiver<PokeMove> pokeReceiver) {
        rx.Observable<PokeMove> obso = new GenericAdapter<>(PokeClient.POKEAPI_ENDPOINT,
                PokeMove.class).adapter.create(PokeClient.class).getPokemonMove(id);
        new TemplateGET().getOne(obso, pokeReceiver);
    }

    public void getMany(final List<Integer> ids, PokesReceiver<PokeMove> pokeReceiver) {
        final PokeClient client = new GenericAdapter<>(PokeClient.POKEAPI_ENDPOINT,
                PokeMove.class).adapter.create(PokeClient.class);
        rx.Observable<List<PokeMove>> obso =
                Observable.from(ids).flatMap(new Func1<Integer, Observable<PokeMove>>() {
                    @Override
                    public Observable<PokeMove> call(Integer id) {
                        return client.getPokemonMove(id);
                    }
                }).toList();
        new TemplateGET().getMany(obso, pokeReceiver);
    }
}
