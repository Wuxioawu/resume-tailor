package com.resume.tailor.service;

import com.resume.tailor.client.AiClient;
import com.resume.tailor.model.TailorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TailorService {
    @Autowired
    private AiClient aiClient;

    public String processTailoring(TailorRequest request) {
        // 1. 拼接强力的 Prompt
        String prompt = "你是一名资深求职顾问。请根据以下 JD 修改这份简历，"
                + "使其更符合岗位要求。JD内容：" + request.getJobDescription()
                + " 原始简历：" + request.getOriginalResume();

        // 2. 调用 AI
        return aiClient.callAiApi(prompt);
    }
}
