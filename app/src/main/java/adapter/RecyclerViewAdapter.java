package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dataModels.RecyclerViewModel;
import interFaces.onItemClickListener;
import mobin.io.proweatherapp.R;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<RecyclerViewModel>recyclerViewModels ;
    private Context context ;
    private interFaces.onItemClickListener onItemClickListener ;

    public RecyclerViewAdapter(List<RecyclerViewModel> recyclerViewModels, Context context, interFaces.onItemClickListener onItemClickListener) {
        this.recyclerViewModels = recyclerViewModels;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_recyclerview ,parent , false);
        return new ViewHolder(layoutInflater ,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_country.setText(recyclerViewModels.get(position).getCountry());
        holder.tv_city.setText(recyclerViewModels.get(position).getCityName());
        holder.tv_temp.setText(recyclerViewModels.get(position).getTemp());

    }

    @Override
    public int getItemCount() {
        return recyclerViewModels.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_city ;
        TextView tv_temp ;
        TextView tv_city ;
        TextView tv_country ;
        onItemClickListener onItemClickListener ;


        public ViewHolder(@NonNull View itemView , onItemClickListener onItemClickListener) {
            super(itemView);

            iv_city = itemView.findViewById(R.id.iv_model_back);
            tv_temp = itemView.findViewById(R.id.tv_model_temp);
            tv_city = itemView.findViewById(R.id.tv_model_city);
            tv_country = itemView.findViewById(R.id.tv_model_country);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onClick(view , getAdapterPosition() , tv_city.getText().toString());
        }
    }

}
