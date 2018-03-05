package ru.kazakova_net.myaudiobookshelf.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import ru.kazakova_net.myaudiobookshelf.model.AudioBook;
import ru.kazakova_net.myaudiobookshelf.model.AudioBookAdapter;
import ru.kazakova_net.myaudiobookshelf.R;

public class ArchiveActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + ArchiveActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.book_list);

        // Create a list of currently listening audio-books
        ArrayList<AudioBook> books = new ArrayList<>();
        books.add(new AudioBook("Stephen R. Covey",
                "The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change ",
                2013, "Personal effectiveness", R.drawable.pic_3));

        AudioBookAdapter bookAdapter = new AudioBookAdapter(this, books);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(bookAdapter);
    }
}
