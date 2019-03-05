package lesson5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int maxWeight;
    private List<Item> content = null;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int getWeight(List<Item> items){
        int result = 0;
        for(Item i: items){
            result += i.getWeight();
        }
        return result;
    }

    private int getPrice(List<Item> items){
        int result = 0;
        for(Item i: items){
            result += i.getPrice();
        }
        return result;
    }

    private void compare(List<Item> items){
        if(content == null){
            if(getWeight(items) <= maxWeight){
                content = items;
            }
        } else {
            if(getWeight(items) <= maxWeight && getPrice(items) > getPrice(content)){
                content = items;
            }
        }
    }

    private void select(List<Item> items){
        if(items.size() > 0){
            compare(items);
        }
        for(int i = 0; i < items.size(); i++){
            List<Item> tmp = new ArrayList<>(items);
            tmp.remove(i);
            select(tmp);
        }
    }

    public void getContent(List<Item> items){
        if(content != null) {
            content.clear();
        }
        select(items);
        for(Item i: content){
            System.out.println(i);
        }
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
