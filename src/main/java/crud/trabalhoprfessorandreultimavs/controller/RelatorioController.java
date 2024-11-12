package crud.trabalhoprfessorandreultimavs.controller;

import crud.trabalhoprfessorandreultimavs.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping("/agendas")
    public ResponseEntity<InputStreamResource> gerarRelatorioAgendas() {
        String caminhoArquivo = "relatorio_agendas.pdf";

        // Gera o PDF
        pdfGenerator.gerarPdfComAgendas(caminhoArquivo);

        // Carrega o arquivo PDF gerado
        File pdfFile = new File(caminhoArquivo);
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(pdfFile));

            // Configura os cabeçalhos para o download
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + pdfFile.getName());
            headers.setContentType(MediaType.APPLICATION_PDF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdfFile.length())
                    .body(resource);

        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
