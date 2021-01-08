Offers an interface and concrete classes that implements the interface. 
The type of the class is decided when it is instantiated.
```
public class CardGame{
    public static CardGame createCardGame(GameType type){
        if (type == GameType.Poker){
            return new PokerGame();
        }
        else if (type == GameType.BlackJack){
            return new BlackJackGame();
        }
        return null;
    }
}
```


```
public interface Game{
    void playGame();
}
```
```
public class PokerGame implements Game{
    @Override
    public void playGame(){
        ...
    }
}
```
```
public class BlackJackGame implements Game{
    @Override
    public void playGame(){
        ...
    }
}
```