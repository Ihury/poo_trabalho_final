package restaurant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persist {
    public static boolean save(Object obj, String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(obj);
            objectOut.flush();
            objectOut.close();
            fileOut.flush();
            fileOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object get(String path) {
        Object obj = null;
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            fileIn = new FileInputStream(path);
            objectIn = new ObjectInputStream(fileIn);

            obj = objectIn.readObject();

            objectIn.close();
            fileIn.close();

            return obj;
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
