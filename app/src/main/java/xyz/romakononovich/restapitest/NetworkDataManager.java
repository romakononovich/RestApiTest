package xyz.romakononovich.restapitest;


// Singleton

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.romakononovich.restapitest.interfaces.PostObservable;
import xyz.romakononovich.restapitest.interfaces.PostObserver;
import xyz.romakononovich.restapitest.model.Post;

import static xyz.romakononovich.restapitest.Constants.BASE_URL;

public class NetworkDataManager implements PostObservable {
    private static final String TAG = NetworkDataManager.class.getSimpleName();
    private static NetworkDataManager sInstance;
    private Call<List<Post>> callPosts;
    private List<Post> listPosts;
    private List<PostObserver> postObservers = new ArrayList<>();

    private NetworkDataManager() {
        initRetrofit();
        getPosts();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        callPosts = service.listPosts();


    }

    public static NetworkDataManager getInstance() {
        if (sInstance == null) {
            Class var2 = NetworkDataManager.class;
            synchronized (NetworkDataManager.class) {
                if (sInstance == null) {
                    sInstance = new NetworkDataManager();
                }
            }
        }
        return sInstance;
    }

    private void getPosts() {

        callPosts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                listPosts = response.body();
                notifyObservers();
                Log.d(TAG, "onResponse: code = " + response.code());
                Log.d(TAG, "onResponse: listResponse = " + listPosts);
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


    @Override
    public void addObserver(PostObserver postObserver) {
        postObservers.add(postObserver);
        if (listPosts!=null&&listPosts.size()>0){
            postObserver.onPostsReceived(listPosts);
        }
    }

    @Override
    public void removeObserver(PostObserver postObserver) {
        postObservers.remove(postObserver);

    }

    @Override
    public void notifyObservers() {
        for (PostObserver observer : postObservers) {
            observer.onPostsReceived(listPosts);
        }
    }
}
