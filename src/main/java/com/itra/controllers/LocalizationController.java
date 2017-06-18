package com.itra.controllers;

import com.itra.local.Localizationable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "local")
public class LocalizationController {
    private Localizationable rusLocalization;
    private Localizationable engLocalization;

    @Autowired
    public LocalizationController(@Qualifier("RUSLocalizationImpl") Localizationable rusLocalization,
                                  @Qualifier("ENGLocalizationImpl") Localizationable engLocalization) {
        this.rusLocalization = rusLocalization;
        this.engLocalization = engLocalization;
    }

    @GetMapping(value = "get")
    public ResponseEntity<?> getLocal(@RequestParam(value = "var_local") String var_local) {
        return ResponseEntity.ok(this.getVarLocalization(var_local).getLocalization());
    }

    private Localizationable getVarLocalization(String var_local) {
        if (var_local.equals("RUS")) {
            return this.rusLocalization;
        } else return this.engLocalization;
    }
}