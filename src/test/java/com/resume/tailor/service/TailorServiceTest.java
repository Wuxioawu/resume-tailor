package com.resume.tailor.service;

import com.resume.tailor.client.AiClient;

import com.resume.tailor.model.TailorRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TailorServiceTest {
    @Mock
    private AiClient aiClient; // mock AI client

    @InjectMocks
    private TailorService tailorService; // inject mock into service


    @Test
    void tailor_returnsAiResponse_whenAiClientReturnsValue() {
        TailorRequest request = new TailorRequest();
        // arrange
        request.setOriginalResume("Experience at Xiaomi");
        request.setJobDescription("Looking for Android expert");
        String mockAiResponse = "Optimized Resume Content";
        when(aiClient.generateTailoredResume(anyString())).thenReturn(mockAiResponse);

        // act
        String result = tailorService.tailor(request);

        // assert
        assertEquals(mockAiResponse, result);
    }
}