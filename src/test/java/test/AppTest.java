package test;

import static org.junit.Assert.assertTrue;

import org.javatuples.Pair;
import org.junit.Test;

import java.util.List;

public class AppTest
{
    @Test
    public void findMaxProfitIndices() {
        List<ListOfData> list = App.readDataFromString("[{\"quote_date\": 20161018,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1441.43,\"high\": 1459.94,\"low\": 1441.43,\"close\": 1458.63,\"volume\": 0,\"value\": 0},{\"quote_date\": 20161017,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1445.58,\"high\": 1447.24,\"low\": 1436.66,\"close\": 1438.28,\"volume\": 0,\"value\": 0},{\"quote_date\": 20161014,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1430.31,\"high\": 1447.58,\"low\": 1430.02,\"close\": 1446,\"volume\": 0,\"value\": 0},{\"quote_date\": 20161013,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1442.5,\"high\": 1442.5,\"low\": 1422.09,\"close\": 1426.69,\"volume\": 0,\"value\": 0}]");
        Pair<Integer,Integer> indicies= App.findMaxProfitIndices(list);
        assertTrue( indicies.getValue0() == 0 && indicies.getValue1() == 3);
    }


    @Test
    public void findMaxProfitIndices1() {
        List<ListOfData> list = App.readDataFromString("[{\"quote_date\": 20161018,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1441.43,\"high\": 1459.94,\"low\": 1441.43,\"close\": 1458.63,\"volume\": 0,\"value\": 0},{\"quote_date\": 20161017,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1445.58,\"high\": 1447.24,\"low\": 1436.66,\"close\": 1438.28,\"volume\": 0,\"value\": 0},{\"quote_date\": 20161014,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1430.31,\"high\": 1447.58,\"low\": 1430.02,\"close\": 1446,\"volume\": 0,\"value\": 0},{\"quote_date\": 20161013,\"paper\": \"OMXS30\",\"exch\": \"Stockholm\",\"open\": 1442.5,\"high\": 1442.5,\"low\": 1440.09,\"close\": 1426.69,\"volume\": 0,\"value\": 0}]");
        Pair<Integer,Integer> indicies= App.findMaxProfitIndices(list);
        assertTrue( indicies.getValue0() == 1 && indicies.getValue1() == 3);
    }
}
