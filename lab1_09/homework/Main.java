package homework;

public class Main {
    public static void main(String[] args) {
        Student rinat = new Student("Rinat", "11-503");
        Student ilhan = new Student("Ilhan", "11-503");


        Teacher kamilEnikeev = new Teacher("Kamil Enikeev");
        Teacher maratArslanov = new Teacher("Marat Arslanov");
        Discipline informatics = new Discipline("informatics", kamilEnikeev);
        Discipline math = new Discipline("math", maratArslanov);
        Statement statementRinat140125 = new Statement(informatics, rinat, "15.11.2025", "Самостоятельная работа", 4);
        Statement statementRinat130125 = new Statement(math, rinat, "10.11.2025", "Контрольная работа", 4);
        Statement statementIlhan140125 = new Statement(informatics, ilhan, "13.11.2025", "Контрольная работа", 5);
        Statement statementIlhan130125 = new Statement(math, ilhan, "14.11.2025", "Домашняя работа", 3);
        System.out.println(rinat);
        System.out.println(ilhan);
    }
}
