package com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by nikhil on 28-03-2017.
 */

public class BackgroundTaskCR extends AsyncTask <String,Void,String> {

    Context ctx;
    TaskCompleteCR t;
    private final ProgressDialog dialog ;
    static String method;

    public BackgroundTaskCR(Context ctx , ProgressDialog dialog , TaskCompleteCR t )
    {
        this.ctx =ctx; this.dialog = dialog; this.t = t; Test = false;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Making Changes Over Database ....");
        dialog.show();

    }

    @Override
    protected String doInBackground(String... params) {
        String Create = "http://nikhil4969.esy.es/Ayurvihar/child_rec_add.php";
        String Update = "http://nikhil4969.esy.es/Ayurvihar/child_rec_update.php";
        String Select = "http://nikhil4969.esy.es/Ayurvihar/child_rec_display.php";
        method = params[0];
        if (method.equals("Create") | method.equals("Update") ) {

            try {
                URL url;
                if( method.equals("Create") )
                    url = new URL(Create);
                else
                    url = new URL(Update);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data =
                        URLEncoder.encode("childidentifier", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                                URLEncoder.encode("familyidentifier", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8") + "&" +
                                URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8") + "&" +
                                URLEncoder.encode("mobilenumber", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8") + "&" +
                                URLEncoder.encode("childname", "UTF-8") + "=" + URLEncoder.encode(params[5], "UTF-8") + "&" +
                                URLEncoder.encode("fathername", "UTF-8") + "=" + URLEncoder.encode(params[6], "UTF-8") + "&" +
                                URLEncoder.encode("mothername", "UTF-8") + "=" + URLEncoder.encode(params[7], "UTF-8") + "&" +
                                URLEncoder.encode("dob", "UTF-8") + "=" + URLEncoder.encode(params[8], "UTF-8") + "&" +
                                URLEncoder.encode("sex", "UTF-8") + "=" + URLEncoder.encode(params[9], "UTF-8") ;

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "RS";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("Select") )
        {
            try {
                URL url = new URL(Select);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("childidentifier", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                        URLEncoder.encode("familyidentifier", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line  = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                Log.i("Content" , response);
                String R[] = response.split(",");
                Under5_Core.childidentifier = R[0];
                Under5_Core.familyidentifier = R[1];
                Under5_Core.address = R[2];
                Under5_Core.mobilenumber = R[3];
                Under5_Core.childname = R[4];
                Under5_Core.fathername = R[5];
                Under5_Core.mothername = R[6];
                Under5_Core.dob = R[7];
                Under5_Core.sex = R[8];

                return "Update RS";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean Test = false;
    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, "Results Are : " + result, Toast.LENGTH_SHORT).show();
        switch (method)
        {
            case "Create" : t.TaskCreate();
                            break;
            case "Update" : t.TaskUpdate();
                            break;
            case "Select" : t.TaskRecords();
                            break;
        }
        dialog.dismiss();
    }
}
