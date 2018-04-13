package studing.com.br.approboguice.facade;

import android.os.StrictMode;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import studing.com.br.approboguice.model.Login;

public class LoginServiceFacadeImpl implements LoginServiceFacade {

    private static String URL = "http://echo.jsontest.com";


    @Override
    public Call<Login> findLogin() throws Exception {
        //metodo permitido para auxilia o consumo externo utilizando a api retrofit
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //criando uma instancia
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

        //criando instanciando a interface
        LoginServiceFacade facade = retrofit.create(LoginServiceFacade.class);

        //criando uma instancia Call<Login>
        Call<Login> loginCall = facade.findLogin();

        //retornanco a instancia
        return loginCall;
    }
}
