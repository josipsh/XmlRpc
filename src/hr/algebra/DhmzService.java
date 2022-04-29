package hr.algebra;

public class DhmzService {

    public QueryResult fetchNewestDataFotCity(String city){

        try {
            return doRequest(city);
        }catch (Exception exception){
            return new QueryResult("", "", "2022-04-05", exception.getMessage());
        }
    }

    private QueryResult doRequest(String city) {

        return new QueryResult(city, "Croatia", "2022-04-05", "");
    }
}
