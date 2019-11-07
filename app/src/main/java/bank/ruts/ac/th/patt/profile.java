package bank.ruts.ac.th.patt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class profile extends AppCompatActivity {
Button bt2;
MediaPlayer mp1,mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bt2 = (Button)findViewById(R.id.bt2);
        mp1 = MediaPlayer.create(this, R.raw.effect_btn_shut);
        mp2 = MediaPlayer.create(this, R.raw.sound);
        mp2.start();
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(profile.this, MainActivity.class);
                startActivity(back);
                mp1.start();
                mp2.stop();
            }
        });
    }
}
