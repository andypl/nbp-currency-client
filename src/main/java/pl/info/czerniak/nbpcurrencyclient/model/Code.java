package pl.info.czerniak.nbpcurrencyclient.model;

public enum Code {
    USD("dolar amerykański"),
    AUD("dolar australijski"),
    CAD("dolar kanadyjski"),
    EUR("euro"),
    HUF("forint (Węgry)"),
    CHF("frank szwajcarski"),
    GBP("funt szterling"),
    JPY("jen (Japonia)"),
    CZK("korona czeska"),
    DKK("korona duńska"),
    NOK("korona norweska"),
    SEL("korona szwedzka"),
    XDR("SDR (MFW)");

    private String description;

    Code(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
