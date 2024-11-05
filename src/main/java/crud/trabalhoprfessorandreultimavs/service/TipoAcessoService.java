package crud.trabalhoprfessorandreultimavs.service;


import crud.trabalhoprfessorandreultimavs.entity.TipoAcesso;
import crud.trabalhoprfessorandreultimavs.repository.TipoAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAcessoService {

    @Autowired
    private TipoAcessoRepository tipoAcessoRepository;

    public List<TipoAcesso> getAllTiposAcesso() {
        return tipoAcessoRepository.findAll();
    }

    public Optional<TipoAcesso> getTipoAcessoById(Integer id) {
        return tipoAcessoRepository.findById(id);
    }

    public TipoAcesso createTipoAcesso(TipoAcesso tipoAcesso) {
        return tipoAcessoRepository.save(tipoAcesso);
    }

    public TipoAcesso updateTipoAcesso(Integer id, TipoAcesso tipoAcesso) {
        if (tipoAcessoRepository.existsById(id)) {
            tipoAcesso.setId(id);
            return tipoAcessoRepository.save(tipoAcesso);
        }
        return null;
    }

    public void deleteTipoAcesso(Integer id) {
        tipoAcessoRepository.deleteById(id);
    }
}
