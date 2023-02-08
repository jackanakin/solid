interface Image {
    void displayImage();
  }
  
  class RealImage implements Image {
    private final String fileName;
  
    public RealImage(String fileName) {
      this.fileName = fileName;
      loadImageFromDisk(fileName);
    }
  
    @Override
    public void displayImage() {
      System.out.println("Displaying " + fileName);
    }
  
    private void loadImageFromDisk(String fileName) {
      System.out.println("Loading " + fileName);
    }
  }
  
  class ImageProxy implements Image {
    private final String fileName;
    private RealImage realImage;
  
    public ImageProxy(String fileName) {
      this.fileName = fileName;
    }
  
    @Override
    public void displayImage() {
      if (realImage == null) {
        realImage = new RealImage(fileName);
      }
      realImage.displayImage();
    }
  }
  
  public class Main {
    public static void main(String[] args) {
      Image image1 = new ImageProxy("image1.jpg");
      Image image2 = new ImageProxy("image2.jpg");
  
      image1.displayImage();
      image2.displayImage();
      image1.displayImage();
    }
  }