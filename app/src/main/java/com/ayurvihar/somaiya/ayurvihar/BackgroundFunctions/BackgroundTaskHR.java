package com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Health_Record_Core;

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

import static com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Health_Record_Core.hr;

/**
 * Created by ABC on 22-Apr-17.
 */

public class BackgroundTaskHR extends AsyncTask <String,Void,String> {
    Context ctx;
    TaskCompleteCR t;
    private final ProgressDialog dialog ;
    static String method;

    public BackgroundTaskHR(Context ctx , ProgressDialog dialog , TaskCompleteCR t )
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
    protected String doInBackground(String...params){
        String Create="https://vitelline-mothers.000webhostapp.com/health_rec_add.php";
        String Update="https://vitelline-mothers.000webhostapp.com/health_rec_update.php";
        String Select="https://vitelline-mothers.000webhostapp.com/health_rec_display.php";
        method=params[0];
        if(method.equals("Create")|method.equals("Update"))
        {
            try
            {
                URL url;
                if( method.equals("Create") )
                    url = new URL(Create);
                else
                    url = new URL(Update);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                Log.i("info dwinei" , "jvirbviur");
                String data=
                        URLEncoder.encode("childhealthcheckupnumber", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8") + "&" +
                                URLEncoder.encode("childidentifier", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                                URLEncoder.encode("familyidentifier", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8") + "&" +
                                URLEncoder.encode("checkupdate", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8") + "&" +
                                URLEncoder.encode("height", "UTF-8") + "=" + URLEncoder.encode(params[5], "UTF-8") + "&" +
                                URLEncoder.encode("weight", "UTF-8") + "=" + URLEncoder.encode(params[6], "UTF-8") + "&" +
                                URLEncoder.encode("weightforagestatus", "UTF-8") + "=" + URLEncoder.encode(params[7], "UTF-8") + "&" +
                                URLEncoder.encode("remarks", "UTF-8") + "=" + URLEncoder.encode(params[8], "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                httpURLConnection.disconnect();
                return "RS";
            }
            catch(MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(method.equals("Select"))
        {
            try
            {
                URL url=new URL(Select);
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String response = "";
                String line  = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.v("Contenthr" , response);
                String R[] = response.split(";");
                Log.v("rlen",""+R.length);

                for(int i=0;i<R.length;i++)
                {
                    //Log.v("forhr","hello"+R[i]);
                    if(!R[i].equals(",,,,,,,"))
                    {
                        String temp[]=R[i].split(",");
                        Under5_Health_Record_Core uhr = new Under5_Health_Record_Core();
                        uhr.childhealthcheckupnumber=temp[0];
                        //Log.v("forhr","hello"+R[i]);
                        uhr.childidentifier=temp[1];
                        uhr.familyidentifier=temp[2];
                        uhr.checkupdate=temp[3];
                        uhr.height=temp[4];
                        uhr.weight=temp[5];
                        uhr.weightforagestatus=temp[6];
                        uhr.remarks=temp[7];

                        // Adding object into ArrayList
                        Under5_Health_Record_Core.hr.add(uhr);
                    }
                }
                return "Update RS";
            }
            catch(MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean Test = false;

    @Override
    protected void onPostExecute(String result){
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
