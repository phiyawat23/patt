package bank.ruts.ac.th.patt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class login extends AppCompatActivity {

    FirebaseDatabase databaseconnect,databaseconnect2;
    DatabaseReference sendValue,getValue;
    TextView tv1,tv2,tv3;
    Button bt5,bt6;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv1 = (TextView)findViewById(R.id.txtname);
        tv2 = (TextView)findViewById(R.id.txtpass);
        bt5 = (Button)findViewById(R.id.bt5);
        bt6 = (Button)findViewById(R.id.bt6);
        value = (EditText)findViewById(R.id.editText3);
        tv3 = (TextView)findViewById(R.id.txtGet);

        tv1.setText(getIntent().getStringExtra("name"));
        tv2.setText(getIntent().getStringExtra("passwd"));

        databaseconnect = FirebaseDatabase.getInstance();
        sendValue = databaseconnect.getReference("Android/write");
        databaseconnect2 = FirebaseDatabase.getInstance();
        getValue = databaseconnect2.getReference("Sensor");
        getValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String data = String.valueOf(map.get("sensor"));
                tv3.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        final String text = value.getText().toString();
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(login.this, MainActivity.class);
                startActivity(back);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendValue.setValue(value.getText().toString());

            }
        });

        Toast toast = Toast.makeText(this,"Login Success!!",Toast.LENGTH_SHORT);
        toast.show();
    }
}
