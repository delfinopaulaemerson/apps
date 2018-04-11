package studing.com.br.model;

import javax.inject.Inject;

import dagger.Module;

@Module
public class ToastMessage {

    @Inject
    public ToastMessage() {
    }

    public String getMassage(){
        return " Hello Toast Massage ";
    }


}
