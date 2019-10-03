package pe.dquispe.labcalificado3.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import pe.dquispe.labcalificado3.R;
import pe.dquispe.labcalificado3.adapters.OperationAdapter;
import pe.dquispe.labcalificado3.models.Operation;
import pe.dquispe.labcalificado3.repositories.OperationRepository;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView operationsList;
    private Long id;
    public ImageView imgView1, imgView2, imgView3;
    private ProgressBar progressBar1;
    private TextView saldoAhorro, saldoCredito, saldoEfectivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView1=findViewById(R.id.imageView1);
        imgView2=findViewById(R.id.imageView2);
        imgView3=findViewById(R.id.imageView3);
        saldoAhorro=findViewById(R.id.txtSAA);
        saldoCredito=findViewById(R.id.txtSAC);
        saldoEfectivo=findViewById(R.id.txtSAE);

    }

    public void showRegister(View view){
        startActivityForResult(new Intent(this, NewOperationActivity.class), REGISTER_FORM_REQUEST);
    }


    public void showDetail1(View view){
        startActivityForResult(new Intent(this, DetailActivity.class), REGISTER_FORM_REQUEST);
    }
    public void showDetail2(View view){
        startActivityForResult(new Intent(this, DetailActivity.class), REGISTER_FORM_REQUEST);
    }
    public void showDetail3(View view){
        startActivityForResult(new Intent(this, DetailActivity.class), REGISTER_FORM_REQUEST);
    }

}



