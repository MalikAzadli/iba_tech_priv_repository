package homePractice;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static <T> T getAway(T element) {
        return element;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(getAway("Jane"));
//
//
//        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
//
//        FileOutputStream fileOutputStream = new FileOutputStream("save.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(strings);
//
//        FileInputStream fileInputStream = new FileInputStream("save.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        List<String> asss = (List<String>) objectInputStream.readObject();
//        System.out.println(asss);


//        String str = String.format("--%1$15s", "Malik");
//        System.out.println(-2<<1);

//        List<Integer> list = new ArrayList<>();
//        list.forEach(() -> 77.77);

//        Map<String, Commands> commandsMap = new HashMap<>();
//        List<Commands> collect = Arrays.stream(Commands.values()).collect(Collectors.toList());
//        System.out.println(collect);
//        collect.forEach(commands -> commandsMap.put(String.format("%d", collect.indexOf(commands)),commands));
//
//        System.out.println(commandsMap.get("5"));



        Scanner scanner = new Scanner(System.in);
        Map<String, Object> requests = getRequests();
        List<String> inputs = new ArrayList<>();
        requests.keySet().forEach(k -> {
            System.out.print(k.toString());
            String line = scanner.nextLine();
            if (checkValidity(line, requests.get(k))) inputs.add(line);
        });

        inputs.forEach(i -> System.out.println(i));

    }

    private static boolean checkValidity(String line, Object o) {
        boolean flag = false;
        switch (o.getClass().getSimpleName()) {
            case "Integer":
                Integer.parseInt(line);
                flag = true;
                break;
        }
        return flag;
    }

    public static Map<String, Object> getRequests() {
        Map<String, Object> requests = new HashMap<>();
        requests.put("Please, enter flight no: ", new Integer(0));
        requests.put("Please, enter destination: ", new String());
        requests.put("Please, enter date: ", LocalDate.now());


        return requests;
    }

}
