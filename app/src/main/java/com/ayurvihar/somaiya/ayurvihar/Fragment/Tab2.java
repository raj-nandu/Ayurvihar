package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Immunization_Core;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_OnePlace;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskIM;
import com.ayurvihar.somaiya.ayurvihar.R;

/**
 * Created by ABC on 23-Apr-17.
 */

public class Tab2 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.tab2_immunization,container,false);
        final EditText et1=(EditText)view.findViewById(R.id.i1);
        final EditText et2=(EditText)view.findViewById(R.id.i2);
        final EditText et3=(EditText)view.findViewById(R.id.i3);
        final EditText et4=(EditText)view.findViewById(R.id.i4);
        final EditText et5=(EditText)view.findViewById(R.id.i5);
        final EditText et6=(EditText)view.findViewById(R.id.i6);
        final EditText et7=(EditText)view.findViewById(R.id.i7);
        final EditText et8=(EditText)view.findViewById(R.id.i8);
        final EditText et9=(EditText)view.findViewById(R.id.i9);
        final EditText et10=(EditText)view.findViewById(R.id.i10);
        final EditText et11=(EditText)view.findViewById(R.id.i11);
        final EditText et12=(EditText)view.findViewById(R.id.i12);
        final EditText et13=(EditText)view.findViewById(R.id.i13);
        final EditText et14=(EditText)view.findViewById(R.id.i14);
        final EditText et15=(EditText)view.findViewById(R.id.i15);
        final EditText et16=(EditText)view.findViewById(R.id.i16);
        final EditText et17=(EditText)view.findViewById(R.id.i17);
        final EditText et18=(EditText)view.findViewById(R.id.i18);
        final EditText et19=(EditText)view.findViewById(R.id.i19);
        final EditText et20=(EditText)view.findViewById(R.id.i20);
        final EditText et21=(EditText)view.findViewById(R.id.i21);
        final EditText et22=(EditText)view.findViewById(R.id.i22);
        final EditText et23=(EditText)view.findViewById(R.id.i23);
        final EditText et24=(EditText)view.findViewById(R.id.i24);
        final EditText et25=(EditText)view.findViewById(R.id.i25);
        final EditText et26=(EditText)view.findViewById(R.id.i26);
        final EditText et27=(EditText)view.findViewById(R.id.i27);
        final EditText et28=(EditText)view.findViewById(R.id.i28);
        final EditText et29=(EditText)view.findViewById(R.id.i29);
        final EditText et30=(EditText)view.findViewById(R.id.i30);
        final EditText et31=(EditText)view.findViewById(R.id.i31);
        final EditText et32=(EditText)view.findViewById(R.id.i32);
        final EditText et33=(EditText)view.findViewById(R.id.i33);
        final EditText et34=(EditText)view.findViewById(R.id.i34);
        final EditText et35=(EditText)view.findViewById(R.id.i35);
        final EditText et36=(EditText)view.findViewById(R.id.i36);
        final EditText et37=(EditText)view.findViewById(R.id.i37);
        final EditText et38=(EditText)view.findViewById(R.id.i38);
        final EditText et39=(EditText)view.findViewById(R.id.i39);
        final EditText et40=(EditText)view.findViewById(R.id.i40);

        et1.setText(Under5_Immunization_Core.childidentifier);
        et2.setText(Under5_Immunization_Core.familyidentifier);
        et3.setText(Under5_Immunization_Core.bcg);
        et4.setText(Under5_Immunization_Core.bcg_given);
        et5.setText(Under5_Immunization_Core.opv_0);
        et6.setText(Under5_Immunization_Core.opv_0_given);
        et7.setText(Under5_Immunization_Core.hbv_0);
        et8.setText(Under5_Immunization_Core.hbv_0_given);
        et9.setText(Under5_Immunization_Core.dpt_opv_1);
        et10.setText(Under5_Immunization_Core.dpt_opv_1_given);
        et11.setText(Under5_Immunization_Core.dpt_opv_2);
        et12.setText(Under5_Immunization_Core.dpt_opv_2_given);
        et13.setText(Under5_Immunization_Core.dpt_opv_3);
        et14.setText(Under5_Immunization_Core.dpt_opv_3_given);
        et15.setText(Under5_Immunization_Core.hbv_1);
        et16.setText(Under5_Immunization_Core.hbv_1_given);
        et17.setText(Under5_Immunization_Core.hbv_2);
        et18.setText(Under5_Immunization_Core.hbv_2_given);
        et19.setText(Under5_Immunization_Core.hbv_3);
        et20.setText(Under5_Immunization_Core.hbv_3_given);
        et21.setText(Under5_Immunization_Core.measles_vita_1);
        et22.setText(Under5_Immunization_Core.measles_vita_1_given);
        et23.setText(Under5_Immunization_Core.mmr);
        et24.setText(Under5_Immunization_Core.mmr_given);
        et25.setText(Under5_Immunization_Core.dpt_opv_booster1_vita_2);
        et26.setText(Under5_Immunization_Core.dpt_opv_booster1_vita_2_given);
        et27.setText(Under5_Immunization_Core.vita_3);
        et28.setText(Under5_Immunization_Core.vita_3_given);
        et29.setText(Under5_Immunization_Core.vita_4);
        et30.setText(Under5_Immunization_Core.vita_4_given);
        et31.setText(Under5_Immunization_Core.vita_5);
        et32.setText(Under5_Immunization_Core.vita_5_given);
        et33.setText(Under5_Immunization_Core.vita_6);
        et34.setText(Under5_Immunization_Core.vita_6_given);
        et35.setText(Under5_Immunization_Core.vita_7);
        et36.setText(Under5_Immunization_Core.vita_7_given);
        et37.setText(Under5_Immunization_Core.vita_8);
        et38.setText(Under5_Immunization_Core.vita_8_given);
        et39.setText(Under5_Immunization_Core.dpt_booster2_vita_9);
        et40.setText(Under5_Immunization_Core.dpt_booster2_vita_9_given);

        Button button = (Button) view.findViewById(R.id.updateim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskIM backgroundTaskIM = new BackgroundTaskIM(Under5_Scroll_View.ctx , Under5_Scroll_View.dialog , Under5_Scroll_View.SV);
                backgroundTaskIM.execute("Update",
                        et1.getText().toString(),
                        et2.getText().toString(),
                        et3.getText().toString(),
                        et4.getText().toString(),
                        et5.getText().toString(),
                        et6.getText().toString(),
                        et7.getText().toString(),
                        et8.getText().toString(),
                        et9.getText().toString(),
                        et10.getText().toString(),
                        et11.getText().toString(),
                        et12.getText().toString(),
                        et13.getText().toString(),
                        et14.getText().toString(),
                        et15.getText().toString(),
                        et16.getText().toString(),
                        et17.getText().toString(),
                        et18.getText().toString(),
                        et19.getText().toString(),
                        et20.getText().toString(),
                        et21.getText().toString(),
                        et22.getText().toString(),
                        et23.getText().toString(),
                        et24.getText().toString(),
                        et25.getText().toString(),
                        et26.getText().toString(),
                        et27.getText().toString(),
                        et28.getText().toString(),
                        et29.getText().toString(),
                        et30.getText().toString(),
                        et31.getText().toString(),
                        et32.getText().toString(),
                        et33.getText().toString(),
                        et34.getText().toString(),
                        et35.getText().toString(),
                        et36.getText().toString(),
                        et37.getText().toString(),
                        et38.getText().toString(),
                        et39.getText().toString(),
                        et40.getText().toString() );
            }
        });
        return view;
    }

}
