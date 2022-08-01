package org.example.ProcessingSystem.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnums {
    PROCESS("В процессе"),
    PROCESSED("Обработан"),
    NOTPROCESSED("Не обработан");

    private final String status;
}
