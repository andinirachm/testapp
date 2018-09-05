package id.testapp.presenter;

public interface BasePresenter<V> {
    void onAttachView(V view);
    void onDetachView();
}
