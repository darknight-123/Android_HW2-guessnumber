package ttu.cse.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int answer;
    private int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame();
        Button bt1=findViewById(R.id.button);
        EditText edit=findViewById(R.id.editTextTextPersonName6);
        edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN &&keyCode == KeyEvent.KEYCODE_ENTER){
                    times=times+1;
                    checkAns(v);

                    return true;
                }
                return false;
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    newGame();

            }
        });

    }

    public void newGame(){
        TextView text=findViewById(R.id.textView6);
        text.setText("你猜測的結果將顯示於此!");
        Random ran =new Random(System.currentTimeMillis());
        answer=1+ ran.nextInt(100);
        times = 0;
    }



    public void checkAns(View view){
        EditText edit=findViewById(R.id.editTextTextPersonName6);
        TextView text=findViewById(R.id.textView6);
        int num=Integer.parseInt(String.valueOf(edit.getText()));
        if(answer>num){
            text.setText("太小了,再試一次");
        }
        else if(answer<num){
            text.setText("太大了,再試一次");
        }
        else
        {
            text.setText("恭喜猜對,總共花"+times+"次");
        }

    }

    public  void playAgain(View view){

        newGame();
    }
}