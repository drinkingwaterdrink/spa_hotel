import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {   //고객
    Scanner sc = new Scanner(System.in);

    String phonePattern = "^\\d{3}-\\d{4}-\\d{4}$";

    List<ClientList> arr = new ArrayList<>();

    public Client() {}

    public void addClient() {
        System.out.println("이름을 입력해주세요.");
        String cName = sc.nextLine();
        System.out.println("전화번호를 입력해주세요.");
        String cNumber = sc.nextLine();

        while (Pattern.matches(phonePattern, cNumber) == false) {
            System.out.println("올바른 전화번호를 입력해주세요.");
            cNumber = sc.nextLine();
        }
        System.out.println("소지금액을 입력해주세요.");
        int cMoney = sc.nextInt();
        sc.nextLine();

        this.arr.add(new ClientList(cName, cNumber, cMoney));
    }



    public void getClientInfo() {
        String cNumber = sc.nextLine();

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (cNumber.equals(this.arr.get(i).getNumber())) {
                System.out.println(arr.get(i) + "\n");
            }

        }
    }

//    public void reserv_client(){
//        Reserv reserv = new Reserv();
//        reserv.reserv_hotel();
//
//
//    }



}