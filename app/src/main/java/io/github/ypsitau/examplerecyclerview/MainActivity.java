package io.github.ypsitau.examplerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		final RecyclerView recyclerView = findViewById(R.id.recyclerView);
		//recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(new NameListAdapter(getResources().getStringArray(R.array.fullNames)));
		final Button button_nextActivity = findViewById(R.id.button_nextActivity);
		final Context contextCur = this;
		button_nextActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Util.Printf("check\n");
				Intent intent = new Intent(contextCur, Sub1Activity.class);
				startActivity(intent);
			}
		});
		Util.init(this, (EditText)findViewById(R.id.editText_log));
	}
}
