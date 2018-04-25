package univr.intcatchboatusermanual;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
				web_view.setWebViewClient(new WebViewClient() {
						@Override public boolean shouldOverrideUrlLoading(WebView webView, String url) { webView.loadUrl(url); return true; }
				});
				String root_url = "file:///sdcard/INTCATCH/user manual/index.html";
				web_view.loadUrl(root_url);

				// TODO: https://stackoverflow.com/questions/16142311/android-unzipping-files-programmatically-in-android
				// TODO: set up location for downloading a file, put a zip of the sphinx html build folder there
				// TODO: check if the index file exists
				// TODO: if index file does not exist, automatically download and unzip the file, then display index
				// TODO: if possible, show some kind of progress bar or something
				// TODO: if index file does exist, just display it
				

				// TODO: either open in chrome or add a back and forward button to the webview

		}
}
