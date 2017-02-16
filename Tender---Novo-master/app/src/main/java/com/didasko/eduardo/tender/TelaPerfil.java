package com.didasko.eduardo.tender;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;
import org.json.JSONObject;

import java.net.MalformedURLException;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.didasko.eduardo.tender.R.id.profile_pic;


public class TelaPerfil extends AppCompatActivity {


    Button btnSair;
    ImageView adReceita;
    ImageView verMreceitas;
    ImageView android;


    ImageView user_picture;

    JSONObject response, profile_pic_data, profile_pic_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.tela_perfil );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        FacebookSdk.sdkInitialize( getApplicationContext() );

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/{user-id}/picture",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {

                        user_picture = (CircleImageView) findViewById(profile_pic);


                    }
                }
        ).executeAsync();

        final Intent intent = getIntent();
        String jsondata = intent.getStringExtra( "jsondata" );

        setUserProfile( jsondata );


        TextView user_name = (TextView) findViewById( R.id.nome );
        user_name.setText( Prefs.getNome( this ) );


        btnSair = (Button) findViewById( R.id.btnSair );
        btnSair.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent( TelaPerfil.this, MainActivity.class );
                startActivity( intent1 );
                finish();
            }
        } );

        adReceita = (ImageView) findViewById( R.id.adReceita );
        adReceita.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent( TelaPerfil.this, NovaReceita.class );
                startActivity( intent1 );
                finish();
            }
        } );

        verMreceitas = (ImageView) findViewById( R.id.verMreceitas );
        verMreceitas.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent( TelaPerfil.this, MinhasReceitas.class );
                startActivity( intent1 );
                finish();
            }
        } );




    }

    public void setUserProfile(String jsondata) {

        try {
            response = new JSONObject( jsondata );
            profile_pic_data = new JSONObject( response.get( "picture" ).toString() );
            profile_pic_url = new JSONObject( profile_pic_data.getString( "data" ) );

            Picasso.with( this ).load( profile_pic_url.getString( "url" ) )
                    .into( user_picture );
        } catch (Exception e) {
            e.printStackTrace();
        }
        user_picture = (ImageView) findViewById( profile_pic );
    }


}








