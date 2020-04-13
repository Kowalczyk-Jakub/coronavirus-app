package pl.kowalczyk.coronavirusapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kowalczyk.coronavirusapp.service.CoronaVirusService;
import java.io.IOException;

@Controller
public class CoronaVirusController {

    private CoronaVirusService coronaVirusService;

    @Autowired
    public CoronaVirusController(CoronaVirusService coronaVirusService) {
        this.coronaVirusService = coronaVirusService;
    }

    @GetMapping
    public String getView(Model model) throws IOException, InterruptedException {
        model.addAttribute("list",coronaVirusService.getData());
        return "view";
    }

}
