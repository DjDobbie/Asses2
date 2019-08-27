package com.example.ass2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_data);

        //get data from intent named "intent"
        Intent intent = getIntent();
        //declare Strings and place data within variable names
        String message_name = intent.getStringExtra(MainActivity.MESSAGE_Name);
        String message_post = intent.getStringExtra(MainActivity.MESSAGE_Post);

        //Initiate TextViews declare and reference
        TextView NameT = findViewById(R.id.NameT);
        TextView PostT = findViewById(R.id.PostT);
        TextView LiveT = findViewById(R.id.LiveT);

        //set the text of TextViews to String Values: message_name & message_post
        NameT.setText(message_name);
        PostT.setText(message_post);

        //Parsing and removing text view hidden line breaks
        String post = PostT.getText().toString();
        post = post.replace( "\n", "" );
        post = post.replace( " ", "" );
        int total = getValue( post );

        //IF Statement PostCode Check
        if(total < 3999 && total > 3000){
            LiveT.setText(message_name +" Lives within VICTORIA");
        }else{
            LiveT.setText(message_name +" does not Live within VICTORIA");
        }

        }

    //Return this page back to home
    public void returnHome(View v){
        //Intent: return this page to mainActivity class
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Get Value Method - for extracting value from TextView
    private int getValue( String line ) {
        int value = 0;

        if( line.contains( "+" ) ) {
            String[] lines = line.split( "\\+" );
            value += getValue( lines[0] );

            for( int i = 1; i < lines.length; i++ )
                value += getValue( lines[i] );

            return value;
        }

        if( line.contains( "-" ) ) {
            String[] lines = line.split( "\\-" );
            value += getValue( lines[0] );

            for( int i = 1; i < lines.length; i++ )
                value -= getValue( lines[i] );

            return value;
        }

        if( line.contains( "*" ) ) {
            String[] lines = line.split( "\\*" );
            value += getValue( lines[0] );

            for( int i = 1; i < lines.length; i++ )
                value *= getValue( lines[i] );

            return value;
        }

        if( line.contains( "/" ) ) {
            String[] lines = line.split( "\\/" );
            value += getValue( lines[0] );

            for( int i = 1; i < lines.length; i++ )
                value /= getValue( lines[i] );

            return value;
        }

        return Integer.parseInt( line );
    }





}
