import java.util.Scanner;  
class BankDetails {  
    private String accno;  
    private String name;  
    private String acc_type;  
    private long balance;  
    Scanner sc = new Scanner(System.in);  
    //method to open new account  
    public void openAccount() {  
        System.out.print("Hesap No girin: ");  
        accno = sc.next();  
        System.out.print("Hesap turunu girin: ");  
        acc_type = sc.next();  
        System.out.print("Isim Girin: ");  
        name = sc.next();  
        System.out.print("Bakiyeyi Girin: ");  
        balance = sc.nextLong();  
    }  
    //method to display account details  
    public void showAccount() {  
        System.out.println("Hesap sahibinin adi: " + name);  
        System.out.println("Hesap no.: " + accno);  
        System.out.println("Hesap Turu: " + acc_type);  
        System.out.println("Bakiye: " + balance);  
    }  
    //method to deposit money  
    public void deposit() {  
        long amt;  
        System.out.println("Yatirmak istediginiz tutari girin: ");  
        amt = sc.nextLong();  
        balance = balance + amt;  
    }  
    //method to withdraw money  
    public void withdrawal() {  
        long amt;  
        System.out.println("Cekmek istediginiz tutari girin: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Para cekildikten sonraki bakiye: " + balance);  
        } else {  
            System.out.println("Bakiyeniz daha az " + amt + "\tİşlem basarisiz oldu...!!" );  
        }  
    }  
    //method to search an account number  
    public boolean search(String ac_no) {  
        if (accno.equals(ac_no)) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    }  
}  
public class BankaOtomasyonu {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
        //create initial accounts  
        System.out.print("Kac musteri kaydi yapmak istiyorsunuz? ");  
        int n = sc.nextInt();  
        BankDetails C[] = new BankDetails[n];  
        for (int i = 0; i < C.length; i++) {  
            C[i] = new BankDetails();  
            C[i].openAccount();  
        }  
        // loop runs until number 5 is not pressed to exit  
        int ch;  
        do {  
            System.out.println("\n **Bankacilik Sistemi Uygulamasi**");  
            System.out.println("1. Tum hesap bilgilerini goruntule \n 2. Hesap numarasina gore ara\n 3. Para yatirin \n4. Para cekin \n 5.Cikis");  
            System.out.println("Seciminizi girin: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].showAccount();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Aramak istediginiz Hesap numarasini girin: ");  
                        String ac_no = sc.next();  
                        boolean found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Arama basarisiz oldu! Hesap mevcut degil..!!");  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Hesap No Girin. : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Arama basarisiz oldu! Hesap mevcut degil..!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Hesap No girin : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Arama basarisiz oldu! Hesap mevcut degil..!!");  
                        }  
                        break;  
                    case 5:  
                        System.out.println("Iyi Gunler Dileriz...");  
                        break;  
                }  
            }  
            while (ch != 5);
    }
}