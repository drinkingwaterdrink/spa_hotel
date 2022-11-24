public class Room { //객실

    private int size;   //크기
    private int price;   //숙박비
    private int room_num;   //객실호수
    private String type;     //객실타입

    private boolean isReserved;   //예약여부 (?)

    public Room(String type, int room_num) {
        switch (type) {
            case "스탠다드":
                this.type = type;
                this.size = 20;
                this.price = 50000;
                this.room_num = room_num;
                this.isReserved = false;
                break;
            case "디럭스":
                this.type = type;
                this.size = 40;
                this.price = 70000;
                this.room_num = room_num;
                this.isReserved = false;
                break;
            case "프리미어":
                this.type = type;
                this.size = 60;
                this.price = 100000;
                this.room_num = room_num;
                this.isReserved = false;
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
}

//1.기본 로직대로 돌아가게 만들기




//2.DB
//3.mvc패턴인데
//4.vip고객이있어서 일정횟수나 ㄷ일정금액을 결제하면 추가할인이된다
//5.
