package pe.dquispe.labcalificado3.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import pe.dquispe.labcalificado3.R;
import pe.dquispe.labcalificado3.adapters.OperationAdapter;
import pe.dquispe.labcalificado3.models.Operation;
import pe.dquispe.labcalificado3.repositories.OperationRepository;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView operationsList;
    private Long id;
    private TextView signo,date,ingegr,tipo,monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        signo = (TextView)findViewById(R.id.input_signo_detail);
        date = (TextView)findViewById(R.id.date_text);
        ingegr = (TextView)findViewById(R.id.input_ingegr_detail);
        tipo = (TextView)findViewById(R.id.input_tipoN_detail);
        monto = (TextView)findViewById(R.id.input_monto_detail);

        this.operationsList = (RecyclerView)findViewById(R.id.detail_list);
        this.operationsList.setLayoutManager(new LinearLayoutManager(this));
        this.operationsList.setAdapter(new OperationAdapter());

        refreshData();

        id = getIntent().getExtras().getLong("ID");
        Log.e(TAG, "ID: " + id);

        Operation operation = OperationRepository.get(id);

        date.setText(operation.getDate());
        ingegr.setText(operation.getIngEgr());
        tipo.setText(operation.getTipoCuenta());
        monto.setText(operation.getMonto());

    }

    public void refreshData(){
        OperationAdapter adapter = (OperationAdapter) operationsList.getAdapter();
        List<Operation> notes = OperationRepository.getOperations();
        adapter.setOperations(notes);
        adapter.notifyDataSetChanged(); // Refrezca los cambios
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REGISTER_FORM_REQUEST:
                if (resultCode == RESULT_OK) {
                    refreshData();
                }
                break;
            default:
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
