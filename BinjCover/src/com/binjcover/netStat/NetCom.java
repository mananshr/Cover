package com.binjcover.netStat;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

import com.binjcover.test.R;

public class NetCom extends AsyncTask<Void, Void, Object> {

	public NetCom() {
		// TODO Auto-generated constructor stub
		super();
	}

	public NetCom(Activity activity) {
		// TODO Auto-generated constructor stub

		super();
		this.activity = activity;
	}

	ProgressDialog progressDialog;
	Activity activity;
	String error;

	protected String getString(int id) {
		return this.activity.getResources().getString(id);
	}

	@Override
	protected void onPreExecute() {
		progressDialog = ProgressDialog.show(this.activity, "",
				getString(R.string.loading), true, false);
	}

	@Override
    protected void onPostExecute(Object dvo) {
        if (dvo != null) {
            // Do something useful with dvo here
             
            // Dismiss the progress dialog when done
            progressDialog.dismiss();
        } else {
            // Dismiss the progress dialog
            progressDialog.dismiss();
             
            // Display a simple error dialog to the user
            new AlertDialog.Builder(this.activity)
                .setMessage(this.error)
                .setNeutralButton(
                    getString(R.string.ok),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    }
                ).create().show();
        }
	}

	@Override
	protected Object doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		DataMod dataModel = new DataMod();
        Object dvo = null;
        try {
            dvo = dataModel.getData();
        } catch (IOException e) {
            this.error = getString(R.string.error); // or e.getMessage() when debugging
        }
        return dvo;
	}

}
