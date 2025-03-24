package com.example.week_10;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView titleText, yearText, genreText;

    public MovieViewHolder(View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.movieTitle);
        yearText = itemView.findViewById(R.id.movieYear);
        genreText = itemView.findViewById(R.id.movieGenre);
    }

    public void bind(Movie movie) {
        titleText.setText(movie.getTitle());
        yearText.setText(String.valueOf(movie.getYear()));
        genreText.setText(movie.getGenre());
    }
}
