package com.resume.tailor;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ResumeTailorApplication {
    public static void main(String[] args) {
        String apiKey = "AIzaSyCqWSQYujQSiFquCNeNtbtZcMOjnmIBhzQ";
        Client client = Client.builder().apiKey(apiKey).build();
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3-flash-preview",
                        "Explain how AI works in a few words",
                        null);

        System.out.println(response.text());
    }
}