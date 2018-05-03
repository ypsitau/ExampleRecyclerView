package io.github.ypsitau.examplerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private String[] dataSet;
	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		public TextView textView_index;
		public TextView textView_fullName;
		public TextView textView_firstName;
		public TextView textView_lastName;
		public ViewHolder(View viewRoot) {
			super(viewRoot);
			this.textView_index = viewRoot.findViewById(R.id.textView_index);
			this.textView_fullName = viewRoot.findViewById(R.id.textView_fullName);
			this.textView_firstName = viewRoot.findViewById(R.id.textView_firstName);
			this.textView_lastName = viewRoot.findViewById(R.id.textView_lastName);
			viewRoot.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Util.Printf("%d\n", this.getAdapterPosition() + 1);
		}

	}
	public MyAdapter(String[] dataSet) {
		this.dataSet = dataSet;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new ViewHolder(LayoutInflater.from(parent.getContext())
				.inflate(R.layout.my_adapter_view_holder, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		String fullName = dataSet[position];
		String[] fields = fullName.split("\\s");
		String firstName = "", lastName = "";
		holder.textView_index.setText(String.format("%d", position + 1));
		holder.textView_fullName.setText(fullName);
		if (fields.length > 0) holder.textView_firstName.setText(fields[0]);
		if (fields.length > 1) holder.textView_lastName.setText(fields[1]);
	}

	@Override
	public int getItemCount() {
		return dataSet.length;
	}
}
