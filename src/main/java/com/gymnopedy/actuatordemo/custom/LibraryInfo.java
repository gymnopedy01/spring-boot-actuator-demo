package com.gymnopedy.actuatordemo.custom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibraryInfo {
    private String name;
    private String version;
}
