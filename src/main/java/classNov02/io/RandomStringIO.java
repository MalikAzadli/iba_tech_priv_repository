package classNov02.io;

import mix.RandomChars;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomStringIO {
    public static void main(String[] args) throws IOException {
        RandomStringIO randomStringIO = new RandomStringIO();
        //1. generate strings
        List<String> strings = randomStringIO.genStrings(33);
        //2. write to file
        randomStringIO.writeToFile("first.txt", strings);
        //3. read from file
        Stream<String> stringStream = randomStringIO.readFile("first.txt");
        //4. sort them
        List<String> sorted = stringStream
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        //5. write sorted list to new file
        randomStringIO.writeToFile("second.txt" ,sorted);
    }

    public List<String> genStrings(int size){
        Random rand = new Random();
        List<String> strings = Stream
                .generate(() -> RandomChars.genRandom(rand.nextInt(10)+20))
                .limit(size)
                .collect(Collectors.toList());
        return strings;
    }

    public void writeToFile(String fileName, List<String> strings) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        strings.forEach(s -> {
            try {
                bw.write(s);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
    }

    public Stream<String> readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        return br.lines();
    }
}
