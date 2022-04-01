package ru.ssb.hw5.services;

import ru.ssb.hw5.entity.PremiereEntity;

import java.util.List;

public interface PremiereRepoMethods {
    PremiereEntity addPremiere(PremiereEntity premiereEntity);
    void deletePremiere(String premiereName);
    PremiereEntity changePremiere(PremiereEntity premiereEntity);
    List<PremiereEntity> findAll();
    PremiereEntity findByName(String name);

}
