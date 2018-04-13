package studing.com.br.approboguice.facade;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import studing.com.br.approboguice.model.Login;

public interface LoginServiceFacade {

    @Headers({ "Accept: application/json" })
    @GET("/userName/android/password/123456")
    public Call<Login> findLogin()throws Exception;
}
