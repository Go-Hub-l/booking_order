package com.xlb.ip;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class CheckIP {
    @Test
    public void test() {
        String ipInfoURL = "http://ipinfo.io/ip"; // 或者使用 http://checkip.amazonaws.com
        URL url = null;
        try {
            url = new URL(ipInfoURL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String ip = reader.readLine();
            System.out.println("Your IP address is: " + ip);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test2() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> integer1 = new ArrayList<>();
        List<Integer> integer2 = new ArrayList<>();
        List<Integer> integer3 = new ArrayList<>();

        for (int j = 1; j < 10; j *= 2) {
            integer1.add(j);
        }
        for (int j = 1; j < 10; j *= 3) {
            integer2.add(j);
        }
        for (int j = 1; j < 19; j *= 5) {
            integer3.add(j);
        }
        res.add(integer1);
        res.add(integer2);
        res.add(integer3);

        List<Integer> collect = res.stream().flatMap(List::stream).collect(Collectors.toList());
        Stream<List<Integer>> stream = res.stream();

        Stream<Integer> stream2 = integer1.stream();
        Stream<Integer> integerStream = stream.flatMap(List::stream);
        List<Integer> collect1 = integerStream.collect(Collectors.toList());
        System.out.println(collect);
    }
}
