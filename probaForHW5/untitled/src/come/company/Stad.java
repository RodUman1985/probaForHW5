package come.company;

public class Stad  {
    String st;
    String status;
    Stad(String s){
        this.st=s;
        this.status = "�� ����������";
    }
    Stad(String s,String stat){
        this.st=s;
        this.status = stat;
    }
    @Override
    public String toString() {
        return "{" +
                "�������='" + st + '\'' +
                ", ������='" + status + '\'' +
                '}';
    }
/* @Override
    public String toString() {
        return ( "\n ������� =  \n"+st +"\n ��������� =   \n"+status+""
        );
    }*/
}
