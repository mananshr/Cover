package com.binjcover.commun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

public class JsonRcvUtil {

	public JsonRcvUtil() {
		// TODO Auto-generated constructor stub
	}

	public JSONObject recJson(HttpResponse httpresponse, Context context) {

		HttpEntity resultentity = httpresponse.getEntity();
		InputStream inputstream;
		try {
			inputstream = resultentity.getContent();

			Header contentencoding = httpresponse
					.getFirstHeader("Content-Encoding");
			if (contentencoding != null
					&& contentencoding.getValue().equalsIgnoreCase("gzip")) {
				inputstream = new GZIPInputStream(inputstream);
			}
			String resultstring = convertStreamToString(inputstream, context);
			inputstream.close();
			resultstring = resultstring.substring(1, resultstring.length() - 1);
			JSONObject recvdjson = new JSONObject(resultstring);

			return recvdjson;

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String convertStreamToString(InputStream is, Context context) {
		String line = "";
		StringBuilder total = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		try {
			while ((line = rd.readLine()) != null) {
				total.append(line);
			}
		} catch (Exception e) {
			Toast.makeText(context, "Stream Exception", Toast.LENGTH_SHORT)
					.show();
		}
		return total.toString();
	}

}
