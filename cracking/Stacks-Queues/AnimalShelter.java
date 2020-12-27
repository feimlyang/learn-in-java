import java.util.Iterator;
import java.util.LinkedList;

/**
 * AnimalShelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in Linkedlist data structure.
 */

abstract class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
public class AnimalShelter {

    LinkedList<Animal> queue = new LinkedList<>();
    
    public void enqueue(Animal animal){
        queue.addLast(animal);
    } 
    public Animal dequeueAny(){
        Animal any = queue.getFirst();
        queue.remove(any);
        return any;
    }
    public Dog dequeueDog(){
        Iterator<Animal> iter = queue.iterator();
        Dog dog = null;
        Animal next = null;
        while (iter.hasNext()){
            next = iter.next();
            if (next instanceof Dog){
                dog = (Dog)next;
                break;
            }
        }
        queue.remove(next);
        return dog;
    }
    public Cat dequeueCat(){
        Iterator<Animal> iter = queue.iterator();
        Cat cat = null;
        Animal next = null;
        while (iter.hasNext()){
            next = iter.next();
            if (next instanceof Cat){
                cat = (Cat)next;
                break;
            }
        }
        queue.remove(next);
        return cat;
    }

    public void printAddress(){
        Iterator<Animal> iter = queue.iterator();
        while (iter.hasNext()){
            Animal next = iter.next();
            System.out.print( next.toString() + " -> ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        for (int i = 0; i < 20; i++){
            if (((int) (Math.random() * 10)) % 2 == 0){
                Dog dog = new Dog();
                shelter.enqueue(dog);
            }
            else{
                Cat cat = new Cat();
                shelter.enqueue(cat);
            }
        }
        shelter.printAddress();
        System.out.println(shelter.dequeueAny().toString());
        shelter.printAddress();
        System.out.println(shelter.dequeueCat().toString());
        shelter.printAddress();
        System.out.println(shelter.dequeueCat().toString());
        shelter.printAddress();
        System.out.println(shelter.dequeueDog().toString());
        shelter.printAddress();

        shelter.enqueue(new Dog());
        shelter.printAddress();
    
    }

}

