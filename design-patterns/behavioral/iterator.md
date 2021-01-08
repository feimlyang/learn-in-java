```
public interface Iterator{
    public boolean hasNext();
    public Object next();
}

public interface Container{
    public Iterator getIterator();
}
```

```
public class NameRepo implements Container{
    String names[] = {...}

    @Override 
    public Iterator getIterator(){
        return new NameIterator();
    }

    private class NameIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext(){
            ...
        }

        @Override
        public Object next(){
            ...
        }
    }
}