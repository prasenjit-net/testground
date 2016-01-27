package com.example.controller;

import org.junit.Test;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by PRASEN on 1/27/2016.
 */
public class PersonControllerTest extends AbstractControllerBase {

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andDo(document("persons",
                        links(linkWithRel("self").description("self link")),
                        responseFields(fieldWithPath("persons").description("all the orders available"),
                                fieldWithPath("_links").description("all links available"))));
    }

    @Test
    public void testView() throws Exception {

    }

    @Test
    public void testOrders() throws Exception {

    }
}