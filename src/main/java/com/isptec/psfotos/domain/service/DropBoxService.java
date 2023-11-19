package com.isptec.psfotos.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DropBoxService {


//   private final DbxClientV2 dropboxClient;
    public String salvarNovoTxt(){

        String fileName= UUID.randomUUID().toString();

        List<String> lines = Collections.singletonList("");

        Path file = Paths.get(fileName);
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        MultipartFile file = new MultipartFile()

        return  fileName;

    }
}
