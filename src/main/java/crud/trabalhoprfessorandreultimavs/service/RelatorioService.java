package crud.trabalhoprfessorandreultimavs.service;
import java.util.HashMap;
import java.util.Map;


public class RelatorioService {
    public Map<String, String> getDados() {
        Map<String, String> dados = new HashMap<>();
        dados.put("titulo", "Relatório de Vendas");
        dados.put("conteudo", "Relatorio.");
        return dados;
    }
}
