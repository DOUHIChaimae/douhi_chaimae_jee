package ma.enset.tp1.part1.ext;


import ma.enset.tp1.part1.dao.IDao;

public class DaoImpl2 implements IDao {
    @Override
    public double getDate() {
        System.out.println("version bdd");
        return 20;
    }
}
