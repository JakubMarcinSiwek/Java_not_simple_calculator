import java.util.Scanner;

public class S25190_p01 {
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj pierwsza liczbe: ");
            int val1 = scanner.nextInt();
            System.out.println("Podaj druga liczbe");
            int val2 = scanner.nextInt();
            if (!((val1 | val2) == 0)) {
                System.out.println("Podaj operacje");
                String operacja = scanner.next();


                String toPrintval1 = "";
                int val1tochange = val1;
                for (int i = 0; i < 32; i++) {
                    if ((i & 3) == 0) toPrintval1 =" "+toPrintval1 ;
                    if ((i & 7) == 0) toPrintval1 =" "+toPrintval1;
                    toPrintval1 = (val1tochange&1) + toPrintval1;
                    val1tochange = val1tochange>>1;
                }
                System.out.println(val1 + " - " + toPrintval1);

                String toPrintval2 = "";
                int val2tochagne = val2;
                for (int i = 0; i < 32; i++) {
                    if ((i & 3) == 0) toPrintval2 = " " + toPrintval2;
                    if ((i & 7) == 0) toPrintval2 = " " + toPrintval2;

                    toPrintval2 = (val2tochagne & 1) + toPrintval2;
                    val2tochagne = val2tochagne >> 1;
                }
                System.out.println(val2 + " - " + toPrintval2);

                int a = 0;
                int b = 0;
                int temp1 = 0;
                int temp2 = 0;

                switch (operacja) {
                    case "-":
                        if(val2>val1){
                            int krotkitemp=val1;
                            val1=val2;
                            val2=krotkitemp;
                        }
                        val2 = ~(val2);
                        temp1 = 1;

                        temp2 = val2;
                        do {
                            a = temp1 ^ temp2;
                            b = (temp1 & temp2) << 1;
                            temp1 = a;
                            temp2 = b;
                        } while (b != 0);

                        val2 = a;
                        b = val1;

                    case "+":
                        a = 0;
                        b = 0;
                        temp1 = val1;
                        temp2 = val2;
                        do {
                            a = temp1 ^ temp2;
                            b = (temp1 & temp2) << 1;
                            temp1 = a;
                            temp2 = b;
                        } while (b != 0);

                        String toPrinta = "";
                        int valatochange = a;
                        for (int i = 0; i < 32; i++) {
                            if ((i & 3) == 0) toPrinta = " " + toPrinta;
                            if ((i & 7) == 0) toPrinta = " " + toPrinta;

                            toPrinta = (valatochange & 1) + toPrinta;
                            valatochange = valatochange >> 1;
                        }
                        System.out.println(a + " - " + toPrinta);
                        break;

                    case "*":
                        if ((val1 | val2) == 0) {
                            System.out.println("0");
                            break;
                        }

                        int wynik = 0;
                        a = val1;
                        b = val2;
                        while (b != 0) {
                            if ((b & 1) != 0) {
                                int tempa = 0;
                                int tempb = 0;
                                int temp11 = wynik;
                                int temp22 = a;
                                do {
                                    tempa = temp11 ^ temp22;
                                    tempb = (temp11 & temp22) << 1;
                                    temp11 = tempa;
                                    temp22 = tempb;
                                } while (tempb != 0);

                                wynik = tempa;

                            }
                            a <<= 1;
                            b >>= 1;

                        }
                        String toPrintWynik = "";
                        int wyniktochange = wynik;
                        for (int i = 0; i < 32; i++) {
                            if ((i & 3) == 0) toPrintWynik = " " + toPrintWynik;
                            if ((i & 7) == 0) toPrintWynik = " " + toPrintWynik;

                            toPrintWynik = (wyniktochange & 1 )+ toPrintWynik;
                            wyniktochange=wyniktochange >> 1;
                        }
                        System.out.println(wynik + " - " + toPrintWynik);
                        break;

                    case "/":
                        if (val2 == 0) {
                            System.out.println("Nie można dzielić przez zero!");
                            return;
                        }
                        int dzielna = val1;
                        int dzielnik = val2;
                        int counter = 0;


                        while (dzielnik <= dzielna) {
                            // prosze przyjac moje najszczersze przeprosiny ale tyle zmiennych musialem nazwac ze skocznyly mi sie nazwy

                            counter++;

                            int odejmik = dzielnik;
                            int odejmiczka = dzielna;
                            odejmik = ~(odejmik);

                            int tymczasowe1 = 1;
                            int tymczasowe2;
                            tymczasowe2 = odejmik;
                            int pomocnik;
                            int pomocniczka;
                            do {
                                pomocnik = tymczasowe1 ^ tymczasowe2;
                                pomocniczka = (tymczasowe1 & tymczasowe2) << 1;
                                tymczasowe1 = pomocnik;
                                tymczasowe2 = pomocniczka;
                            } while (pomocniczka != 0);

                            odejmik = pomocnik;
                            pomocniczka = odejmiczka;

                            pomocnik = 0;
                            pomocniczka = 0;
                            tymczasowe1 = odejmiczka;
                            tymczasowe2 = odejmik;
                            do {
                                pomocnik = tymczasowe1 ^ tymczasowe2;
                                pomocniczka = (tymczasowe1 & tymczasowe2) << 1;
                                tymczasowe1 = pomocnik;
                                tymczasowe2 = pomocniczka;
                            } while (pomocniczka != 0);
                            dzielna = pomocnik;
                        }

                        String toPrintWynik1 = "";
                        int resztaTochange = counter;
                        for (int i = 0; i < 32; i++) {
                            if ((i & 3) == 0) toPrintWynik1 = " " + toPrintWynik1;
                            if ((i & 7) == 0) toPrintWynik1 = " " + toPrintWynik1;

                            toPrintWynik1 = (resztaTochange & 1) + toPrintWynik1;
                            resztaTochange=resztaTochange >> 1;
                        }
                        System.out.println(counter + " - " + toPrintWynik1);

                        break;

                    default:
                        System.out.println("Nieznana operacja!");
                        return;
                }
            } else {
                run = false;
                System.out.println("kalkulator skończył swoją pracę! ");
            }


        }


    }


}