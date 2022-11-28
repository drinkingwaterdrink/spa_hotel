import java.util.ArrayList;
import java.util.List;

public class RoomList {
    private List<Room> arr = new ArrayList<>();

    public RoomList() {
        this.arr.add(new Room("스탠다드",101));
        this.arr.add(new Room("스탠다드",102));
        this.arr.add(new Room("스탠다드",103));
        this.arr.add(new Room("디럭스",201));
        this.arr.add(new Room("디럭스",202));
        this.arr.add(new Room("디럭스",203));
        this.arr.add(new Room("프리미어",301));
        this.arr.add(new Room("프리미어",302));
        this.arr.add(new Room("프리미어",303));
    }

    public void showAllRoomList() {
        for (Room room :this.arr) {
            System.out.println(room);
        }
    }

    public List<Room> getArr() {
        return arr;
    }

    public Room getRoom(int room_num) {                    //룸넘버를 넣으면 룸을 리턴해주는 함수
        int cnt = 0;
        for (Room room : this.arr) {
            if(room.getRoom_num() == room_num) {
                cnt += 1;
                return room;
            }
        }
        if (cnt == 0) {
            System.out.println("해당 호수가 존재하지 않습니다.");
        }
        return null;
    }
}
