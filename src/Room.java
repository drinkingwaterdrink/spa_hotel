import java.util.ArrayList;
import java.util.List;

public class Room { //객실

    private int size;   //크기
    private int price;   //숙박비
    private int room_num;   //객실호수
    private String type;     //객실타입

    private List<Integer> date_list = new ArrayList<>();   //예약여부 (?)

    public Room(String type, int room_num) {
        switch (type) {
            case "스탠다드":
                this.type = type;
                this.size = 20;
                this.price = 50000;
                this.room_num = room_num;
                break;
            case "디럭스":
                this.type = type;
                this.size = 40;
                this.price = 70000;
                this.room_num = room_num;
                break;
            case "프리미어":
                this.type = type;
                this.size = 60;
                this.price = 100000;
                this.room_num = room_num;
                break;
        }
    }

    @Override
    public String toString() {
        return
                "\n방호수 : " + room_num +"호"+
                        "\n 타입 : " + type +
                        "\n 가격 : " + price +"원"+
                        "\n 방크기 : " + size +" 제곱미터";
    }

    public int getPrice() {
        return price;
    }

    public int getRoom_num() {
        return room_num;
    }

    public List<Integer> getDate_list() {
        return date_list;
    }

    public boolean addDate_list(int date) {


        for(Integer day : date_list){
            if(day==date){  //중복된 예약일이 있다면
                return false;
            }
            this.date_list.add(date);
            return true;        //중복된 예약일없으면 삽입
        }


    }
}
