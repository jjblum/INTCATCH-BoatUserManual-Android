package univr.intcatchboatusermanual;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;

public class HTMLViewerActivity extends Activity
{

		static int REQUEST_EXTERNAL_STORAGE = 0;


		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_htmlviewer);

				if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
								!= PackageManager.PERMISSION_GRANTED)
				{
						requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
				}

				WebView web_view = (WebView) findViewById(R.id.web_view);
				web_view.getSettings().setJavaScriptEnabled(true);
				String root_url = "file:///sdcard/INTCATCH/user manual/index.html";
				web_view.loadUrl(root_url);



		}
}
