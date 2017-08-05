package com.example.testframework.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.testframework.domain.FieldComparisonFailure;
import com.example.testframework.service.TestProjectService;

@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private TestProjectService testProjectService;

    @RequestMapping(value = "jsonCompare", method = RequestMethod.POST)
    @ResponseBody
    public List<FieldComparisonFailure> jsonCompare(@RequestParam("expect") String expect, @RequestParam("actual") String actual, ModelMap model,
            HttpSession session) {

        List<FieldComparisonFailure> list = testProjectService.compare(expect, actual);

        return list;
    }

}
