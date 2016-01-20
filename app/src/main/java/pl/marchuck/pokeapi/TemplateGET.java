package pl.marchuck.pokeapi;

import java.util.List;

import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.interfaces.PokesReceiver;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
class TemplateGET extends BaseRequest {


    public <T> void getOne(rx.Observable<T> request, final PokeReceiver<T> receiver) {
        pokeSubscription = request.subscribeOn(Schedulers.io())
                .doOnSubscribe(onStart).doOnCompleted(onEnd)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<T>() {
                    @Override
                    public void call(T object) {
                        receiver.onReceived(object);
                    }
                }, onError);
    }

    public <T> void getMany(rx.Observable<List<T>> request, final PokesReceiver<T> receiver) {
        pokeSubscription = request.subscribeOn(Schedulers.io())
                .doOnSubscribe(onStart).doOnCompleted(onEnd)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<T>>() {
                    @Override
                    public void call(List<T> object) {
                        receiver.onReceived(object);
                    }
                }, onError);
    }
}
