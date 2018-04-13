package studing.com.br.approboguice.bind;

import android.app.Application;

import com.google.inject.AbstractModule;

import studing.com.br.approboguice.facade.LoginServiceFacade;
import studing.com.br.approboguice.facade.LoginServiceFacadeImpl;

public class BindingModule extends AbstractModule {

    //construtor default
    public BindingModule(Application application) {

    }

    @Override
    protected void configure() {
        bind(LoginServiceFacade.class).to(LoginServiceFacadeImpl.class);

    }


}
