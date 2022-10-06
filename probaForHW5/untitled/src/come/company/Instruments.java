package come.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public  class Instruments {

    HashMap<Date, ArrayList<Stad>> deals = new HashMap<>();


    public void addToList() {

        Boolean t = true;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");

        while (t) {
            System.out.println("��������� ������� ���� � ������� ��.��.����");
            String d1 = sc.next();
            Date data = null;

            try {
                data = sd.parse(d1);
                System.out.println("������� ������");
                String task = sc.next();
                Stad z = new Stad(task);
                ArrayList<Stad> f;
                if (this.deals.containsKey(data)) {
                    f = this.deals.get(data);

                    boolean flag = false;
                    for (Stad s : f) {
                        if (s.st.equals(task)) {
                            System.out.println("��������� ������");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        f.add(z);
                        this.deals.put(data, f);
                    }
                } else {
                    f = new ArrayList();
                    f.add(z);
                    this.deals.put(data, f);
                }

                System.out.println("������� ����������(1 - ��, 2 - ���)");
                int k = sc.nextInt();
                if (k == 2) {
                    t = false;
                }

                if (k != 1 && k != 2) {
                    System.out.println("������������ �������");
                    break;
                }
            } catch (ParseException e) {
                System.out.println("�������� ������ ����");
                break;
            }
        }

    }

    public void seeOne() {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("��������� ������� ���� � ������� ��.��.����");
        String d1 = sc.next();
        Date data = null;


        try {
            data = sd.parse(d1);

        } catch (ParseException e) {
            System.out.println("�������� ������ ����");
        }
        if (deals.containsKey(data)) {
            ArrayList<Stad> f = deals.get(data);
            System.out.println(data);

            for (int i = 0; i < f.size(); ++i) {
                System.out.print(i + 1 + "---");
                System.out.println(f.get(i));
            }
        } else {
            System.out.println("� ���� ���� �� ���������� ��������");

        }

    }

    public void dealsOnThisDay() {

        Date t = new Date();
        SimpleDateFormat st1 = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(t);
        String r = st1.format(t);


        System.out.println(r);
        SimpleDateFormat st = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date dat = st.parse(r);
            System.out.println(dat);
            if (deals.containsKey(dat)) {
                ArrayList<Stad> f = deals.get(dat);
                System.out.println("    " + dat);

                for (int i = 0; i < f.size(); ++i) {
                    int n = i + 1;
                    System.out.print("          " + n + "---");
                    System.out.println(f.get(i));
                }
            } else {
                System.out.println("� ���� ���� �� ���������� ��������");

            }
        } catch (ParseException e) {
            System.out.println("�������� ������ ����");
        }

    }




    public void dealsOnThisWeak() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int weekI = c.get(Calendar.WEEK_OF_MONTH);
        System.out.println(weekI);
        for (Date dat : deals.keySet()) {
            c.setTime(dat);
            if (c.get(Calendar.WEEK_OF_MONTH) == weekI) {
                if (deals.containsKey(dat)) {
                    ArrayList<Stad> f = deals.get(dat);
                    System.out.println("     " + dat);

                    for (int i = 0; i < f.size(); ++i) {
                        System.out.print("           " + (i + 1) + "---");
                        System.out.println(f.get(i));
                    }
                } else {
                    System.out.println("� ���� ���� �� ���������� ��������");
                }

            }

        }

    }

    public void changeDealls() {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("��������� ������� ���� � ������� ��.��.����");
        String d1 = sc.next();
        Date data = null;


        try {
            data = sd.parse(d1);

        } catch (ParseException e) {
            System.out.println("�������� ������ ����");
        }
        if (deals.containsKey(data)) {
            ArrayList<Stad> f = deals.get(data);
            System.out.println(data);

            for (int i = 0; i < f.size(); ++i) {
                int r = i + 1;
                System.out.print(r + "---");
                System.out.println(f.get(i));
            }
            boolean w=true;
            while (w) {
                int nD;
                System.out.println("������� ����� ������");
                nD = sc.nextInt();
                if ((nD > 0) && (nD <= f.size())) {

                    for (int i = 0; i < f.size(); ++i) {
                        int r = i + 1;
                        if (r == nD) {
                            int t = 0;
                            while (t != 5) {
                                System.out.println("�������� �������� � �������:");
                                System.out.println("1 - �������������� �������");
                                System.out.println("2 - �������� ��� '����������'");
                                System.out.println("3 - �������� ��� '�� ����������'");
                                System.out.println("4 - �������");
                                System.out.println("5 - �����");
                                t = sc.nextInt();
                                switch (t) {
                                    case 1:
                                        System.out.println("������� ������");
                                        String task = sc.next();
                                        Stad z = new Stad(task);
                                        boolean flag = false;
                                        for (Stad s : f) {
                                            if (s.st.equals(task)) {
                                                System.out.println("��������� ������");
                                                flag = true;
                                                break;
                                            }
                                        }
                                        if (!flag) {
                                            f.add(z);
                                            this.deals.put(data, f);
                                        }
                                        break;
                                    case 2:
                                        int n = r - 1;
                                        f.set(n, new Stad(f.get(nD-1).st, "����������"));
                                        this.deals.put(data, f);
                                        break;
                                    case 3:
                                        int n1 = r - 1;
                                        f.set(n1, new Stad(f.get(nD-1).st, "�� ����������"));
                                        this.deals.put(data, f);
                                        break;
                                    case 4:
                                        System.out.println("������� ������� ������(1 - ��, 2 - ���)");
                                        int k = sc.nextInt();
                                        if (k == 1) {
                                            f.remove(nD-1);
                                            this.deals.put(data, f);
                                        }
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("�������� ����");
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("��� ����� ������");
                }
                System.out.println("������� ����������(1 - ��, 2 - ���)");
                int k= sc.nextInt();
                if (k == 2) {
                    w = false;
                }
            }
            }else{
            System.out.println("� ���� ���� �� ���������� ��������");


        }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////

    }









