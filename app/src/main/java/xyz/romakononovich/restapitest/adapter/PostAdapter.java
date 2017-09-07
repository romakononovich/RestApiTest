package xyz.romakononovich.restapitest.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.romakononovich.restapitest.R;
import xyz.romakononovich.restapitest.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    List<Post> listPost = new ArrayList<>();


    public void setList(List<Post> list) {
        listPost = list;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_preview,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.tvTitle.setText(listPost.get(position).getTitle());
        holder.tvBody.setText(listPost.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvBody;
        PostViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);

        }
    }
}
