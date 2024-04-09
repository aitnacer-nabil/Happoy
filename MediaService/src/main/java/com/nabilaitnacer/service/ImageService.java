package com.nabilaitnacer.service;


import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.cloud.storage.StorageOptions;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {




    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());

        }
        return tempFile;
    }
    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("insta-downloader-71d7a.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = ImageService.class.getClassLoader().getResourceAsStream("media-service-firestorage.json");
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/insta-downloader-71d7a.appspot.com/o/%s?alt=media";
        return String.format(downloadUrl, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
            File file = this.convertToFile(multipartFile, fileName);
            String url = this.uploadFile(file, fileName);
            file.delete();
            return url;
        } catch (Exception e) {
            //TODO Throw custom exception
            return "Image couldn't upload, Something went wrong";
        }
    }
    public List<String> uploadMultipleFiles(List<MultipartFile> multipartFiles) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            urls.add(this.upload(multipartFile));
        }
        return urls;
    }
}
