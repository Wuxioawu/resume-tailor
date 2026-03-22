package com.resume.tailor.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// AiClient.java
@Component
public class AiClient {
    @Value("${ai.api.key}")
    private String apiKey;

    public String callAiApi(String fullPrompt) {
        // 使用 RestTemplate 发送请求到 Gemini 或 OpenAI

        // 设置 Header: Authorization: Bearer + apiKey

        // 设置 Body: 包含 model 名称和 prompt 内容

        // 返回 AI 的文本响应
        String aiGeneratedText = "";
        return aiGeneratedText; 
    }
}