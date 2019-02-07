package com.example.felipe.appgreen.Activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


import com.example.felipe.appgreen.Bluetooth.ListaDispositivosBluetooth;
import com.example.felipe.appgreen.Bluetooth.MenuBluetooth;
import com.example.felipe.appgreen.R;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class Controle_manual_bico_activity extends AppCompatActivity {

    Switch bico1, bico2, bico3, bico4, bico5, bico6, bico7;
    Button bt_conected_bicoabico_manaual;

//    String switchOn = "Switch is ON";
//    String switchOff = "Switch is OFF";

    //Variaveis para Buetooth
    /*Bluetooth*/
    BluetoothAdapter meuBluetoothAdapter = null;
    private static String MAC = null;
    BluetoothDevice meuDevice = null;
    BluetoothSocket meuSocket = null;
    UUID UUID_SERIAL_PORT = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    ConnectedThread connectedThread;

    /*Variaveis de controle*/
    private static final int SOLICITA_ATIVACAO_BT = 10;
    private static final int SOLICITA_CONEXAO_BT = 20;
    private static final int MENSAGEM_RECEBIDA_BT = 30;
    boolean conectado = false;
//    android.os.Handler meuHandler;
//    StringBuilder dadosBluetooth = new StringBuilder();
    char [] enviar = new char[]{'a','b','c','d','e','f','g'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle_manual_bico_activity);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        /*Pega o adaptador bluetooth do aparelho*/
        meuBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        bico1 = (Switch) findViewById(R.id.switch1);
        bico2 = (Switch) findViewById(R.id.switch2);
        bico3 = (Switch) findViewById(R.id.switch3);
        bico4 = (Switch) findViewById(R.id.switch4);
        bico5 = (Switch) findViewById(R.id.switch5);
        bico6 = (Switch) findViewById(R.id.switch6);
        bico7 = (Switch) findViewById(R.id.switch7);


        bt_conected_bicoabico_manaual = (Button) findViewById(R.id.bt_bluetooth_manual);
        bt_conected_bicoabico_manaual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Controle_manual_bico_activity.this, ListaDispositivosBluetooth.class);
                startActivityForResult(intent, SOLICITA_CONEXAO_BT);
            }
        });

        bico1.setChecked(true);
        bico1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                String s = String.valueOf(enviar);
                if (isChecked) {
                    bico1.setText("On");
                    Log.d("switch", "Checked 1");
                    enviar[0]='A';
                } else {
                    bico1.setText("Off");
                    Log.d("switch", "Not Checked 1");
                    enviar[0]='a';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bico2.setChecked(true);
        bico2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bico2.setText("On");
                    Log.d("switch", "Checked 2");
                    enviar[1]='B';
                } else {
                    bico2.setText("Off");
                    Log.d("switch", "Not Checked 2");
                    enviar[1]='b';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bico3.setChecked(true);
        bico3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bico3.setText("On");
                    Log.d("switch", "Checked 3");
                    enviar[2]='C';
                } else {
                    bico3.setText("Off");
                    Log.d("switch", "Not Checked 3");
                    enviar[2]='c';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bico4.setChecked(true);
        bico4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bico4.setText("On");
                    Log.d("switch", "Checked 4");
                    enviar[3]='D';
                } else {
                    bico4.setText("Off");
                    Log.d("switch", "Not Checked 4");
                    enviar[3]='d';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bico5.setChecked(true);
        bico5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bico5.setText("On");
                    Log.d("switch", "Checked 5");
                    enviar[4]='E';
                } else {
                    bico5.setText("Off");
                    Log.d("switch", "Not Checked 5");
                    enviar[4]='e';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bico6.setChecked(true);
        bico6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bico6.setText("On");
                    Log.d("switch", "Checked 6");
                    enviar[5]='F';
                } else {
                    bico6.setText("Off");
                    Log.d("switch", "Not Checked 6");
                    enviar[5]='f';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bico7.setChecked(true);
        bico7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bico7.setText("On");
                    Log.d("switch", "Checked 7");
                    enviar[6]='G';
                } else {
                    bico7.setText("Off");
                    Log.d("switch", "Not Checked 7");
                    enviar[6]='g';
                }
                String s = String.valueOf(enviar);
                /*Verifica se esta conectado */
                if(conectado){
                    connectedThread.enviar(s);
                }else{
                    Toast.makeText(getApplicationContext(),"Bluetooth não está conectado!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater(); // exibir menu na tela
//        inflater.inflate(R.menu.menu_bt, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.bt_conect2){
            Intent abreListaDispositivos = new Intent(Controle_manual_bico_activity.this, ListaDispositivosBluetooth.class);
            startActivityForResult(abreListaDispositivos, SOLICITA_CONEXAO_BT);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(getApplicationContext(), "FUNCIONANDO !", Toast.LENGTH_SHORT).show();
        if(resultCode==RESULT_OK){
            Toast.makeText(getApplicationContext(), "PRIMEIRO!", Toast.LENGTH_SHORT).show();
            if(requestCode==SOLICITA_CONEXAO_BT){
                Toast.makeText(getApplicationContext(), "TESTE !", Toast.LENGTH_SHORT).show();
                /* Caso tenha recebido o endereco MAC para realizar a conexao */
                /* Salva o MAC retornado */
//                    MAC = data.getExtras().getString(ListaDispositivosBluetooth.ENDERECO_MAC);
                MAC = data.getExtras().getString(ListaDispositivosBluetooth.ENDERECO_MAC);
                /* Cria um dispositivo com o endereco retornado */
                meuDevice = meuBluetoothAdapter.getRemoteDevice(MAC);

                /* Tenta criar um socket para comunicacao */
                try{
                    /* Cria um socket utilizando o dispositivo externo passando o UUID desejado (SERIAL) */
                    meuSocket = meuDevice.createRfcommSocketToServiceRecord(UUID_SERIAL_PORT);

                    /* Tenta estabilizar a conexao */
                    meuSocket.connect();
                    conectado = true;
//                        btnConectar.setText("DESCONECTAR");

                    /*Cria uma thread */
                    connectedThread = new ConnectedThread(meuSocket);
                    connectedThread.start();

                    Toast.makeText(getApplicationContext(), "Conectado !", Toast.LENGTH_SHORT).show();

                } catch (IOException erro) {
                    /* Caso ocorra algum problema durante a conexao */
                    conectado = false;
                    Toast.makeText(getApplicationContext(), "Ocorreu um erro ao tentar conectar"+"\n"+"ERRO :"+erro,Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            meuSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        /* Call this from the main activity to send data to the remote device */
        public void enviar (String dado) {
            byte[] msgBuffer = dado.getBytes();
            try {
                mmOutStream.write(msgBuffer);
            } catch (IOException e) { }
        }

    }
}