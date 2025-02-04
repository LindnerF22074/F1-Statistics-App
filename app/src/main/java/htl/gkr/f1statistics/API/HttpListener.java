package htl.gkr.f1statistics.API;

public interface HttpListener<T> {
    void onSuccess(T response);
    void onError(String error);
}
