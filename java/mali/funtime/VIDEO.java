package mali.funtime;

import android.graphics.PixelFormat;
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

public class VIDEO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView videoView =(VideoView)findViewById(R.id.videoView2);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r1---sn-4g57kndy.googlevideo.com/Cj0LENy73wIaNAlHVXPNbSZmehMYDSANFC3gpeFWMOCoAUIASARgv5ed2dSZ2LNUigELaFppMHdqcWJtd2cM/31226B1F70760FC9741745A81EBD2A8C5CAE56F3.B3A3035E1DF0D7FD4BCCF0418D94370F64D8A816/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }

}

