package ru.ssb.hw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssb.hw5.entity.PremiereEntity;
import ru.ssb.hw5.repository.PremiereEntityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PremiereRepoService implements PremiereRepoMethods {

    private final PremiereEntityRepository premiereEntityRepository;

    @Autowired
    public PremiereRepoService(PremiereEntityRepository premiereEntityRepository) {
        this.premiereEntityRepository = premiereEntityRepository;
    }

    @Override
    @Transactional
    public PremiereEntity addPremiere(PremiereEntity premiereEntity) {
        return premiereEntityRepository.saveAndFlush(premiereEntity);
    }


    @Override
    @Transactional
    public void deletePremiere(String name) {
        PremiereEntity premiereEntity = premiereEntityRepository.findByName(name);
        premiereEntityRepository.delete(premiereEntity);
    }

    @Override
    @Transactional
    public PremiereEntity changePremiere(PremiereEntity premiereEntity) {
        return premiereEntityRepository.saveAndFlush(premiereEntity);
    }

    @Override
    public List<PremiereEntity> findAll() {
        return premiereEntityRepository.findAll();
    }

    @Override
    public PremiereEntity findByName(String premiereName) {
        return premiereEntityRepository.findByName(premiereName);
    }

    public void deleteAll() {
        premiereEntityRepository.findAll().forEach(premiereEntityRepository::delete);
    }

    public void printAll() {
        premiereEntityRepository.findAll().forEach(System.out::println);
    }

    @Transactional
    public boolean buyTickets(String premiereName, Integer numTikets) {
        PremiereEntity premiereEntity = premiereEntityRepository.findByName(premiereName);
        if (premiereEntity.getNumberOfSeats() >= numTikets) {
            premiereEntity.setNumberOfSeats(premiereEntity.getNumberOfSeats() - numTikets);
            premiereEntityRepository.save(premiereEntity);
            return true;
        } else {
            return false;
        }

    }

    @Transactional
    public void returnTickets(String premiereName, Integer numTikets) {
        PremiereEntity premiereEntity = premiereEntityRepository.findByName(premiereName);
        premiereEntity.setNumberOfSeats(premiereEntity.getNumberOfSeats() + numTikets);
        premiereEntityRepository.save(premiereEntity);
    }

    public String getPremeiresInfo(String premiereName) {
        String ret;
        if (premiereName != null) {
            PremiereEntity premiereEntity = premiereEntityRepository.findByName(premiereName);
            ret = premiereEntity.toString();
        } else {
            List<PremiereEntity> list = premiereEntityRepository.findAll();
            StringBuilder sb = new StringBuilder();
            for (PremiereEntity p : list) {
                sb.append(p.toString()).append("\n");
            }
            ret = sb.toString();
        }

        return ret;
    }
}
