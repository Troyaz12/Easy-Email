package com.example.android.newemailappmom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String eMail=null;
    private MediaPlayer intro;
    private MediaPlayer selected;
    private MediaPlayer unselect;
    private SoundPool soundPool;
    private boolean loaded=false;
    private int soundID;
    private float volume;
    private boolean soundOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout)).setTitle("Easy Email!");
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
                return new ViewHolder(getLayoutInflater().inflate(R.layout.content_main, parent, false));
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, int position) {
                viewHolder.contact1.setBackgroundResource(R.drawable.custombuttontroy);
                viewHolder.contact2.setBackgroundResource(R.drawable.custombuttoncory);
                viewHolder.contact3.setBackgroundResource(R.drawable.custombuttonmarc);
                viewHolder.contact4.setBackgroundResource(R.drawable.custombuttonpiche);
                viewHolder.contact5.setBackgroundResource(R.drawable.custombuttonbrennen);
                viewHolder.contact6.setBackgroundResource(R.drawable.custombuttonadrian);
                viewHolder.contact7.setBackgroundResource(R.drawable.custombuttondad);
            }

            @Override
            public int getItemCount() {
                return 1;
            }
        });


        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
// Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });

        soundID = soundPool.load(this, R.raw.unselect, 1);



  //      CheckBox contact2 = (CheckBox) findViewById(R.id.contact2);
  //      CheckBox contact3 = (CheckBox) findViewById(R.id.contact3);
  //      CheckBox contact4 = (CheckBox) findViewById(R.id.contact4);
    //    CheckBox contact5 = (CheckBox) findViewById(R.id.contact5);
      //  CheckBox contact6 = (CheckBox) findViewById(R.id.contact6);
     //   CheckBox contact7 = (CheckBox) findViewById(R.id.contact7);

/*
        //set click listeners for checkboxes
        contact1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff
                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }
        });

        contact2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff
                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });
        contact3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff
                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });

        contact4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff

                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });
        contact5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff

                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });
        contact6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff

                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });

        contact7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff

                if (loaded&&soundOn==true) {
                    soundPool.play(soundID, 5, 5, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });
        */
    }

    protected void onStart(){
        super.onStart();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        soundOn = prefs.getBoolean(getString(R.string.sound_key), false);

        selected = MediaPlayer.create(this, R.raw.allright);
        intro = MediaPlayer.create(this, R.raw.guitarintro);
        unselect = MediaPlayer.create(this, R.raw.unselect);


        if(soundOn==true)
            intro.start();
    }
    private static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        TextView text2;
        CheckBox contact1;
        CheckBox contact2;
        CheckBox contact3;
        CheckBox contact4;
        CheckBox contact5;
        CheckBox contact6;
        CheckBox contact7;



        public ViewHolder(View itemView) {
            super(itemView);
            // get checkbox
            contact1 = (CheckBox) itemView.findViewById(R.id.contact1);
            contact2 = (CheckBox) itemView.findViewById(R.id.contact2);
            contact3 = (CheckBox) itemView.findViewById(R.id.contact3);
            contact4 = (CheckBox) itemView.findViewById(R.id.contact4);
            contact5 = (CheckBox) itemView.findViewById(R.id.contact5);
            contact6 = (CheckBox) itemView.findViewById(R.id.contact6);
            contact7 = (CheckBox) itemView.findViewById(R.id.contact7);


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setClass(this,SettingsActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void openEmail(View myView){
        if(soundOn==true)
            selected.start();

        Intent intent = new Intent();       //creates an intent to open the users gmail account
        intent.setClass(this,openEmailProgram.class);
        startActivity(intent);
    }
    public void exitApp(View myView){
        this.finish();
        System.exit(0);
    }
    public void email(View myView){
        eMail="";

        if(soundOn==true)
            selected.start();

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.contact1);
    //    CheckBox checkBox2 = (CheckBox) findViewById(R.id.contact2);
  //      CheckBox checkBox3 = (CheckBox) findViewById(R.id.contact3);
  //      CheckBox checkBox4 = (CheckBox) findViewById(R.id.contact4);
  //      CheckBox checkBox5 = (CheckBox) findViewById(R.id.contact5);
 //       CheckBox checkBox6 = (CheckBox) findViewById(R.id.contact6);
 //       CheckBox checkBox7 = (CheckBox) findViewById(R.id.contact7);

        if(checkBox1.isChecked()==true){
            eMail = "example@gmail.com; ";
        }
/*
        if(checkBox2.isChecked()==true){
            eMail = eMail+"example2@gmail.com; ";
        }
        if(checkBox3.isChecked()==true){
            eMail = eMail+"example3@gmail.com; ";
        }
        if(checkBox4.isChecked()==true){
            eMail = eMail+"example4@gmail.com; ";
        }
        if(checkBox5.isChecked()==true){
            eMail = eMail+"example5@gmail.com; ";
        }
        if(checkBox6.isChecked()==true){
            eMail = eMail+"example6@gmail.com; ";
        }
        if(checkBox7.isChecked()==true){
            eMail = eMail+"example7@gmail.com; ";
        }
*/
        Intent i = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", eMail, null)
        );
        i.putExtra(Intent.EXTRA_SUBJECT, "Hi from Mom/Nana.");  //add subject line to email
        startActivity(i);
    }
}
