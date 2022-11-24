public class ClientList {
    String name;    //예약자 이름
    String number;  //예약자 번호
    int money;  //소지금
    String id;  //여기다가 저장하는게 맞는지?
    //저장하는게맞다면, 다중예약이된다면 리스트형태로 만들어서 보관?

    public ClientList(String cName, String cNumber, int cMoney) {
        this.name = cName;
        this.number = cNumber;
        this.money = cMoney;
    }


    public String getNumber() {
        return number;
    }


    public String toString() {
        return "\n예약자 이름 : " + name +
               "\n예약자 번호 : " + number +
               "\n소지금 : " + money
               ;
    }


}
