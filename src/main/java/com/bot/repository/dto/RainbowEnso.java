package com.bot.repository.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class RainbowEnso {

    private Long scenarioId;
    private String scenarioName;

}
