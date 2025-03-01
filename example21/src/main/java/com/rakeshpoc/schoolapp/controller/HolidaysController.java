package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.model.Holiday;
import com.rakeshpoc.schoolapp.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
public class HolidaysController {
    @Autowired
    private HolidaysRepository holidaysRepository;



    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {

        if(null!=display && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }else if(null!=display && display.equals("festival")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", false);
        }else if(null!=display && display.equals("federal")) {
            model.addAttribute("festival", false);
            model.addAttribute("federal", true);
        }
        Iterable<Holiday> holidays =holidaysRepository.findAll();

        Holiday.Type[] types=Holiday.Type.values();
        List<Holiday> holidayList = StreamSupport.stream(holidays.spliterator(), false).toList();
        for(Holiday.Type type : types){
            model.addAttribute(type.toString(),
                    holidayList.stream().filter(holiday->holiday.getType().equals(type)).collect(Collectors.toList()));
        }
        return "holidays.html";
    }
}
