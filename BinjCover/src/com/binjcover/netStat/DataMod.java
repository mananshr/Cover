package com.binjcover.netStat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import com.binjcover.test.R;

import android.net.http.AndroidHttpClient;
import android.util.Log;

public class DataMod {

	protected AndroidHttpClient httpClient;
	protected HttpGet httpRequest;

	public DataMod() {
		// TODO Auto-generated constructor stub

		this.httpClient = AndroidHttpClient.newInstance("Android "
				+ android.os.Build.VERSION.RELEASE + " "+ R.string.app_name   
				);
	}

	public Object getData() throws IOException {
		String urlstr = "";
		HttpGet httpRequest = new HttpGet(urlstr);
		httpRequest.addHeader("Accept",
				"application/json;q=1,application/x-msgpack;q=0.9");
		httpRequest.addHeader("Accept-Encoding", "bzip2,gzip,deflate");
		HttpResponse httpResponse = this.httpClient.execute(httpRequest);
		Log.i("Resp", httpResponse.toString());
		// ...
		
		return httpResponse;
	}

}
