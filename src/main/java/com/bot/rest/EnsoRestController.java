package com.bot.rest;

import com.bot.rest.model.ResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "rest/ensobot")
@Slf4j
public class EnsoRestController {

//    + ResponseEntity<...>
//    + GetMapping

    @Autowired
    final EnsoRestService ensoRestService;

    record EnsoRequest(String requestName, List<Long> scenarioIdList) {
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_XML_VALUE)
    public List<ResponseModel> runEnsoScenario(@RequestBody EnsoRequest ensoRequest) {
        log.info("Run ENSO request_name = " + ensoRequest.requestName + " scenarioIdList = " + ensoRequest.scenarioIdList);
        return ensoRestService.runEnsoScenario(ensoRequest);
    }

}
