package com.itra.local.LocalImpl;

import com.itra.local.Localizationable;
import org.springframework.stereotype.Component;

@Component
public class ENGLocalizationImpl implements Localizationable {
    private final String ENG;

    public ENGLocalizationImpl() {
        ENG = "[" +
                "{ \"key\":\"home\",\"value\":\"Home\"}, " +
                "{ \"key\":\"project\",\"value\":\"Project\"}, " +
                "{ \"key\":\"projects\",\"value\":\"Projects\"}, " +
                "{ \"key\":\"message\",\"value\":\"Message\"}, " +
                "{ \"key\":\"news\",\"value\":\"News\"}, " +
                "{ \"key\":\"user\",\"value\":\"User\"}, " +
                "{ \"key\":\"admin\",\"value\":\"Administarator\"}, " +
                "{ \"key\":\"tag\",\"value\":\"Tag\"}, " +
                "{ \"key\":\"add\",\"value\":\"Add\"} " +
                "]";
    }

    @Override
    public String getLocalization() {
        return ENG;
    }
}
