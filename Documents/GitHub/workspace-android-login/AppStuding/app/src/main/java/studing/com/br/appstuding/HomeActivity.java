package studing.com.br.appstuding;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * metodo para logout
     * @param view
     */
    public void logOut(View view){

        Intent logoutintent = new Intent(this, MainActivity.class);
        startActivity(logoutintent);
        SharedPreferences loginSharedPreferences;
        loginSharedPreferences = getSharedPreferences(
                MainActivity.ACTIVITY_SERVICE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginSharedPreferences.edit();
        editor.putString("UniqueId", "");
        editor.commit();
        finish();

      System.out.println(" Entrou !!!!");
    }
}
