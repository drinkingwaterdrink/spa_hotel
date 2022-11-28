import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("1234");
        Hotel hotel = new Hotel(0);

        String phonePattern = "^\\d{3}-\\d{4}-\\d{4}$";
        int choice;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        while (true) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+'09:00'");
            Date cur_date = Date.from(zonedDateTime.toInstant());
            System.out.println("현재 날짜입니다.: " + df.format(zonedDateTime));

            System.out.println("=====================");
            System.out.println("ㅐ***Hotel 911***ㅐ");
            System.out.println("1. 관리자 화면은 숫자 '1'을, 2. 고객이시면 숫자 '2', 3. 프로그램종료는 '3'을 눌러주세요.");
            System.out.println("=====================");
            Scanner indexInput = new Scanner(System.in);
            int num = indexInput.nextInt();

            //관리자 화면
            switch (num) {
                case 1:
                    System.out.println("\n관리자 화면입니다.");
                    System.out.println("관리자 비밀번호를 입력해주세요");
                    String adminPassword = sc.nextLine();
                    if (adminPassword.equals(admin.getPassword())) {
                        while (true) {
                            System.out.println("\n-----------------------관리자모드-----------------------");
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
                                    try{
                                        UUID inputId = UUID.fromString(sc.nextLine());
                                        hotel.cancleReserv(inputId);
                                        System.out.println("취소가 완료 되었습니다.");
                                    }catch (Exception e){
                                        System.out.println("올바르지 않은 ID입니다. 아이디를 다시 확인해주세요");
                                    }

                                    break;
                                case 3:

                                    System.out.println("조회하고자하는 날짜를 숫자로 입력해주세요 ex) 2022년11월25일 -> 2022-11-25");
                                    String Inputdate = sc.nextLine();
                                    String regExp4 = "^\\d{4}-\\d{2}-\\d{2}$";   //날짜는 반드시 8글자. 예외시 에러메세지
                                    if(Inputdate.matches(regExp4)){

                                        hotel.showReservableRoomList(Inputdate);
                                    }else{
                                        System.out.println("올바르지 않은 날짜입니다. 날짜를 다시 확인해주세요");
                                    }
                                    break;
                                case 4:
                                    System.out.println("이용 감사합니다.");
                                    flag2 = true;
                                    break;
                                case 5:
                                    System.out.println("\n넘길 일 수를 입력해주세요.");
                                    int calDate = sc.nextInt();
                                    sc.nextLine();
                                    zonedDateTime = zonedDateTime.plusDays(calDate);
                                    System.out.println("입력한 일 수 만큼 패스한 날짜입니다.: " + df.format(zonedDateTime));

                                    Date date = Date.from(zonedDateTime.toInstant());
                                    hotel.cancelPassed(date);
                                    break;
                                default:
                                    System.out.println("\n================================");
                                    System.out.println("****1~4 사이 숫자를 입력해주세요****");
                                    System.out.println("================================\n");
                                    break;
                            }
                            if (flag2 == true) break;
                        }
                    } else {
                        System.out.println("관리자 비밀번호가 틀렸습니다.");
                        break;
                    }
                    break;
                case 2:
                    Client client = new Client("null","null",0,null);  // case 2 에서 사용할 클라이언트 선언
                    System.out.println("\n고객 화면입니다.");
                    System.out.println("성함을 입력해주세요.");
                    String name = sc.nextLine();
                    System.out.println("전화번호를 입력해주세요.");
                    String number = sc.nextLine();
                    if(number.matches(phonePattern)){

                    if(hotel.clientUseCheck(name,number)){  //호텔이용 목록에있다면
                        client = hotel.getOldClient(name,number);
                    }else{      //신규 고객이라면  새로운 고객 생성
                        System.out.println(name+ " 님은 신규 고객이십니다. \n" );
                        System.out.println("소지 금액을 입력해주세요\n");
                        try {
                            int money = sc.nextInt();
                            client = hotel.getNewClient(name, number, money);

                        } catch (Exception e) {
                            System.out.println("올바른 금액을 입력해주세요");
                            continue;
                        }


                    }
                    }else{
                        System.out.println("올바르지 않은 전화번호입니다. 전화번호를 다시 확인해주세요");
                        continue;
                    }

                    System.out.println("\n\n"+name +"님 환영합니다. \n\n" );



                    while (true) {
                        System.out.println("\n-----------------------고객예약-----------------------");
                        System.out.println("현재 잔액 = " + client.getMoney());
                        System.out.println("\n1. 예약 하기 2. 예약 조회 3. 예약 취소 4. 예약 가능객실보기 5. 종료");
                        System.out.println("숫자를 입력해주세요.");


                        choice = sc.nextInt();
                        sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

                        switch (choice) {
                            case 1:

                                System.out.println("예약하고자하는 날짜를 입력해주세요 ex) 2022년11월25일 -> 2022-11-25");
                                String inputDate = sc.nextLine();
                                String regExp = "^\\d{4}-\\d{2}-\\d{2}$";   //날짜는 반드시 8글자. 예외시 에러메세지
                                if(inputDate.matches(regExp) && cur_date.before(transformDate(inputDate))) {                 //입력한 날짜가 오늘 날짜와 같거나 과거 날짜이면 다시 입력받는다

                                    System.out.println("예약하고자하는 객실번호를 입력해주세요 ex) 301호 -> 301");
                                    String inputRoomNum = sc.nextLine();
                                    String regExp2 = "^(\\d{3})$";  //객실번호는 반드시 3글자. 예외시 에러메세지

                                    if(inputRoomNum.matches(regExp2)){

                                        hotel.addReserv(client, inputDate, Integer.parseInt(inputRoomNum));
                                    }else{
                                        System.out.println("올바르지 않은 객실번호입니다. 객실번호를 다시 확인해주세요");
                                    }

                                }else{
                                    System.out.println("올바르지 않은 날짜입니다. 날짜를 다시 확인해주세요");
                                }

                                break;
                            case 2:
                                System.out.println("조회하고자하는 예약 id를 입력해주세요");

                                try{
                                    UUID inputId = UUID.fromString(sc.nextLine());
                                    hotel.showClientReserv(inputId);
                                }catch (Exception e){
                                    System.out.println("올바르지 않은 ID입니다. 아이디를 다시 확인해주세요");
                                }
                                

                                break;
                            case 3:
                                System.out.println("취소하고자하는 예약 id를 입력해주세요");

                                try{
                                    UUID inputId2 = UUID.fromString(sc.nextLine());
                                    hotel.cancleReserv(inputId2);
                                    System.out.println("취소가 완료 되었습니다.");
                                }catch (Exception e){
                                    System.out.println("올바르지 않은 ID입니다. 아이디를 다시 확인해주세요");
                                }


                                break;
                            case 4:


                                System.out.println("조회하고자하는 날짜를 숫자로 입력해주세요 ex) 2022년11월25일 -> 2022-11-25");
                                String Inputdate = sc.nextLine();
                                String regExp3 = "^\\d{4}-\\d{2}-\\d{2}$";   //날짜는 반드시 8글자. 예외시 에러메세지
                                if(Inputdate.matches(regExp3)){

                                    hotel.showReservableRoomList(Inputdate);
                                }else{
                                    System.out.println("올바르지 않은 날짜입니다. 날짜를 다시 확인해주세요");
                                }






                                break;
                            case 5:
                                System.out.println("이용 감사합니다.");
                                flag3 = true;
                                break;
                            default:
                                System.out.println("\n================================");
                                System.out.println("****1~5 사이 숫자를 입력해주세요****");
                                System.out.println("================================\n");
                                break;
                        }
                        if (flag3 == true) break;
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다");
                    flag1 = true;
                    break;
                default:
                    System.out.println("\n================================");
                    System.out.println("****1~3 사이 숫자를 입력해주세요****");
                    System.out.println("================================\n");
                    break;
            }
            if (flag1 == true) break;
        }

    }
    public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyy-mm-dd");

        // Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");

        java.util.Date tempDate = null;

        try {
            // 현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
        String transDate = afterFormat.format(tempDate);

        // 반환된 String 값을 Date로 변경한다.
        java.sql.Date d = java.sql.Date.valueOf(transDate);

        return d;
    }
}

