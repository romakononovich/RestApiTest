package xyz.romakononovich.restapitest.interfaces;

import java.util.List;

import xyz.romakononovich.restapitest.model.Post;

/**
 * Created by romank on 07.09.17.
 */

public interface PostObserver {
    void onPostsReceived(List<Post> postList);
}
