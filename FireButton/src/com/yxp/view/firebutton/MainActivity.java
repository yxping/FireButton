package com.yxp.view.firebutton;

import cn.yxp.view.firebutton.R;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
		ActivityState.isRun = true;
    	super.onResume();
    }

	@Override
	protected void onDestroy() {
		ActivityState.isRun = false;
		super.onDestroy();
	}

}
