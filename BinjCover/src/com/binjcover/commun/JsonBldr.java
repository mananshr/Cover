package com.binjcover.commun;

import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonBldr {

	/**
	 * 
	 */
	public JsonBldr(Object object) {
		JSONObject jsonobj;
		jsonobj = new JSONObject();
		try {
			// adding some keys
			jsonobj.put("key", "value");
			jsonobj.put("weburl", "URL");

			JSONObject header = new JSONObject();
			header.put("devicemodel", android.os.Build.MODEL); // Device model
			header.put("deviceVersion", android.os.Build.VERSION.RELEASE); // Device os version
																			
			header.put("language", Locale.getDefault().getISO3Language()); // Language
			jsonobj.put("header", header);
			// Display the contents of the JSON objects
			Log.v("JSON", jsonobj.toString());
		} catch (JSONException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public JsonBldr() {
		super();
		// TODO Auto-generated constructor stub
	}

}
