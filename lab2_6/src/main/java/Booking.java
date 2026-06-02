public class Booking {
    private Integer id;
    private String arrivaldate;
    private String stayingdate;
    private String departuredate;
    private Hotel hotel;
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getStayingdate() {
        return stayingdate;
    }

    public void setStayingdate(String stayingdate) {
        this.stayingdate = stayingdate;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Booking[" +
                "id=" + id +
                ", arrivaldate='" + arrivaldate + '\'' +
                ", stayingdate='" + stayingdate + '\'' +
                ", departuredate='" + departuredate + '\'' +
                ", hotel=" + hotel +
                ", person=" + person +
                ']';
    }
}


//    {
//            "id": 7087959,
//            "arrivaldate": "2022-03-10",
//            "stayingdate": "2022-03-11",
//            "departuredate": "2022-03-11",
//            "hotel": {
//            "id": 332,
//            "name": "hotel332"
//            },
//            "person": {
//            "gender": "Male",
//            "birthdate": "1983-10-14",
//            "fromcity": "Город Санкт-Петербург"
//          }
//            },
