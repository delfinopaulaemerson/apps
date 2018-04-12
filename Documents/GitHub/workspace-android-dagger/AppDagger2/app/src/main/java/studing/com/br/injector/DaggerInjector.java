package studing.com.br.injector;

import studing.com.br.component.AppComponent;
import studing.com.br.component.DaggerAppComponent;
import studing.com.br.module.MessageModule;

/**
 * emerson delfino
 */
public class DaggerInjector {

    private static AppComponent appComponent = DaggerAppComponent.builder().messageModule(new MessageModule()).build();

    public static AppComponent get(){

        return appComponent;
    }
}
