import java.util.ArrayList;
import java.util.List;

public class Hotel {    //호텔
    RoomList roomList = new RoomList();
    private List<Reserv> reservList = new ArrayList<>();
    int money;  //보유자산

    public Hotel(int money) {
        this.money = money;
    }

    public void addReserv(Client client, String date, int room_num) {             //고객으로 부터 받은 Reserv를 검증후 reservList에 추가
        Reserv reserv = new Reserv(client,date,room_num);
        boolean ck = reserv.ck(client,date,room_num);
        if (ck) {
            this.reservList.add(reserv);
            this.roomList.getRoom(room_num).addDate_list(date);                    //해당 room 인스턴스에 예약날짜를 추가
        }
        else {
            System.out.println("해당예약은 할수 없습니다.");
        }
    }

    public void cancleReserv(String id) {             //고객으로 부터 받은 id에 해당하는 reserve를 reservList에서 삭제
        int cnt = 0;
        for (Reserv reserv : this.reservList) {
            if(reserv.id == id) {
                this.reservList.remove(reserv);
                cnt += 1;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("해당 예약이 존재하지 않습니다.");
        }

    }

    public void showReservableRoomList(String date) {                  //호텔 해당날짜에 예약가능한 방을 보여주는 기능
        for (Room room : this.roomList.getArr()) {
            int cnt = 0;
            if(room.getDate_list().contains(date)) {
                    cnt +=1;
                }

            if(cnt == 0) {
                System.out.println(room);
            }
        }
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
