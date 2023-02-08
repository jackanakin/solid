public class Run {
    public static void main(String[] args) throws Exception {
        HttpFacade httpFacade = new HttpFacade();
        String response = httpFacade.sendGet("https://www.example.com/api/get");
        System.out.println(response);
    }
}