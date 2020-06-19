package com.example.sahranalbum;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button playBtton,next,prev;
    SeekBar start, end;
    TextView startText, endText;
    MediaPlayer song;
    ImageView imageView,imageVieweee,ccc,ccccccccc,cccaaa;
    Animation animation;
    ImageView mute,unmute,back;
    int SongTotalTime;
    Preferences preferences;
    TextView TextTitle,TextName;
    Boolean looping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Id implementation
        playBtton = findViewById(R.id.play);
        startText = findViewById(R.id.TextStart);
        endText = findViewById(R.id.TextEnd);
        imageView = findViewById(R.id.img);
        animation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        ccc = findViewById(R.id.ccc);
        ccccccccc = findViewById(R.id.cccccccc);
        cccaaa = findViewById(R.id.cccaaa);
        looping = true;
        mute = findViewById(R.id.mute);
        unmute = findViewById(R.id.unmute);
        back = findViewById(R.id.back);
        TextTitle = findViewById(R.id.TextTitle);
        TextName = findViewById(R.id.TextName);



        cccaaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (looping == true){
                    song.setLooping(false);
                    looping = false;
                    Animation myAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop_anim);
                    // Use bounce interpolator with amplitude 0.2 and frequency 20
                    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                    myAnim.setInterpolator(interpolator);
                    cccaaa.startAnimation(myAnim);
                }
                else if (looping == false){
                    song.setLooping(true);
                    Animation myAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop_anim);
                    // Use bounce interpolator with amplitude 0.2 and frequency 20
                    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                    myAnim.setInterpolator(interpolator);
                    cccaaa.startAnimation(myAnim);
                }
            }
        });
        ccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccc.setVisibility(View.GONE);
                ccccccccc.setVisibility(View.VISIBLE);

                Animation myAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop_anim);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                ccccccccc.startAnimation(myAnim);

            }
        });
        ccccccccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccccccccc.setVisibility(View.GONE);
                ccc.setVisibility(View.VISIBLE);

                Animation myAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop_anim);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                ccc.startAnimation(myAnim);

            }
        });



        int[] color = {getResources().getColor(R.color.darkBlue),getResources().getColor(R.color.cccc)};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.MIRROR; // or TileMode.REPEAT;
        LinearGradient lin_grad = new LinearGradient(0, 0, 0, 20,color,position, tile_mode);
        Shader shader_gradient = lin_grad;
        TextName.getPaint().setShader(shader_gradient);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessDialog();
            }
        });


/*        //Song Added
        song = MediaPlayer.create(this, R.raw.zy_mante);
        preferences.Save_name(this,"zymante");
        song.setLooping(true);
        song.seekTo(0);
        song.setVolume(0.5f, 0.5f);
        SongTotalTime = song.getDuration();*/
        String songnn = preferences.Get_name(this);
        String songnn1 = preferences.Get_nameee(this);

        if (songnn.equals("zymante")){
            song = MediaPlayer.create(this, R.raw.zy_mante);
            preferences.Save_name(this,"zymante");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }

        else if (songnn.equals("odam")){
            song = MediaPlayer.create(this, R.raw.odam_mraytha);
            preferences.Save_name(this,"odam");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }

        else if (songnn.equals("sahran")){

            song = MediaPlayer.create(this, R.raw.sahran);
            preferences.Save_name(this,"sahran");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }

        else if (songnn.equals("mkanfalby")){

            song = MediaPlayer.create(this, R.raw.mkank_f_alby);
            preferences.Save_name(this,"mkanfalby");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("yftkrne")){

            song = MediaPlayer.create(this, R.raw.hay3esh_yftkrne);
            preferences.Save_name(this,"yftkrne");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("yomtalat")){

            song = MediaPlayer.create(this, R.raw.yom_talat);
            preferences.Save_name(this,"yomtalat");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("blghkad")){

            song = MediaPlayer.create(this, R.raw.bl_dehka_d);
            preferences.Save_name(this,"blghkad");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("bhbo")){

            song = MediaPlayer.create(this, R.raw.bahebo);
            preferences.Save_name(this,"bhbo");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("awlyom")){

            song = MediaPlayer.create(this, R.raw.awl_yom);
            preferences.Save_name(this,"awlyom");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("ameltaib")){

            song = MediaPlayer.create(this, R.raw.aam_eltabeb);
            preferences.Save_name(this,"ameltaib");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("yarawaank")){

            song = MediaPlayer.create(this, R.raw.ya_rawaaank);
            preferences.Save_name(this,"yarawaank");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("helwaelbdayat")){

            song = MediaPlayer.create(this, R.raw.helwa_elbdayat);
            preferences.Save_name(this,"helwaelbdayat");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("roh")){

            song = MediaPlayer.create(this, R.raw.rooh);
            preferences.Save_name(this,"roh");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("gamila")){

            song = MediaPlayer.create(this, R.raw.gamila);
            preferences.Save_name(this,"gamila");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }
        else if (songnn.equals("gamdabs")){

            song = MediaPlayer.create(this, R.raw.gamda_bs);
            preferences.Save_name(this,"gamdabs");
            TextName.setText(songnn1);

            song.setLooping(true);
            song.seekTo(0);
            song.setVolume(0.5f, 0.5f);
            SongTotalTime = song.getDuration();
        }


        if (preferences.Get_name(this).equals("zymante")){
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.GONE);
        }
        if (preferences.Get_name(this).equals("gamdabs")){
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.GONE);
        }
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (preferences.Get_name(v.getContext()).equals("zymante")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("قدام مرايتها");
                        song = MediaPlayer.create(v.getContext(), R.raw.odam_mraytha);
                        preferences.Save_name(v.getContext(),"odam");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("odam")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("سهران");
                        song = MediaPlayer.create(v.getContext(), R.raw.sahran);
                        preferences.Save_name(v.getContext(),"sahran");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("sahran")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("مكانك فى قلبى");
                        song = MediaPlayer.create(v.getContext(), R.raw.mkank_f_alby);
                        preferences.Save_name(v.getContext(),"mkanfalby");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("mkanfalby")){
                        song.pause();
                        prev.setVisibility(View.VISIBLE);

                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("هيعيش يفتكرنى");
                        song = MediaPlayer.create(v.getContext(), R.raw.hay3esh_yftkrne);
                        preferences.Save_name(v.getContext(),"yftkrne");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("yftkrne")){
                        prev.setVisibility(View.VISIBLE);
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("يوم تلات");
                        song = MediaPlayer.create(v.getContext(), R.raw.yom_talat);
                        preferences.Save_name(v.getContext(),"yomtalat");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("yomtalat")){
                        song.pause();
                        prev.setVisibility(View.VISIBLE);
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("بالضحكة دى");
                        song = MediaPlayer.create(v.getContext(), R.raw.bl_dehka_d);
                        preferences.Save_name(v.getContext(),"blghkad");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("blghkad")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("بحبه");
                        song = MediaPlayer.create(v.getContext(), R.raw.bahebo);
                        preferences.Save_name(v.getContext(),"bhbo");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("bhbo")){
                        song.pause();
                        prev.setVisibility(View.VISIBLE);

                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("اول يوم");
                        song = MediaPlayer.create(v.getContext(), R.raw.awl_yom);
                        preferences.Save_name(v.getContext(),"awlyom");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("awlyom")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("عم الطبيب");
                        song = MediaPlayer.create(v.getContext(), R.raw.aam_eltabeb);
                        preferences.Save_name(v.getContext(),"ameltaib");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("ameltaib")){
                        song.pause();
                        prev.setVisibility(View.VISIBLE);

                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("يا روقانك");
                        song = MediaPlayer.create(v.getContext(), R.raw.ya_rawaaank);
                        preferences.Save_name(v.getContext(),"yarawaank");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("yarawaank")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("حلوة البدايات");
                        song = MediaPlayer.create(v.getContext(), R.raw.helwa_elbdayat);
                        preferences.Save_name(v.getContext(),"helwaelbdayat");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("helwaelbdayat")){
                        song.pause();
                        prev.setVisibility(View.VISIBLE);

                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("روح");
                        song = MediaPlayer.create(v.getContext(), R.raw.rooh);
                        preferences.Save_name(v.getContext(),"roh");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("roh")){
                        prev.setVisibility(View.VISIBLE);

                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("جميلة");
                        song = MediaPlayer.create(v.getContext(), R.raw.gamila);
                        preferences.Save_name(v.getContext(),"gamila");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("gamila")){
                        song.pause();
                        prev.setVisibility(View.VISIBLE);

                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("جامدة بس");
                        song = MediaPlayer.create(v.getContext(), R.raw.gamda_bs);
                        preferences.Save_name(v.getContext(),"gamdabs");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                        next.setVisibility(View.GONE);

                    }


                }
            });

            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aaa = preferences.Get_name(v.getContext());
                    if (preferences.Get_name(v.getContext()) .equals("odam") ){
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("زى ما انتى");
                        prev.setVisibility(View.GONE);
                        song = MediaPlayer.create(v.getContext(), R.raw.zy_mante);
                        preferences.Save_name(v.getContext(),"zymante");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("sahran")){
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("قدام مرايتها");
                        song = MediaPlayer.create(v.getContext(), R.raw.odam_mraytha);
                        preferences.Save_name(v.getContext(),"odam");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();

                    }

                    else if (preferences.Get_name(v.getContext()).equals("mkanfalby")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("سهران");
                        song = MediaPlayer.create(v.getContext(), R.raw.sahran);
                        preferences.Save_name(v.getContext(), "sahran");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("yftkrne")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("مكانك فى قلبى");
                        song = MediaPlayer.create(v.getContext(), R.raw.mkank_f_alby);
                        preferences.Save_name(v.getContext(), "mkanfalby");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("yomtalat")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("هيعيش يفتكرنى");
                        song = MediaPlayer.create(v.getContext(), R.raw.hay3esh_yftkrne);
                        preferences.Save_name(v.getContext(), "yftkrne");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("blghkad")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("يوم تلات");
                        song = MediaPlayer.create(v.getContext(), R.raw.yom_talat);
                        preferences.Save_name(v.getContext(), "yomtalat");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }
                    else if (preferences.Get_name(v.getContext()).equals("bhbo")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("بالضحكة دى");
                        song = MediaPlayer.create(v.getContext(), R.raw.bl_dehka_d);
                        preferences.Save_name(v.getContext(), "blghkad");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("awlyom")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("بحبه");
                        song = MediaPlayer.create(v.getContext(), R.raw.bahebo);
                        preferences.Save_name(v.getContext(), "bhbo");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("ameltaib")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("اول يوم");
                        song = MediaPlayer.create(v.getContext(), R.raw.awl_yom);
                        preferences.Save_name(v.getContext(), "awlyom");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("yarawaank")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("عم الطبيب");
                        song = MediaPlayer.create(v.getContext(), R.raw.aam_eltabeb);
                        preferences.Save_name(v.getContext(), "ameltaib");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("helwaelbdayat")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("يا روقانك");
                        song = MediaPlayer.create(v.getContext(), R.raw.ya_rawaaank);
                        preferences.Save_name(v.getContext(), "yarawaank");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }


                    else if (preferences.Get_name(v.getContext()).equals("roh")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("حلوة البدايات");
                        song = MediaPlayer.create(v.getContext(), R.raw.helwa_elbdayat);
                        preferences.Save_name(v.getContext(), "helwaelbdayat");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }

                    else if (preferences.Get_name(v.getContext()).equals("gamila")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("روح");
                        song = MediaPlayer.create(v.getContext(), R.raw.rooh);
                        preferences.Save_name(v.getContext(), "roh");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                    }


                    else if (preferences.Get_name(v.getContext()).equals("gamdabs")) {
                        song.pause();
                        playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                        TextName.setText("جميلة");
                        song = MediaPlayer.create(v.getContext(), R.raw.gamila);
                        preferences.Save_name(v.getContext(), "gamila");
                        song.setLooping(true);
                        song.seekTo(0);
                        song.setVolume(0.5f, 0.5f);
                        SongTotalTime = song.getDuration();
                        song.start();
                        next.setVisibility(View.VISIBLE);
                    }
                }
            });




        //Control Seek bar track line / play line
        start = findViewById(R.id.PlayLine);
        start.setMax(SongTotalTime);
        start.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    song.seekTo(progress);
                    start.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Volume control
        end = findViewById(R.id.volume);
        end.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = progress / 100f;
                song.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        unmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unmute.setVisibility(View.GONE);
                mute.setVisibility(View.VISIBLE);
                song.setVolume(0,0);
            }
        });

        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mute.setVisibility(View.GONE);
                unmute.setVisibility(View.VISIBLE);
                song.setVolume(100,100);
            }
        });
        //Up date song time line
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (song != null) {
                    try {
                        Message message = new Message();
                        message.what = song.getCurrentPosition();
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {

                    }
                }
            }
        }).start();

    }


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message message) {
            int SeekBarPosition = message.what;
            //Update song seek bar
            start.setProgress(SeekBarPosition);

            //Update Labels
            String Time = createTimeText(SeekBarPosition);
            startText.setText(Time);

            //Time calculation
            String remainingTime = createTimeText(SongTotalTime - SeekBarPosition);
            endText.setText("- " + remainingTime);
        }
    };

    //Time Shows
    public String createTimeText(int time){
        String timeText;
        int min =  time / 1000 / 60;
        int sec = time / 1000 % 60;
        timeText = min + ":";
        if (sec < 10 ) timeText += "0";
        timeText += sec;
        return timeText;
    }


    public void PlayButton(View view) {
        if (!song.isPlaying()) {
            //Stopped
            song.start();
            //Rotation start
            //imageView.startAnimation(animation);
            playBtton.setBackgroundResource(R.drawable.ic_pause_black_24dp);
        }else {
            //Played
            song.pause();
            //imageView.clearAnimation();
            playBtton.setBackgroundResource(R.drawable.ic_play_arrow_black_24dp);
        }
    }

    @Override
    public void onBackPressed() {
        showSuccessDialog();
    }


    private void showSuccessDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.success_dialog, viewGroup, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        imageVieweee = dialogView.findViewById(R.id.aaaaaaaaaaaaaaaa);
        imageVieweee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                song.pause();
                finish();
            }
        });
    }

    class MyBounceInterpolator implements android.view.animation.Interpolator {
        private double mAmplitude = 1;
        private double mFrequency = 10;

        MyBounceInterpolator(double amplitude, double frequency) {
            mAmplitude = amplitude;
            mFrequency = frequency;
        }

        public float getInterpolation(float time) {
            return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                    Math.cos(mFrequency * time) + 1);
        }
    }
}
