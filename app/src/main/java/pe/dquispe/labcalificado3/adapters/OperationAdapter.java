package pe.dquispe.labcalificado3.adapters;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.util.ArrayList;
import java.util.List;

import pe.dquispe.labcalificado3.R;
import pe.dquispe.labcalificado3.activities.DetailActivity;
import pe.dquispe.labcalificado3.models.Operation;
import pe.dquispe.labcalificado3.repositories.OperationRepository;

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.ViewHolder> {
    private static final String TAG = OperationAdapter.class.getSimpleName();

    private List<Operation> operations;

    public OperationAdapter(){
        this.operations = new ArrayList<>();
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView inputMonto;
        public TextView inputIngEgr;
        public TextView inputTipo;
        public TextView dateText;


        public ViewHolder(View itemView) {
            super(itemView);
            inputMonto = (TextView) itemView.findViewById(R.id.input_monto_detail);
            inputIngEgr = (TextView) itemView.findViewById(R.id.input_ingegr_detail);
            inputTipo = (TextView) itemView.findViewById(R.id.input_tipo_detail);
            dateText = (TextView) itemView.findViewById(R.id.date_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Operation operation = this.operations.get(position);

        viewHolder.inputMonto.setText(operation.getMonto());
        viewHolder.inputIngEgr.setText(operation.getIngEgr());
        viewHolder.inputTipo.setText(operation.getTipoCuenta());
        viewHolder.dateText.setText(operation.getDate());


        // OnClick on Detail
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("ID", operation.getId());
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.operations.size();
    }

}
