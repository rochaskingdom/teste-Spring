package br.com.jogo.api.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public ResponseEntity<Animal> buscaPorCodigo(Long codigo) {
        Optional<Animal> animal = animalRepository.findById(codigo);
        return animal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
