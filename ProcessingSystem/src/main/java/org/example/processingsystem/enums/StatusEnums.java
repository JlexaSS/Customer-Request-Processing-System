package org.example.processingsystem.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnums {
    PROCESS(1,"В процессе"),
    PROCESSED(2,"Обработан"),
    NOTPROCESSED(3,"Не обработан");


    private final int id;
    private final String status;
}
