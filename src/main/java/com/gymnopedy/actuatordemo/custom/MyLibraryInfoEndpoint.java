package com.gymnopedy.actuatordemo.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Endpoint(id = "myLibraryInfo")
public class MyLibraryInfoEndpoint {

    @ReadOperation
    public List<LibraryInfo> getLibraryInfos(@Nullable String name, boolean includeVersion) {

        List<LibraryInfo> libraryInfos = List.of(LibraryInfo.builder()
                        .name("logback")
                        .version("1.0.0")
                        .build()
                , LibraryInfo.builder()
                        .name("jackson")
                        .version("2.0.0")
                        .build());

        if (name != null) {
            libraryInfos = libraryInfos.stream()
                    .filter(lib -> lib.getName().equals(name))
                    .toList();
        }

        if (includeVersion == false) {
            libraryInfos = libraryInfos.stream()
                    .map(lib -> LibraryInfo.builder()
                            .name(lib.getName())
                            .build())
                    .toList();
        }

        return libraryInfos;

    }

    @WriteOperation
    public void changeSomething(String name, boolean enableSomething) {
        log.info("name:{}, enableSomething: {}", name, enableSomething);
    }

    @ReadOperation
//    public String getPathTest(@Selector(match = Selector.Match.SINBLE) String[] path1) {
    public String getPathTest(@Selector(match = Selector.Match.ALL_REMAINING) String[] path1) {
        log.info("path1: {}", Arrays.asList(path1));
        return "path1:" + Arrays.asList(path1);
    }
}
