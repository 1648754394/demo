package com.example.project.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class User implements Serializable {
  private long id;


//  @Schema(description = "User's name", requiredMode = Schema.RequiredMode.REQUIRED)
  private String userName;

  private String password;

  @Serial
  private static final long serialVersionUID = 1L;
}