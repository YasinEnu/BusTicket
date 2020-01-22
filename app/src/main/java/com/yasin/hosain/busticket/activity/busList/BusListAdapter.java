package com.yasin.hosain.busticket.activity.busList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.yasin.hosain.busticket.R;
import com.yasin.hosain.busticket.activity.BusSeatDetails.BusSeatDetailsActivity;
import com.yasin.hosain.busticket.activity.busList.model.BusData;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.ViewHolder> {

    private Context context;
    private BusData busData;

    public BusListAdapter(Context context, BusData busData) {
        this.context=context;
        this.busData=busData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_list_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TextView busNameAndType=holder.itemView.findViewById(R.id.tvBusNameAndType);
        TextView seatCountTV=holder.itemView.findViewById(R.id.seatCountTV);
        TextView departureTimeTV=holder.itemView.findViewById(R.id.tvDepartureTime);
        TextView amountTV=holder.itemView.findViewById(R.id.amountTV);
        ConstraintLayout busListItemCL=holder.itemView.findViewById(R.id.busListItemCL);
        busNameAndType.setText(busData.getData().get(position).getCompany().getName()+"("+busData.getData().get(position).getCoachType()+")");
        seatCountTV.setText(String.valueOf(busData.getData().get(position).getAvailableSeats()));
        departureTimeTV.setText(busData.getData().get(position).getDepartureTime());
        amountTV.setText(busData.getData().get(position).getMinimumFare());
        busListItemCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BusSeatDetailsActivity.class).putExtra(BusSeatDetailsActivity.KEY,busData.getData().get(position).getId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return busData.getData().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
