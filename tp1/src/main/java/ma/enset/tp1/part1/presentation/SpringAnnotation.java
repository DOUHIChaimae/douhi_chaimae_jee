package ma.enset.tp1.part1.presentation;

import ma.enset.tp1.part1.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotation {
    public static void main(String[] args) {
        //dao,metier.. packages to scan
        ApplicationContext context = new AnnotationConfigApplicationContext("ma");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
