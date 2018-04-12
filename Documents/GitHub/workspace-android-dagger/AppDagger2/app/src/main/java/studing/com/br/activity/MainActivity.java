package studing.com.br.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import studing.com.br.appdagger2.R;
import studing.com.br.injector.DaggerInjector;
import studing.com.br.model.ErrorMessage;
import studing.com.br.model.LogMessage;
import studing.com.br.model.ToastMessage;

/**
 * emerson delfino
 */

public class MainActivity extends Activity {

    @Inject
    ToastMessage toast;

    @Inject
    ErrorMessage error;

    @Inject
    LogMessage log;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerInjector.get().inject(this);

        Toast.makeText(this, toast.getMassage(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, log.getValue(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, error.getValue(), Toast.LENGTH_SHORT).show();
    }
}
