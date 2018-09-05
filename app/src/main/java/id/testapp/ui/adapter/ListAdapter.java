package id.testapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.testapp.R;
import id.testapp.model.CityModel;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private static ClickListener clickListener;

    Context context;
    private List<CityModel> list = new ArrayList<>();

    public ListAdapter(Context context, List<CityModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            final CityModel item = list.get(position);
            ((ViewHolder) holder).setData(item);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_ITEM;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        ImageView imageView;

        ViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.text_view_name);
            imageView = view.findViewById(R.id.image_view_item);

            itemView.setOnClickListener(this);
        }

        void setData(CityModel item) {
            textViewName.setText(item.getName());
            Picasso.get()
                    .load(item.getImageUrl())
                    .into(imageView);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener listener) {
        ListAdapter.clickListener = listener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
