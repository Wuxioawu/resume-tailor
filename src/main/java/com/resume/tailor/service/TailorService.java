package com.resume.tailor.service;

import com.resume.tailor.client.AiClient;
import com.resume.tailor.model.TailorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TailorService {
    @Autowired
    private AiClient aiClient;

    public String tailor(TailorRequest request) {
        // 构造高度定制化的 Prompt
        String prompt = String.format(
                "你是一名专业的简历优化专家。请根据以下[职位描述]修改[原始简历]。\n\n" +
                        "要求：\n" +
                        "1. 重点突出与 JD 相关的技能（如 %s）。\n" +
                        "2. 使用 STAR 法则优化工作经历，增加量化指标。\n" +
                        "3. 保持简历真实，严禁编造项目经历。\n" +
                        "4. 输出格式为 Markdown。\n\n" +
                        "[职位描述]:\n%s\n\n" +
                        "[原始简历]:\n%s",
                "Android, Kotlin, HyperOS", // 这里可以动态提取
                request.getJobDescription(),
                request.getOriginalResume()
        );

        return aiClient.generateTailoredResume(prompt);
    }
}
