package com.example.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecDto {
    private String processor;
    private String display;
    private String sistemOperasi;
    private String ram;
    private String hardDrive;
    private String opticalDrive;
    private String konektifitas;


}
