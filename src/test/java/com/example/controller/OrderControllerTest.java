package com.example.controller;

import com.example.TestgroundApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by PRASEN on 1/21/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestgroundApplication.class)
@WebAppConfiguration
public class OrderControllerTest {

    @Rule
    public RestDocumentation restDocumentation = new RestDocumentation(System.getProperty("buildDirectory") + "/snippets");

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(context).apply(documentationConfiguration(restDocumentation)).build();
        String buildDirectory = System.getProperty("buildDirectory");
        System.out.println(buildDirectory);
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andDo(document("orders",
                        links(linkWithRel("self").description("self link")),
                        responseFields(fieldWithPath("orders").description("all the orders available"),
                                fieldWithPath("_links").description("all links available"))));
    }

    @Test
    public void testView() throws Exception {

    }
}