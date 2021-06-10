package webapp.main;

import webapp.model.Resume;
import webapp.storage.ArrayStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainArray {
    private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | size | save id | update id | delete id | get id | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            String id = null;
            if (params.length == 2) {
                id = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save":
                    r = new Resume();
                    r.setId(id);
                    ARRAY_STORAGE.save(r);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(id);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(id));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "update":
                    r = new Resume();
                    ARRAY_STORAGE.update(r);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}
