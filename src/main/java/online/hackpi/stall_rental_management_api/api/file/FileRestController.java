package online.hackpi.stall_rental_management_api.api.file;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@RequestMapping("api/v1/file-single-upload")
@RestController
public class FileRestController {
    @PostMapping("")
    public ResponseEntity<?> uploadSingleFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(multipartFile.getInputStream())){
            try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/file/"+ UUID.randomUUID()+".mp4"))){
                bufferedOutputStream.write(bufferedInputStream.readAllBytes());
            }
        }catch (Exception ignored){}
        return ResponseEntity.status(HttpStatus.OK)
                .body(multipartFile.getName());
    }
}
