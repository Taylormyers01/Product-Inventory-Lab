package services;

import models.Sneaker;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SneakerService {
    private static int nextId = 1;  // (1)

    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)
    public Sneaker create(String name, String brand, String sport, int size, int quantity, float price) {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);

        // (3)
        inventory.add(createdSneaker);

        // (4)
        return createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        return inventory.stream().filter(i -> i.getId() == id).collect(Collectors.toList()).get(0);
    }

    //read all
    public Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
        return inventory.stream().toArray(Sneaker[]::new);
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        return inventory.remove(findSneaker(id));
    }
}
