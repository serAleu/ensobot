package com.bot.rest;

import com.bot.rest.model.ResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "rest/ensobot")
@Slf4j
public class EnsoRestController {

    @Autowired
    final EnsoRestService ensoRestService;

    record EnsoRequest(String requestName, List<Long> scenarioIdList) {
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public List<ResponseModel> runEnsoScenario(@RequestBody EnsoRequest ensoRequest) {
        log.info("Run ENSO request_name = " + ensoRequest.requestName + " scenarioIdList = " + ensoRequest.scenarioIdList);
        return ensoRestService.runEnsoScenario(ensoRequest);
    }

    @GetMapping
    public ResponseEntity<String> getRequest() {
        log.info("WoW i intercepted the GET request");
        return ResponseEntity.ok().body("Please, use POST request");
    }
}
