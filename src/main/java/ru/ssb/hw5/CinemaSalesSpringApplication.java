package ru.ssb.hw5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.ssb.hw5.entity.PremiereEntity;
import ru.ssb.hw5.services.PremiereRepoService;

@SpringBootApplication
public class CinemaSalesSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CinemaSalesSpringApplication.class, args);


        PremiereRepoService premiereService = ctx.getBean(PremiereRepoService.class);
        premiereService.deleteAll();

        System.out.println("\n***Добавили 2-е премьеры***");
        premiereService.addPremiere(new PremiereEntity("Крик", "2022, детектив, триллер, ужасы , США", 10, 100));
        premiereService.addPremiere(new PremiereEntity("King's Man: Начало", "2021, боевик, комедия, приключения , Чехия, Великобритания, США", 6, 100));

        premiereService.printAll();

        System.out.println("\n***Добавлена новая премьера \"Звёздный разум\"***");
        premiereService.addPremiere(new PremiereEntity("Звёздный разум", "2021, приключения, фантастика , Россия", 10, 90));

        premiereService.printAll();
//
//        System.out.println("\n***Удалена премьера \"King's Man: Начало\"***");
//        premiereService.deletePremiere("King's Man: Начало");
//
//        premiereService.printAll();
//
//
//        System.out.println("\n***Куплено 20 билетов на премьеру \"Крик\"***");
//        if (!premiereService.buyTickets("Крик", 20)) {
//            System.out.println("Все билеты на премьру \"Крик\" выкуплены");
//        }
//
//        premiereService.printAll();
    }
}
