package pe.dquispe.labcalificado3.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pe.dquispe.labcalificado3.models.Operation;

public class OperationRepository {
    private static final String TAG = OperationRepository.class.getSimpleName();

    private static List<Operation> operations = new ArrayList<>();

    public static List<Operation> getOperations() {
        return operations;
    }

    private static long sequence = 1;

    public static Operation add(Operation operation){
        operation.setId(sequence++);
        operations.add(0, operation);
        return operation;
    }

    public static Operation get(Long id){
        for (Operation operation : operations) {
            if(operation.getId().equals(id))
                return operation;
        }
        return null;
    }
}
