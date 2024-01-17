package com.isptec.psfotos.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("photos")
public class PhotoController {

    @PostMapping("/{idAlbum}/upload")
    public ResponseEntity<String> fileUploading(
            @PathVariable Integer idAlbum,
            @RequestParam("file") MultipartFile file) {
        // Code to save the file to a database or disk
        System.out.println(idAlbum);
        return ResponseEntity.ok("Successfully uploaded the file");
    }
}
