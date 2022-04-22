package pl.info.czerniak.nbpcurrencyclient.service;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.info.czerniak.nbpcurrencyclient.model.SingleRate;
import pl.info.czerniak.nbpcurrencyclient.model.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SingleRateMapper {
    public SingleRate map(String response) {
        JSONObject rawResponse = new JSONObject(response);
        JSONArray rawArray = new JSONArray(rawResponse.getJSONArray("rates"));

        return new SingleRate(Table.valueOf(rawResponse.get("table").toString()),
                rawResponse.getString("code"),
                rawResponse.getString("currency"),
                rawArray.getJSONObject(0).get("no").toString(),
                LocalDate.parse(rawArray.getJSONObject(0).get("effectiveDate").toString()),
                new BigDecimal(rawArray.getJSONObject(0).get("bid").toString()),
                new BigDecimal(rawArray.getJSONObject(0).get("ask").toString()));

    }
}
