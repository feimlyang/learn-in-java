A class has only one instance and provides the access to the instance.

```
public class Store{
    private static Store instance = null;
    protected Store(){
        ...
    }
    public static Store getInstance(){
        if (instance == null){
            instance = new Store();
        }
        return instance;
    }
}
```