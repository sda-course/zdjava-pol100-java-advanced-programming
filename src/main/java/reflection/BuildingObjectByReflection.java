package reflection;

import javafx.gui.Album;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BuildingObjectByReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Obiekt utworzony tradycyjnie przez new
        //Album album = new Album();
        Class<Album> albumClass = Album.class;
        //obiekt utworzony metodą refleksji
        Album album1 = albumClass.getConstructor().newInstance();
        System.out.println(album1);
        Field[] fields = albumClass.getDeclaredFields();
        for(Field f: fields){
            System.out.println("Nazwa pola: " + f.getName() + ", typ: " + f.getType().getName());
            if (f.getName().equals("id")){
                f.setAccessible(true);
                f.setInt(album1, 2);
            }
        }
        System.out.println(album1);
    }
}
