package xyz.romakononovich.restapitest;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import xyz.romakononovich.restapitest.adapter.CommentAdapter;
import xyz.romakononovich.restapitest.adapter.PostAdapter;
import xyz.romakononovich.restapitest.model.Comment;

/**
 * Created by romank on 12.09.17.
 */

public class CommentsDialog extends Dialog{
    private RecyclerView recyclerView;
    private CommentAdapter adapter;

    public CommentsDialog(@NonNull Context context) {
        super(context);
        init();
    }



    public CommentsDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init();
    }

    protected CommentsDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        setContentView(R.layout.activity_main);
        initRV();
    }

    private void initRV() {
        recyclerView = (RecyclerView) findViewById(R.id.rvPost);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CommentAdapter();
        recyclerView.setAdapter(adapter);

    }
    public void setCommentsList(List<Comment> commentsList){
        adapter.setList(commentsList);
    }
}
