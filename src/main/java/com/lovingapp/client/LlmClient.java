package com.lovingapp.client;

import com.lovingapp.model.domain.ai.LLMRequest;
import com.lovingapp.model.domain.ai.LLMResponse;

public interface LlmClient {

    <T> LLMResponse<T> generate(LLMRequest request, Class<T> responseClass);

    default LLMResponse<String> generate(LLMRequest request) {
        return generate(request, String.class);
    }
}
