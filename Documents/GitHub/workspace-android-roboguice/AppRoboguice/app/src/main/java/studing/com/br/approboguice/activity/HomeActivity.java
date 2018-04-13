package studing.com.br.approboguice.activity;

import android.os.Bundle;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import studing.com.br.approboguice.R;

@ContentView(R.layout.activity_home)
public class HomeActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
