import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public class Reserv{   //예약

    //    String name;    //예약자 이름
    //    String number;  //예약자 번호
    //    int money;  //소지금
    //    UUID id;
        Client client;
        //클라이언트가 위의 내용을 가지고있음

        Room room;      //객실
        String date;




    //예약은 객실, 고객의 이름, 고객의 전화번호, 예약 날짜를 가지고 있다.
            //!! 이 메소드는 예약이 완료될때만 실행됨
                //이전 메소드에서 고객데이터+원하는 객실을 받아옴
    public String client_save(Client client,Room room,int resrv_Date,UUID id){

        //return 1,2는 에러출력, 4는 정상작동




        this.room = room;
        this.client.name = client.name;

        //String regExp = "^01(?:0|1|[6-9])[-]?(\\d{4})[-]?(\\d{4})$";
        String regExp = "^01(?:0|1|[6-9])-(\\d{4})-(\\d{4})$";
        //^ 정규표현식 시작
        //01 처음에는 01이와야함
        //(?:0|1|[6-9]) 0 or 1 or 6~9가와야함(010 011 016 017 018 019 앞자리를 커버하기위해)
        //[-]? 번호사이에 -를추가한다. 만약 .도넣고싶다면 [.-]식으로 짠다
        //- 필수로 붙어야할지 아닐지 정할수있다. 문제에서 필수로 정하라했으니 변경
        //(\\d{4}) 4개의 숫자가 들어간다
        //(\\d{4}) 4개의숫자가 들어간다.
        //$ 정규표현식의 끝을 의미한다
        //String ss = "010-8468-1190"; //테스트코드
        //System.out.println(ss.matches(regExp)); //테스트코드

        if(client.number.matches(regExp)){
            //전화번호가 XXX-XXXX-XXXX식이 맞다면 트루 반환
            this.client.number = client.number;
        }else{
            //전화번호 재대로 안되있으면 에러넘김 // 호텔클래스에서 넘기는게좋을듯
            //System.out.println("잘못된 전화번호 입니다!!!");
            return "1";
        }



        //---------------------

        // ISO 8601
        // UTC(받아와야함)
        TimeZone time;
        Date dates = new Date();
        DateFormat df = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssX':00'");
        time = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(time);
        System.out.format("%n%s%n%n",df.format(dates));

        this.date = df.format(dates);

        if(room.addDate_list(resrv_Date)){
            //중복된 예약일이 없다면

        }else{
            return "2";
        }




        this.client.id =  id;

        return "4";


    }


    public String reserv_Room(Client client,RoomList room,int resrv_Date,int room_num){
        //getmoney변경필요
        if(client.money>room.getRoom(room_num).getPrice()){ //돈이 충분히 있다면
            //예약가능
            UUID uuid = UUID.randomUUID();
            //String uuid = UUID.randomUUID().toString();
            String query = client_save(client,room.getRoom(room_num),resrv_Date,client.id);
            if(query.equals("4")){
                //정상생성. uuid 리턴
                return uuid.toString();
            }else if(query.equals("2")){
                return "2"; //1이라는 스트링이 리턴되면 예약불가-전화번호에러
            }else if(query.equals("1")){
                return "1"; //1이라는 스트링이 리턴되면 예약불가-전화번호에러
            }
        }else{
            return "0"; //0이라는 스트링이 리턴되면 예약불가-돈부족
        }
        return "";  //이곳에 도달불가. 에러방지용 리턴코드


    }







}

