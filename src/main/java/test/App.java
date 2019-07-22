package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.javatuples.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class App {

    public static List<ListOfData> readDataFromFile(Path path) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(path.toString()));
        return new Gson().fromJson(br, new TypeToken<List<ListOfData>>() {}.getType());
    }

    public static List<ListOfData> readDataFromString(String json) {
        BufferedReader br = new BufferedReader(new StringReader(json));
        return new Gson().fromJson(br, new TypeToken<List<ListOfData>>() {}.getType());
    }

    public static Pair<Integer,Integer> findMaxProfitIndices(List<ListOfData> data) {
        int buyIndex = 0;
        int sellIndex = 1;
        int currentBuyIndex = 0;

        // Sort by date
        data.sort(new Comparator<ListOfData>() {
            @Override
            public int compare(ListOfData o1, ListOfData o2) {
                return Integer.valueOf(o1.quote_date).compareTo(o2.quote_date);
            }
        });

        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getLow() < data.get(currentBuyIndex).getLow()) {
                currentBuyIndex = i;
            }

            if (data.get(sellIndex).getHigh() - data.get(buyIndex).getLow() < data.get(i).getHigh() - data.get(currentBuyIndex).getLow()) {
                sellIndex = i;
                buyIndex = currentBuyIndex;
            }
        }
        return Pair.with(buyIndex, sellIndex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "data.json";
        List<ListOfData> data = readDataFromFile(Paths.get(path));

        Pair<Integer,Integer> result = findMaxProfitIndices(data);

        System.out.println("Buy date " + data.get(result.getValue0()).quote_date + " with value " + data.get(result.getValue0()).getLow());
        System.out.println("Sell date " + data.get(result.getValue1()).quote_date + " with value " + data.get(result.getValue1()).getHigh());
    }
}