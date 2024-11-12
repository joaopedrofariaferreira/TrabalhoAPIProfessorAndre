package crud.trabalhoprfessorandreultimavs;

import crud.trabalhoprfessorandreultimavs.entity.Agenda;
import crud.trabalhoprfessorandreultimavs.service.AgendaService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PdfGenerator {

    @Autowired
    private AgendaService agendaService;

    public void gerarPdfComAgendas(String caminhoArquivo) {

        List<Agenda> agendas = agendaService.getAllAgendas();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(100, 750);
                contentStream.showText("Relatório de Agendas");
                contentStream.newLineAtOffset(0, -30);

                contentStream.setFont(PDType1Font.HELVETICA, 12);

                for (Agenda agenda : agendas) {
                    String agendaInfo = String.format("ID: %d | Cliente: %s | Serviço: %s | Status: %s",
                            agenda.getId(),
                            agenda.getCliente().getNome(),
                            agenda.getServico().getNome(),
                            agenda.getStatus() ? "Realizado" : "Pendente");

                    contentStream.showText(agendaInfo);
                    contentStream.newLineAtOffset(0, -15);
                }

                contentStream.endText();
            }

            document.save(caminhoArquivo);
            System.out.println("PDF criado com sucesso em: " + caminhoArquivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
