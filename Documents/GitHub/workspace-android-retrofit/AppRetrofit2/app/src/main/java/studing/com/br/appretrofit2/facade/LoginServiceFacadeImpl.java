package studing.com.br.appretrofit2.facade;

import android.os.StrictMode;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import studing.com.br.appretrofit2.model.Login;

/**
 * simple GET
 * API http://echo.jsontest.com/userName/android/password/123456
 *
 * */
public class LoginServiceFacadeImpl implements LoginServiceFacade {

    private static String URL = "http://echo.jsontest.com";


    @Override
    public Call<Login> findByLogin() throws Exception {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

        LoginServiceFacade facade = retrofit.create(LoginServiceFacade.class);

        Call<Login> loginCall = facade.findByLogin();

        return loginCall;
    }
}
