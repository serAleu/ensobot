package com.bot.rest;

import com.bot.repository.EnsoRepository;
import com.bot.repository.dto.RainbowEnso;
import com.bot.rest.model.ResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class EnsoRestService {

    final EnsoRepository ensoRepository;

    public List<ResponseModel> runEnsoScenario(EnsoRestController.EnsoRequest ensoRequest) {
        try {
            List<ResponseModel> responseModelList = new ArrayList<>();
            ensoRequest.scenarioIdList().stream()
                    .filter(scenariodId -> scenariodId != null && scenariodId >= 1 && scenariodId <= 3)
                    .forEach(scenarioId -> {
                        RainbowEnso rainbowEnso = ensoRepository.getRainbowEnsoByScenarioId(scenarioId);
                        responseModelList.add(new ResponseModel()
                                .setRainbowEnso(rainbowEnso)
                                .setScenarioId(scenarioId)
                                .setScenarioDescription(defineScenarioDescriptionByScenarioId(scenarioId))
                                .setRequestName(ensoRequest.requestName()));
                    });
            return responseModelList;
        } catch (Exception e) {
            throw new RuntimeException("Exception while runEnsoScenario", e);
        }
    }

    private String defineScenarioDescriptionByScenarioId(long scenarioId) {
        return switch ((int) scenarioId) {
            case 1 -> "first scenario selected";
            case 2 -> "second scenario selected";
            case 3 -> "third scenario selected";
            default -> "undefined scenario";
        };
    }
}
