package studing.com.br.component;

import javax.inject.Singleton;

import dagger.Component;
import studing.com.br.activity.MainActivity;
import studing.com.br.model.LogMessage;
import studing.com.br.module.MessageModule;

@Component(modules = {MessageModule.class, LogMessage.class})
@Singleton
public interface AppComponent {

    public void inject(MainActivity mainActivity);
}
