package studing.com.br.model;

import javax.inject.Inject;

public class ErrorMessage {

    @Inject
    public ErrorMessage() {
    }

    public  String getValue(){

        return  "Hello Erro Massage";
    }
}
