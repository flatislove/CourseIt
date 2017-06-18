package com.itra.local.LocalImpl;

import com.itra.local.Localizationable;
import org.springframework.stereotype.Component;

@Component
public class RUSLocalizationImpl implements Localizationable {

    private final String RUS;

    public RUSLocalizationImpl() {
        RUS = "[" +
                "{ \"key\":\"home\",\"value\":\"Главная\"}, " +
                "{ \"key\":\"project\",\"value\":\"Проект\"}, " +
                "{ \"key\":\"projects\",\"value\":\"Проекты\"}, " +
                "{ \"key\":\"message\",\"value\":\"Сообщение\"}, " +
                "{ \"key\":\"news\",\"value\":\"Новости\"}, " +
                "{ \"key\":\"user\",\"value\":\"Пользователь\"}, " +
                "{ \"key\":\"admin\",\"value\":\"Администратор\"}, " +
                "{ \"key\":\"tag\",\"value\":\"Тэг\"}, " +
                "{ \"key\":\"add\",\"value\":\"Добавить\"} " +
                "]";
    }

    @Override
    public String getLocalization() {
        return RUS;
    }
}
