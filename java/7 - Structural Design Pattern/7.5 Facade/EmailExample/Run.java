public class Run {
    public static void main(String[] args) {
        EmailFacade emailFacade = new EmailFacade("youremail@gmail.com", "yourpassword", 
                                                  "recipientemail@gmail.com", "Subject", "Message");
        emailFacade.sendEmail();
    }
}