import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int countOfAnimals = 0;
        Animal[] animals = new Animal[0];
        ByteArrayInputStream dataInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream ois = new ObjectInputStream(dataInputStream);
            countOfAnimals = ois.readInt();
            animals = new Animal[countOfAnimals];
            for (int i = 0; i < countOfAnimals; i++) {
                Animal a = (Animal) ois.readObject();
                animals[i] = a;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }

    public static void main(String[] args) throws IOException {
        Animal[] animals = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentacles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animals.length);
        for (int i = 0; i < animals.length; i++) {
            oos.writeObject(animals[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animals2 = deserializeAnimalArray(bai.toByteArray());
        for (int i = 0; i < animals2.length; i++) {
            System.out.printf("%d. %s \n", i+1, animals2[i].getName());
        }
    }
}
