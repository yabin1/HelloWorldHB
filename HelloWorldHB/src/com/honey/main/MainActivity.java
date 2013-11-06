package com.honey.main;

import org.honey.hbController.HoneyBadger;
import org.honey.hbController.SingleEntry;

import com.honey.hellowworldhb.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		WebView browser = (WebView)findViewById(R.id.homeView);
        
        ////***************Honey Badger call***************////
        HoneyBadger w_object = SingleEntry.getInstance();
        w_object.createMap(this,getAssets());
        ////***********************************************////
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        
        browser.setWebChromeClient(new WebChromeClient() 
        {
            @Override
            public void onProgressChanged(WebView view, int progress) 
            {               
            	 progressBar.setProgress(0);
            	 progressBar.setVisibility(View.VISIBLE);
            	 MainActivity.this.setProgress(progress * 1000);
            	 
            	 progressBar.incrementProgressBy(progress);
            	 
                 if(progress == 100)
                 {
                    // progressBar.setVisibility(View.GONE);
                 }
            }
        });  
		
		//------------------------
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
