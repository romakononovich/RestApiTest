package xyz.romakononovich.restapitest.interfaces;

/**
 * Created by romank on 07.09.17.
 */

public interface PostObservable  {
    void addObserver(PostObserver postObserver);
    void removeObserver(PostObserver postObserver);
    void notifyObservers();
}
