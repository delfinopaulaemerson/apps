package studing.com.br.approboguice.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.inject.Inject;

import retrofit2.Call;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import studing.com.br.approboguice.R;
import studing.com.br.approboguice.facade.LoginServiceFacade;
import studing.com.br.approboguice.model.Login;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    @InjectView(R.id.editUser)
    private EditText userNameEdit;

    @InjectView(R.id.editPassword)
    private EditText passwordEdit;

    @Inject
    private LoginServiceFacade loginServiceFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void sigIn(View view) {
        String strUserName;
        String strPassword;
        Call<Login> cl = null;
        Login login = null;
        try {
            strUserName = userNameEdit.getText().toString();
            strPassword = passwordEdit.getText().toString();
            cl = this.loginServiceFacade.findLogin();
            login = cl.execute().body();
            if((strUserName.equals(login.getUserName()))&&(strPassword.equals(login.getPassword()))){
                Intent home = new Intent(this,HomeActivity.class);
                startActivity(home);
            }else{
                AlertDialog alerta = null;
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Mensagem :");
                builder.setMessage("UserName ou Password incorretos!");
                builder.setPositiveButton(" OK ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, " OK " + arg1, Toast.LENGTH_SHORT).show();
                    }
                });
                alerta = builder.create();
                alerta.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
