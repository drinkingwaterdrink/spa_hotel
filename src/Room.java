import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Room { //객실

    private int size;   //크기
    private int price;   //숙박비
    private int room_num;   //객실호수
    private String type;     //객실타입

    private List<Date> date_list = new ArrayList<>();   //예약여부 (?)

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

    public List<Date> getDate_list() {
        return date_list;
    }

    public boolean addDate_list(String date) {

        Date trans_date = transformDate(date);
        for(Date day : date_list){
            if(day==trans_date){  //중복된 예약일이 있다면
                return false;
            }
            this.date_list.add(trans_date);
            return true;        //중복된 예약일없으면 삽입
        }
        this.date_list.add(trans_date);
        return true;
    }

    public void delDate_List(String date){    //예약일 받음
        Date trans_date = transformDate(date);
        for(Date day : date_list){
            if(day==trans_date){  //중복된 예약일이 있다면
                date_list.remove(day);
                return;
            }
        }
    }

    public Date transformDate(String date)
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
        Date d = Date.valueOf(transDate);

        return d;
    }


}
