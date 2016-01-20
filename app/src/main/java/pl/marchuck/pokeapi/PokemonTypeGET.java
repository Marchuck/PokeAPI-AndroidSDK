package pl.marchuck.pokeapi;

import java.util.List;

import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.interfaces.PokesReceiver;
import pl.marchuck.pokeapi.model.PokeType;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
public class PokemonTypeGET extends BaseRequest {

    public PokemonTypeGET() {
    }

    public void getFirst(PokeReceiver<PokeType> receiver) {
        getSingle(1, receiver);
    }

    public void getSingle(Integer typeId, final PokeReceiver<PokeType> receiver) {

        GenericAdapter<PokeType> a =
                new GenericAdapter<>(PokeClient.POKEAPI_ENDPOINT, PokeType.class);
        pokeSubscription = a.adapter.create(PokeClient.class)
                .getPokemonType(typeId)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(onStart).doOnCompleted(onEnd)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<PokeType>() {
                    @Override
                    public void call(PokeType pokemonDescription) {
                        receiver.onReceived(pokemonDescription);
                    }
                }, onError);
    }

    public void getMany(List<Integer> ids, final PokesReceiver<PokeType> types) {
        GenericAdapter<PokeType> a =
                new GenericAdapter<>(PokeClient.POKEAPI_ENDPOINT, PokeType.class);
        final PokeClient client = a.adapter.create(PokeClient.class);
        Observable.from(ids)
                .subscribeOn(Schedulers.trampoline())
                .flatMap(new Func1<Integer, Observable<PokeType>>() {
                    @Override
                    public Observable<PokeType> call(Integer id) {
                        return client.getPokemonType(id);
                    }
                }).toList().subscribe(new Action1<List<PokeType>>() {
            @Override
            public void call(List<PokeType> pokeTypes) {
                types.onReceived(pokeTypes);
            }
        }, onError);
    }
}
