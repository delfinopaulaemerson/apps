package studing.com.br.appstuding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * metodo login
     * @param view
     */
    public void signIn(View view) {

        password = (EditText) findViewById(R.id.password);

        System.out.println(password.getText().toString());

        username = (EditText) findViewById(R.id.userName);

        System.out.println(username.getText().toString());

        //TUDO implementar o metodo de autenticacao

        Intent homeActivity = new Intent(this,HomeActivity.class);
        startActivity(homeActivity);

    }
}
