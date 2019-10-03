package pe.dquispe.labcalificado3.models;

public class Operation {
    private Long id;
    private String monto;
    private String ingEgr;
    private String tipoCuenta;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getIngEgr() {
        return ingEgr;
    }

    public void setIngEgr(String ingEgr) {
        this.ingEgr = ingEgr;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", monto='" + monto + '\'' +
                ", ingEgr='" + ingEgr + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
