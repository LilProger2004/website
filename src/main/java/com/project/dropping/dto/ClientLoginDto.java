package com.project.dropping.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.project.dropping.model.Client}
 */
@Value
public class ClientLoginDto implements Serializable {
    String username;
    String password;
}