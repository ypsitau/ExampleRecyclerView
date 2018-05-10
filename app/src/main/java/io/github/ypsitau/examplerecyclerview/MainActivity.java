package io.github.ypsitau.examplerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	static FragmentFactory[] fragmentFactories = new FragmentFactory[] {
		new PageAFragment.Factory(),
		new PageBFragment.Factory(),
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		ViewPager viewPager = findViewById(R.id.viewPager);
		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) { return fragmentFactories[position].create(); }
			@Override
			public int getCount() { return fragmentFactories.length; }
		});
		Util.init(this, (EditText) findViewById(R.id.editText_log));
	}
	public static abstract class FragmentFactory {
		abstract Fragment create();
	}
	public static class PageAFragment extends Fragment {
		public static class Factory extends FragmentFactory {
			@Override
			Fragment create() { return new PageAFragment(); }
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View viewRoot = inflater.inflate(R.layout.fragment_page_a, container, false);
			final RecyclerView recyclerView = viewRoot.findViewById(R.id.recyclerView);
			//recyclerView.setHasFixedSize(true);
			recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
			recyclerView.setAdapter(new NameListAdapter(getResources().getStringArray(R.array.fullNames)));
			return viewRoot;
		}
	};
	public static class PageBFragment extends Fragment {
		public static class Factory extends FragmentFactory {
			@Override
			Fragment create() { return new PageBFragment(); }
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View viewRoot = inflater.inflate(R.layout.fragment_page_b, container, false);
			final RecyclerView recyclerView = viewRoot.findViewById(R.id.recyclerView);
			//recyclerView.setHasFixedSize(true);
			recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(), 2));
			recyclerView.setAdapter(new NameListAdapter(getResources().getStringArray(R.array.fullNames)));
			return viewRoot;
		}
	};
}
