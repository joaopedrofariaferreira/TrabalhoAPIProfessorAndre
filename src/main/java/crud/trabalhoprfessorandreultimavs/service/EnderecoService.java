package crud.trabalhoprfessorandreultimavs.service;


import crud.trabalhoprfessorandreultimavs.entity.Endereco;
import crud.trabalhoprfessorandreultimavs.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco getEnderecoByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> getEnderecoById(Integer id) {
        return enderecoRepository.findById(id);
    }

    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco updateEndereco(Integer id, Endereco endereco) {
        if (enderecoRepository.existsById(id)) {
            endereco.setId(id);
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    public void deleteEndereco(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
