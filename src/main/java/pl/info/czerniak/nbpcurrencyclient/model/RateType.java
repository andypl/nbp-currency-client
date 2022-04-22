package pl.info.czerniak.nbpcurrencyclient.model;

import lombok.Getter;

@Getter
public enum RateType {
    ASK("buy"),
    BID("sell");

    private final String description;

    RateType(String description) {
        this.description = description;
    }
}
