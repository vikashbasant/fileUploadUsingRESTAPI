package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // Path where we need to upload the image file:
    public final String UPLOAD_DIR = "/home/decimal/Documents/workspace-spring-tool-suite-4-4.13.1.RELEASE/fileUploadUsingRESTAPI/src/main/resources/static/image";


    // Here MultipartFile type is used for handle the file:
    // Here this method upladFile just simply tells the whether the file is uploaded or not:
    public boolean uploadFile(MultipartFile f) {
        boolean tempF = false;
        try{
            // ------------- Here we need used the old API:-----------------------------------------

            // // Here this well gives us InputStream:
            // InputStream is = f.getInputStream();

            // // Here we need to create an array of size of coming data size(i.e is.available()):
            // byte data[] = new byte[is.available()];

            // // Here we need to read the data:
            // is.read(data);

            // // Now we need to write the data into UPLOAD_DIR floder:
            // // File.separator: instant of /
            // // f.getOriginalFilename(): it gives an orignal file name:
            // // UPLOAD_DIR: it will gives the path where we need to save the data:
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + f.getOriginalFilename());

            // // Now we need to save data inot FileOutputStream:
            // fos.write(data);

            // // Now we need to flush the FileOutputStream:
            // fos.flush();
            // // Now we need to close the FileOutputStream:
            // fos.close();




            //-----------------------------------Now we need used new API i.e(NIO Package)--------------------------
            // Alternative of old api version:
            // Files.copy(क्या save करना है, कहा पर save करना है, किस तरह से save करना हैं )
            Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            // Now simply check the validation:
            tempF = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Now simply return tempF:
        return tempF;
    }

}
