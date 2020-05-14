package com.example.inshape;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class detailVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayer;
    String title,video_url;
    String youtube_id = "AIzaSyBleyiUrjMdwJ6vU0oIbzMgWZ62f4F5cJ0";
    String video_id;
    VideoView videoView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);
        youTubePlayer = (YouTubePlayerView)findViewById(R.id.exercise_video);
        progressDialog = new ProgressDialog(this);

        title = getIntent().getStringExtra("title");

        if(title.equals("20 barbell bicep curl")){video_id = "LY1V6UbRHFM";}
        else if(title.equals("20 hammer curl")){video_id = "TwD-YGVP4Bk";}
        else if(title.equals("25 diamond pushups")){video_id = "J0DnG1_S92I";}
        else if(title.equals("25 close-grip pushups")){video_id = "iFb3DPTWwD8";}
        else if(title.equals("15 decline triceps extension")){video_id = "zSxRVoI8ktQ";}
        else if(title.equals("15 triceps kickback")){video_id = "m9me06UBPKc";}
        else if(title.equals("3 minutes plank")){video_id = "ASdvN_XEl_c";}
        else if(title.equals("2 mintues reverse plank")){video_id = "ZNAxdJ6Bt00";}
        else if(title.equals("15 dynamic chest streches")){video_id = "urICkMgMrjk";}
        else if(title.equals("8 barbell bench press")){video_id = "rT7DgCr-3pg";}
        else if(title.equals("10 bench dumbbell press")){video_id = "VmB1G1K7v94";}
        else if(title.equals("10 incline barbell bench press")){video_id = "SrqOu55lrYU";}
        else if(title.equals("12 incline dumbbell press")){video_id = "0G2_XV7slIg";}
        else if(title.equals("15dembbell pullovers")){video_id = "ZhPOEQJRzBU";}
        else if(title.equals("20 mountain climbers")){video_id = "nmwgirgXLYM";}
        else if(title.equals("10 chest dips")){video_id = "dX_nSOOJIsE";}
        else if(title.equals("25 wide pushups")){video_id = "rr6eFNNDQdU";}
        else if(title.equals("15 chest shoulder stretches")){video_id = "XMsBC9-vSDs";}
        else if(title.equals("20 shoulder rotation")){video_id = "-SKM8uWVG2Y&t=1s";}
        else if(title.equals("15 dumbbell incline bench press")){video_id = "8iPEnn-ltC8";}
        else if(title.equals("15 dumbbell lateral raise")){video_id = "3VcKaXpzqRo";}
        else if(title.equals("10 dumbbell rear latteral raise")){video_id = "Z0HTsZEMedA";}
        else if(title.equals("16 dumbell alt latteral raise")){video_id = "MstS-f1EbwU";}
        else if(title.equals("15 dumbbell seated shoulder press")){video_id = "qEwKCR5JCog";}
        else if(title.equals("10 dumbell standing alt raise")){video_id = "TEs1Kj0itQE";}
        else if(title.equals("20 sit-ups")){video_id = "jDwoBqPH0jk";}
        else if(title.equals("20 air bikes")){video_id = "i6mPCVUrtNk";}
        else if(title.equals("25 crunches")){video_id = "Xyd_fa5zoEU";}
        else if(title.equals("15 decline crunches")){video_id = "QhGU5cmNZds";}
        else if(title.equals("3 min plank")){video_id = "ASdvN_XEl_c";}
        else if(title.equals("10 lying leg raise")){video_id = "JB2oyawG9KI";}
        else if(title.equals("2 min side plank")){video_id = "K2VljzCC16g";}
        else if(title.equals("20 russian twist")){video_id = "wkD8rjkodUI";}
        else if(title.equals("10 V-ups")){video_id = "iP2fjvG0g3w";}
        else
        { Toast.makeText(this, "video not found",Toast.LENGTH_SHORT).show(); }

        youTubePlayer.initialize(youtube_id, this);
    }

    /*public void video_view_method(String video_url) {
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        progressDialog.setMessage("Buffering video please wait");
        progressDialog.show();
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(video_url));
        videoView.requestFocus();
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
            }
        });
        progressDialog.dismiss();
    }*/

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean video_present) {
        if(!video_present)
        {
            youTubePlayer.cueVideo(video_id);
            youTubePlayer.play();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(this, "no video uploaded", Toast.LENGTH_SHORT).show();
    }
}
