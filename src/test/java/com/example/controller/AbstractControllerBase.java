package com.example.controller;

import com.example.TestgroundApplication;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Properties;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by PRASEN on 1/27/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestgroundApplication.class)
@WebAppConfiguration
@Ignore
public class AbstractControllerBase {
    @Rule
    public RestDocumentation restDocumentation = new RestDocumentation(System.getProperty("buildDirectory") + "/snippets");
    @Autowired
    protected WebApplicationContext context;
    protected MockMvc mockMvc;
    protected RestDocumentationResultHandler document;

    @Before
    public void setUp() throws Exception {
        this.document = document("{method-name}",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()));

        mockMvc = webAppContextSetup(context).apply(documentationConfiguration(restDocumentation)).build();
        Properties buildDirectory = System.getProperties();
        System.out.println(buildDirectory);
    }
}
