package com.binjcover.commun;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.widget.Toast;

public class ReqServe {

	private HttpResponse getResponse(Context context) {
		// TODO Auto-generated method stub
		HttpClient httpclient = new DefaultHttpClient();

		String url = "";

		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(null, null);
		httpPost.setParams(null);
		
		try {
			HttpResponse response = httpclient.execute(httpPost);
			if (response != null) {
				String line = "";
				InputStream inputstream = response.getEntity().getContent();

				int ch;
				StringBuilder sb = new StringBuilder();
				while ((ch = inputstream.read()) != -1)
					sb.append((char) ch);
				line = sb.toString();
				// line = convertStreamToString(inputstream);
				Toast.makeText(context, line.toString(), Toast.LENGTH_SHORT)
						.show();
				return response;
				
			} else {
				Toast.makeText(context, "Unable to complete your request",
						Toast.LENGTH_LONG).show();
			}
		} catch (ClientProtocolException e) {
			Toast.makeText(context, "Caught ClientProtocolException",
					Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(context, "Caught IOException", Toast.LENGTH_SHORT)
					.show();
		} catch (Exception e) {
			Toast.makeText(context, "Caught Exception", Toast.LENGTH_SHORT)
					.show();
		}
		return null;

	}
}
