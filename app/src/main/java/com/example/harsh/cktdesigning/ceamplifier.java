package com.example.harsh.cktdesigning;

import android.content.Intent;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.spec.RC2ParameterSpec;

public class ceamplifier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceamplifier);

        Button Submit = (Button) findViewById(R.id.Submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              submit();
            }
        });


    }

    String conv;
    int i,S=5;
    boolean isRms;
    double[] resistor ={1,1.2,1.5,1.8,2.2,2.7,3.3,3.9,4.2,4.7,5.6,6.8,8.2,9.1,10,12,15,18,22,27,33,39,42,47,56,68,82,91,100,120,150,180,220,270,330,390,420,470,560,680,820,910,1000,1200,1500,1800,2200,2700,3300,3900,4200,4700,5600,6800,8200,9100,10000,12000,15000,18000,22000,27000,33000,39000,42000,47000,56000,68000,82000,91000,100000,120000,150000,180000,220000,270000,330000,390000,420000,470000,560000,680000,820000,910000,1e+06,1.2e+06,1.5e+06,1.8e+06,2.2e+06,2.7e+06,3.3e+06,3.9e+06,4.2e+06,4.7e+06,5.6e+06,6.8e+06,8.2e+06,9.1e+06,1e+07,1.2e+07,1.5e+07,1.8e+07,2.2e+07,2.7e+07,3.3e+07,3.9e+07,4.2e+07,4.7e+07,5.6e+07,6.8e+07,8.2e+07,9.1e+07,1e+08,1.2e+08,1.5e+08,1.8e+08,2.2e+08,2.7e+08,3.3e+08,3.9e+08,4.2e+08,4.7e+08,5.6e+08,6.8e+08,8.2e+08,9.1e+08};
    double temp,VE=5,VCE=1,VCEQ,Vcc,RE,VBE=0.7;
    double Fl,Av,Vo,Beta,ICQ,IBQ,IEQ,RTH,VTH,RB,Ri;
    double hie=2700,hre=0.00015,hoe=0.000018,hfemin=125,hfetyp=220,hfemax=260,hFEmin=115,hFEtyp=180,hFEmax=220;
    double Rl,Rc,R1,R2,C1,C2,CE,Vopeak;



public void submit()
{
    EditText VoltageGain = (EditText) findViewById(R.id.VoltageGainBox);
    conv = VoltageGain.getText().toString();
    Av = Double.valueOf(conv);

    EditText FrequencyLower = (EditText) findViewById(R.id.LowerFrequencyBox);
    conv = FrequencyLower.getText().toString();
    Fl = Double.valueOf(conv);

    EditText VoltageOut = (EditText) findViewById(R.id.OutputVoltageBox);
    conv = VoltageOut.getText().toString();
    Vo = Double.valueOf(conv);

    EditText Betaval = (EditText) findViewById(R.id.BetaValueBox);
    conv = Betaval.getText().toString();
    Beta = Double.valueOf(conv);

    CheckBox Rms=(CheckBox) findViewById(R.id.rmsCheck);
    isRms= Rms.isChecked();

    calculate();
}
public void calculate()
{
     Rc=(Av*hie/hfemin);
    temp=Rc;
    i=0;
     while(Rc==temp)
     {
         if(Rc<resistor[i])
         {
             Rc=resistor[i];
         }
         i++;
     }
//Rc value is calculated.

    if(isRms==true)
    {
        Vo=1.414*Vo;
    }
//Vo is converted from RMS to P-P

 VCEQ=Vo+VCE;
    Vcc=VCEQ*2;
    ICQ=(Vcc-VCEQ-VE)/Rc;
    IBQ=ICQ/hFEtyp;
    IEQ=ICQ+IBQ;
    RE=VE/IEQ;

    RB=(RE+hFEtyp)/(S+(1+hFEtyp)*RE-1-hFEtyp);
    VTH=(IBQ*RB+VBE+VE);
    R1=(RB*Vcc/(VTH));
    R2=(R1*RB)/(R1-RB);
Ri=(hie*RB)/(hie+RB);
C1=10/(2*3.14*Fl*Ri);
C2=10/(2*3.14*Fl*Rc);
CE=10/(2*3.14*Fl*RE);
//Parameters done.

    Intent intent= new Intent(ceamplifier.this,ceampans.class);
    intent.putExtra("R1",Double.toString(R1));
    intent.putExtra("R2",Double.toString(R2));
    intent.putExtra("RC",Double.toString(Rc));
    intent.putExtra("RE",Double.toString(RE));
    intent.putExtra("C1",Double.toString(C1));
    intent.putExtra("C2",Double.toString(C2));
    intent.putExtra("CE",Double.toString(CE));
    intent.putExtra("Vcc",Double.toString(Vcc));
    startActivity(intent);
}
}
