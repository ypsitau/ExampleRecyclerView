// The "implementation" statement required to be added in build.grade with "com.android.support:design:27.1.1"
// to use TabLayout view.

package io.github.ypsitau.examplerecyclerview;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

			@Nullable
			@Override
			public CharSequence getPageTitle(int position) {
				return getString(fragmentFactories[position].resIdTitle);
			}
		});
		TabLayout tabLayout = findViewById(R.id.tabLayout);
		tabLayout.setupWithViewPager(viewPager);
		App.setLogEditText((EditText)findViewById(R.id.editText_log), true);
	}
	public static abstract class FragmentFactory {
		public final int resIdTitle;
		public FragmentFactory(int resIdTitle) { this.resIdTitle = resIdTitle; }
		abstract Fragment create();
	}
	public static class PageAFragment extends Fragment {
		public static class Factory extends FragmentFactory {
			Factory() { super(R.string.One_column); }
			@Override
			Fragment create() { return new PageAFragment(); }
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View viewRoot = inflater.inflate(R.layout.fragment_page, container, false);
			final RecyclerView recyclerView = viewRoot.findViewById(R.id.recyclerView);
			//recyclerView.setHasFixedSize(true);
			recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
			recyclerView.setAdapter(new NameListAdapter(getResources().getStringArray(R.array.fullNames)));
			final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
					new ItemTouchHelper.SimpleCallback(
							ItemTouchHelper.UP | ItemTouchHelper.DOWN,
							ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
						public boolean onMove(RecyclerView recyclerView,
											  RecyclerView.ViewHolder viewHolder,
											  RecyclerView.ViewHolder viewHolderTgt) {
							final int posFrom = viewHolder.getAdapterPosition();
							final int posTo = viewHolderTgt.getAdapterPosition();
							recyclerView.getAdapter().notifyItemMoved(posFrom, posTo);
							return true; // true if moved, false otherwise
						}
						public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
							final int fromPos = viewHolder.getAdapterPosition();
							//dataset.remove(fromPos);
							recyclerView.getAdapter().notifyItemRemoved(fromPos);
						}

					});
			itemTouchHelper.attachToRecyclerView(recyclerView);
			return viewRoot;
		}
	};
	public static class PageBFragment extends Fragment {
		public static class Factory extends FragmentFactory {
			Factory() { super(R.string.Two_columns); }
			@Override
			Fragment create() { return new PageBFragment(); }
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View viewRoot = inflater.inflate(R.layout.fragment_page, container, false);
			final RecyclerView recyclerView = viewRoot.findViewById(R.id.recyclerView);
			//recyclerView.setHasFixedSize(true);
			recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(), 2));
			recyclerView.setAdapter(new NameListAdapter(getResources().getStringArray(R.array.fullNames)));
			final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
					new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP |
							ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
						public boolean onMove(RecyclerView recyclerView,
											  RecyclerView.ViewHolder viewHolder,
											  RecyclerView.ViewHolder viewHolderTgt) {
							final int posFrom = viewHolder.getAdapterPosition();
							final int posTo = viewHolderTgt.getAdapterPosition();
							recyclerView.getAdapter().notifyItemMoved(posFrom, posTo);
							return true; // true if moved, false otherwise
						}
						public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
							final int fromPos = viewHolder.getAdapterPosition();
							//dataset.remove(fromPos);
							recyclerView.getAdapter().notifyItemRemoved(fromPos);
						}

					});
			itemTouchHelper.attachToRecyclerView(recyclerView);
			return viewRoot;
		}
	};
}
