package studing.com.br.appretrofit2.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import studing.com.br.appretrofit2.R;
import studing.com.br.appretrofit2.facade.LoginServiceFacadeImpl;
import studing.com.br.appretrofit2.model.Login;

public class MainActivity extends AppCompatActivity {

    private LoginServiceFacadeImpl facade;
    private Login login;

    private EditText userNameEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        facade = new LoginServiceFacadeImpl();
        login = new Login();
    }

    /**
     * metodo login comparando os dados de entrada
     * com os dados consumidos da API
     * http://echo.jsontest.com/userName/android/password/123456
     * @param view
     */
    public void signIn(View view) {
        passwordEdit = findViewById(R.id.password);
        userNameEdit = findViewById(R.id.userName);
        String strPassword = passwordEdit.getText().toString();
        String strUserName = userNameEdit.getText().toString();
        try {
            //verifica se os dados de entrada estao preenchidos
            //caso nao exibe uma mensagem de alerta
            if (("".equals(strUserName)) && ("".equals(strPassword))) {
                AlertDialog alerta = null;
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Mensagem :");
                builder.setMessage("Favor Preencher User Name ou Password!");
                builder.setPositiveButton(" OK ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, " OK " + arg1, Toast.LENGTH_SHORT).show();
                    }
                });
                alerta = builder.create();
                alerta.show();
            } else {
                //consumo da API retrofit2
                Call<Login> cl = facade.findByLogin();
                login = cl.execute().body();

                //verifica se os dados de entrada sao iguais os dados do consumo da API
                //navega para interface de HomeActivity
                if(login.getUserName().equals(strUserName)&& login.getPassword().equals(strPassword)){
                    Intent home = new Intent(this,HomeActivity.class);
                    startActivity(home);
                }else{
                    //senão emite uma mensagem de alerta informando que
                    //user name ou password estao incorreto
                    AlertDialog alerta = null;
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Mensagem :");
                    builder.setMessage("User Name ou Password incorreto!");
                    builder.setPositiveButton(" OK ", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(MainActivity.this, " OK " + arg1, Toast.LENGTH_SHORT).show();
                        }
                    });
                    alerta = builder.create();
                    alerta.show();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
