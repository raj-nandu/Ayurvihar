package com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Add_Child_Record;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Immunization_Core;

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

public class BackgroundTaskIM extends AsyncTask <String,Void,String> {

    Context ctx;
    TaskCompleteCR t;
    private final ProgressDialog dialog ;
    static String method;

    public BackgroundTaskIM(Context ctx , ProgressDialog dialog , TaskCompleteCR t )
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
        String Create = "https://vitelline-mothers.000webhostapp.com/immunization_create.php";
        String Update = "https://vitelline-mothers.000webhostapp.com/immunization_update.php";
        String Select = "https://vitelline-mothers.000webhostapp.com/immunization_select.php";
        method = params[0];
        Log.v("im","url");
        if (method.equals("Create") || method.equals("Update")) {

            Log.v("incri","ien");
            try {
                Log.i("incri","ien");
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

                Log.i("Come","Here");
                String data =
                        URLEncoder.encode("childidentifier", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                                URLEncoder.encode("familyidentifier", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8") + "&" +
                                URLEncoder.encode("bcg", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8") + "&" +
                                URLEncoder.encode("bcg_given", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8") + "&" +
                                URLEncoder.encode("opv_0", "UTF-8") + "=" + URLEncoder.encode(params[5], "UTF-8") + "&" +
                                URLEncoder.encode("opv_0_given", "UTF-8") + "=" + URLEncoder.encode(params[6], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_0", "UTF-8") + "=" + URLEncoder.encode(params[7], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_0_given", "UTF-8") + "=" + URLEncoder.encode(params[8], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_1", "UTF-8") + "=" + URLEncoder.encode(params[9], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_1_given", "UTF-8") + "=" + URLEncoder.encode(params[10], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_2", "UTF-8") + "=" + URLEncoder.encode(params[11], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_2_given", "UTF-8") + "=" + URLEncoder.encode(params[12], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_3", "UTF-8") + "=" + URLEncoder.encode(params[13], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_3_givend", "UTF-8") + "=" + URLEncoder.encode(params[14], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_1", "UTF-8") + "=" + URLEncoder.encode(params[15], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_1_given", "UTF-8") + "=" + URLEncoder.encode(params[16], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_2", "UTF-8") + "=" + URLEncoder.encode(params[17], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_2_given", "UTF-8") + "=" + URLEncoder.encode(params[18], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_3", "UTF-8") + "=" + URLEncoder.encode(params[19], "UTF-8") + "&" +
                                URLEncoder.encode("hbv_3_given", "UTF-8") + "=" + URLEncoder.encode(params[20], "UTF-8") + "&" +
                                URLEncoder.encode("measles_vita_1", "UTF-8") + "=" + URLEncoder.encode(params[21], "UTF-8") + "&" +
                                URLEncoder.encode("measles_vita_1_given", "UTF-8") + "=" + URLEncoder.encode(params[22], "UTF-8") + "&" +
                                URLEncoder.encode("mmr", "UTF-8") + "=" + URLEncoder.encode(params[23], "UTF-8") + "&" +
                                URLEncoder.encode("mmr_given", "UTF-8") + "=" + URLEncoder.encode(params[24], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_booster1_vita_2", "UTF-8") + "=" + URLEncoder.encode(params[25], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_opv_booster1_vita_2_given", "UTF-8") + "=" + URLEncoder.encode(params[26], "UTF-8") + "&" +
                                URLEncoder.encode("vita_3", "UTF-8") + "=" + URLEncoder.encode(params[27], "UTF-8") + "&" +
                                URLEncoder.encode("vita_3_given", "UTF-8") + "=" + URLEncoder.encode(params[28], "UTF-8") + "&" +
                                URLEncoder.encode("vita_4", "UTF-8") + "=" + URLEncoder.encode(params[29], "UTF-8") + "&" +
                                URLEncoder.encode("vita_4_given", "UTF-8") + "=" + URLEncoder.encode(params[30], "UTF-8") + "&" +
                                URLEncoder.encode("vita_5", "UTF-8") + "=" + URLEncoder.encode(params[31], "UTF-8") + "&" +
                                URLEncoder.encode("vita_5_given", "UTF-8") + "=" + URLEncoder.encode(params[32], "UTF-8") + "&" +
                                URLEncoder.encode("vita_6", "UTF-8") + "=" + URLEncoder.encode(params[33], "UTF-8") + "&" +
                                URLEncoder.encode("vita_6_given", "UTF-8") + "=" + URLEncoder.encode(params[34], "UTF-8") + "&" +
                                URLEncoder.encode("vita_7", "UTF-8") + "=" + URLEncoder.encode(params[35], "UTF-8") + "&" +
                                URLEncoder.encode("vita_7_given", "UTF-8") + "=" + URLEncoder.encode(params[36], "UTF-8") + "&" +
                                URLEncoder.encode("vita_8", "UTF-8") + "=" + URLEncoder.encode(params[37], "UTF-8") + "&" +
                                URLEncoder.encode("vita_8_given", "UTF-8") + "=" + URLEncoder.encode(params[38], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_booster2_vita_9", "UTF-8") + "=" + URLEncoder.encode(params[39], "UTF-8") + "&" +
                                URLEncoder.encode("dpt_booster2_vita_9_given", "UTF-8") + "=" + URLEncoder.encode(params[40], "UTF-8");
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
                Log.i("Info","malformed");
                e.printStackTrace();
            } catch (IOException e) {
                Log.i("info" , "ioexcepion");
                e.printStackTrace();
            }
        }

        else if(method.equals("Select") )
        {
            try {
                Log.v("IM","select");
                URL url = new URL(Select);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                Log.v("IM","1");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("childidentifier", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                        URLEncoder.encode("familyidentifier", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
                bufferedWriter.write(data);
                Log.v("Info",data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                Log.v("Info",data);
                InputStream inputStream = httpURLConnection.getInputStream();
                Log.v("Info",data);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                Log.v("Info",data);
                String response = "";
                String line  = "";
                Log.v("Content1",response);
                while ((line = bufferedReader.readLine())!=null)
                {
                    Log.v("Info",data);
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.v("Content" , response);
                String R[] = response.split(",");
                Under5_Immunization_Core.childidentifier = R[0];
                Under5_Immunization_Core.familyidentifier = R[1];
                Under5_Immunization_Core.bcg=R[2];
                Under5_Immunization_Core.bcg_given=R[3];
                Under5_Immunization_Core.opv_0=R[4];
                Under5_Immunization_Core.opv_0_given=R[5];
                Under5_Immunization_Core.hbv_0=R[6];
                Under5_Immunization_Core.hbv_0_given=R[7];
                Under5_Immunization_Core.dpt_opv_1=R[8];
                Under5_Immunization_Core.dpt_opv_1_given=R[9];
                Under5_Immunization_Core.dpt_opv_2=R[10];
                Under5_Immunization_Core.dpt_opv_2_given=R[11];
                Under5_Immunization_Core.dpt_opv_3=R[12];
                Under5_Immunization_Core.dpt_opv_3_given=R[13];
                Under5_Immunization_Core.hbv_1=R[14];
                Under5_Immunization_Core.hbv_1_given=R[15];
                Under5_Immunization_Core.hbv_2=R[16];
                Under5_Immunization_Core.hbv_2_given=R[17];
                Under5_Immunization_Core.hbv_3=R[18];
                Under5_Immunization_Core.hbv_3_given=R[19];
                Under5_Immunization_Core.measles_vita_1=R[20];
                Under5_Immunization_Core.measles_vita_1_given=R[21];
                Under5_Immunization_Core.mmr=R[22];
                Under5_Immunization_Core.mmr_given=R[23];
                Under5_Immunization_Core.dpt_opv_booster1_vita_2=R[24];
                Under5_Immunization_Core.dpt_opv_booster1_vita_2_given=R[25];
                Under5_Immunization_Core.vita_3=R[26];
                Under5_Immunization_Core.vita_3_given=R[27];
                Under5_Immunization_Core.vita_4=R[28];
                Under5_Immunization_Core.vita_4_given=R[29];
                Under5_Immunization_Core.vita_5=R[30];
                Under5_Immunization_Core.vita_5_given=R[31];
                Under5_Immunization_Core.vita_6=R[32];
                Under5_Immunization_Core.vita_6_given=R[33];
                Under5_Immunization_Core.vita_7=R[34];
                Under5_Immunization_Core.vita_7_given=R[35];
                Under5_Immunization_Core.vita_8=R[36];
                Under5_Immunization_Core.vita_8_given=R[37];
                Under5_Immunization_Core.dpt_booster2_vita_9=R[38];
                Under5_Immunization_Core.dpt_booster2_vita_9_given=R[39];
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
        if(!Under5_Add_Child_Record.Test)
        {
            switch (method)
            {
                case "Create" : t.TaskCreate();
                    break;
                case "Update" : t.TaskUpdate();
                    break;
                case "Select" : t.TaskRecords();
                    break;
            }
        }
        Under5_Add_Child_Record.Test = false;
        dialog.dismiss();
    }
}
