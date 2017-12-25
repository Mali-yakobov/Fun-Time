package mali.funtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import mali.funtime.R;

public class MainActivity extends AppCompatActivity {
    private static ImageButton button_game;
    private static ImageButton button_sentence;
    private static ImageButton button_video;
    private static ImageButton button_song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();
    }

    public void OnClickButtonListener() {
        button_sentence = (ImageButton) findViewById(R.id.button_sentence);
        button_sentence.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("mali.funtime.BeautifulSentences");
                        startActivity(intent);
                    }
                }

        );
        button_game = (ImageButton) findViewById(R.id.button_game);
        button_game.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("mali.funtime.XO");
                        startActivity(intent);
                    }
                }

        );
        button_video = (ImageButton) findViewById(R.id.button_video);
        button_video.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("mali.funtime.VIDEO");
                        startActivity(intent);
                    }
                }

        );
        button_song = (ImageButton) findViewById(R.id.button_song);
        button_song.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("mali.funtime.Songs");
                        startActivity(intent);
                    }
                }

        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
