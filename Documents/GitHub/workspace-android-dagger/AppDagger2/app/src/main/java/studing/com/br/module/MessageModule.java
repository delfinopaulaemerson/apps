package studing.com.br.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import studing.com.br.model.ErrorMessage;
import studing.com.br.model.ToastMessage;

@Module
public class MessageModule {

    @Provides
    @Singleton
    public ToastMessage provideToast(){
        return new ToastMessage();
    }

    @Provides
    @Singleton
    public ErrorMessage provideErroMessage(){
        return new ErrorMessage();
    }
}
