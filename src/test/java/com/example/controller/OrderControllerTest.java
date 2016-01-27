package com.example.controller;

import org.junit.Test;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by PRASEN on 1/21/2016.
 */
public class OrderControllerTest extends AbstractControllerBase {

    @Test
    public void testGetAll() throws Exception {
        document.snippets(responseHeaders(
                headerWithName("sid").description("The Content-Type of the payload, e.g. 'application/hal+json'")));

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