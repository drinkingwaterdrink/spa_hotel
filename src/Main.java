import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int choice;
        boolean flag = false;
        Reserve reserveList = new Reserve();

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
                while (true) {
                    System.out.println("\n1. 예약 확인 2. 이용 내역 3. 예약 변경 4. 예약 취소 5. 종료");
                    System.out.println("숫자를 입력해주세요.");

                    choice = sc.nextInt();
                    sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

                    switch (choice) {
                        case 1:
                            reservelist.reserveAdd();
                            break;
                        case 2:
                            reservelist.getList();
                            break;
                        case 3:
                            reservelist.reserveEdit();
                            ;
                            break;
                        case 4:
                            reservelist.reserveDel();
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
                }
                    if (flag == true) break;

                //고객 화면
            case 2:
                System.out.println("고객 화면입니다.");
                    while (true) {
                        System.out.println("\n1. 예약 확인 2. 이용 내역 3. 예약 변경 4. 예약 취소 5. 종료");
                        System.out.println("숫자를 입력해주세요.");

                        choice = sc.nextInt();
                        sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

                        switch (choice) {
                            case 1:
                                reservelist.reserveAdd();
                                break;
                            case 2:
                                reservelist.getList();
                                break;
                            case 3:
                                reservelist.reserveEdit();
                                ;
                                break;
                            case 4:
                                reservelist.reserveDel();
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

