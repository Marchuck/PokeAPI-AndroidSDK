package pl.marchuck.pokeapi;

import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.model.Pokedex;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
public class PokedexGET extends BaseRequest {

    public PokedexGET() {
    }

    public void get(PokeReceiver<Pokedex> receiver) {
        getVersion(1, receiver);
    }
    public void vv(){
        getVersion(1, new PokeReceiver<Pokedex>() {
            @Override
            public void onReceived(Pokedex pokemon) {

            }
        });
    }

    public void getVersion(Integer version, final PokeReceiver<Pokedex> receiver) {

        GenericAdapter<Pokedex> a =
                new GenericAdapter<>(PokeClient.POKEAPI_ENDPOINT, Pokedex.class);
        pokeSubscription = a.adapter.create(PokeClient.class)
                .getPokedex(version)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(onStart).doOnCompleted(onEnd)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Pokedex>() {
                    @Override
                    public void call(Pokedex pokemonDescription) {
                        receiver.onReceived(pokemonDescription);
                    }
                }, onError);
    }
}
