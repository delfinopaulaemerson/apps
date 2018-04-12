package studing.com.br.appretrofit2.facade;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import studing.com.br.appretrofit2.model.Login;

public interface LoginServiceFacade {

    @Headers({ "Accept: application/json" })
    @GET("/userName/android/password/123456")
    public Call<Login> findByLogin() throws Exception;
}
