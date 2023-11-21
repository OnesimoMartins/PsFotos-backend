package com.isptec.psfotos.domain.service;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DropBoxService {


   private final DbxClientV2 dropboxClient;


   public String criarNovoCatalogo()  {
       String fileName= "/catalogo_"+UUID.randomUUID()+".txt";
       FileMetadata metadata = null;

       try (InputStream in = new ByteArrayInputStream("".getBytes())) {
          metadata = dropboxClient.files()
                   .uploadBuilder(fileName)
                   .uploadAndFinish(in);
       } catch (UploadErrorException e) {
           System.out.println(" Erro 1");
       } catch (DbxException | IOException e) {
           System.out.println("Erro 2");
       }

       return metadata.getPathDisplay();
   }


    public void atualizarCatalogo(String path, String newString)  {
        FileMetadata metadata = null;

        try {
            DbxDownloader downloader= dropboxClient.files()
                    .download(metadata.getPathDisplay());

            String result = new BufferedReader(new InputStreamReader(downloader.getInputStream()))
                    .lines().parallel().collect(Collectors.joining("\n"));

            StringBuilder stringBuilder = new StringBuilder(result);

            stringBuilder.append("\n");
            stringBuilder.append(newString);

            dropboxClient.files().deleteV2(metadata.getPathDisplay());

            dropboxClient.files()
                    .upload(metadata.getPathLower())
                    .uploadAndFinish(new ByteArrayInputStream(stringBuilder
                            .toString().getBytes()));

        } catch (UploadErrorException e) {
            System.out.println(" Erro 1");
        } catch (DbxException | IOException e) {
            System.out.println(" Erro 2");
        }
    }

    @Deprecated
    public String salvarNovoTxt2() throws DbxException, IOException {

        String fileName= "/catalogo_"+UUID.randomUUID()+".txt";

        System.out.println(fileName);
        System.out.println(dropboxClient.users().getCurrentAccount().getEmail());

//        para por byes
//        InputStream in = new ByteArrayInputStream(fileName.getBytes())

        try (InputStream in = new ByteArrayInputStream("test".getBytes())) {


            FileMetadata metadata = dropboxClient.files()
                    .uploadBuilder(fileName)
                    .uploadAndFinish(in);

            System.out.println(metadata.getPathLower());
            System.out.println(metadata.getPathDisplay());
            System.out.println(metadata.getId());


            System.out.println("UU");
//            FileMetadata metaData2= dropboxClient.files()
//                    .download(metadata.getPathDisplay())
//                    .getResult();
//                    .getF(metadata.getPathDisplay());
//            metaData2.
//            metaData2.getExportInfo().getExportAs()
            DbxDownloader downloader= dropboxClient.files()
                    .download(metadata.getPathDisplay());
//            FileOutputStream out = new FileOutputStream(
//                    new File("C:\\Users\\marti\\OneDrive\\Ambiente de Trabalho\\ISPTEC\\APLM\\local_store\\txt.txt"));

            // Read Data
            String result = new BufferedReader(new InputStreamReader(downloader.getInputStream()))
                    .lines().parallel().collect(Collectors.joining("\n"));

            result= result+" 0000000000000000000000";

            dropboxClient.files().deleteV2(metadata.getPathDisplay());


            dropboxClient.files()
             .upload(metadata.getPathLower())
               .uploadAndFinish(new ByteArrayInputStream(result.getBytes()));

            System.out.println(result);
//            inputStream.

        }

        return  fileName;

    }
}
