package ru.kazakova_net.myaudiobookshelf.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ru.kazakova_net.myaudiobookshelf.R;
import ru.kazakova_net.myaudiobookshelf.model.AudioBook;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MyLog - " + DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_detail);

        Intent detailIntent = getIntent();

        AudioBook book = detailIntent.getParcelableExtra(AudioBook.BOOK);

        ImageView pictureImageView = findViewById(R.id.picture_image_view);
        pictureImageView.setImageResource(book.getImageResourceId());

        TextView titleTextView = findViewById(R.id.title_text_view);
        titleTextView.setText(book.getTitle());

        TextView authorTextView = findViewById(R.id.author_text_view);
        authorTextView.setText(book.getAuthor());

        TextView genreTextView = findViewById(R.id.genre_text_view);
        genreTextView.setText(book.getGenre());

        TextView yearTextView = findViewById(R.id.year_text_view);
        yearTextView.setText(String.valueOf(book.getYear()));

        TextView descriptionTextView = findViewById(R.id.description_text_view);
        descriptionTextView.setText(book.getDescription());

        TextView playTextView = findViewById(R.id.play_text_view);
        playTextView.setOnClickListener(this);

        TextView homeTextView = findViewById(R.id.home_text_view);
        homeTextView.setOnClickListener(this);
    }

    public static Intent getDetailIntent(AudioBook book, Context packageContext) {
        Intent detailIntent = new Intent(packageContext, DetailActivity.class);
        detailIntent.putExtra(AudioBook.BOOK, book);

        return detailIntent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_text_view:
                Toast.makeText(DetailActivity.this, R.string.start_play_message,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_text_view:
                Intent mainIntent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(mainIntent);
                break;
        }
    }
}
