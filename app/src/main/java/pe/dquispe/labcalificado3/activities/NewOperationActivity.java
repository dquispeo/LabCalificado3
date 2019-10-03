package pe.dquispe.labcalificado3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import pe.dquispe.labcalificado3.R;
import pe.dquispe.labcalificado3.models.Operation;
import pe.dquispe.labcalificado3.repositories.OperationRepository;

public class NewOperationActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText monto,date;
    private RadioGroup radioGroup;
    private Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        monto = (EditText)findViewById(R.id.txtMonto);
        date = (EditText)findViewById(R.id.txtDate);
        radioGroup =  (RadioGroup) findViewById(R.id.radioGroup);
        spinner1 = (Spinner)findViewById(R.id.spinner);

    }

    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Ingreso", Toast.LENGTH_SHORT).show();
                break;
        case R.id.radioButton2:
            Toast.makeText(getApplicationContext(), "Egreso", Toast.LENGTH_SHORT).show();
            break;
        }    }

    public void callRegister(View view){

        String montoN = monto.getText().toString();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        String item = (String)spinner1.getSelectedItem();
        String dateN = date.getText().toString();
        String radioButtonIdN = "";

        if(montoN.isEmpty() || dateN.isEmpty()){
            Toast.makeText(this, "Debe completar los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (radioButtonId == R.id.radioButton1){
            radioButtonIdN="Ingreso";
        }else if (radioButtonId == R.id.radioButton2){
            radioButtonIdN="Egreso";
        }


        Operation operation = new Operation();
        operation.setMonto(montoN);
        operation.setIngEgr(radioButtonIdN);
        operation.setTipoCuenta(item);
        operation.setDate(dateN);

        OperationRepository.add(operation);

        Toast.makeText(this, "Operación registrado correctamente", Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK);

        finish();
    }
}
