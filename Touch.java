import java.io.File;
import java.io.FileOutputStream;

public class Touch {

	public static final String filepath = "file";

	public static void main(String[] args) throws Exception {
    File file = new File(filepath);

    System.out.println(file.lastModified());

    if (args.length == 0 || args[0].equals("bad")) {
      BadTouch(file);
    } else {
      GoodTouch(file);
    }

    System.out.println(file.lastModified());
	}

  public static void BadTouch(File file) throws Exception {
    if (!file.setLastModified(System.currentTimeMillis())) {
      throw new Exception("Could not update time stamp for " + file);
    }
  }

  public static void GoodTouch(File file) throws Exception {
    FileOutputStream fos = new FileOutputStream(file);
    byte[] empty = new byte[0];
    fos.write(empty);
  }

}
