package mali.funtime;

        import android.net.Uri;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.VideoView;
        import android.widget.MediaController;

        import mali.funtime.R;

public class Songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r13---sn-4g57knzk.googlevideo.com/Cj0LENy73wIaNAlYysX_siJu1BMYDSANFC0-peFWMOCoAUIASARgv5ed2dSZ2LNUigELaFppMHdqcWJtd2cM/892A2B261EAB37D4B373258F22C0BC1E766AEF54.16B407B070417604E087AC29EF77FFDB1433E26E/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }


}
