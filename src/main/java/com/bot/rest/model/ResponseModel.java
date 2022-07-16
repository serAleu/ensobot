package com.bot.rest.model;

import com.bot.repository.dto.RainbowEnso;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@RequiredArgsConstructor
@Getter
@Setter
public class ResponseModel {

    private String scenarioDescription;
    private Long scenarioId;
    private String requestName;
    private RainbowEnso rainbowEnso;

}
