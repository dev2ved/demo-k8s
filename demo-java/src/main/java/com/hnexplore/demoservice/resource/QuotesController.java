package com.hnexplore.demoservice.resource;

import com.hnexplore.demoservice.service.QuotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuotesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuotesController.class);

    @Autowired
    private QuotesService quotesService;

    @RequestMapping("/quotes")
    public String quotes(Model model) {
        LOGGER.info("ENTERED: quotes");
        model.addAttribute("quotes", quotesService.getQuotesOfTheDay());
        return "quotes";
    }
}
