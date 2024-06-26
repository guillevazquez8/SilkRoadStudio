package com.projects.silkroadstudio.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseError {
    private String errorMessage;
    private String status;
}