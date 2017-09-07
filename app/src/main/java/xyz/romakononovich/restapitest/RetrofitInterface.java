package xyz.romakononovich.restapitest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.romakononovich.restapitest.model.Post;

/**
 * Created by romank on 29.08.17.
 */

public interface RetrofitInterface {
    @GET("/posts")
    Call<List<Post>> listPosts();
}
