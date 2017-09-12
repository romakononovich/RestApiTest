package xyz.romakononovich.restapitest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.romakononovich.restapitest.R;
import xyz.romakononovich.restapitest.model.Comment;
import xyz.romakononovich.restapitest.model.Post;

/**
 * Created by romank on 12.09.17.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    List<Comment> listComments = new ArrayList<>();


    public void setList(List<Comment> list) {
        listComments = list;
        notifyDataSetChanged();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment_preview,parent,false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.tvName.setText(listComments.get(position).getName());
        holder.tvEmail.setText(listComments.get(position).getEmail());
        holder.tvComment.setText(listComments.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return listComments.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvEmail;
        TextView tvComment;
        CommentViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
            tvComment = (TextView) itemView.findViewById(R.id.tv_comment);

        }
    }
}
