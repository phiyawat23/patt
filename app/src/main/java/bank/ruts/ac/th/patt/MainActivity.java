package bank.ruts.ac.th.patt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt4,map;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.profile);
        bt4 = (Button)findViewById(R.id.bt4);
        map = (Button)findViewById(R.id.map);

        username =(EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MainActivity.this, profile.class);
                startActivity(profile);
            }
        });

            bt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent login = new Intent(MainActivity.this, login.class);
                    login.putExtra("name", username.getText().toString());
                    login.putExtra("passwd", password.getText().toString());
                    startActivity(login);
                }
            });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(MainActivity.this, map.class);
                startActivity(map);
            }
        });

    }
}
