package com.metimol.easybook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.metimol.easybook.R;
import com.metimol.easybook.api.models.Serie;

import java.util.Objects;

public class SeriesAdapter extends ListAdapter<Serie, SeriesAdapter.SeriesViewHolder> {
    public interface OnSeriesClickListener {
        void onSeriesClick(Serie serie);
    }
    private OnSeriesClickListener clickListener;

    public void setOnSeriesClickListener(OnSeriesClickListener listener) {
        this.clickListener = listener;
    }

    public SeriesAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Serie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Serie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Serie oldItem, @NonNull Serie newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Serie oldItem, @NonNull Serie newItem) {
            return Objects.equals(oldItem.getName(), newItem.getName()) &&
                    oldItem.getBooksCount() == newItem.getBooksCount();
        }
    };

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serie, parent, false);
        return new SeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        Serie serie = getItem(position);
        holder.bind(serie);
        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onSeriesClick(serie);
            }
        });
    }

    static class SeriesViewHolder extends RecyclerView.ViewHolder {
        private final TextView serieName;
        private final TextView serieBooksCount;

        public SeriesViewHolder(@NonNull View itemView) {
            super(itemView);
            serieName = itemView.findViewById(R.id.serieName);
            serieBooksCount = itemView.findViewById(R.id.serieBooksCount);
        }

        public void bind(Serie serie) {
            serieName.setText(serie.getName());
            Context ctx = itemView.getContext();

            String booksCountText;
            try {
                booksCountText = ctx.getResources().getQuantityString(
                        R.plurals.books_count, serie.getBooksCount(), serie.getBooksCount()
                );
            } catch (Exception e) {
                booksCountText = serie.getBooksCount() + " " + ctx.getString(R.string.books_fallback);
            }
            serieBooksCount.setText(booksCountText);
        }
    }
}