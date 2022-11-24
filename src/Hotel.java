import java.util.ArrayList;
import java.util.List;

public class Hotel {    //호텔
    RoomList roomList = new RoomList();
    private List<Reserv> reservList = new ArrayList<>();
    int money;  //보유자산

    public Hotel(int money) {
        this.money = money;
    }

    public void addReserv(Reserv reserv) {             //예약으로 부터 받은 Reserv를 reservList에 추가
        this.reservList.add(reserv);
//        if (방의 타입이 ㅇㅇ이면) {
//            money += 금액;
//        }
    }

    public void cancleReserv(Reserv reserv) {             //예약으로 부터 받은 Reserv를 reservList에서 삭제
        this.reservList.remove(reserv);
//        if (방의 타입이 ㅇㅇ이면) {
//            money -= 금액;
//        }
    }

    public void showClientReserv(String id) {                      //고객은 자신의 예약 목록을 조회 할 수 있다.( 예약 번호로 예약 내역을 조회한다)
        int cnt = 0;
        for (Reserv reserv : this.reservList) {
            if(reserv.id == id) {
                System.out.println(reserv);
                cnt += 1;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("해당 예약이 존재하지 않습니다.");
        }
    }
    public void showAllReservList() {                  //호텔은 모든 예약 목록을 조회 할 수 있다.
        for (Reserv reserv : this.reservList) {
            System.out.println(reserv);
        }
    }

    public void showAllRoom() {                         //모든 방의 목록을 보여주는 기능
        this.roomList.showAllRoomList();
    }
}
