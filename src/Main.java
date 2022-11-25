import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("1234");
        Hotel hotel = new Hotel(0);


        int choice;
        boolean flag = false;
        Reserv reserveList = new Reserv();

        System.out.println("=====================");
        System.out.println("ㅐ***Hotel 911***ㅐ");
        System.out.println("1. 관리자 화면은 숫자 '1'을, 2. 고객이시면 숫자 '2'를 눌러주세요.");
        System.out.println("=====================");
        Scanner indexInput = new Scanner(System.in);
        int num = indexInput.nextInt();

        //관리자 화면
        switch (num) {
            case 1:
                System.out.println("관리자 화면입니다.");
                System.out.println("관리자 비밀번호를 입력해주세요");
                String adminPassword = sc.nextLine();
                if (adminPassword.equals(admin.getPassword())) {
                    while (true) {
                        System.out.println("\n1. 모든예약내역 확인 2.예약 취소 3.예약가능한객실 확인 4. 종료");
                        System.out.println("숫자를 입력해주세요.");

                        choice = sc.nextInt();
                        sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

                        switch (choice) {
                            case 1:
                                hotel.showAllReservList();
                                break;
                            case 2:
                                System.out.println("취소하고자하는 예약 id를 입력해주세요");
                                String inputId = sc.nextLine();
                                hotel.cancleReserv(inputId);
                                break;
                            case 3:
                                System.out.println("조회하고자하는 날짜를 숫자로 입력해주세요");
                                int Inputdate = sc.nextInt();
                                hotel.showReservableRoomList(Inputdate);
                                break;
                            case 4:
                                System.out.println("이용 감사합니다.");
                                flag = true;
                                break;
                            default:
                                System.out.println("\n================================");
                                System.out.println("****1~4 사이 숫자를 입력해주세요****");
                                System.out.println("================================\n");
                                break;
                        }
                    }
                }
                else {
                    System.out.println("관리자 비밀번호가 틀렸습니다.");
                }
                //고객 화면
            case 2:
                System.out.println("고객 화면입니다.");
                while (true) {
                    System.out.println("\n1. 예약 하기 2. 예약 조회 3. 예약 취소 4. 예약 가능객실보기 5. 종료");
                    System.out.println("숫자를 입력해주세요.");

                    choice = sc.nextInt();
                    sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

                    switch (choice) {
                        case 1:
                            Client client = new Client();
                            client.addClient();
                            hotel.addReserv(client);
                            break;
                        case 2:
                            break;
                        case 3:
                            ;
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.println("이용 감사합니다.");
                            flag = true;
                            break;
                        default:
                            System.out.println("\n================================");
                            System.out.println("****1~5 사이 숫자를 입력해주세요****");
                            System.out.println("================================\n");
                            break;
                    }
                    if (flag == true) break;
                }
        }
    }
}
