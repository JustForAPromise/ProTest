package com.securitytest.demo.contrallor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadContrallor {
    private  static String UPLOADED_FOLDER = "D://temp//";

    @RequestMapping("/file") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try{
            byte[] fileBytes = file.getBytes();
            File oldFile = new File(UPLOADED_FOLDER+file.getOriginalFilename());
            if(oldFile.exists()){
                oldFile.delete();
            }
//            Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
//            Files.write(path,fileBytes);

        }catch (IOException e){
            e.printStackTrace();
        }
        return "home";
    }
}
