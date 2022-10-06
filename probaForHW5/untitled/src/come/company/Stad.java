package come.company;

public class Stad  {
    String st;
    String status;
    Stad(String s){
        this.st=s;
        this.status = "не выполненно";
    }
    Stad(String s,String stat){
        this.st=s;
        this.status = stat;
    }
    @Override
    public String toString() {
        return "{" +
                "задание='" + st + '\'' +
                ", статус='" + status + '\'' +
                '}';
    }
/* @Override
    public String toString() {
        return ( "\n задание =  \n"+st +"\n состояние =   \n"+status+""
        );
    }*/
}
