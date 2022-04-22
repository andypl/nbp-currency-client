package pl.info.czerniak.nbpcurrencyclient.model;

import lombok.Getter;

@Getter
public enum RateCode {
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
    SEK("korona szwedzka"),
    XDR("SDR (MFW)");

    private String description;

    RateCode(String description) {
        this.description = description;
    }
}
