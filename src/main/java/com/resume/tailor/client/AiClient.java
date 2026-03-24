package com.resume.tailor.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://ai.google.dev/gemini-api/docs/interactions
@Component
public class AiClient {
    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String generateTailoredResume(String prompt) {
        // 1. set the request Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 2. build  Gemini API request body (Simple Structure)
        // Gemini structure { "contents": [{ "parts": [{ "text": "..." }] }] }
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> part = new HashMap<>();
        part.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", Collections.singletonList(part));
        requestBody.put("contents", Collections.singletonList(content));

        // 3. send POST request to Gemini API
        String fullUrl = apiUrl + "?key=" + apiKey;
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(fullUrl, entity, Map.class);

            // 4. 解析返回的 JSON (层级较深: candidates[0].content.parts[0].text)
            List<Map> candidates = (List<Map>) response.getBody().get("candidates");
            Map firstCandidate = candidates.get(0);
            Map contentNode = (Map) firstCandidate.get("content");
            List<Map> parts = (List<Map>) contentNode.get("parts");

            return parts.get(0).get("text").toString();
        } catch (Exception e) {
            return "AI 调用失败: " + e.getMessage();
        }
    }


    public String callAiApi(String fullPrompt) {
        // 使用 RestTemplate 发送请求到 Gemini 或 OpenAI

        // 设置 Header: Authorization: Bearer + apiKey

        // 设置 Body: 包含 model 名称和 prompt 内容

        // 返回 AI 的文本响应
        String aiGeneratedText = "";
        return aiGeneratedText;
    }
}