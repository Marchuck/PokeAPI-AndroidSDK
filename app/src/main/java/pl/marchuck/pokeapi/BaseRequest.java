package pl.marchuck.pokeapi;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by Łukasz Marczak
 *
 * @since 20.01.16
 */
public class BaseRequest {
    protected rx.Subscription pokeSubscription;

    public void unSubscribe() {
        if (pokeSubscription != null && !pokeSubscription.isUnsubscribed())
            pokeSubscription.unsubscribe();
    }
    protected Action1<Throwable> onError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {

        }
    };
    protected Action0 onStart = new Action0() {
        @Override
        public void call() {

        }
    };
    protected Action0 onEnd = new Action0() {
        @Override
        public void call() {

        }
    };

    public BaseRequest onDownloadStart(Action0 actionStart) {
        this.onStart = actionStart;
        return this;
    }

    public BaseRequest onDownloadEnd(Action0 actionEnd) {
        this.onStart = actionEnd;
        return this;
    }

    public BaseRequest onError(Action1<Throwable> actionError) {
        this.onError = actionError;
        return this;
    }
}
