# Lab3:
**Q:** When overriding the equals() method of the Object class, you will have to cast the Object parameter obj to the type of Object that you are dealing with. For example, in the Media class, you must cast the Object obj to a Media, and then check the equality of the two objects’ attributes as the above requirements (i.e. title for Media; title and length for Track). If the passing object is not an instance of Media, what happens?
A: If the casted Class do not have the right method (getTitle), Java will throw ClassCastException error


**Question:** Alternatively, to compare items in the cart, instead of using the Comparator class I have mentioned, you can use the Comparable interface1 and override the compareTo()method. You can refer to the Java docs to see the information of this interface. Suppose we are taking this Comparable interface approach. 
1. What class should implement the Comparable interface? 
- The Media class
2. In those classes, how should you implement the compareTo() method to reflect the ordering that we want? 
- I will implement like this in case of sorting by title_cost
```java
public abstract class Media implements Comparable<Media> {
    @Override
    public int compareTo(Media media) {
        if (this.cost == media.getCost()) {
            return this.title.compareTo(media.getTitle());
        }
        return this.cost < media.getCost() ? -1 : 1;
    }
}
```
3. Can we have two ordering rules of the item (by title then cost and by cost then title) if we use this Comparable interface approach? 
- No, we cannot implement multiple ordering rules using just Comparable interface approach.
- But we can still combine Comparable interface approach with custom Comparator normally
4. Suppose the DVDs have a different ordering rule from the other media types, that is by title, then decreasing length, then cost. How would you modify your code to allow this? 
- I would implement `Comparable<DigitalVideoDisc>` method to `DigitalVideoDisc` class.
- Then, I would write a custom `compareTo(DigitalVideoDisc dvd)` sastified this ordering rule.