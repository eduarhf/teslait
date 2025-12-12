/*
package com.teslait.template.stadistic.infrastructure.outbound.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleStorageAdapter{

    private final ObjectMapper objectMapper;
    @Autowired
    Environment environment;
    private final Storage storage;

    public GoogleStorageAdapter(ObjectMapper objectMapper, Storage storage) {
        this.objectMapper = objectMapper;
        this.storage = storage;
    }
    public BtsResponse getFile(String fileName) throws IOException {
        String filePath = "B2B/incomming/";
        Blob blob = storage.get(Blob.of(environment.getProperty("cloud.storage.bucket-name"),
                filePath + fileName)
        ));
        if(blob = null){
            throw new IOException("fILE NOT FOUND IN STORAGE"+fileName);
        }
        String jsonData = new String(blob.getContent());
        BtsResponse btsResponse = objectMapper.readValue(jsonData, BtsResponse.class);
        return btsResponse;
    }
    public Boolean deleteFile(String fileName) {
        String filePath = "B2B/incomming/";
        BlobId blobId = BlobId.of(environment.getProperty("cloud.storage.bucket-name"), filePath + fileName);
        Boolean deleted = storage.delete(blobId);
        return deleted;
    }
}
*/