package io.github.ypsitau.examplerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sub1Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.activity_main);
		final RecyclerView recyclerView = findViewById(R.id.recyclerView);
		//recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
		recyclerView.setAdapter(new NameListAdapter(getResources().getStringArray(R.array.fullNames)));
		/*
		final Button button_prevActivity = findViewById(R.id.button_prevActivity);
		final Context contextCur = this;
		button_prevActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Util.Printf("check\n");
				Intent intent = new Intent(contextCur, MainActivity.class);
				startActivity(intent);
			}
		});
		*/
		Util.init(this, (EditText)findViewById(R.id.editText_log));
	}
}
