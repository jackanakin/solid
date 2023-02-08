abstract class PurchasePower {
    protected static final double BASE = 500;
    protected PurchasePower successor;
  
    abstract protected double getAllowable();
    abstract protected String getRole();
  
    public void setSuccessor(PurchasePower successor) {
      this.successor = successor;
    }
  
    public void processRequest(PurchaseRequest request) {
      if (request.getAmount() < this.getAllowable()) {
        System.out.println(this.getRole() + " will approve $" + request.getAmount());
      } else if (successor != null) {
        successor.processRequest(request);
      }
    }
  }
  
  class ManagerPower extends PurchasePower {
    protected double getAllowable() {
      return BASE * 10;
    }
  
    protected String getRole() {
      return "Manager";
    }
  }
  
  class DirectorPower extends PurchasePower {
    protected double getAllowable() {
      return BASE * 20;
    }
  
    protected String getRole() {
      return "Director";
    }
  }
  
  class VicePresidentPower extends PurchasePower {
    protected double getAllowable() {
      return BASE * 40;
    }
  
    protected String getRole() {
      return "Vice President";
    }
  }
  
  class PresidentPower extends PurchasePower {
    protected double getAllowable() {
      return BASE * 60;
    }
  
    protected String getRole() {
      return "President";
    }
  }
  
  class PurchaseRequest {
    private double amount;
    private String purpose;
  
    public PurchaseRequest(double amount, String purpose) {
      this.amount = amount;
      this.purpose = purpose;
    }
  
    public double getAmount() {
      return this.amount;
    }
  
    public String getPurpose() {
      return this.purpose;
    }
  }
  
  public class Run {
    public static void main(String[] args) {
      PurchasePower manager = new ManagerPower();
      PurchasePower director = new DirectorPower();
      PurchasePower vp = new VicePresidentPower();
      PurchasePower president = new PresidentPower();
  
      manager.setSuccessor(director);
      director.setSuccessor(vp);
      vp.setSuccessor(president);
  
      PurchaseRequest request = new PurchaseRequest(1000, "Supplies");
      manager.processRequest(request);
    }
  }