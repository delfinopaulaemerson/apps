package studing.com.br.model;

import javax.inject.Inject;

import dagger.Module;

/**
 * emerson delfino
 */
@Module
public class LogMessage {

    @Inject
    public LogMessage() {
    }

    public String getValue(){

        return  " Hello Log message ";
    }
}
