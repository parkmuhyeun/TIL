package com.test.restdocs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.restdocs.dto.ReviewCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureMockMvc
@SpringBootTest
class ReviewControllerTest {

    @Autowired private MockMvc mockMvc;

    @Autowired private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }
    @Test
    @DisplayName("컨택하기")
    void newReview() throws Exception {
        String body = objectMapper.writeValueAsString(
                new ReviewCreateRequest(1L, 2L, "hello world", "abcdefghi", "github/parkmuhyeun"));

        mockMvc.perform(
                post("/reviews").content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", "/reviews/1"))
                .andExpect(status().isCreated())
                .andDo(document("reviews/create",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        responseHeaders(headerWithName("Location").description("review detail resource id"))
                ));
    }

    @Test
    @DisplayName("컨택하기")
    void newReview1() throws Exception {
        String body = objectMapper.writeValueAsString(
                new ReviewCreateRequest(3L, 4L, "hello world1", "abcdefghi1", "github/parkmuhyeun1"));

        mockMvc.perform(
                post("/reviews1").content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", "/reviews1/1"))
                .andExpect(status().isCreated())
                .andDo(document("reviews/create1",
                        responseHeaders(headerWithName("Location").description("review1 detail resource id"))
                ));
    }
}