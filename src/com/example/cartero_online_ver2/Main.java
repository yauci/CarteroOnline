package com.example.cartero_online_ver2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {
	
	Button buttonSend;
	EditText textTo;
	EditText textSubject;
	EditText textMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		buttonSend = (Button) findViewById(R.id.button1);
		textTo = (EditText) findViewById(R.id.etEmail);
		textSubject = (EditText) findViewById(R.id.etSubject);
		textMessage = (EditText) findViewById(R.id.etBody);
 
		buttonSend.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
			  String to = textTo.getText().toString();
			  String subject = textSubject.getText().toString();
			  String message = textMessage.getText().toString();
 
			  Intent email = new Intent(Intent.ACTION_SEND);
			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
			  email.putExtra(Intent.EXTRA_SUBJECT, subject);
			  email.putExtra(Intent.EXTRA_TEXT, message);
 

			  email.setType("message/rfc822");
 
			  startActivity(Intent.createChooser(email, "De que forma quiere enviarlo :"));
 
			}
		});
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
